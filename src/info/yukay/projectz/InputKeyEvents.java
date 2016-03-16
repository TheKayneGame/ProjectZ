package info.yukay.projectz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter
{
	public void keyPressed(KeyEvent e)
	{
		int keys = e.getKeyCode();
		System.out.println(keys); //log key id
		
		switch(keys)
		{
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
					Player.setX(Player.getX() + 2);
				break;
			
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				
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
				break;
		}
		
		
	}

}
