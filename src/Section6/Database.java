package Section6;


interface Database<K, V> {
	//全てクリアする
	void clear();
	void assign(K key, V value);
	public V retrieve(K key);
}
