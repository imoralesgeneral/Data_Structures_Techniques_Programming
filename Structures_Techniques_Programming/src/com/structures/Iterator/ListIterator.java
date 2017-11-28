package com.structures.Iterator;

import com.structures.List.ListInterface;

public class ListIterator<T> implements IteratorInterface<T>{

	private ListInterface<T> handler;
	private ListInterface<T> restart;
	
	/**
	* Constructor for ListIterator.
	* @param handler List manager.
	*/
	public ListIterator(ListInterface<T> handler)
	{
		this.handler = handler;
		this.restart = handler;
	}
	
	/**
	* Return next iterator element.
	* @return Next iterator element.
	*/
	@Override
	public T getNext()
	{
		T next = handler.getFirst ();
		handler = handler.getTail ();
		return next;
	}
	
	/**
	* Check if there are more elements.
	* @return True if there are more elements.
	*/
	@Override
	public boolean hasNext()
	{
		return !handler.isEmpty ();
	}
	
}
