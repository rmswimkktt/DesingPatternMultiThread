package Section6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantDatabase<K, V> implements Database<K, V> {
	private final Map<K, V> map = new HashMap<K, V>();
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	//全てクリアする
	public void clear(){
		lock.writeLock().lock();
		try{
			verySlowly();
			map.clear();
		}finally{
			lock.writeLock().unlock();
		}
	}
	
	public void assign(K key, V value){
		lock.writeLock().lock();
		try{
			verySlowly();
			map.put(key, value);
		}finally{
			lock.writeLock().unlock();
		}
	}
	public V retrieve(K key){
		lock.readLock().lock();
		V value;
		try{
			slowly();
			value = map.get(key);
		}finally{
			lock.readLock().unlock();
		}
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
