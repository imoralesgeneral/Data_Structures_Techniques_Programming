package com.structures.Heap;

import java.util.Arrays;

import com.structures.Comparator.ComparatorHeap;

public class Heap<T> implements HeapInterface<T> {

	private Object[] V;
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
		this.V = new Object[n+1];
		this.c = 0;
		this.max = n;
	}
	
	/**
	* Constructor for Heap.
	* @param n Max size.
	* @param V Object[].
	*/
	public Heap(Object[] V) {
		this.V = new Object[V.length+1];
		this.c = 0;
		this.max = V.length+1;
		insertV(V);
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
		ComparatorHeap ch = new ComparatorHeap();
		int father = i/2;
		while(i > 1 && (ch.isGreater(V[i], V[father])))//V[father] < V[i])) //// CREAR COMPARATOR
        {
            exchange(i, father);
            i = i / 2;
            father = i / 2;
        }
	}

	@Override
	public void shiftDown(int i) {
		ComparatorHeap ch = new ComparatorHeap();
		int hi = 2*i;
        int hd = 2*i+1;
        int p = i;
        do {
            if(hi <= c && hd <= c)
            {
                if((hi <= max) && (ch.isGreater(V[hd], V[i])))
                {
                    i = hd;
                }
                if((hi <= max) && (ch.isGreater(V[hi], V[i])))
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
            c++;
            V[c] = element;
            shiftUp(c);
        }		
	}

	@Override
	public T getTop() {
		Object element = null;
        if(c != 0)
        {
        	Arrays.toString(V);
        	element = (T) V[1];
            V[1] = null;
            exchange(1,c);
            //V[1] = V[c];
            c = c-1;
            shiftDown(1);        
        }
        return (T) element;	
	}

	@Override
	public T getFirst() {
		Object first = null;
        if(c == 0)
        {
            // dev ERROR
        } else {
        	first = V[1];
        }
        return (T) first;	
	}
	
	/**
	* Exchange two elements
	* @param e index first element.
	* @param i index second element.
	*/
	private void exchange(int e, int i) {
		T aux_one = (T)V[e];
        T aux_two = (T)V[i];
        V[e] = aux_two;
        V[i] = aux_one;
	}
	
	/**
	* Sorting
	* @param v Vector to sort.
	*/
	public Object[] Heapsort(T[] t)
    {
        T e = null;
        Object[] s = new Object[t.length];
        Heap aux = new Heap(t);
        int indice = 0;
        while(!aux.isEmpty()) {
			Object aux_ = aux.getTop();
			s[indice] = aux_;
			indice++;
		}       
        return s;
    }
	
	private void insertV(Object[] v)
	{
		int len = v.length;
		for(int i=1; i<=len; i++)
		{
			T aux = (T) v[i-1];
			this.insert(aux);
		}
	}
	
}
