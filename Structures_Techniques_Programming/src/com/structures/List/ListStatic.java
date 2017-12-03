package com.structures.List;

import com.structures.Comparator.ComparatorInterface;
import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.ListIterator;

public class ListStatic<T> implements ListInterface<T>
{
    private Object[] elements;
    private int capacity;
    private int first;

    /**
     * Constructor for objects of class ListStatic
     */
    public ListStatic(int capacity)
    {
        this.capacity = capacity;
        this.first = capacity;
        this.elements = new Object[capacity];
    }

    /**
     * Constructor for objects of class ListStatic
     * @param list
     */
    public ListStatic(ListInterface<T> list)
    {
        if(list != null){
            this.capacity = list.getLength();
            this.first = this.capacity;
            this.elements = new Object[this.capacity];
            
            ListInterface<T> aList = list;
            for(int i = capacity-list.getLength(); i < capacity; i++){
                this.elements[i] = aList.getFirst();
                this.first = this.first-1;
                aList = aList.getTail();
            }
        }
    }
    
    /**
     * It copies a list
     * @param list
     * @return a list copied.
     */
    private ListInterface<T> copy (ListStatic<T> list)
    {
        ListStatic<T> l = new ListStatic<T>(capacity);
        l.first = list.first;
        l.elements = list.elements;
        return l;
    }
    
    @Override
    public T getFirst()
    {
        if(isEmpty()){ 
            return null;
        }
        return (T)elements[first];
    }
    
    @Override
    public ListInterface<T> getTail()
    {
        if(!isEmpty()){
            ListStatic<T> tail = (ListStatic<T>) copy (this);
            tail.first = first+1;
            return tail;
        }
        return this;
    }
    
    @Override
    public ListInterface<T> insert (T elem)
    {
        if(!isFull()){
            first = first - 1;
            elements[first] = elem;
        } 
        return this;
    }
    
    @Override
    public boolean isEmpty()
    {
        return first == capacity;
    }
    
    @Override
    public boolean isFull()
    {
        return first == 0;
    }
    
    @Override
    public int getLength()
    {
        return capacity-first;
    }
    
    @Override
    public IteratorInterface<T> getIterator()
    {
    	ListInterface<T> handler = new ListStatic<T>(this);
        return new ListIterator<T> (handler);
    }
    
    @Override
    public boolean contains (T elem)
    {
     return true;//   
    }
    
    /**
     * It inverts the list.
     * @return an inverted list .
     */
    public ListInterface<T> invert (){
        // Case 0
        if (isEmpty())
            return this;
        // Insert first element   
        ListDynamic<T> inv = new ListDynamic<T>(this);
        ListStatic<T> inv_ = new ListStatic<T>(inv.invert());
        return inv_;         
    }
    
    @Override
    public ListInterface<T> sort (ComparatorInterface<T> comparator)
    {
        return new ListDynamic<T>();
    }

}
