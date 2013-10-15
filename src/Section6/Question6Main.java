package Section6;

public class Question6Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database<String, String> database = new SynchronizedDatabase<String, String>();
//		Database<String, String> database = new ReentrantDatabase<String, String>();
		
		new AssignThread(database, "Alice", "Alaska").start();
		new AssignThread(database, "Alice", "Australia").start();
		new AssignThread(database, "Bobby", "Brazil").start();
		new AssignThread(database, "Bobby", "Bulgaria").start();
		
		for(int i = 0; i < 10; i++){
			new RetrieveThread(database, "Alice").start();
			new RetrieveThread(database, "Bobby").start();
		}
		
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
		}
		
		System.exit(0);
	}

}
