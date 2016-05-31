package info.yukay.projectz;

public class Player
{
	private static int x = 200;
	private static int y = 420;
	        
	public static int getX()
	{
		return x;
	}
	
	public static int getY()
	{
		return y;
	}
	
	public static void move(int i, int e)
	{
		
		switch(e)
		{
		case 1:
			if (Player.getY() >= 11)
			{
				y = y - i;
			}
			break;
		case 2:
			if (Player.getY() <= 428)
			{
			y = y + i;
			}
			break;
		case 3:
			if (Player.getX() >= 3)
			{
			x =x - i;
			}
			break;
		case 4:
			if (Player.getX() <= 394)
			{
			x = x + i;
			}
			break;
		
		}
		if (ProjectZ.DebugModeOn())
		{
		System.out.print("Key: "+ InputKeyEvents.key);
		System.out.print("; X: "+x);
		System.out.println("; Y: "+y);
		}
	}
//	public static void setY(int i)
//	{
//		y = i;
//		
//		System.out.print("Key: "+InputKeyEvents.getKey());
//		System.out.print("; X: "+x);
//		System.out.println("; Y: "+y);
//	}
}