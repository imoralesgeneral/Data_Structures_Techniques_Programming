package com.structures.Iterator;

public interface IteratorInterface<T> {
	
	/**
	* Return next iteration element.
	* @return Next iteration element.
	*/
	public T getNext ();
	
	/**
	* Check if there are more elements.
	* @return true or false.
	*/
	public boolean hasNext ();
	
	/**
	* Reset the iterator.
	*/
	public void reset ();
}
