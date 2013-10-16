package Section7_Fifth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Section7_Forth.Host;


public class Main {
	public void main(String args[]) {
		System.out.println("main BEGIN");
		ExecutorService executorService = Executors.newCachedThreadPool();
		Host host = new Host(executorService);
		try{
			host.request(10, 'A');
			host.request(20, 'B');
			host.request(30, 'C');
		}finally{
			executorService.shutdown();
			System.out.println("main END");
		}
	}
}
