import java.util.List;


public class WriterThreadCopyOnWrite extends Thread{
	private final List<Integer> list;
	public WriterThreadCopyOnWrite(List<Integer> list){
		super("WriterThread");
		this.list = list;
	}
	public void run(){
		for(int i = 0; true; i++){
			list.add(i);
			list.remove(0);
		}
	}
}
