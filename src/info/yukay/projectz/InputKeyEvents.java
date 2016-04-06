package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	Thread KeyThread;
	int key3;
	static double posX;
	static int KeyThreadSpeed = 5;
	static int key;
	static boolean Debug;
	static Projectile projectile;
	
	//Keys
	static boolean VK_W;
	static boolean VK_A;
	static boolean VK_S;
	static boolean VK_D;
	
	public static void init() 
	{
		Thread KeyThread = new Thread (Threadrun);
		KeyThread.start();
		System.out.println("KeyEvents INIT");
		
		projectile = new Projectile();
	}
	
	public void keyPressed(KeyEvent e)
	{

		if (e.getKeyCode() == KeyEvent.VK_Q)
			{
			if (ProjectZ.DebugModeOn() == true)
			{
				ProjectZ.DebugSwitch(false);
			} 
			else if (ProjectZ.DebugModeOn() == false)
			{
				ProjectZ.DebugSwitch(true);
			}
			System.out.println("DebugMode: " + ProjectZ.DebugModeOn());
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Projectile.Shooting = true;
		}
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			VK_W = true;
			break;
		case KeyEvent.VK_A:
			VK_A = true;
			break;
		case KeyEvent.VK_S:
			VK_S = true;
			break; 
		case KeyEvent.VK_D:
			VK_D = true;
			break;
		}
	}
	
	
	public void keyReleased(KeyEvent e)
	{		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			VK_W = false;
			break;
		case KeyEvent.VK_A:
			VK_A = false;
			break;
		case KeyEvent.VK_S:
			VK_S = false;
			break; 
		case KeyEvent.VK_D:
			VK_D = false;
			break;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Projectile.Shooting = false;
		}
	}
	static Runnable Threadrun = new Runnable()
	{

		public void run() 
		{
			System.out.println("Thread Runned");
			while (true) 
			{
				if(VK_W)
				{
					Player.move(1, 1);
				}
				if(VK_S)
				{
					Player.move(1, 2);
				}
				if(VK_A)
				{
					Player.move(1, 3);
				}
				if(VK_D)
				{
					Player.move(1, 4);
				}	
				try 
				{
					Thread.sleep(KeyThreadSpeed);
				}
				catch (InterruptedException ex){}
			}
		}
	};
	
	public static int getKey() 
	{
		return key;
	}
	
}



//	static Runnable Threadrun = new Runnable()
//	{
//		public void run() 
//		{
//			System.out.println("Thread Runned");
//			while (true) 
//			{
//				
//				switch(keys)
//				{
//				case KeyEvent.VK_D:
//					if (Player.getX() <= 394)
//					{
//						Player.setX(Player.getX() + 1);
//					}
//					break;
//
//				case KeyEvent.VK_A:
//
//					if (Player.getX() >= 11)
//					{
//						Player.setX(Player.getX() - 1);
//					}
//					break;
//
//				case KeyEvent.VK_W:
//					if (Player.getY() >= 11)
//					{
//						Player.setY(Player.getY() - 1);
//					}
//					break;
//
//				case KeyEvent.VK_S:
//					if (Player.getY() <= 443)
//					{
//						Player.setY(Player.getY() + 1);					
//					}
//					break;
//				}	
//
//				try 
//				{
//					Thread.sleep(KeyThreadSpeed);
//				}
//				catch (InterruptedException ex){}
//			}
//		}
//	};
//	
//	public static int getKey() 
//	{
//		return keys;
//	}
//	
//}
/*private static int keys;
	
	public void keyPressed(KeyEvent e)
	{
		keys = e.getKeyCode();
		//System.out.print(keys);
		
		switch(keys)
		{
			case KeyEvent.VK_D:
				if (Player.getX() <= 394)
				{
					Player.setX(Player.getX() + 2);
				}
				break;
			
			case KeyEvent.VK_A:
				
				if (Player.getX() >= 11)
				{
					Player.setX(Player.getX() - 2);
				}
				break;
			
			case KeyEvent.VK_W:
				if (Player.getY() >= 11)
				{
					Player.setY(Player.getY() - 2);
				}
				break;
			
			case KeyEvent.VK_S:
				if (Player.getY() <= 443)
				{
					Player.setY(Player.getY() + 2);					
				}

				break;
		}	
	}
	
	public static int getKey() {
		return keys;
	}*/