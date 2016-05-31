package info.yukay.projectz;

public class Collision {
	Thread Collision;
	Enemy1 Enemy1 = new Enemy1();
	Player Player = new Player();
	FriendlyBullets FiendlyBullets = new FriendlyBullets();
	
	public void init() {
		Collision = new Thread (Threadrun1);
		Collision.start();
		System.out.println("Collision INIT");
	}
	
	Runnable Threadrun1 = new Runnable()
	{
		@SuppressWarnings("static-access")
		public void run() 
		{
			while (true) 
			{
				//Collision Check
				
				//Friendly bullets x Enemy
				for(int i = 0; i<FriendlyBullets.FProjectilesX.size(); i++)
				{
					if(FriendlyBullets.FProjectilesX.get(i) + 4 > Enemy1.x 
					&& FriendlyBullets.FProjectilesX.get(i) + 8 < Enemy1.x + 10
					&& FriendlyBullets.FProjectilesY.get(i) < Enemy1.y
					&& FriendlyBullets.FProjectilesY.get(i) + 16 > Enemy1.y + 10)
					{
						FriendlyBullets.RemoveBullet(i);
						System.out.println("a");
						try {
							Thread.sleep(1);	
						}
						catch (InterruptedException ex){}
					}
					
				}
				try {
					Thread.sleep(1);	
				}
				catch (InterruptedException ex){}
			}
		}
	};
}
