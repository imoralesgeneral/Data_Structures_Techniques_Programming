package com.structures.TestGraph;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Graph.GraphD;

public class TestGraphD {
	
	GraphD g = new GraphD(5);

	@Test
	public void testNumVertex() {
		assertEquals(5, g.numVertex());
	}

	/*@Test
	public void testInsertVertex() {
		g.insertVertex();
		assertEquals(6, g.numVertex());
	}*/

	@Test
	public void testNumEdges() {
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		assertEquals(2, g.numEdges());
	}

	@Test
	public void testExistsEdge() {
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		assertEquals(true, g.existsEdge(2,3));
		assertEquals(false, g.existsEdge(3,2));
	}

	@Test
	public void testWeightEdge() {
		g.insertEdge(1, 2);
		g.insertEdgeP(4, 2, 3);
		int aux1 = Integer.parseInt(Double.toString(g.weightEdge(1,2)));
		int aux2 = Integer.parseInt(Double.toString(g.weightEdge(4,2)));
		assertEquals(1, aux1, 0.1);
		assertEquals(3, aux2, 0.1);
	}

	@Test
	public void testInsertEdge() {
		g.insertEdge(2, 3);
		assertEquals(1, g.numEdges());
	}

	@Test
	public void testInsertEdgeP() {
		g.insertEdgeP(4, 2, 3);
		assertEquals(1, g.numEdges());
	}

	@Test
	public void testDeleteEdge() {
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		assertEquals(2, g.numEdges());
		g.deleteEdge(2, 3);
		assertEquals(1, g.numEdges());
	}
	
	@Test
	public void testGraphD() {
		assertNotNull(g);
	}

}
