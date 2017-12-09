package com.structures.Queue;

import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.QueueIterator;
import com.structures.List.ListInterface;

public class QueueStatic<T> implements QueueInterface<T>
{

    private Object[] elements;
    private int capacity;
    private int first;
    private int last;

    /**
     * Constructor for objects of class QueueStatic
     */
    public QueueStatic(int capacity)
    {

        this.elements = new Object[capacity+1];
        this.capacity = capacity+1;
        this.first = 0;
        this.last = 0;
    }
    
    /**
     * Constructor for objects of class QueueStatic
     * @param queue
     */
    public QueueStatic(QueueInterface<T> queue)
    {
        if(queue != null){
            this.capacity = queue.getLength()+1;
            this.elements = new Object[this.capacity+1];
            this.first = 0;
            this.last = 0;
            
            for(int i=0; i<queue.getLength(); i++) {
                T element = queue.getFirst();
                add(element);
                queue.remove();
                queue.add(element);
            }
        }
    }

    /**
     * Constructor for objects of class QueueStatic
     * @param list
     */
    public QueueStatic(ListInterface<T> list)
    {
        if(list != null) {
            this.capacity = list.getLength()+1;
            this.elements = new Object[this.capacity+1];
            this.first = 0;
            this.last = 0;
            
            ListInterface<T> l = list;
            while(!l.isEmpty()){
                add(l.getFirst());
                l = l.getTail();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public T getFirst()
    {
        if(isEmpty()){
            return null;
        }
        return (T)elements[first];
    }
    
    @Override
    public QueueInterface<T> add(T elem)
    {
        if(elem != null) {
            if(!isFull()) {
                elements[last] = elem;
                last = next(last);
            }
        }
        return this;
    }
    
    @Override
    public QueueInterface<T> remove()
    {
        if(!isEmpty()){
            first = next(first);
        } 
        return this;
    }
    
    @Override
    public boolean isEmpty()
    {
        return first == last;
    }
    
    @Override
    public boolean isFull()
    { 
        return next(last) == first;
    }
    
    @Override
    public int getLength()
    {
        if(first <= last) {
            return last-first;
        } else {
            return capacity - (first-last);
        }
    }
    
    private int next(int index)
    {
        return(index+1)%capacity;
    }
    
    @Override
    public boolean contains(T elem)
    {
        boolean found = false;
        int index = first;
        while(!found && Math.abs(last-index)>0) {
            found = elements[index].equals(elem);
            index = next(index);
        }
        return found;
    }
    
    @Override
    public IteratorInterface<T> getIterator()
    {
        QueueInterface<T> handler = new QueueStatic<T>(this.capacity);
        return new QueueIterator<T>(handler);
    }
    
}

