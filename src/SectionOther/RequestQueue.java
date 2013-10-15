import java.util.LinkedList;
import java.util.Queue;


public class RequestQueue implements RequestQueueImp{
	private final Queue<Request> queue = new LinkedList<Request>();
	private long timeout;
	
	public RequestQueue(long timeout) {
		super();
		this.timeout = timeout;
	}
	public synchronized Request getRequest(){
		long start = System.currentTimeMillis();
		while(queue.peek() == null){
			long now = System.currentTimeMillis();
			long rest = now - (timeout + start);
			if(rest > 0){
				throw new LivenessException("Time Out!!!");
			}
			try{
				System.out.println("wait...BEGIN");
				wait();
				System.out.println("wait...END");
			}catch(InterruptedException e){
			}
		}
		return queue.remove();
	}
	public synchronized void putRequest(Request request){
		System.out.println("Put.");
		queue.offer(request);
		System.out.println("notifyAll...BEGIN");
		notifyAll();
		System.out.println("notifyAll...END");
	}
}
