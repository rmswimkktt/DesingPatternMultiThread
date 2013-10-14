import java.util.LinkedList;
import java.util.Queue;


public class RequestQueue implements RequestQueueImp{
	private final Queue<Request> queue = new LinkedList<Request>();
	public synchronized Request getRequest(){
		while(queue.peek() == null){
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
