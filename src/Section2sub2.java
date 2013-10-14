import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Section2sub2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		new WriterThread(list).start();
		new ReaderThread(list).start();
	}

}
