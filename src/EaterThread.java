import java.util.Random;

public class EaterThread extends Thread {
	private final Random random;
	private final Table table;
	private static int id = 0;

	public EaterThread(String name, Table table, long seed) {
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}

	public void run() {
		try {
			while (true) {
				String cake = table.take();
				Thread.sleep(random.nextInt(20000));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
