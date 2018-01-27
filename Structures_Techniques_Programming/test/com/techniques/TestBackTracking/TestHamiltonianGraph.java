package com.techniques.TestBackTracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techniques.Backtracking.HamiltonianGraph;

public class TestHamiltonianGraph {
	
	private int[][] pr = {{0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
        };
	
	private int[][] pr2 = {{0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},
        };
	
	private HamiltonianGraph hg;
	private HamiltonianGraph hg2;
	
	public TestHamiltonianGraph() {
		hg = new HamiltonianGraph(pr);
		hg2 = new HamiltonianGraph(pr2);
	}
	
	@Test
	public void testGraphColor() {
		assertEquals("FIN",hg.Path());
		assertEquals("FIN",hg2.Path());
	}
	
			
}
