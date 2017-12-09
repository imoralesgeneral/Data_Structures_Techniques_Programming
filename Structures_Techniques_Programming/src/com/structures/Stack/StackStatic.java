package com.structures.Stack;

import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.StackIterator;
import com.structures.List.ListInterface;

public class StackStatic<T> implements StackInterface<T>
{

    private Object[] elements;
    private int capacity;
    private int top;

    /**
     * Constructor for objects of class StackStatic
     */
    public StackStatic(int capacity)
    {

        this.elements = new Object[capacity];
        this.capacity = capacity;
        this.top = -1;
    }
    
    /**
     * Constructor for objects of class StackStatic
     * @param stack
     */
    @SuppressWarnings("unchecked")
	public StackStatic(StackInterface<T> stack)
    {
        if(stack != null) {
            this.capacity = stack.getLength();
            this.elements = new Object[this.capacity];
            this.top = -1;
            
            for(int i=capacity-1; i>=0; i--) {
                T element = stack.getTop();
                elements[i] = element;
                stack.pop();
                top++;
            }
            for(int i=0; i<= capacity-1; i++) {
                T element = (T) elements[i];
                stack.push(element);
            }
        }
    }
    
    /**
     * Constructor for objects of class StackStatic
     * @param list
     */
    public StackStatic(ListInterface<T> list)
    {
        if(list != null) {
            this.capacity = list.getLength();
            this.elements = new Object[this.capacity];
            this.top = -1;
            
            ListInterface<T> aList = list;
            for(int i=0; i < list.getLength(); i++) {
                this.elements[i] = aList.getFirst();
                aList = aList.getTail();
            }
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public T getTop()
    {
        if(isEmpty()) {
            return null;
        }
        return (T) elements[top];
    }
    
    @Override
    public StackInterface<T> push (T elem)
    {
        if(elem != null) {
            if(!isFull()) { 
                top = top+1;
                elements[top] = elem;
            }
        }
        return this;
    }
    
    @Override
    public StackInterface<T> pop ()
    {
        if(!isEmpty()) {
            top = top-1;
        } 
        return this;
    }
    
    @Override
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    @Override
    public boolean isFull()
    {
        return top == (capacity-1);
    }
    
    @Override
    public int getLength()
    {
        return top+1;
    }
    
    @Override
    public boolean contains (T elem)
    {
        boolean found = false;
        int index = top;
        while(!found && index>=0) {
            found = elements[index].equals(elem);
            index--;
        }
        return found;
    }
    
    @Override
    public IteratorInterface<T> getIterator()
    {
        StackInterface<T> handler = new StackStatic<T>(this.capacity);
        return new StackIterator<T>(handler);
    }
    
}
