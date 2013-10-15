
public class Section3Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestQueueImp requestQueueImp = new RequestQueue(3000);
		new ClientThread(requestQueueImp, "Alice", 1L).start();
		new ServerThread(requestQueueImp, "Bobby", 2L).start();

	}

}
