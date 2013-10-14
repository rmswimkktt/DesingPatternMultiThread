
public class section2Question2_3 {
	private static final long CALL_COUNT = 1000000000L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		trial("NotSynch", CALL_COUNT, new NotSynch());
		trial("Synch",    CALL_COUNT, new Synch());
	}
	
	private static void trial(String msg, long count, Object object){
		System.out.println(msg + ": BEGIN");
		long start_time = System.currentTimeMillis();
		for(long i = 0; i < count; i++){
			object.toString();
		}
		System.out.println(msg + ": END");
		System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");
	}

}

class NotSynch{
	private final String name = "NotSynch";
	public String toString(){
		return "[ " + name + "]";
	}
}

class Synch{
	private final String name = "Synch";
	public synchronized String toString(){
		return "[ " + name + "]";
	}
}