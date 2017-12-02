package com.structures.Graph;

import com.structures.Iterator.ListIterator;
import com.structures.List.ListDynamic;

public abstract class GraphInterface {

	/**
	* Return the number of vertex.
	* @return the number of vertex.
	*/
	public abstract int numVertex();
	
	/**
	* Insert a new vertex into the graph.
	* @return a graph including the new vertex.
	*/
	public abstract void insertVertex();
	
	/**
	* Return the number of edges.
	* @return the number of edges.
	*/
	public abstract int numEdges();
	
	/**
	* Check if exist a edge between both vertex.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return true if edge exists.
	*/
	public abstract boolean existsEdge(int v1, int v2);
	
	/**
	* Return weight between both vertex.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return  weight between both vertex.
	*/
	public abstract double weightEdge(int v1, int v2);
	
	/**
	* Insert a new edge into the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return a graph including the new edge.
	*/
	public abstract void insertEdge(int v1, int v2);
	
	/**
	* Insert a new weighted edge into the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @param weight between vertex.
	* @return a graph including the new edge.
	*/
	public abstract void insertEdgeP(int v1, int v2, double w);
	
	/**
	* Delete an edge belongs the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	*/
	public abstract void deleteEdge(int v1, int v2);
	
	/**
	* Return a list with v's adj.
	* @param a vertex.
	* @return  a list with v's adj.
	*/
	public abstract ListDynamic<Adjacent> adj(int v);
	
	public String toString() {
		String res = "";
		for(int i = 1; i <= numVertex(); i++) {
			res += "Vertex: "+i;
			ListDynamic<Adjacent> l = adj(i);
			res += (l.isEmpty()) ? " without adjacents " : " with adjacents ";
			ListIterator li = (ListIterator) l.getIterator();
			while(li.hasNext()) {
				Adjacent ad = (Adjacent) li.getNext();
				res += ad.toString();
				res += "\n";
			}
		}
		return res;
	}
	
}

class Adjacent {
	
	int dest; // destination
	double weight;
	
	Adjacent(int codAdy, double w) {
		this.dest = codAdy;
		this.weight = w;
	}
	
	@Override
	public String toString() {
		return dest+ "(" + weight + ")";
	}
	
}
