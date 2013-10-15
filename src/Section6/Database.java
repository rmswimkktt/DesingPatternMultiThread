package Section6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database<K, V> {
	private final Map<K, V> map = new HashMap<K, V>();
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	//全てクリアする
	public synchronized void clear(){
		lock.readLock().lock();
		verySlowly();
		map.clear();
		lock.readLock().unlock();
	}
	
	public synchronized void assign(K key, V value){
		lock.writeLock().lock();
		verySlowly();
		map.put(key, value);
		lock.writeLock().unlock();
	}
	public synchronized V retrieve(K key){
		lock.readLock().lock();
		slowly();
		V value = map.get(key);
		lock.readLock().unlock();
		return value;
	}
	
	private void slowly(){
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
		}
	}
	
	private void verySlowly(){
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
		}
	}		
}
