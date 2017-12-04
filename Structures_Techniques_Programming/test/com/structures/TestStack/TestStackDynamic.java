package com.structures.TestStack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;
import com.structures.Stack.StackDynamic;

public class TestStackDynamic {

	StackDynamic<Integer> sd = new StackDynamic<Integer>();
	
	@Test
	public void testStackDynamic() {
		assertNotNull(sd);
	}

	@Test
	public void testStackDynamicStackInterfaceOfT() {
		sd.push(3);
		assertNotNull(new StackDynamic<Integer>(sd));
	}

	@Test
	public void testStackDynamicListInterfaceOfT() {
		ListDynamic<Integer> ld = new ListDynamic<Integer>();
		ListDynamic<Integer> ld_ = null;
		ld.insert(3);
		ld.insert(5);
		assertNotNull(new StackDynamic<Integer>(ld));
		assertNotNull(new StackDynamic<Integer>(ld_));
	}

	@Test
	public void testGetTop() {
		sd.push(3);
		sd.push(5);
		sd.push(4);
		assertEquals((Integer)4, sd.getTop());
	}

	@Test
	public void testPush() {
		sd.push(null);
		sd.push(4);
		assertEquals((Integer)4, sd.getTop());
	}

	@Test
	public void testPop() {
		sd.push(3);
		sd.push(5);
		sd.push(4);
		assertEquals((Integer)5, sd.pop().getTop());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, sd.isEmpty());
		sd.push(3);
		assertEquals(false, sd.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, sd.isFull());
	}

	@Test
	public void testGetLength() {
		sd.push(3);
		sd.push(5);
		sd.push(4);
		assertEquals(3, sd.getLength());
	}

	@Test
	public void testContains() {
		StackDynamic<Integer> sd_ = new StackDynamic<Integer>();
		sd.push(3);
		sd.push(5);
		sd.push(4);
		assertEquals(true, sd.contains(5));
		assertEquals(false, sd.contains(6));
		assertEquals(false, sd_.contains(5));
	}

	@Test
	public void testGetIterator() {
		assertNotNull(sd.getIterator());
	}

	@Test
	public void testToString() {
		sd.push(5);
		sd.push(4);
		assertEquals("StackDynamic -[4, 5]", sd.toString());
	}

	@Test
	public void testInversa() {
		assertEquals(null, sd.inversa().getTop());
		sd.push(3);
		sd.push(5);
		sd.push(4);
		assertEquals((Integer)3, sd.inversa().getTop());
	}

}
