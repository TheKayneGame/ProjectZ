package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	
	Thread ThreadA;
	static double posX;
	static int TrSpeed1 = 10;
	private static int keys;
	
	public static void init() 
	{
		Thread ThreadA = new Thread (Threadrun);
		ThreadA.start();
		System.out.println("KeyEvents INIT");
	}
	
	public void KeyReleased(KeyEvent e)
	{
		while(keys != 0)
		{
			keys = 0;
		}
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
				default:
					System.out.println("Unknown result");
					break;
			}
			
				
			
			try 
			{
			Thread.sleep(TrSpeed1);	
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