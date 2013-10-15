import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class BackgroundTaskTest {
	@Rule
	public Timeout timeout = new Timeout(1000);
	
	@Test
	public void invoke_is_another_thread() throws Exception{
		final AtomicReference<String> backgroundThreadName = new AtomicReference<String>();
		final CountDownLatch latch = new CountDownLatch(1);
		Runnable task = new Runnable() {
			public void run() {
				backgroundThreadName.set(Thread.currentThread().getName());
				latch.countDown();
				// TODO Auto-generated method stub
				
			}
		};
		BackgroundTask sut = new BackgroundTask(task);
		
		sut.invoke();
		latch.await();
		
		assertThat(backgroundThreadName.get(), is(not(Thread.currentThread().getName())));
	}
}
