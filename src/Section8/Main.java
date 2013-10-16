package Section8;

public class Main {
	public static void main(String[] args){
		Channel channel = new Channel();
		try{
			new ClientThread("Alice", channel).start();
			new ClientThread("Bobby", channel).start();
			new ClientThread("Chris", channel).start();
			
			Thread.sleep(5000);
			
		}catch(InterruptedException e){
			
		}finally{
			System.exit(0);
		}
	}
}
