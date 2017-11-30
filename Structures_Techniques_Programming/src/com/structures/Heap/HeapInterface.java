package com.structures.Heap;

public interface HeapInterface<T> {

	/**
	* Check if the heap is empty.
	* @return true if the heap is empty.
	*/
	public boolean isEmpty (); 
	
	/**
	* Move a node up in the tree, as long as needed; used to restore heap condition after insertion.
	* @param index of the element to shift up.
	*/
	public void shiftUp(int i);
	
	/**
	* Move a node down in the tree, similar to sift-up; used to restore heap condition after deletion or replacement.
	* @param index of the element to shift down.
	*/
	public void shiftDown(int i);
	
	/**
	* Insert a new element into the heap.
	* @param element.
	* @return a heap including the element.
	*/
	public void insert (T element);
	
	/**
	* Return the peek and delete it in the heap.
	* @return the peek of the heap.
	*/
	public T getTop ();
	
	/**
	* Return the first element of a heap.
	* @return first element of a heap.
	*/
	public T getFirst ();
	
	
}
