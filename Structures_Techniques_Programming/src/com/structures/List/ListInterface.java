package com.structures.List;

import com.structures.Comparator.ComparatorInterface;
import com.structures.Iterator.IteratorInterface;

public interface ListInterface<T> {

	/**
	* Return the first element of a list.
	* @return first element of a list.
	*/
	public T getFirst ();
	
	/**
	* Return the list except the first element.
	* @return the list except the first element.
	*/
	public ListInterface<T> getTail ();
	
	/**
	* Insert a new element into the list.
	* @param element.
	* @return a list including the element.
	*/
	public ListInterface<T> insert (T element);
	
	/**
	* Check if the list is empty.
	* @return true if the list is empty.
	*/
	public boolean isEmpty ();
	
	/**
	* Check if the list is full.
	* @return true if the list is full.
	*/
	public boolean isFull();
	
	/**
	* Return the number of elements in the list.
	* @return number of elements in the list.
	*/
	public int getLength ();
	
	/**
	* Return an iterator.
	* @return An iterator for the list.
	*/
	public IteratorInterface<T> getIterator ();
	
	/**
	* Check if the list contains the element.
	* @param element.
	* @return true if the list contains it.
	*/
	public boolean contains (T element);
	
	/**
	* Order the list.
	* @param comparator.
	* @return ordered list.
	*/
	public ListInterface<T> sort (ComparatorInterface<T> comparator);
	
}
