package com.zyt;

/**
 *  ģ�� HashMap ʵ��
 * @author zb
 *
 * @param <K>
 * @param <V>
 */
public interface skyMap<K,V> {
	
	//�򼯺��в���ֵ
	public V put(K k,V v);
	
	//����k ֵ��ȡ�����ж�Ӧ��ֵ
	public V get(K k);
	
	//��ȡ������Ԫ�صĸ��� 
	public int size();
	
	//�û���ȡ������ ����ֵ�� �Ķ���
	interface Entry<K,V>{
		K getKey();
		V getValue();
		V setValue(V v);
		Entry<K, V> getNext();
		Entry<K, V> setNext(Entry<K, V> next);
	}
}	
