package com.structures.HashTable;

import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public class HashTable<T> implements HashTableInterface<T>{

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
	public void insert(T key, T value) {
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

class Contenedor<T> {
	
	private T key;
	private T value;
	
	public Contenedor(T key, T value)
	{
		this.key = key;
		this.value = value;
	}
	
	public T getKey(){
		return this.key;
	}
	
	public T getValue(){
		return this.value;
	}
	
}
