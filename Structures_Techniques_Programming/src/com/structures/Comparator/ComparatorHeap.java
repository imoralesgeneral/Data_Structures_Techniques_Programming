package com.structures.Comparator;

public class ComparatorHeap implements ComparatorInterface {

	@Override
	public int compare(Object e1, Object e2) {
		int sol = -99;
		if (e1.getClass().getName().equals(e2.getClass().getName())) {
			if (e1.getClass().getName().equals("java.lang.String")) {
				String a = e1.toString();
				String b = e2.toString();
				int i = a.compareToIgnoreCase(b);
				if (i != 0) {
					if (i < 0) {
						sol = GREATER;
					} else {
						sol = LESS;
					}
				} else {
					sol = EQUAL;
				}
			}
			if (e1 instanceof Number) {
				double a = (Double) e1;
				double b = (Double) e2;
				if (a < b) {
					sol = LESS;
				} else if (a > b) {
					sol = GREATER;
				} else {
					sol = EQUAL;
				}
			}
		}
		return sol;
	}

	@Override
	public boolean isLess(Object e1, Object e2) {
		int aux = compare(e1, e2);
		return aux == LESS;
	}

	@Override
	public boolean isEqual(Object e1, Object e2) {
		int aux = compare(e1, e2);
		return aux == EQUAL;
	}

	@Override
	public boolean isGreater(Object e1, Object e2) {
		int aux = compare(e1, e2);
		return aux == GREATER;
	}

}
