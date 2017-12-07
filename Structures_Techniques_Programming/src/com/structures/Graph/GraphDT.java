package com.structures.Graph;

import com.structures.HashTable.HashTable;
import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public class GraphDT<T> extends GraphD{
	
	T tags[];
	HashTable<T, Integer> dic;
	
	/* Firstly, you have to tag vertex */
	/* Code is the position of vertex */

	public GraphDT(int num_vert) {
		super(num_vert);
		tags = (T[]) new Object[num_vert+1];
		dic = new HashTable<T, Integer>(num_vert);
		// TODO Auto-generated constructor stub
	}
	
	public boolean existsEdge(T i, T j) {
		// TODO Auto-generated method stub
		return existsEdge(obtainCode(i), obtainCode(j));
	}
	
	public double weightEdge(T i, T j) {
		// TODO Auto-generated method stub
		return weightEdge(obtainCode(i), obtainCode(j));
	}
	
	public void insertEdge(T i, T j) {
		insertEdge(obtainCode(i), obtainCode(j));
	}
	
	public void insertEdgeP(T i, T j, double w) {
		insertEdgeP(obtainCode(i), obtainCode(j), w);
	}
	
	public void deleteEdge(T i, T j) {
		super.deleteEdge(obtainCode(i), obtainCode(j));
	}
	
	public ListDynamic<Adjacent> adj(T i) {
		// TODO Auto-generated method stub
		return adj(obtainCode(i));
	}
	
	public void tagVertex(int code, T tag) {
		tags[code] = tag;
		dic.insert(tag, code);
	}
	
	public T getTag(int code) {
		return tags[code];
	}
	
	public int obtainCode(T tag) {
		int code;
		try {
			code = ((Integer) dic.find(tag));
		} catch (Exception e) {
			code = -1;
		}
		return code;
	}

}
