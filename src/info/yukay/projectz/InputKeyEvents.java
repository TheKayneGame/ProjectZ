package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	
	private static int keys;
	
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
	}
}
