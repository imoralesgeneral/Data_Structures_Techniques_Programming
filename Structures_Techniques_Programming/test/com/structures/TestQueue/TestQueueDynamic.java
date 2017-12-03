package com.structures.TestQueue;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;
import com.structures.Queue.QueueDynamic;

public class TestQueueDynamic {
	
	QueueDynamic<Integer> qd = new QueueDynamic<Integer>();

	@Test
	public void testQueueDynamic() {
		assertNotNull(qd);
	}

	@Test
	public void testQueueDynamicQueueInterfaceOfT() {
		qd.add(3);
		assertNotNull(new QueueDynamic<Integer>(qd));
		assertNotNull(new QueueDynamic<Integer>(new QueueDynamic<Integer>()));
		QueueDynamic<Integer> qd2 = null;
		assertNotNull(new QueueDynamic<Integer>(qd2));
	}

	@Test
	public void testQueueDynamicListInterfaceOfT() {
		ListDynamic<Integer> ld = new ListDynamic<Integer>();
		assertNotNull(new QueueDynamic<Integer>(ld));
		ld.insert(5);
		ld.insert(7);
		assertNotNull(new QueueDynamic<Integer>(ld));
		ListDynamic<Integer> ld2 = null;
		assertNotNull(new QueueDynamic<Integer>(ld2));
	}

	@Test
	public void testGetFirst() {
		qd.add(3);
		qd.add(5);
		qd.add(7);
		assertEquals((Integer)3, qd.getFirst());
	}

	@Test
	public void testAdd() {
		qd.add(3);
		assertEquals((Integer)3, qd.getFirst());
		qd.add(null);
	}

	@Test
	public void testRemove() {
		qd.add(3);
		qd.add(5);
		qd.add(7);
		assertEquals((Integer)5, qd.remove().getFirst());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, qd.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, qd.isFull());
	}

	@Test
	public void testGetLength() {
		qd.add(3);
		qd.add(5);
		qd.add(7);
		assertEquals(3, qd.getLength());
	}

	@Test
	public void testContains() {
		qd.add(3);
		qd.add(5);
		qd.add(7);
		assertEquals(true, qd.contains(3));
	}

	@Test
	public void testGetIterator() {
		assertNotNull(qd.getIterator());
	}

	/*@Test
	public void testEqualsObject() {
		QueueDynamic<Integer> qd2 = new QueueDynamic<Integer>();
		assertEquals(true, qd.equals(qd2));
	}*/

	@Test
	public void testToString() {
		qd.add(3);
		qd.add(5);
		assertEquals("QueueDynamic -[3, 5]", qd.toString());
	}

}
