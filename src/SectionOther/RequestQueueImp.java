import java.util.LinkedList;
import java.util.Queue;


interface RequestQueueImp {
	public Request getRequest();
	public void putRequest(Request request);
}
