package com.structures.TestHashTable;

import static org.junit.Assert.*;

import org.junit.Test;

import com.structures.HashTable.HashTable;

public class TestHashTable {
	
	HashTable<String, Integer> ht = new HashTable<String, Integer>();
	HashTable<Integer, String> hts = new HashTable<Integer, String>(3);

	@Test
	public void testHashTable() {
		assertNotNull(ht);
	}

	@Test
	public void testHashTableInt() {
		assertNotNull(hts);
	}

	@Test
	public void testCalculateCode() {
		int aux_ht = "casa".hashCode()%49;
		int aux_hts = "casa".hashCode()%3;
		assertEquals(aux_ht, ht.calculateCode("casa"));
		assertEquals(aux_hts, hts.calculateCode("casa"));
	}

	@Test
	public void testInsert() {
		ht.insert("casa", 2);
		ht.insert("", 2);
		ht.insert("", 1);
		ht.contains("casa");
		ht.insert("casa", 8);
		assertEquals(2, ht.find("casa"));
		assertEquals(2, ht.find(""));
	}

	@Test
	public void testFind() {
		ht.insert("casa", 2);
		hts.insert(2, "casa");
		ht.insert("casona", 9);
		hts.insert(21, "palacio");
		assertEquals(2, ht.find("casa"));
		assertEquals(9, ht.find("casona"));
		assertEquals("casa", hts.find(2));
		assertEquals("palacio", hts.find(21));
	}

	@Test
	public void testContains() {
		hts.insert(2, "casa");
		hts.insert(21, "palacio");
		assertEquals(true, hts.contains(2));
		assertEquals(false, hts.contains(22));
	}

	@Test
	public void testDelete() {
		hts.insert(2, "casa");
		hts.insert(21, "palacio");
		hts.delete(2);
		assertEquals(false, hts.contains(2));
	}
	
	@Test
	public void testContenedor() {
		Contenedor<String, Integer> c1 = new Contenedor<String, Integer>("casa", 2);
		assertEquals("casa", c1.getKey());
		assertEquals((Integer)2, c1.getValue());
	}
	
	class Contenedor<T, V> {
		
		private T key;
		private V value;
		
		public Contenedor(T key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		public T getKey(){
			return this.key;
		}
		
		public V getValue(){
			return this.value;
		}
		
	}

}
