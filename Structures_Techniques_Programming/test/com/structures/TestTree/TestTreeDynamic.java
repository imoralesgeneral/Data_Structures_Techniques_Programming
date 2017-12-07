package com.structures.TestTree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.Iterator.TreeIterator;
import com.structures.Tree.TreeDynamic;

public class TestTreeDynamic {

	TreeDynamic<Integer> bt1 = new TreeDynamic<Integer>();
	TreeDynamic<Integer> bt2 = new TreeDynamic<Integer>(2);
	TreeDynamic<Integer> bt3 = new TreeDynamic<Integer>(3);
	TreeDynamic<Integer> bt4;
	TreeDynamic<Integer> bt5 = new TreeDynamic<Integer>();
	
	public TestTreeDynamic() {
		bt1.setRoot(1);
		bt1.addChildren(bt2);
		bt1.addChildren(bt3);
		bt4 = new TreeDynamic<Integer>(bt1);
	}
	
	@Test
	public void testTreeDynamic() {
		assertNotNull(bt1);
	}

	@Test
	public void testTreeDynamicT() {
		assertNotNull(bt2);
		assertNotNull(bt3);
	}

	@Test
	public void testTreeDynamicTreeInterfaceOfT() {
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
	public void testGetChildren() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveChild() {
		bt1.removeChild(1);
		TreeIterator<Integer> it = (TreeIterator<Integer>) bt1.getIterator(0);
		int aux = 0;
		while(it.hasNext()) {
			aux += it.getNext();
		}
		assertEquals(3, aux);
		
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
		TreeIterator<Integer> it = (TreeIterator<Integer>) bt1.getIterator(0);
		int aux = 0;
		while(it.hasNext()) {
			aux += it.getNext();
		}
		assertEquals(6, aux);
	}

}
