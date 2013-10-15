import java.util.concurrent.Exchanger;


public class ExchangeMain {

	public static void main(String[] args) {
		Exchanger<char[]> exchanger = new Exchanger<char[]>();
		char[] buffer1 = new char[10];
		char[] buffer2 = new char[10];
		new ProducerThread(exchanger, buffer1, 1).start();
		new ConsumerThread(exchanger, buffer2, 3).start();
		
	}

}
