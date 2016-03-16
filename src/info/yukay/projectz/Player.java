package info.yukay.projectz;

public class Player
{
	private static int x = 50, y = 50;
	
	public static int getX()
	{
		return x;
	}
	
	public static int getY()
	{
		
		return y;
	}
	
	public static void setX(int i)
	{
		x = i;
		System.out.println("X:"+i);
	}
	public static void setY(int i)
	{
		y = i;
		System.out.println("Y:"+i);
	}
}
