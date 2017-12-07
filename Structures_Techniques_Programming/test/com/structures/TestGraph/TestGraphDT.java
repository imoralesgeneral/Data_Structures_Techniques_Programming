package com.structures.TestGraph;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Graph.GraphDT;

public class TestGraphDT {

	GraphDT<String> g = new GraphDT<String>(5);
	
	public TestGraphDT() {
	g.tagVertex(1, "yo1");
	g.tagVertex(2, "yo2");
	g.tagVertex(3, "yo3");
	g.insertEdge("yo1", "yo2");
	g.insertEdge("yo2", "yo3");
	}
	@Test
	public void testGraphDT() {
		assertNotNull(g);
	}

	@Test
	public void testExistsEdgeTT() {
		
		
		
		assertEquals(true, g.existsEdge("yo2","yo3"));
		assertEquals(false, g.existsEdge("yo3","yo2"));
	}

	@Test
	public void testWeightEdgeTT() {
		g.insertEdgeP("yo3", "yo2", 3);
		assertEquals(3, g.weightEdge("yo3","yo2"), 0.1);
	}

	@Test
	public void testInsertEdgeTT() {
		assertEquals(true, g.existsEdge("yo2","yo3"));
	}

	@Test
	public void testInsertEdgePTTDouble() {
		g.insertEdgeP("yo3", "yo2", 3);
		assertEquals(true, g.existsEdge("yo3","yo2"));
	}

/*	@Test
	public void testDeleteEdgeTT() {
		g.deleteEdge("yo2", "yo3");
		assertEquals(false, g.existsEdge("yo2","yo3"));
	}*/
/*
	@Test
	public void testAdjT() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	public void testTagVertex() {
		g.tagVertex(4, "yo4");
		assertNotNull(g.getTag(4));
	}

	@Test
	public void testGetTag() {
		g.tagVertex(4, "yo4");
		assertNotNull(g.getTag(4));
	}

	@Test
	public void testObtainCode() {
		g.tagVertex(4, "yo4");
		assertEquals(4, g.obtainCode("yo4"));
		assertEquals(-1, g.obtainCode("yo6"));
	}

	@Test
	public void testNumVertex() {
		assertEquals(5, g.numVertex());
	}

	/*@Test
	public void testInsertVertex() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testNumEdges() {
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		assertEquals(2, g.numEdges());
	}

}
