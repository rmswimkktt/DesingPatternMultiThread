package Section6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedDatabase<K, V> implements Database<K, V>{
	private final Map<K, V> map = new HashMap<K, V>();
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	//全てクリアする
	public synchronized void clear(){
		verySlowly();
		map.clear();
	}
	
	public synchronized void assign(K key, V value){
		verySlowly();
		map.put(key, value);
	}
	public synchronized V retrieve(K key){
		slowly();
		return map.get(key);
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
