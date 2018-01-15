package com.techniques.TestDynamicProgramming;

import com.techniques.DynamicProgramming.CoinsChange;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCoinsChange {

	
	@Test
	public void testBinomial() {
		int[] a = {1,6,10};
		int[] b = {1,3,4};
		int[] c = {1,2,4,8};
		int[] Sa = {0,2,0};
		int[] Sb = {1,0,1};
		int[] Sc = {1,0,1,7};
		CoinsChange Fa = new CoinsChange(12,a);
		CoinsChange Fb = new CoinsChange(5,b);
		CoinsChange Fc = new CoinsChange(61,c);
		assertEquals(Arrays.toString(Sa), Arrays.toString(Fa.devRes()));
		assertEquals(Arrays.toString(Sb), Arrays.toString(Fb.devRes()));
		assertEquals(Arrays.toString(Sc), Arrays.toString(Fc.devRes()));
	}
}
