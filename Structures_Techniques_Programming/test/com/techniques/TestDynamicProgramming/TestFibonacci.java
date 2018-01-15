package com.techniques.TestDynamicProgramming;

import com.techniques.DynamicProgramming.Fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFibonacci {

	int a = 1;
	int b = 3;
	int c = 10;
	
	
	@Test
	public void testBSearch() {
		Fibonacci Fa = new Fibonacci(a);
		Fibonacci Fb = new Fibonacci(b);
		Fibonacci Fc = new Fibonacci(c);
		assertEquals(1, Fa.devRes());
		assertEquals(2, Fb.devRes());
		assertEquals(55, Fc.devRes());
	}
}
