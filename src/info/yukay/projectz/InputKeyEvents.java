package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	
	Thread KeyThread;
	static double posX;
	static int KeyThreadSpeed = 5;
	private static int keys;
	
	public static void init() 
	{
		Thread KeyThread = new Thread (Threadrun);
		KeyThread.start();
		System.out.println("KeyEvents INIT");
	}
	
	public void keyReleased(KeyEvent e)
	{
		//keys = e.getKeyCode();
		keys = 0;
	}
	
	public void keyPressed(KeyEvent e)
	{
		keys = e.getKeyCode();  
	}
	

	static Runnable Threadrun = new Runnable()
	{
	public void run() 
	{
		while (true) 
		{
			switch(keys)
			{
				case KeyEvent.VK_D:
					if (Player.getX() <= 394)
					{
						Player.setX(Player.getX() + 1);
					}
					break;
				
				case KeyEvent.VK_A:
					
					if (Player.getX() >= 11)
					{
						Player.setX(Player.getX() - 1);
					}
					break;
				
				case KeyEvent.VK_W:
					if (Player.getY() >= 11)
					{
						Player.setY(Player.getY() - 1);
					}
					break;
				
				case KeyEvent.VK_S:
					if (Player.getY() <= 443)
					{
						Player.setY(Player.getY() + 1);					
					}
					break;
				default:
					//System.out.println("Unknown result");
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
		return keys;
	}
	
}
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