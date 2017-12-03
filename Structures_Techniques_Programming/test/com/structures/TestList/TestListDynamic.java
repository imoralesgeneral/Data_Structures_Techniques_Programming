package com.structures.TestList;

import static org.junit.Assert.*;
import org.junit.Test;
import com.structures.List.ListDynamic;
import com.structures.List.ListInterface;


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
		assertNotNull(new ListDynamic<Integer>(null));
	}
	
	@Test
    public void testGetFirst (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		assertEquals((Integer)8, test_.getFirst());
    }
	
	
	@Test
    public void testGetTail (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test.insert(3);
		test.insert(5);
		ListInterface<Integer> testTail = test_.getTail();
		assertEquals(testTail.getFirst(), test.getFirst());
		assertNotNull(new ListDynamic<Integer>().getTail());
    }
	
	@Test
    public void testInsert (){
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test_.insert((Integer)3);
		test.insert((Integer)3);
		assertEquals(test_.getFirst(), test.getFirst());
		assertEquals(test_.getFirst(), test.insert(null).getFirst());
    }
	
	@Test
    public void testIsEmpty (){
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		assertEquals(true, test.isEmpty());
		test.insert((Integer)3);
		assertEquals(false, test.isEmpty());
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
	
	@Test
    public void testGetIterator (){
		assertNotNull(test_.getIterator());
    }
	
	@Test
    public void testContains (){
		test_.insert(3);
		test_.insert(5);
		test_.insert(8);
		assertEquals(true, test_.contains(3));
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		assertEquals(false, test.contains(3));
    }
	
	/*@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
    public void testSort (){
		test_.insert(3);
		test_.insert(1);
		test_.insert(8);
		double aux1 = Double.parseDouble("1");
		ListDynamic<Integer> test = (ListDynamic<Integer>) test_.sort(new ComparatorHeap());
		String aux = Integer.toString(test.getFirst());
		double aux2 = Double.parseDouble(Integer.toString(test.getFirst()));		
		assertEquals(true, aux1 == aux2);
    }*/
	
	/*@Test
    public void testSortInsert (){
		test_.insert(3);
		test_.insert(1);
		test_.insert(8);
		assertEquals((Integer)1, test_.sort().getFirst());
    }*/
	
	/*@Test
    public void testEquals (){
		test_.insert(3);
		test_.insert(1);
		test_.insert(8);
		assertEquals((Integer)1, test_.sort().getFirst());
    }*/
	
	
	@Test
    public void testToString (){
		test_.insert(3);
		test_.insert(5);
		assertEquals("ListDynamic -[5, 3]", test_.toString());
    }
	
	@Test
    public void testInvert(){
		test_.insert(3);
		test_.insert(5);
		test_.insert(6);
		ListDynamic<Integer> test = new ListDynamic<Integer>();
		test.insert(6);
		test.insert(5);
		test.insert(3);
		assertEquals(test.toString(), test_.invert().toString());
    }

	
	
	
}
