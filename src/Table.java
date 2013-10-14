
public class Table {
	private final String[] buffer;
	private int tail;
	private int head;
	private int count;
	public Table(int count){
		this.buffer = new String[count];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}
	
	public synchronized void put(String cake) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " puts " + cake);
		while(count >= buffer.length){
			System.out.println("Put wait.");
			wait();
		}
		buffer[tail] = cake;
		tail = (tail + 1) % buffer.length;
		count++;
		notifyAll();
	}
	
	public synchronized String take() throws InterruptedException{
		while(count <= 0){
			System.out.println("Take wait.");
			wait();
		}
		String cake = buffer[head];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " taked " + cake);
		return cake;
	}
	
	public synchronized void clear(){
		for(int i = 0; i < buffer.length; i++){
			buffer[i] = new String();
		}
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}

}
