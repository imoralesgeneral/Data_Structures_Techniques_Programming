package com.structures.TestStack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;
import com.structures.Stack.StackDynamic;
import com.structures.Stack.StackStatic;

public class TestStackStatic {
	
	StackStatic<Integer> ss = new StackStatic<Integer>(10);

	@Test
	public void testStackStaticInt() {
		assertNotNull(ss);
	}

	@Test
	public void testStackStaticStackInterfaceOfT() {
		StackDynamic<Integer> sd = new StackDynamic<Integer>();
		sd.push(3);
		assertNotNull(new StackStatic<Integer>(sd));
	}

	@Test
	public void testStackStaticListInterfaceOfT() {
		ListDynamic<Integer> ld = new ListDynamic<Integer>();
		ListDynamic<Integer> ld_ = null;
		ld.insert(3);
		ld.insert(5);
		assertNotNull(new StackStatic<Integer>(ld));
		assertNotNull(new StackStatic<Integer>(ld_));
	}

	@Test
	public void testGetTop() {
		ss.push(3);
		ss.push(5);
		ss.push(4);
		assertEquals((Integer)4, ss.getTop());
	}

	@Test
	public void testPush() {
		ss.push(null);
		ss.push(4);
		assertEquals((Integer)4, ss.getTop());
	}

	@Test
	public void testPop() {
		ss.push(3);
		ss.push(5);
		ss.push(4);
		assertEquals((Integer)5, ss.pop().getTop());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, ss.isEmpty());
		ss.push(3);
		assertEquals(false, ss.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, ss.isFull());
	}

	@Test
	public void testGetLength() {
		ss.push(3);
		ss.push(5);
		ss.push(4);
		assertEquals(3, ss.getLength());
	}

	@Test
	public void testContains() {
		StackStatic<Integer> ss_ = new StackStatic<Integer>(5);
		ss.push(3);
		ss.push(5);
		ss.push(4);
		assertEquals(true, ss.contains(4));
		assertEquals(false, ss.contains(6));
		assertEquals(false, ss_.contains(5));
	}

	@Test
	public void testGetIterator() {
		assertNotNull(ss.getIterator());
	}

}
