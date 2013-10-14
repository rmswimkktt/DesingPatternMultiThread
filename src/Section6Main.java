
public class Section6Main {
	public static void main(String[] args){
		RWData data = new RWData(10);
		new Section6ReaderThread(data).start();
		new Section6ReaderThread(data).start();
		new Section6ReaderThread(data).start();
		new Section6ReaderThread(data).start();
		new Section6ReaderThread(data).start();
		new Section6ReaderThread(data).start();
		new Section6WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
		new Section6WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
	}
}
