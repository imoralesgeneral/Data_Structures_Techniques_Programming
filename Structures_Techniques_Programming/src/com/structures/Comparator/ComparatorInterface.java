package com.structures.Comparator;

public interface ComparatorInterface<T> {

	/**
	* Initial values to compare
	*/
	public static int LESS = -1;
	public static int EQUAL = 0;
	public static int GREATER = 1;

	/**
	* It compares 2 values
	* @param e1 value 1; e2 value 2
	* @return the result produced by comparison: LESS, EQUAL, GREATER
	*/
	public int compare(T e1, T e2);

	/**
	* It analyzes if any value is less
	* @param e1 value 1; e2 value 2
	* @return the result produced by comparison is true or false
	*/
	public boolean isLess(T e1, T e2);

	/**
	* It analyzes if both values are equal
	* @param e1 value 1; e2 value 2
	* @return the result produced by comparison is true or false
	*/
	public boolean isEqual(T e1, T e2);

	/**
	* It analyzes if any value is greater
	* @param e1 value 1; e2 value 2
	* @return the result produced by comparison is true or false
	*/
	public boolean isGreater(T e1, T e2);

}
