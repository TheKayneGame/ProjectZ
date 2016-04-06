package info.yukay.projectz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Projectile extends ProjectZ {
	static List<Integer> ProjectilesX = new ArrayList<Integer>();
	static List<Integer> ProjectilesY = new ArrayList<Integer>();
	static BufferedImage Bullet;
	static int x;
	static int y;
	static Thread ProjectileMoveThread;
	static Thread ProjectileSpawnThread;
	static boolean Shooting;
	ProjectZ projectz;
	
	public void init(){
		System.out.println("Projectile INIT");
		ProjectileMoveThread = new Thread (Threadrun);
		ProjectileSpawnThread = new Thread (Threadrun1);
		ProjectileMoveThread.start();
		ProjectileSpawnThread.start();
		projectz = new ProjectZ();
		
		try
    	{
    		Bullet = ImageIO.read(new File("Bullet.png"));   		
    	} catch (IOException ex) { } 
		
	}
	
	public void addProjectile() {
		x = Player.getX();
		y = Player.getY();
		ProjectilesX.add(x);
		ProjectilesY.add(y);
		System.out.println("ldl");
		
	}

	
	Runnable Threadrun = new Runnable()
	{
		public void run() 
		{
			System.out.println("Thread Runned");
			
			
			
			while (true) 
			{
				
				for(int i = 0; i < ProjectilesY.size() ; i++)
				{
					//ProjectZ.gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(i), this);
					//drawBullet(ProjectilesX.get(i), ProjectilesY.get(i));
					ProjectilesY.set(i, ProjectilesY.get(i) - 1);
					if(ProjectilesY.get(i) < 11)
					{
						ProjectilesX.remove(i);
						ProjectilesY.remove(i);
						if(ProjectZ.DebugModeOn())
						{
							System.out.println(i + "Removed");
						}
					}
					if(ProjectZ.DebugModeOn())
					{
						System.out.println(ProjectilesX.get(i)+ " " + ProjectilesY.get(i));
					}
				
				}
				try 
				{
					Thread.sleep(2);
				}
				catch (InterruptedException ex){}
			}
		}
	};
	Runnable Threadrun1 = new Runnable()
	{
		public void run() 
		{
			System.out.println("Thread Runned");
			while (true) 
			{
				if (Shooting)
				{
					x = Player.getX();
					y = Player.getY();
					ProjectilesX.add(x);
					ProjectilesY.add(y);
					try 
					{
						Thread.sleep(100);
					}
					catch (InterruptedException ex){}
				}
				
				try 
				{
					Thread.sleep(10);
				}
				catch (InterruptedException ex){}
			}
		}
	};
	
	public void drawBullet(int i, int e)
	{
		projectz.gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(e), this);
		System.out.println("1521");
	}

}
