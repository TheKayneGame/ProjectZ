package info.yukay.projectz;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;

public class Projectile{

	Thread ThreadA;
	static double posX;
	static int TrSpeed1 = 100;
	
	public static void init() {
		Thread ThreadA = new Thread (Threadrun);
		ThreadA.start();
		System.out.println("Projectile INIT");
	}
	
	
	static Runnable Threadrun = new Runnable(){


	public void run() {
		while (true) {
			
			if (InputKeyEvents.getKey() == KeyEvent.VK_Q)
			{
				
				posX = Math.random();
				posX = posX * 1000;
				posX = Math.rint(posX);
				if (posX > 10 && posX < 410)
				{
					System.out.println(posX);
				}
			}
			
			try {
			Thread.sleep(TrSpeed1);	
			}
			catch (InterruptedException ex){}
			}
		}
	};
}
	



