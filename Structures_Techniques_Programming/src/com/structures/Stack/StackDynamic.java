package com.structures.Stack;

import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.StackIterator;
import com.structures.List.ListInterface;

public class StackDynamic<T> implements StackInterface<T> 
{
	private T element;
	private StackDynamic<T> next;
	
	/**
	* Constructor for StackDynamic.
	*/
	public StackDynamic (){
		element = null;
		next = null;
	}
	
	/**
	* Constructor for StackDynamic.
	* @param stack
	*/
	public StackDynamic (StackInterface<T> stack){
		this ();
		if (stack != null)
			if (!stack.isEmpty ()){
				element = stack.getTop ();
				next = new StackDynamic<T> (stack.pop ());
				stack.push (element);
			}
	}
	
	/**
	* Constructor for StackDynamic.
	* @param list
	*/
	public StackDynamic (ListInterface<T> list){
		this ();
		if (list != null)
			if (!list.isEmpty()) {
				element = list.getFirst ();
				next = new StackDynamic<T> (list.getTail ());
			}
	}
	
	@Override
	public T getTop (){
		return element;
	}
	
	@Override
	public StackInterface<T> push (T element){
		if (element != null) {
			StackDynamic<T> stack = new StackDynamic<T> ();
			stack.element = this.element;
			stack.next = this.next;
			this.element = element;
			this.next = stack;
		}
		return this;
	}
	
	@Override
	public StackInterface<T> pop (){
		if (!isEmpty ()) {
			element = next.element;
			next = next.next;
		}
		return this;
	}
	
	@Override
	public boolean isEmpty (){
		return element == null && next == null;
	}
	
	@Override
	public boolean isFull(){
		return false;
	}
	
	@Override
	public int getLength (){
		if (isEmpty ()) 
			return 0;
		return 1 + next.getLength ();
	}
	
	@Override
	public boolean contains (T element){
		if (isEmpty ()) 
			return false;
		else 
			return this.element.equals (element) || next.contains (element);
	}
	
	@Override
	public IteratorInterface<T> getIterator (){
		StackInterface<T> handler = new StackDynamic<T> (this);
		return new StackIterator<T> (handler);
	}
	
	@Override
	public int hashCode (){
		return 31 * ((element == null) ? 0 : element.hashCode ()) +
		((next == null) ? 0 : next.hashCode ());
	}
	
	/*
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals (Object o) {
	
	}
	*/
	@Override
	public String toString () {
		StringBuffer buff = new StringBuffer ();
		buff.append ("StackDynamic -[");
		IteratorInterface<T> listIt = getIterator ();
		while (listIt.hasNext ()) {
			T element = listIt.getNext();
			buff.append (element);
			if (listIt.hasNext ())
				buff.append (", ");
		}
		buff.append ("]");
		return buff.toString ();
	}
	
	/**
	 * Return inverse stack
	 * @return inverse stack
	 */
	public StackInterface<T> inversa(){
		StackDynamic<T> inv = new StackDynamic<T>();
		if (!isEmpty())
			inv = (StackDynamic<T>) inversaAux(inv);
		return inv;
	}
	
	
	private StackInterface<T> inversaAux (StackInterface<T> inv){
		inv.push(getTop());
		if (!next.isEmpty())
			inv = next.inversaAux(inv);
		return inv;
	}
	
}
