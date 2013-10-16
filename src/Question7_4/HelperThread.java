package Question7_4;

import Section7.Helper;

public class HelperThread extends Thread {
	private Helper helper;
	private int count;
	private char c;
	public HelperThread(Helper helper, int count, char c) {
		this.helper = helper;
		this.count = count;
		this.c = c;
	}
	public void run(){
		helper.handle(count, c);
	}
}
