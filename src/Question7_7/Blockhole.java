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
		Thread thread = new Thread(){
			public void run() {
				synchronized (obj) {
					synchronized (this) {
						this.setName("Start");
						this.notify();
					}
					while(true){
					}
				}
			}
		};
		synchronized (thread) {
			thread.setName("NotStart");
			thread.start();
			while(thread.getName().equals("NotStart")){
				try {
					thread.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
