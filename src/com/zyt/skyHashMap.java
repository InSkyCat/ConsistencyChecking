package com.zyt;

import java.util.Iterator;

import javax.management.DefaultLoaderRepository;

import com.sun.star.geometry.RealSize2D;
import com.sun.star.i18n.KCharacterType;

public class skyHashMap<K, V> implements skyMap<K, V> {

	Entry<K, V> table[] = null; // 存储数据的数组
	private int size = 0; // 元素个数
	// 很重要！ 很重要! 很重要！
	private int defaultLength = 1 << 4; // hashmap 的默认长度
	private double defaultLoader = 0.75;// 加载因子

	@Override
	public V put(K k, V v) {
		// TODO Auto-generated method stub		
		resize();
		if (table == null)
			table = new Entry[defaultLength];
		
		int index = getIndex(k,defaultLength);
		Entry<K, V> node = table[index];
		if (node == null) {
			size++;
			table[index] = new Node(k, v, null);
			return v;
		} else {
			while (node != null) {
				if (node.getKey().equals(k) || node.getKey() == k)
					return node.setValue(v);
				node = node.getNext();
			}
			size++;
			node = table[index];
			table[index] = new Node(k, v, node);
			return v;
		}
	}

	private void resize() {
		// TODO Auto-generated method stub
		
		if(size>=defaultLength*defaultLoader)
		{
			System.out.println("resize start "+size);
			// 创建一个新的数据用户扩容
			
			Entry<K, V> newTable[]=new Entry[defaultLength<<1];
			// 将原来的table 重新散列 
			for (int i = 0; i < table.length; i++) {
				Entry<K, V> node =table[i];
				if(node!=null){
					// 得到新的newTable 的index 的位置 
					while (node!=null) { 
						int index =getIndex(node.getKey(),newTable.length);
						Entry<K, V> nextNode=node.getNext();
						node.setNext(newTable[index]);
						newTable[index]=node;						
						node =nextNode;
					}
					
				}
			}
			table=newTable;
			defaultLength=newTable.length;			
			System.out.println("resize end ");
			newTable=null;
		}
	}

	public void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < table.length; i++) {
			Entry<K, V> item = table[i];
			System.out.print("下标[" + i + "]：");
			if (item != null) {
				while (item != null) {
					System.out.print("[" + item.getKey() + "," + item.getValue() + "]");
					item = item.getNext();
				}
			}
			System.out.println();
		}
	}

	private int getIndex(K k,int length) {
		// TODO Auto-generated method stub
		int index = k.hashCode() & (length - 1);
		return index;
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub

		if (table != null) {
			int index = getIndex(k,defaultLength);
			Entry<K, V> node = table[index];
			while (node != null) {
				if (node.getKey().equals(k) || node.getKey() == k)
					return node.getValue();
				node=node.getNext();
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	static class Node<K, V> implements Entry<K, V> {

		K key = null;
		V value = null;
		private Entry<K, V> next = null;

		public Node(K k, V v, Entry<K, V> next) {
			super();
			this.key = k;
			this.value = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V v) {
			// TODO Auto-generated method stub
			this.value = v;
			return this.value;
		}

		@Override
		public com.zyt.skyMap.Entry<K, V> getNext() {
			// TODO Auto-generated method stub
			return next;
		}

		@Override
		public com.zyt.skyMap.Entry<K, V> setNext(com.zyt.skyMap.Entry<K, V> next) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
