package com.structures.TestHeap;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.structures.Heap.Heap;

public class TestHeap {
	
	Heap<Integer> h = new Heap<Integer>(5);
	Heap<Integer> hn = new Heap<Integer>();

	@Test
	public void testHeap() {
		assertNotNull(hn);
	}

	@Test
	public void testHeapInt() {
		assertNotNull(h);
	}

	@Test
	public void testHeapIntTArray() {
		Integer[] vec1 = new Integer[5];
		vec1[0] = 5;
		vec1[1] = 1;
		vec1[2] = 9;
		vec1[3] = 7;
		vec1[4] = 4;
		System.out.println(Arrays.toString(vec1));
		Heap<Integer> h1 = new Heap<Integer>(vec1);
		while(!h1.isEmpty()) {
			System.out.println(h1.getTop());
		}  
		assertNotNull(h1);
		Integer[] vec = new Integer[8];
		vec[0] = 5;
		vec[1] = 1;
		vec[2] = 9;
		vec[3] = 7;
		vec[4] = 4;
		vec[5] = 6;
		vec[6] = 2;
		vec[7] = 8;
		System.out.println(Arrays.toString(vec));
		Heap<Integer> h2 = new Heap<Integer>(vec);
		while(!h2.isEmpty()) {
			System.out.println(h2.getTop());
		}  
		assertNotNull(h2);
		String[] vec3 = new String[5];
		vec3[0] = "casa";
		vec3[1] = "barco";
		vec3[2] = "mierda";
		vec3[3] = "dinero";
		vec3[4] = "pepe";
		System.out.println(Arrays.toString(vec3));
		Heap<String> h3 = new Heap<String>(vec3);
		while(!h3.isEmpty()) {
			System.out.println(h3.getTop());
		}  
		assertNotNull(h3);
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, h.isEmpty());
		h.insert(3);
		assertEquals(false, h.isEmpty());
	}

	@Test
	public void testShiftUp() {
		h.insert(3);
		h.insert(2);
		h.insert(3);
		h.insert(6);
		h.insert(5);
		h.shiftUp(5);
		assertEquals((Integer)6, h.getTop());
		assertEquals((Integer)5, h.getTop());
	}

	@Test
	public void testShiftDown() {
		h.insert(8);
		h.insert(6);
		h.insert(7);
		h.shiftDown(3);
		assertEquals((Integer)8, h.getTop());
	}

	@Test
	public void testInsert() {
		h.insert(3);
		assertEquals((Integer)3, h.getFirst());
		Heap<String> h3 = new Heap<String>(5);
		h3.insert("casa");
		assertEquals("casa", h3.getFirst());
	}

	@Test
	public void testGetTop() {
		h.insert(3);
		h.insert(5);
		assertEquals((Integer)5, h.getTop());
		assertEquals((Integer)3, h.getTop());
	}

	@Test
	public void testGetFirst() {
		h.insert(3);
		h.insert(5);
		assertEquals((Integer)5, h.getFirst());
	}

	@Test
	public void testHeapsort() {
		Integer[] vec = new Integer[5];
		vec[0] = 5;
		vec[1] = 1;
		vec[2] = 9;
		vec[3] = 7;
		vec[4] = 4;
		//Object[] v2 = h.Heapsort(vec);
		//assertEquals(9, v2[0]);	
		//assertEquals(4, v2[3]);
		Integer[] vec3 = new Integer[30];
		Random r = new Random();
		for(int i=0; i<30; i++)
		{
			vec3[i] = r.nextInt(30);
		}
		System.out.println(Arrays.toString(vec3));
		Object[] v3 = h.Heapsort(vec3);
		
	}

}
