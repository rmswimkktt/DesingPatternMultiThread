package Section8;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class Main {
	public static void main(String[] args){
		Channel channel = new Channel(5);
		channel.startWorkers();
		ClientThread alice = new ClientThread("Alice", channel);
		ClientThread bobby = new ClientThread("Bobby", channel);
		ClientThread chris = new ClientThread("Chris", channel);
		alice.start();
		bobby.start();
		chris.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alice.stopThread();
		bobby.stopThread();
		chris.stopThread();
		channel.stopAllWorkers();

	}
}
