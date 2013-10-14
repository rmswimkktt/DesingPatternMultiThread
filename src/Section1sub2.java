import java.util.Random;
import java.util.concurrent.Semaphore;


class Log {
	public static void println(String s){
		System.out.println(Thread.currentThread().getName() + ": " + s);
	}
}

class BoundedResource{
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(1);
	
	public BoundedResource(int permits){
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}
	public void use() throws InterruptedException{
		semaphore.acquire();
		try{
			doUse();
		} finally{
			semaphore.release();
		}
	}
	
	protected void doUse() throws InterruptedException{
		Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(590));
		Log.println("END:   used = " + (permits - semaphore.availablePermits()));		
	}
}

class UserThreadsub extends Thread{
	private final static Random random = new Random(2);
	private final BoundedResource resource;
	
	public UserThreadsub(BoundedResource resource){
		this.resource = resource;
	}
	
	public void run(){
		try{
			while(true){
				resource.use();
				Thread.sleep(random.nextInt(3000));
			}
		} catch(InterruptedException e){
		}
	}
}

public class Section1sub2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BoundedResource resource = new BoundedResource(3);
		
		for(int i = 0; i < 10; i++){
			new UserThreadsub(resource).start();
		}

	}

}
