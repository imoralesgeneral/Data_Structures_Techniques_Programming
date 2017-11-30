package com.structures.Heap;

public class Heap<T> implements HeapInterface<T> {

	private T[] V;
	private int c;
	private int max;
	
	/**
	* Constructor for Heap.
	*/
	public Heap() {
		
	}
	
	/**
	* Constructor for Heap.
	* @param n Max size.
	*/
	public Heap(int n) {
		this.V = null;
		this.c = 0;
		this.max = n;
	}
	
	/**
	* Constructor for Heap.
	* @param n Max size.
	* @param V T[].
	*/
	public Heap(int n, T[] V) {
		this.V = V;
		this.c = V.length-1;
		this.max = n;
	}
    
	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(c == 0) {
			empty = true;
		}
		return empty;
	}

	@Override
	public void shiftUp(int i) {
		int father = i/2;
		while(i > 1 && (V[father] < V[i])) //// CREAR COMPARATOR
        {
            exchange(i, father);
            i = i / 2;
            father = i / 2;
        }
	}

	@Override
	public void shiftDown(int i) {
		int hi = 2*i;
        int hd = 2*i+1;
        int p = i;
        do {
            if(hi <= c && hd <= c)
            {
                if((hi <= max) && (V[hd] > V[i]))
                {
                    i = hd;
                }
                if((hi <= max) && (V[hi] > V[i]))
                {
                    i = hi;
                }
                exchange(p, i);
                hi = 2*i;
                hd = 2*i+1;
                p = i;
                i = i*2;
            }
        } while (p != i && i < c);
    }

	@Override
	public void insert(T element) {
		if(c == max)
        {
            //ERROR  HEAP IS FULL
        } else {
            c = c+1;
            V[c] = element;
            shiftUp(c);
        }		
	}

	@Override
	public T getTop() {
		T element = null;
        if(c != 0)
        {
        	element = V[1];
            V[1] = null;
            exchange(1,c);
            //V[1] = V[c];
            c = c-1;
            shiftDown(1);
        }
        return element;	
	}

	@Override
	public T getFirst() {
		T first = null;
        if(c == 0)
        {
            // dev ERROR
        } else {
        	first = V[1];
        }
        return first;	
	}
	
	/**
	* Exchange two elements
	* @param e index first element.
	* @param i index second element.
	*/
	public void exchange(int e, int i) {
		T aux_one = V[e];
        T aux_two = V[i];
        V[e] = aux_two;
        V[i] = aux_one;
	}
	
	/**
	* Exchange two elements
	* @param e index first element.
	* @param i index second element.
	*/
	public T[] Heapsort(T[] t, int max)
    {
        T e = null;
        T[] s = null;
        Heap aux = new Heap(max, t);
        for(int i=1; i< t.length; i++)
        {
            e = (T) aux.getTop();
            s[i] = e;
        }        
        return s;
    }
}
