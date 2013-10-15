import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Section2sub2CopyOnWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final List<Integer> list = new CopyOnWriteArrayList<Integer>();
		new WriterThread(list).start();
		new ReaderThread(list).start();
	}

}
