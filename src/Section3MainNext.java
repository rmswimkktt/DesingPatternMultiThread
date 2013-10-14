
public class Section3Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Alice", 1L).start();
		new ServerThread(requestQueue, "Bobby", 2L).start();

	}

}
