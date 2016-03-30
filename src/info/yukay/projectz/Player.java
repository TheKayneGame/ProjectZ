package info.yukay.projectz;

public class Player
{
	private static int x = 200, y = 420;
	
	public void init(){
		System.out.println("Player INIT");
	}
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
		System.out.print("Key: "+InputKeyEvents.getKey());
		System.out.print("; X: "+x);
		System.out.println("; Y: "+y);
	}
	public static void setY(int i)
	{
		y = i;
		System.out.print("Key: "+InputKeyEvents.getKey());
		System.out.print("; X: "+x);
		System.out.println("; Y: "+y);
	}
}