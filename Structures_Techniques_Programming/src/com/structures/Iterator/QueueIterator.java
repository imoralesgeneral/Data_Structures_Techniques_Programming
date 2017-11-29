package com.structures.Iterator;

import com.structures.Queue.QueueDynamic;
import com.structures.Queue.QueueInterface;

public class QueueIterator<T> implements IteratorInterface<T>{
	
	private QueueInterface<T> handler;
	private QueueInterface<T> restart;
	
	/**
	* Constructor for objects of class QueueIterator.
	* @param handler manager of queue.
	*/
	public QueueIterator (QueueInterface<T> handler)
	{
		this.handler = handler;
		this.restart = new QueueDynamic<T> (handler);
	}
	
	/**
	* Return next iteration element.
	* @return Next iteration element.
	*/
	@Override
	public T getNext ()
	{
		T element = handler.getFirst ();
		handler.remove ();
		return element;
	}
	
	/**
	* Check if there are more elements.
	* @return true or false.
	*/
	@Override
	public boolean hasNext ()
	{
		return !handler.isEmpty ();
	}
	
	/**
	* Reset the iterator.
	*/
	@Override
	public void reset ()
	{
		handler = new QueueDynamic<T> (restart);
	}
}
