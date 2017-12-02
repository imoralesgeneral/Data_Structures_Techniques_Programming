package com.structures.Graph;

import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public class GraphND extends GraphD{

	public GraphND(int num_vert) {
		super(num_vert);
		// TODO Auto-generated constructor stub
	}
	
	/**
	* Insert a new weighted edge into the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @param weight between vertex.
	*/
	public void insertEdge(int v1, int v2, double w) {
		if(!existsEdge(v1,v2) && v1 != v2) {
			eArray[v1].insert(new Adjacent(v2, w));
			eArray[v2].insert(new Adjacent(v1, w));
		}
		numE++;
	}

	/**
	* Delete an edge belongs the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	*/
	public void deleteEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		ListDynamic<Adjacent> l = eArray[v1];
		ListDynamic<Adjacent> l_aux = new ListDynamic<Adjacent>();
		ListIterator li = (ListIterator) l.getIterator();
		while(li.hasNext()) {
			Adjacent ad = (Adjacent) li.getNext();
			if(ad.dest != v2) {
				l_aux.insert(ad);
			} else {
				numE--;
			}
		}
		eArray[v2] = l_aux;
		ListDynamic<Adjacent> l2 = eArray[v1];
		ListDynamic<Adjacent> l2_aux = new ListDynamic<Adjacent>();
		ListIterator li2 = (ListIterator) l2.getIterator();
		while(li2.hasNext()) {
			Adjacent ad = (Adjacent) li2.getNext();
			if(ad.dest != v2) {
				l2_aux.insert(ad);
			} else {
				numE--;
			}
		}
		eArray[v2] = l2_aux;
	}
}
