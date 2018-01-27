package com.techniques.TestBackTracking;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import com.techniques.Backtracking.GraphColoring;


public class TestGraphColoring {
	
	private int m;
	private int[][] pr = {{0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},
        };
	private GraphColoring gr;
	
	public TestGraphColoring() {
		this.m = 3;
		gr = new GraphColoring(pr, m);
	}
	
	@Test
	public void testGraphColor() {
		assertEquals("FIN",gr.GraphColor(0, false));
	}
	
			
}
