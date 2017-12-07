package com.structures.TestTree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Iterator.BTreeIterator;
import com.structures.Tree.BTreeDynamic;

public class TestBTreeDynamic {
	
	BTreeDynamic<Integer> bt1 = new BTreeDynamic<Integer>();
	BTreeDynamic<Integer> bt2 = new BTreeDynamic<Integer>(2);
	BTreeDynamic<Integer> bt3 = new BTreeDynamic<Integer>(3);
	BTreeDynamic<Integer> bt4;
	BTreeDynamic<Integer> bt5 = new BTreeDynamic<Integer>();
	
	public TestBTreeDynamic() {
		bt1.setRoot(1);
		bt1.setLeftChild(bt2);
		bt1.setRightChild(bt3);
		bt4 = new BTreeDynamic<Integer>(bt1);
	}
	
	@Test
	public void testBTreeDynamic() {
		assertNotNull(bt1);
	}

	@Test
	public void testBTreeDynamicT() {
		assertNotNull(bt2);
		assertNotNull(bt3);
	}

	@Test
	public void testBTreeDynamicBTreeInterfaceOfT() {
		assertNotNull(bt4);
	}

	@Test
	public void testGetRoot() {
		assertEquals((Integer)1, bt1.getRoot());
		assertEquals((Integer)2, bt2.getRoot());
		assertEquals((Integer)3, bt3.getRoot());
		assertEquals((Integer)1, bt4.getRoot());
	}
	
	@Test
	public void testIsLeaf() {
		assertEquals(true, bt2.isLeaf());
		assertEquals(false, bt1.isLeaf());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, bt5.isEmpty());
		assertEquals(false, bt1.isEmpty());
	}

	@Test
	public void testContains() {
		assertEquals(true, bt1.contains(3));
		assertEquals(false, bt1.contains(5));
	}

	@Test
	public void testGetIterator() {
		assertNotNull(bt1.getIterator(0));
		BTreeIterator<Integer> it = (BTreeIterator<Integer>) bt1.getIterator(0);
		int aux = 0;
		while(it.hasNext()) {
			aux += it.getNext();
		}
		assertEquals(6, aux);
	}

	@Test
	public void testGetLeftChild() {
		assertEquals(bt2, bt1.getLeftChild());
		assertEquals(bt2.getRoot(), bt1.getLeftChild().getRoot());
	}

	@Test
	public void testGetRightChild() {
		assertEquals(bt3, bt1.getRightChild());
		assertEquals(bt3.getRoot(), bt1.getRightChild().getRoot());
	}

	@Test
	public void testSetRoot() {
		bt5.setRoot(5);
		assertEquals((Integer)5, bt5.getRoot());
	}

	@Test
	public void testRemoveLeftChild() {
		bt1.removeLeftChild();
		assertEquals(null, bt1.getLeftChild());
	}

	@Test
	public void testRemoveRightChild() {
		bt1.removeRightChild();
		assertEquals(null, bt1.getRightChild());
	}

}
