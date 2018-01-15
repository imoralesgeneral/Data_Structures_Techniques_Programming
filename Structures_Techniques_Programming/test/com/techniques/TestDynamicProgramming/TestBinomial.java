package com.techniques.TestDynamicProgramming;

import com.techniques.DynamicProgramming.Binomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinomial {

	
	@Test
	public void testBinomial() {
		Binomial Fa = new Binomial(3,2);
		Binomial Fb = new Binomial(12,6);
		Binomial Fc = new Binomial(1,0);
		assertEquals(3, Fa.devRes());
		assertEquals(924, Fb.devRes());
		assertEquals(-1, Fc.devRes());
	}
}
