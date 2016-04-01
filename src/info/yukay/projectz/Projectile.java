package info.yukay.projectz;

public class Projectile {

	Thread ThreadA;
	static int ProjSize = 20;
	static boolean RandomProjectileLoc;
	static int calcPosX;
	static int posX;
	static int calcPosY;
	static int posY;	
	static int ProjSpeed1 = 10;
	static int GrowthSpeed = 500;
	
	public static void init() {
		Thread ThreadA = new Thread (Threadrun);
		ThreadA.start();
		Thread ThreadB = new Thread (Threadrun1);
		ThreadB.start();
		System.out.println("Projectile INIT");
	}
	
	static Runnable Threadrun = new Runnable(){
		public void run() {
			while (true) {
				
				if (RandomProjectileLoc == true)
				{
					
					calcPosX = (int) Math.rint(Math.random() * 1000);
					if (calcPosX > 10 && calcPosX < 390)
					{
						RandomProjectileLoc = false;
						posX = calcPosX;
						if (ProjectZ.DebugModeOn())
						{
						System.out.println(posX);
						}
					}	
				}
				
				if (calcPosY >= 443)
				{
						RandomProjectileLoc = true;
						calcPosY = 50;
						posY = calcPosY;
				} 
				else if (calcPosY <= 443) 
				{
						calcPosY = calcPosY + 5;
						posY = calcPosY;
				}
				
				try {
				Thread.sleep(ProjSpeed1);	
				}
				catch (InterruptedException ex){}
				}
			}
	};
	
	static Runnable Threadrun1 = new Runnable(){
		public void run() {
			while (true) {
				ProjSize = ProjSize + 1;
				
				try {
				Thread.sleep(GrowthSpeed);	
				}
				catch (InterruptedException ex){}
				}
			}
	};
}
	



