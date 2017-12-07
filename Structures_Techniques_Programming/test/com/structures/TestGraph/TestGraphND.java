package com.structures.TestGraph;
import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Graph.GraphND;

public class TestGraphND {
	
GraphND g = new GraphND(5);
	
	public TestGraphND() {
	g.insertEdge(1, 2, 0.5);
	g.insertEdge(2, 3, 0.6);
	g.insertEdge(5, 3, 0.7);
	}

	@Test
	public void testGraphND() {
		assertNotNull(g);
	}
	
	@Test
	public void testInsertEdge() {
		g.insertEdge(5, 4, 1);
		assertEquals(true, g.existsEdge(4, 5));
	}
	
	@Test
	public void testInsertVertex() {
		g.insertVertex();
		assertEquals(6, g.numVertex());
		g.insertEdge(6, 1, 3);
		assertEquals(true, g.existsEdge(6,1));
		assertEquals(true, g.existsEdge(6, 1));
		assertEquals(3, g.weightEdge(6, 1), 0.1);
	}

	
	@Test
	public void testDeleteEdge() {
		assertEquals(true, g.existsEdge(3, 2));
		assertEquals(true, g.existsEdge(2, 3));
		g.deleteEdge(2, 3);
		assertEquals(false, g.existsEdge(3, 2));
		assertEquals(false, g.existsEdge(2, 3));
		assertEquals(true, g.existsEdge(5, 3));
		assertEquals(true, g.existsEdge(3, 5));
	}

	@Test
	public void testNumVertex() {
		assertEquals(5, g.numVertex());
	}

	@Test
	public void testNumEdges() {
		assertEquals(3, g.numEdges());
	}

	@Test
	public void testExistsEdge() {
		assertEquals(true, g.existsEdge(2, 3));
		assertEquals(true, g.existsEdge(3, 2));
		assertEquals(false, g.existsEdge(1, 4));
	}

	@Test
	public void testWeightEdge() {
		assertEquals(0.6, g.weightEdge(2, 3), 0.1);
	}

	@Test
	public void testInsertEdgeIntInt() {
		g.insertEdge(4, 3);
		assertEquals(true, g.existsEdge(4, 3));
		assertEquals(1, g.weightEdge(4, 3), 0.1);
		assertEquals(1, g.weightEdge(3, 4), 0.1);
	}

}
