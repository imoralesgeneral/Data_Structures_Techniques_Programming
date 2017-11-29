package com.structures.Iterator;

import com.structures.Stack.StackDynamic;
import com.structures.Stack.StackInterface;

public class StackIterator<T> implements IteratorInterface<T> {

	private StackInterface<T> handler;
	private StackInterface<T> restart;
	
	/**
	* Constructor for objects of class StackIterator.
	* @param handler manager of stacks.
	*/
	public StackIterator (StackInterface<T> handler){
		this.handler = handler;
		this.restart = new StackDynamic<T> (handler);
	}
	
	/**
	* Return next iteration element.
	* @return Next iteration element.
	*/
	@Override
	public T getNext (){
		T top = handler.getTop ();
		handler.pop ();
		return top;
	}
	
	/**
	* Check if there are more elements.
	* @return true or false.
	*/
	@Override
	public boolean hasNext (){
		return !handler.isEmpty ();
	}
	
	/**
	* Reset the iterator.
	*/
	@Override
	public void reset (){
		handler = new StackDynamic<T> (restart);
	}
}
