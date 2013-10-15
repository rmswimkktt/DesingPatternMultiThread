
public class Section3MainNext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestQueueImp requestQueue = new RequestQueue(1000);
		new ClientThread(requestQueue, "Alice", 1L).start();
		new ServerThread(requestQueue, "Bobby", 2L).start();

	}

}
