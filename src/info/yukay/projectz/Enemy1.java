package info.yukay.projectz;

import java.util.ArrayList;
import java.util.List;

public class Enemy1 {
	static List<Integer> E1ProjectilesX = new ArrayList<Integer>();
	static List<Integer> E1ProjectilesY = new ArrayList<Integer>();
	Thread ThreadA;
	int Direction;
	int Movement;
	int MovementSpeed = 4;
	static int x = 50;
	int y = 50;
	
	public void init() {
			Thread ThreadA = new Thread (Threadrun1);
			ThreadA.start();	
			Thread ThreadB = new Thread (Threadrun2);
			ThreadB.start();
	}
	
	
	public boolean move(int i, int e)
	{
		
		switch(e)
		{
		case 1:
			if (y >= 12)
			{
				y = y - i;
				return true;
			}
			break;
		case 2:
			if (y <= 230)
			{
				y = y + i;
				return true;
			}
			break;
		case 3:
			if (x >= 12)
			{
				x = x - i;
				return true;
			}
			break;
		case 4:
			if (x <= 399)
			{
				x = x + i;
				return true;
			}
			break;
		
		}
		if (ProjectZ.DebugModeOn())
		{
			System.out.print("; X: "+x);
			System.out.println("; Y: "+y);
		}
		return false;
	}
	
	Runnable Threadrun1 = new Runnable()
	{
		public void run() 
		{
			while (true) 
			{
				Direction = (int) Math.round(Math.random() * 4 + 1);
				
				Movement = (int) Math.round(Math.random() * 200 + 10);
				
				for(int i=1; i<Movement; i++){
					if (!move(1, Direction))
					{
						i = Movement;
					}
					try {
						Thread.sleep(MovementSpeed);
					} catch (InterruptedException e) {}
				}
				E1ProjectilesX.add(x);
				E1ProjectilesY.add(y);
				
				System.out.println(Direction);
				
				try {
					Thread.sleep(1000);	
				}
				catch (InterruptedException ex){}
			}
		}
	};
	
	Runnable Threadrun2 = new Runnable()
	{
		public void run() 
		{
			System.out.println("Thread Runned");
			
			
			
			while (true) 
			{
				
				for(int i = 0; i < E1ProjectilesY.size() ; i++)
				{
					//ProjectZ.gBuff.drawImage(Bullet, ProjectilesX.get(i), ProjectilesY.get(i), this);
					//drawBullet(ProjectilesX.get(i), ProjectilesY.get(i));
					E1ProjectilesY.set(i, E1ProjectilesY.get(i) + 1);
					if(E1ProjectilesY.get(i) > 450)
					{
						E1ProjectilesX.remove(i);
						E1ProjectilesY.remove(i);
						if(ProjectZ.DebugModeOn())
						{
							System.out.println(i + "Removed");
						}
					}
					if(ProjectZ.DebugModeOn())
					{
						System.out.println(E1ProjectilesX.get(i)+ " " + E1ProjectilesY.get(i));
					}
				
				}
				try 
				{
					Thread.sleep(10);
				}
				catch (InterruptedException ex){}
			}
		}
	};


}
