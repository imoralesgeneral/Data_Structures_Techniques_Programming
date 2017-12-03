package com.structures.TestList;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;
import com.structures.List.ListInterface;
import com.structures.List.ListStatic;

public class TestListStatic {
	
	ListDynamic<Integer> testDyn = new ListDynamic<Integer>();
	ListStatic<Integer> testSt = new ListStatic<Integer>(25);

	@Test
	public void testListStaticInt() {
		assertNotNull(new ListStatic<Integer>(3));
	}

	@Test
	public void testListStaticListInterfaceOfT() {
		testDyn.insert(3);
		testDyn.insert(5);
		assertNotNull(new ListStatic<Integer>(testDyn));
		assertNotNull(new ListStatic<Integer>(null));
	}

	@Test
	public void testGetFirst() {
		testSt.insert(3);
		testSt.insert(5);
		testSt.insert(8);
		assertEquals((Integer)8, testSt.getFirst());
		assertNull(new ListStatic<Integer>(testDyn).getFirst());
    }

	@Test
	public void testGetTail() {
		testSt.insert(3);
		testSt.insert(5);
		testSt.insert(8);
		ListStatic<Integer> test = new ListStatic<Integer>(25);
		test.insert(3);
		test.insert(5);
		ListInterface<Integer> testTail = testSt.getTail();
		assertEquals(testTail.getFirst(), test.getFirst());
		assertNotNull(new ListStatic<Integer>(testDyn).getTail());
	}

	@Test
	public void testInsert() {
		ListStatic<Integer> test = new ListStatic<Integer>(2);
		testSt.insert((Integer)3);
		test.insert((Integer)3);
		assertEquals(testSt.getFirst(), test.getFirst());
		test.insert((Integer)4);
		test.insert((Integer)7);
		assertEquals((Integer)4, test.getFirst());
	}

	@Test
	public void testIsEmpty() {
		ListStatic<Integer> test = new ListStatic<Integer>(25);
		assertEquals(true, test.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, testSt.isFull());
		ListStatic<Integer> test = new ListStatic<Integer>(1);
		test.insert((Integer)3);
		assertEquals(true, test.isFull());
	}

	@Test
	public void testGetLength() {
		ListStatic<Integer> test = new ListStatic<Integer>(4);
		test.insert((Integer)3);
		assertEquals(1, test.getLength());
	}

	@Test
	public void testGetIterator() {
		assertNotNull(testSt.getIterator());
	}

	@Test
	public void testContains() {
		testSt.insert(3);
		testSt.insert(5);
		testSt.insert(8);
		assertEquals(true, testSt.contains(3));
	}

	/*@Test
	public void testSort() {
		fail("Not yet implemented"); // TODO
	}*/

}
