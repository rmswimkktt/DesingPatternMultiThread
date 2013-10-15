
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table table = new Table(3);
		new MakerThread("MakerThread-1", table, 31425).start();
		new MakerThread("MakerThread-2", table, 31426).start();
		new MakerThread("MakerThread-3", table, 31427).start();
		new EaterThread("EaterThread-1", table, 31428).start();
		new EaterThread("EaterThread-2", table, 31429).start();
		new EaterThread("EaterThread-3", table, 31430).start();

	}

}
