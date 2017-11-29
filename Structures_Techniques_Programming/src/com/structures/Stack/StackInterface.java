package com.structures.Stack;

import com.structures.Iterator.IteratorInterface;

public interface StackInterface<T>
{
	/**
	* Return the top of the stack.
	* @return the top of the stack.
	*/
	public T getTop ();
	
	/**
	* Insert an element into the stack
	* @param element to be added.
	* @return stack including the element.
	*/
	public StackInterface<T> push (T element);
	
	/**
	* Remove the element on the top.
	* @return the stack except the element on the top.
	*/
	public StackInterface<T> pop ();
	
	/**
	* Check if the stack is empty.
	* @return true if the stack is empty.
	*/
	public boolean isEmpty ();
	
	/**
	* Check if the stack is full.
	* @return true if the stack is full.
	*/
	public boolean isFull();
	
	/**
	* Return the number of elements in the stack.
	* @return number of elements in the stack.
	*/
	public int getLength ();
	
	/**
	* Check if the stack contains the element.
	* @param element.
	* @return true if the stack contains it.
	*/
	public boolean contains (T element);
	
	/**
	* Return an iterator.
	* @return An iterator for the stack.
	*/
	public IteratorInterface<T> getIterator ();
	
}