package Section6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LocksData implements Data{
	private final char[] buffer;
	private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	public LocksData(int size){
		this.buffer = new char[size];
		for(int i = 0; i < buffer.length; i++){
			buffer[i] = '*';
		}
	}
	public synchronized char[] read() throws InterruptedException{
		return doRead();
	}
	public synchronized void write(char c) throws InterruptedException{
		doWrite(c);
	}
	private char[] doRead(){
		char[] newbuf = new char[buffer.length];
		for(int i = 0; i < buffer.length; i++){
			newbuf[i] = buffer[i];
		}
		slowly();
		return newbuf;
	}
	private void doWrite(char c){
		for(int i = 0; i < buffer.length; i++){
			buffer[i] = c;
			slowly();
		}
	}
	private void slowly(){
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
		}
	}

}
