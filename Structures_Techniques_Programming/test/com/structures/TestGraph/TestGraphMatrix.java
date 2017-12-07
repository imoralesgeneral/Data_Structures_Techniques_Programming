package com.structures.TestGraph;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Graph.GraphMatrix;

public class TestGraphMatrix {
	
	GraphMatrix g = new GraphMatrix(5);

	@Test
	public void testGraphMatrix() {
		assertNotNull(g);
	}

	@Test
	public void testNumVertex() {
		assertEquals(5, g.numVertex());
	}

	@Test
	public void testNumEdges() {
		assertEquals(0, g.numEdges());
		g.insertEdge(1, 1);
		assertEquals(1, g.numEdges());
		g.insertEdgeP(3, 3, 5);
		assertEquals(2, g.numEdges());
		g.insertEdge(5, 1);
	}

	@Test
	public void testExistsEdge() {
		g.insertEdge(1, 1);
		assertEquals(true, g.existsEdge(1,1));
		assertEquals(false, g.existsEdge(2,1));
	}

	@Test
	public void testWeightEdge() {
		g.insertEdgeP(3, 3, 5);
		assertEquals(5, g.weightEdge(3, 3), 0.1);
	}

	@Test
	public void testInsertEdge() {
		g.insertEdge(1, 1);
		assertEquals(true, g.existsEdge(1,1));
	}

	@Test
	public void testInsertEdgeP() {
		g.insertEdgeP(3, 3, 5);
		assertEquals(5, g.weightEdge(3, 3), 0.1);
	}

	@Test
	public void testDeleteEdge() {
		g.insertEdge(1, 1);
		g.insertEdgeP(3, 3, 5);
		assertEquals(2, g.numEdges());
		g.deleteEdge(3, 3);
		assertEquals(1, g.numEdges());
	}

	@Test
	public void testPrintMatrix() {
		g.insertEdgeP(3, 3, 5);
		g.insertEdgeP(5, 5, 1);
		g.printMatrix();
	}

}
