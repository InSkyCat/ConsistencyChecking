package com.zyt;

/**
 *  模拟 HashMap 实现
 * @author zb
 *
 * @param <K>
 * @param <V>
 */
public interface skyMap<K,V> {
	
	//向集合中插入值
	public V put(K k,V v);
	
	//根据k 值获取集合中对应的值
	public V get(K k);
	
	//获取集合中元素的个数 
	public int size();
	
	//用户获取集合中 ，键值对 的对象
	interface Entry<K,V>{
		K getKey();
		V getValue();
		V setValue(V v);
		Entry<K, V> getNext();
		Entry<K, V> setNext(Entry<K, V> next);
	}
}	
