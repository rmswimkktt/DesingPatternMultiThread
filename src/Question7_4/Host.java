package Question7_4;

import Section7.Helper;


public class Host {
	private final Helper helper = new Helper();
	public void request(final int count, final char c){
		System.out.println("    request(" + count + ", " + c + ") BEGIN");
		Thread thread = new HelperThread(helper, count, c);
		thread.start();
		System.out.println("    request(" + count + ", " + c + ") END");
	}
}
