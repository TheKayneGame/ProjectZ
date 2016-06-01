package info.yukay.projectz;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class FriendlyBullets {
	static List<Integer> FProjectilesX = new ArrayList<Integer>();
	static List<Integer> FProjectilesY = new ArrayList<Integer>();
	
	static BufferedImage Bullet;
	static int x;
	static int y;
	static Thread ProjectileMoveThread;
	static Thread ProjectileSpawnThread;
	static boolean Shooting;
	int Cooldown;
	Rectangle BulletHitbox;
	Rectangle Hitbox = new Rectangle(10, 10, 20, 450);
	
	public void init(){
		System.out.println("FriendlyBullets INIT");
		ProjectileMoveThread = new Thread (Threadrun);
		ProjectileSpawnThread = new Thread (Threadrun1);
		ProjectileMoveThread.start();
		ProjectileSpawnThread.start();
	}
	
	public static void RemoveBullet(int i)
	{
		FProjectilesX.remove(i);
		FProjectilesY.remove(i);
		
	}
	
	public void AddBullet(int eX, int eY)
	{
		FProjectilesX.add(eX + 8);
		FProjectilesY.add(eY - 10);
	}
	
	Runnable Threadrun = new Runnable()
	{
		public void run() 
		{
			System.out.println("Thread Runned");
			
			
			
			while (true) 
			{
				
				for(int i = 0; i < FProjectilesY.size() ; i++)
				{
					//ProjectZ.gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(i), this);
					//drawBullet(ProjectilesX.get(i), ProjectilesY.get(i));
					FProjectilesY.set(i, FProjectilesY.get(i) - 1);
					if(FProjectilesY.get(i) < 9)
					{
						RemoveBullet(i);
						if(ProjectZ.DebugModeOn())
						{
							System.out.println(i + "Removed");
						}
						
					}
					if(ProjectZ.DebugModeOn())
					{
						System.out.println(FProjectilesX.get(i)+ " " + FProjectilesY.get(i));
					}
				
				}
				try 
				{
					Thread.sleep(1);
				}
				catch (InterruptedException ex){
					
				}
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
					AddBullet(x,y);
					
					try 
					{
						Thread.sleep(500);
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
	
//	public void drawBullet(int i, int e)
//	{
//		projectz.gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(e), this);
//		System.out.println("1521");
//	}

}
