package Section7_Forth;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Main {
	public void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host(
				new Executor() {
					public void execute(Runnable r) {
						new Thread(r).start();						
					}
				}
		);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		System.out.println("main END");
	}
}
