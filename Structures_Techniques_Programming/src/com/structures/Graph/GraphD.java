package com.structures.Graph;

import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public class GraphD extends GraphInterface{
	
	protected int numV; // Number of vertex
	protected int numE; // Number of edges
	protected ListDynamic<Adjacent> eArray[]; // List of adjacents
	
	@SuppressWarnings("unchecked")
	public GraphD(int num_vert) {
		this.numV = num_vert;
		numE = 0;
		eArray = new ListDynamic[num_vert+1];
		for(int i=1; i<=numV; i++) eArray[i] = new ListDynamic<Adjacent>();
	}

	@Override
	public int numVertex() {
		// TODO Auto-generated method stub
		return numV;
	}

	@Override
	public void insertVertex() {
		// TODO Auto-generated method stub
		numV++;
		extendList();
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return numE;
	}

	@Override
	public boolean existsEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		ListDynamic<Adjacent> l = eArray[v1];
		boolean exists = false;
		boolean seguir = true;
		while(!exists && seguir) {
			ListIterator<Adjacent> li = (ListIterator<Adjacent>) l.getIterator();
			while(li.hasNext()) {
				Adjacent ad = (Adjacent) li.getNext();
				if(ad.dest == v2) exists=true;
			}
			seguir = false;
		}
		return exists;
	}

	@Override
	public double weightEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		double w = 0;
		ListDynamic<Adjacent> l = eArray[v1];
		ListIterator<Adjacent> li = (ListIterator<Adjacent>) l.getIterator();
		while(li.hasNext()) {
			Adjacent ad = (Adjacent) li.getNext();
			if(ad.dest == v2) w=ad.weight;
		}
		return w;
	}

	@Override
	public void insertEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		insertEdgeP(v1, v2, 1);
	}

	@Override
	public void insertEdgeP(int v1, int v2, double w) {
		// TODO Auto-generated method stub
		if(!existsEdge(v1,v2)) {
			eArray[v1].insert(new Adjacent(v2, w));
			numE++;
		}
	}

	@Override
	public ListDynamic<Adjacent> adj(int v) {
		// TODO Auto-generated method stub
		return eArray[v];
	}

	@Override
	public void deleteEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		ListDynamic<Adjacent> l = eArray[v1];
		ListDynamic<Adjacent> l_aux = new ListDynamic<Adjacent>();
		ListIterator<Adjacent> li = (ListIterator<Adjacent>) l.getIterator();
		while(li.hasNext()) {
			Adjacent ad = (Adjacent) li.getNext();
			if(ad.dest != v2) {
				l_aux.insert(ad);
			} else {
				numE--;
			}
		}
		eArray[v1] = l_aux;
	}
	
	private void extendList() {
		ListDynamic<Adjacent> l[] = new ListDynamic[numV+1];
		for(int i=1; i<=numV-1; i++)
		{
			l[i] = eArray[i];
		}
		l[numV] = new ListDynamic<Adjacent>();
		eArray = l;
	}

}
