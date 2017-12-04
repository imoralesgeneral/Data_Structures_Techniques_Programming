package com.structures.HashTable;

import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public class HashTable<T, V> implements HashTableInterface<T, V>{

	private ListDynamic<T>[] v;
	private int size;
	
	public HashTable()
	{
		this.size = 49;
		v = new ListDynamic[49];
	}
	
	public HashTable(int size)
	{
		this.size = size;
		v = new ListDynamic[size];
	}
	
	@Override
	public int calculateCode(Object key) {
		return key.hashCode()%size;
	}

	@Override
	public void insert(T key, V value) {
		int code = calculateCode(key);
		Contenedor contenedor = new Contenedor(key, value);
		v[code].insert((T) contenedor);
	}

	@Override
	public T find(T key) {
		int code = calculateCode(key);
		T contenedor = null;
		ListDynamic aux = new ListDynamic(v[code]);
		ListIterator li = (ListIterator) aux.getIterator();
		while(li.hasNext()) {
			Contenedor aux_two = (Contenedor) li.getNext();
			if(aux_two.getKey().equals(key)){
				contenedor = (T)aux_two.getValue();
				break;
			}
		}
		return contenedor;
	}
	
	public boolean contains(T key) {
		boolean sol = false;
		T contenedor = find(key);
		if(contenedor != null) sol = true;
		return sol;
	}

	@Override
	public void delete(T key) {
		int code = calculateCode(key);
		ListDynamic aux = new ListDynamic(v[code]);
		ListDynamic aux_one = new ListDynamic();
		ListIterator li = (ListIterator) aux.getIterator();
		while(li.hasNext()) {
			Contenedor aux_two = (Contenedor) li.getNext();
			if(!aux_two.getKey().equals(key)){
				aux_one.insert(aux_two);
			}
		}
		v[code] = null;
		v[code] = aux_one;
	}

}

class Contenedor<T, V> {
	
	private T key;
	private V value;
	
	public Contenedor(T key, V value)
	{
		this.key = key;
		this.value = value;
	}
	
	public T getKey(){
		return this.key;
	}
	
	public V getValue(){
		return this.value;
	}
	
}
