package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	//Thread KeyThread;
	int key3;
	double posX;
	int KeyThreadSpeed = 5;
	static int key;
	boolean Debug;
	
	//Keys
	static boolean moveUp;
	static boolean moveLeft;
	static boolean moveDown;
	static boolean moveRight;
	
	
	public void init() 
	{
		Thread KeyThread = new Thread (Threadrun);
		KeyThread.start();
		System.out.println("KeyEvents INIT");
		

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
			FriendlyBullets.Shooting = true;
		}
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			moveUp = true;
			break;
		case KeyEvent.VK_A:
			moveLeft = true;
			break;
		case KeyEvent.VK_S:
			moveDown = true;
			break; 
		case KeyEvent.VK_D:
			moveRight = true;
			break;
		}
	}
	
	
	public void keyReleased(KeyEvent e)
	{		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			moveUp = false;
			break;
		case KeyEvent.VK_A:
			moveLeft = false;
			break;
		case KeyEvent.VK_S:
			moveDown = false;
			break; 
		case KeyEvent.VK_D:
			moveRight = false;
			break;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			FriendlyBullets.Shooting = false;
		}
	}
	Runnable Threadrun = new Runnable()
	{

		public void run() 
		{
			System.out.println("Thread Runned");
			while (true) 
			{
				
				if(moveUp)
				{
					Player.move(1, 1);
					
				}
				if(moveDown)
				{
					Player.move(1, 2);
				}
				if(moveLeft)
				{
					Player.move(1, 3);
				}
				if(moveRight)
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