package com.structures.Queue;

import com.structures.Iterator.IteratorInterface;

public interface QueueInterface<T> {

	/**
	* Return the first element of a queue.
	* @return first element of a queue.
	*/
	public T getFirst ();
	
	/**
	* Insert a new element into the queue.
	* @param element
	* @return a queue including the element.
	*/
	public QueueInterface<T> add (T element);
	
	/**
	* Return the queue except the first element.
	* @return the queue except the first element.
	*/
	public QueueInterface<T> remove ();
	
	/**
	* Check if the queue is empty.
	* @return true if the queue is empty.
	*/
	public boolean isEmpty ();
	
	/**
	* Check if the queue is full.
	* @return true if the queue is full.
	*/
	public boolean isFull();
	
	/**
	* Return the number of elements in the queue.
	* @return number of elements in the queue.
	*/
	public int getLength ();
	
	/**
	* Check if the queue contains the element.
	* @param element.
	* @return true if the queue contains it.
	*/
	public boolean contains (T element);
	
	/**
	* Return an iterator.
	* @return An iterator for the queue.
	*/
	public IteratorInterface<T> getIterator ();
	
}
