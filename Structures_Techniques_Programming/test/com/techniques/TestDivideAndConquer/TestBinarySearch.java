package com.techniques.TestDivideAndConquer;

import com.techniques.DivideAndConquer.BinarySearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearch {

	BinarySearch test = new BinarySearch();
	int[] test_int = {1,3,4,5,6};
	
	
	@Test
	public void testBSearch() {
		assertTrue(test.BSearch(0, 5, test_int, 3));
		assertFalse(test.BSearch(0, 5, test_int, 2));
	}
}
