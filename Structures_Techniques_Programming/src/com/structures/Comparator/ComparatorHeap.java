package com.structures.Comparator;

public class ComparatorHeap implements ComparatorInterface{

	@Override
	public int compare(Object e1, Object e2) {
		if(e1.getClass().getName().equals(e2.getClass().getName()))
		{
		if(e1.getClass().getName().equals("java.lang.String")) {
			String a = e1.toString();
			String b = e2.toString();
			int i = a.compareToIgnoreCase(b);
			if(i != 0) i *= -1;
			
		}
		if(e1 instanceof Number) {
			
		}
		} else {
			
		}
		return 0;
	}

	@Override
	public boolean isLess(Object e1, Object e2) {

		return false;
	}

	@Override
	public boolean isEqual(Object e1, Object e2) {

		return false;
	}

	@Override
	public boolean isGreater(Object e1, Object e2) {

		return false;
	}

}
