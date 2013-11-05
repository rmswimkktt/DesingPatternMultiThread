package Section11_Second;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientThread("Alice").start();
		new ClientThread("Bobby").start();
		new ClientThread("Chris").start();
	}

}
