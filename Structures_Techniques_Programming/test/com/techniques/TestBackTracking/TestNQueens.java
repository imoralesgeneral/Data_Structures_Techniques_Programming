package com.techniques.TestBackTracking;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.techniques.Backtracking.nQueens;

public class TestNQueens {
	
	public nQueens nq1;
	int[] pr = {1,2,3,4,5};
	
	public TestNQueens() {
		nq1 = new nQueens(6);
	}
	
	@Test
	public void testQueens() {
		assertEquals("FIN",nq1.Queens(0));
	}
	
			
}
