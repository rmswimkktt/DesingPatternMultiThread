package Question7_7;

public class Blockhole {
	public static void enter(Object obj){
		System.out.println("Step 1");
		magic(obj);
		System.out.println("Step 2");
		synchronized(obj){
			System.out.println("Step 3 (never reached here)");
		}
	}

	private static void magic(final Object obj) {
		synchronized (obj) {
			new Thread(new Runnable() {
				public void run() {
					synchronized (obj) {
						while(true){
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
					}
				}
			}).start();
		}
	}
}
