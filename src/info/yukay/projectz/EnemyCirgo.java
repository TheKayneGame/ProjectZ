package info.yukay.projectz;

public class EnemyCirgo {
	public static void init() {
		Thread ThreadA = new Thread (Threadrun);
		ThreadA.start();
		
	}
	
	static Runnable Threadrun = new Runnable(){
		public void run() {
			while (true) {
				
				
				try {
				Thread.sleep(10);	
				}
				catch (InterruptedException ex){}
				}
			}
	};
}
