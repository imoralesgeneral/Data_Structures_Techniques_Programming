package com.techniques.TestDivideAndConquer;

import com.techniques.DivideAndConquer.MajorityElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMajorityElement {

	MajorityElement test = new MajorityElement();
	int[] test_int = {1,3,4,4,4,4,5,5,6};
	
	
	@Test
	public void testBSearch() {
		assertEquals(4,test.MElement(0, 8, test_int));
		assertNotEquals(5,test.MElement(0, 8, test_int));
	}
}
