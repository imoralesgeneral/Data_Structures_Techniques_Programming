package com.structures.HashTable;

public interface HashTableInterface<T, V> {
	
	/**
	* Calculate code to insert an element into the HashTable.
	* @return code.
	*/
	public int calculateCode(Object e);
	
	/**
	* Insert a new element into the HashTable.
	* @param key.
	* @param value.
	*/
	public void insert(T key, V value);
	
	/**
	* Find the element which has that key.
	* @param key.
	* @return T value.
	*/
	public T find(T key);
	
	/**
	* Delete the element which has that key.
	* @param key.
	*/
	public void delete(T key);

}
