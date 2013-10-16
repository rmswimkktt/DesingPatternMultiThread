package Section8;

public class Channel {

	public synchronized void putRequest(final Request request){
		new Thread(new Runnable() {
			
			public void run() {
				request.execute();
			}
		}).start();
	}
}
