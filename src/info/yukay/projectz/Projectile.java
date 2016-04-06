package info.yukay.projectz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Projectile extends ProjectZ {
	static List<Integer> ProjectilesX = new ArrayList<Integer>();
	static List<Integer> ProjectilesY = new ArrayList<Integer>();
	private static BufferedImage Bullet;
	static int x;
	static int y;
	static Thread ProjectileThread;
	static boolean Shooting;
	
	public void init(){
		
		ProjectileThread = new Thread (Threadrun);
		ProjectileThread.start();
		try {
			Bullet = ImageIO.read(new File("Bullet.png"));
		} catch (IOException e) {}
	}
	
	public void addProjectile() {
		x = Player.getX();
		y = Player.getY();
		ProjectilesX.add(x);
		ProjectilesY.add(y);
		System.out.println("ldl");
		
	}

	
	static Runnable Threadrun = new Runnable()
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
				}
				for(int i = 0; i < ProjectilesY.size() ; i++)
				{
					gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(i),1,1, this);
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
					Thread.sleep(100);
				}
				catch (InterruptedException ex){}
			}
		}
	};
	
	

}
