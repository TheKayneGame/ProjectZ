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
	private static Projectile projectile;
	
	public static void init() 
	{
		Thread KeyThread = new Thread (Threadrun);
		KeyThread.start();
		System.out.println("KeyEvents INIT");
		
		projectile = new Projectile();
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W: 
		case KeyEvent.VK_A:  
		case KeyEvent.VK_S: 
		case KeyEvent.VK_D:
			key = e.getKeyCode();
			break;
		
		case KeyEvent.VK_Q:
			if (ProjectZ.DebugModeOn() == true)
			{
				ProjectZ.DebugSwitch(false);
			} 
			else if (ProjectZ.DebugModeOn() == false)
			{
				ProjectZ.DebugSwitch(true);
			}
			System.out.println("DebugMode: " + ProjectZ.DebugModeOn());
			break;
		case KeyEvent.VK_E:
			projectile.addProjectile();
			break;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W: 
		case KeyEvent.VK_A:  
		case KeyEvent.VK_S: 
		case KeyEvent.VK_D:
			break;
		}
			
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			
			break;
		case KeyEvent.VK_A:
			break;
		case KeyEvent.VK_S: 
			break;
		case KeyEvent.VK_D:
			break;
		
		}
	}
	static Runnable Threadrun = new Runnable()
	{
		
		public void run() 
		{
			System.out.println("Thread Runned");
			while (true) 
			{
				
				switch(key)
				{
				case KeyEvent.VK_W:
					Player.move(1, 1);
					break;
					
				case KeyEvent.VK_S:
					Player.move(1, 2);					
					break;
					
				case KeyEvent.VK_A:
					Player.move(1, 3);
					break;
					
				case KeyEvent.VK_D:
					Player.move(1, 4);
					break;
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