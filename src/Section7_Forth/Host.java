package Section7_Forth;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

import Section7.Helper;

public class Host {
	private final Helper helper = new Helper();
	private final Executor executor;
	
	public Host(Executor executor){
		this.executor = executor;
	}
	
	public void request(final int count, final char c){
		System.out.println("     request(" + count + ", " + c + ") BEGIN");
		executor.execute(
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			}
		);
	}
}
