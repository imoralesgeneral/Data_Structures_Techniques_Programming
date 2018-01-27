package com.techniques.TestBackTracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techniques.Backtracking.SubSetSum;

public class TestSubSetSum {
	
	int m, C;
	SubSetSum ss;
	
	public TestSubSetSum() {
		m = 5;
		C = 48;
		ss = new SubSetSum(m,C);
	}
	
	@Test
	public void SubSets() {
		int[] v = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		boolean[] vB = new boolean[v.length];
		int k = 0;
		int sum = 0;
		int su = 0;
		assertEquals("FIN",ss.SubSets(v, vB, k, sum, su));
	}
	
			
}
