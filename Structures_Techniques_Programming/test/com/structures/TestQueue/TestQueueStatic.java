package com.structures.TestQueue;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;
import com.structures.Queue.QueueDynamic;
import com.structures.Queue.QueueStatic;

public class TestQueueStatic {

	QueueStatic<Integer> qs = new QueueStatic<Integer>(5);
	
	@Test
	public void testQueueStaticInt() {
		assertNotNull(new QueueStatic<Integer>(4));
	}

	@Test
	public void testQueueStaticQueueInterfaceOfT() {
		assertNotNull(new QueueStatic<Integer>(new QueueStatic<Integer>(4)));
		qs.add(3);
		assertNotNull(new QueueStatic<Integer>(qs));
	}

	@Test
	public void testQueueStaticListInterfaceOfT() {
		ListDynamic<Integer> ld = new ListDynamic<Integer>();
		assertNotNull(new QueueStatic<Integer>(ld));
		ld.insert(5);
		ld.insert(7);
		assertNotNull(new QueueStatic<Integer>(ld));
		ListDynamic<Integer> ld2 = null;
		assertNotNull(new QueueStatic<Integer>(ld2));
	}

	@Test
	public void testGetFirst() {
		qs.add(3);
		qs.add(5);
		qs.add(7);
		assertEquals((Integer)3, qs.getFirst());
		QueueStatic<Integer> qs2 = new QueueStatic<Integer>(1);
		assertEquals(null, qs2.getFirst());
	}

	@Test
	public void testAdd() {
		qs.add(3);
		assertEquals((Integer)3, qs.getFirst());
		qs.add(null);
	}

	@Test
	public void testRemove() {
		qs.add(3);
		qs.add(5);
		qs.add(7);
		assertEquals((Integer)5, qs.remove().getFirst());
		QueueStatic<Integer> qs2 = new QueueStatic<Integer>(1);
		assertEquals(null, qs2.remove().getFirst());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, qs.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, qs.isFull());
		QueueStatic<Integer> qs2 = new QueueStatic<Integer>(1);
		qs2.add(8);
		assertEquals(true, qs2.isFull());
	}

	@Test
	public void testGetLength() {
		qs.add(3);
		qs.add(5);
		qs.add(7);
		assertEquals(3, qs.getLength());
	}

	@Test
	public void testContains() {
		qs.add(3);
		qs.add(5);
		qs.add(7);
		assertEquals(true, qs.contains(3));
	}

	@Test
	public void testGetIterator() {
		assertNotNull(qs.getIterator());
	}

}
