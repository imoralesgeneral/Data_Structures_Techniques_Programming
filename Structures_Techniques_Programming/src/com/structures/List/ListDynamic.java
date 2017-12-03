package com.structures.List;


import com.structures.Comparator.ComparatorInterface;
import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.ListIterator;

public class ListDynamic<T> implements ListInterface<T> {

	private T first;
    private ListInterface<T> tail;
    
    /**
	* Constructor for ListDynamic.
	*/
    public ListDynamic()
    {
        first = null;
        tail = null;
    }
    
    /**
	* Constructor for ListDynamic.
	* @param list.
	*/
    public ListDynamic (ListInterface<T> list)
    {
        this ();
        if (list != null)
        if (!list.isEmpty ()){
            first = list.getFirst ();
            tail = new ListDynamic<T> (list.getTail());
        }
    }
    
    
    @Override
    public T getFirst (){
        return first;
    }
    
    
    @Override
    public ListInterface<T> getTail (){
        if (isEmpty ()) return this;
            return tail;
    }
    
    
    @Override
    public ListInterface<T> insert (T element) {
        if (element != null) {
            ListDynamic<T> next = new ListDynamic<T>();
            next.first = first;
            next.tail = tail;
            first = element;
            tail = next;
        }
        return this;
    }
    
    
    @Override
    public boolean isEmpty (){
        return first == null && tail == null;
    }
    
    
    @Override
    public boolean isFull () {
        return false;
    }
    
    
    @Override
    public int getLength (){
        if (isEmpty ()) 
            return 0;
        else 
            return 1 + tail.getLength ();
    }
    
    
    @Override
    public IteratorInterface<T> getIterator ()
    {
    	ListInterface<T> handler = new ListDynamic<T> (this);
        return new ListIterator<T> (handler);
    }
    

    @Override
    public boolean contains (T element){
        if (isEmpty ()) 
            return false;
        return first.equals (element) || tail.contains (element);
    }

    
	@Override
	public ListInterface<T> sort (ComparatorInterface<T> comparator){
		if (isEmpty ()) 
			return this;
		else 
			return ((ListDynamic<T>)tail.sort(comparator)).sortInsert(first, comparator);
	}
   
    /**
    * Insert an element in a ordered way.
    * @param element
    * @param comparator
    * @return a ordered list.
    */
    private ListInterface<T> sortInsert (T element, ComparatorInterface<T> comparator){
        if (isEmpty ()) 
            return this.insert (element);
        else if (comparator.isLess (element, first))
            return this.insert(element);
        else 
            return ((ListDynamic<T>) tail).sortInsert (element, comparator).insert (first);
    }
    
    public int hashcode () {
        return 31 * ((first == null) ? 0 : first.hashCode ())
                +((tail == null) ? 0 : tail.hashCode ());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof ListDynamic)) return false;
        else {
            ListDynamic<T> l = (ListDynamic<T>) o;
            return l.first.equals (first) &&
            l.tail.equals (tail);
        }
    }
    
    @Override
    public String toString ()
    {
        StringBuffer buff = new StringBuffer ();
        buff.append ("ListDynamic -[");
        IteratorInterface<T> listIt = getIterator();
        while (listIt.hasNext ()) {
            T element = listIt.getNext ();
            buff.append (element);
            if (listIt.hasNext ())
            buff.append (", ");
        }
        buff.append ("]");
        return buff.toString ();
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
        ListInterface<T> inv = new ListDynamic<T>();
        inv = inv.insert(getFirst());
        // Invert queue
        inv = ((ListDynamic<T>) getTail()).invAux(inv);
        return inv;         
    }
    
    /**
     * It inverts another list.
     * @return an inverted list .
     */
    public ListInterface<T> invAux(ListInterface<T> _inv){
        if (!isEmpty()){
            _inv = _inv.insert(getFirst());
            _inv = ((ListDynamic<T>) getTail()).invAux(_inv);
        }
        return _inv;
    }
    
}
