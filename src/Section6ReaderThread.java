
public class Section6ReaderThread extends Thread{
	private final RWData data;
	public Section6ReaderThread(RWData data){
		this.data = data;
	}
	public void run(){
		try{
			while(true){
				char[] readbuf = data.read();
				System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
			}
		}catch(InterruptedException e){
		}
	}
}
