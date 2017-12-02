package com.structures.Graph;

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

}
