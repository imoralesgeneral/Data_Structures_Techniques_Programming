package com.structures.List;

public class ListDynamic<T> implements ListInterface<T> {

	private T first;
    private ListIF<T> tail;
    
    
    public ListDynamic ()
    {
        first = null;
        tail = null;
    }
    
    
    public ListDynamic (ListIF<T> list)
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
    public ListIF<T> getTail (){
        if (isEmpty ()) return this;
            return tail;
    }
    
    
    @Override
    public ListIF<T> insert (T element) {
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
    public IteratorIF<T> getIterator ()
    {
        ListIF<T> handler = new ListDynamic<T> (this);
        return new ListIterator<T> (handler);
    }
    
    /**
    * Devuelve cierto si la lista contiene el elemento.
    * @param element El elemento buscado.
    * @return cierto si la lista contiene el elemento.
    */
    @Override
    public boolean contains (T element){
        if (isEmpty ()) 
            return false;
        return first.equals (element) || tail.contains (element);
    }

    /**
	* Ordena los elementos de la lista.
	* @param comparator El comparador de elementos.
	* @return la lista ordenada.
	*/
	@Override
	public ListIF<T> sort (ComparatorIF<T> comparator){
		if (isEmpty ()) 
			return this;
		else 
			return ((ListDynamic<T>) tail.sort (comparator)).sortInsert (first, comparator);
	}
   
    /**
    * Inserta un elemento en orden en una lista ordenada.
    * @param element El elemento a insertar
    * @param comparator El comparador de elementos.
    * @return la lista ordenada.
    */
    private ListIF<T> sortInsert (T element, ComparatorIF<T> comparator){
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
        IteratorIF<T> listIt = getIterator ();
        while (listIt.hasNext ()) {
            T element = listIt.getNext ();
            buff.append (element);
            if (listIt.hasNext ())
            buff.append (", ");
        }
        buff.append ("]");
        return buff.toString ();
    }
    
    public ListIF<T> invertir (){
        // Caso base
        if (isEmpty())
            return this;
        // Se inserta el primer elemento    
        ListIF<T> inv = new ListDynamic<T>();
        inv = inv.insert(getFirst());
        // Hacemos la inversa de la cola
        inv = ((ListDynamic<T>) getTail()).invAux(inv);
        
        return inv;         
    }
    public ListIF<T> invAux(ListIF<T> _inv){
        if (!isEmpty()){
            _inv = _inv.insert(getFirst());
            _inv = ((ListDynamic<T>) getTail()).invAux(_inv);
        }
        return _inv;
    }
    
}
