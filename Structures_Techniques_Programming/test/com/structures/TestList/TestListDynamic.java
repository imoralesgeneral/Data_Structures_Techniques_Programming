package com.structures.TestList;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.List.ListDynamic;

public class TestListDynamic {
	
	ListDynamic<Integer> test_ = new ListDynamic<Integer>();
	
	@Test
	public void testListDynamic() {
		assertNotNull(new ListDynamic<Object>());
	}
	
	@Test
	public void testListDynamic1() {
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test.insert(3);
		test.insert(5);
		assertNotNull(new ListDynamic<Integer>(test));
	}
	
	@Test
    public void testGetFirst (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		assertEquals((Integer)3, test_.getFirst());
    }
	
	
	@Test
    public void testGetTail (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test.insert(5);
		test.insert(8);
		assertEquals(test, test_.getTail());
    }
	
	@Test
    public void testInsert (){
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test_.insert((Integer)3);
		test.insert((Integer)3);
		assertEquals(test_, test);
    }
	
	@Test
    public void testIsEmpty (){
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		assertEquals(true, test.isEmpty());
    }
	
	@Test
    public void testIsFull (){
		assertEquals(false, test_.isFull());
    }
	
	@Test
    public void testGetLength (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		assertEquals(3, test_.getLength());
    }
	
	
	
	
	
	
	
	
	
}
