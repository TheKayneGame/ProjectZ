package info.yukay.projectz;

public class Enemy1 {
	Thread ThreadA;
	int Direction;
	int Movement;
	static int x = 50;
	static int y = 50;
	
	public void init() {
			Thread ThreadA = new Thread (Threadrun);
			ThreadA.start();	
	}
	
	public static void move(int i, int e)
	{
		
		switch(e)
		{
		case 1:
			if (y >= 12)
			{
				y = y - i;
			}
			break;
		case 2:
			if (y <= 230)
			{
			y = y + i;
			}
			break;
		case 3:
			if (x >= 12)
			{
			x = x - i;
			}
			break;
		case 4:
			if (x <= 399)
			{
			x = x + i;
			}
			break;
		
		}
		if (ProjectZ.DebugModeOn())
		{
			System.out.print("; X: "+x);
			System.out.println("; Y: "+y);
		}
	}
	Runnable Threadrun = new Runnable()
	{
		public void run() 
		{
			while (true) 
			{
				Direction = (int) Math.round(Math.random() * 4 + 1);
				Movement = (int) Math.round(Math.random() * 200 + 1);
				
				for(int i=1; i<Movement; i++){
					move(1, Direction);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {}
				}
				try {
					Thread.sleep(100);	
				}
				catch (InterruptedException ex){}
			}
		}
	};
	


}
