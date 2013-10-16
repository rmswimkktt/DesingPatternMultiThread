package Section7_Third;

import java.util.concurrent.Executors;

import Section7_Second.Host;

public class Main {
	public void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host(
				Executors.defaultThreadFactory()
		);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		System.out.println("main END");
	}
}
