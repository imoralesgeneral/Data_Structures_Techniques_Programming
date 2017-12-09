package com.structures.Comparator;

public class ComparatorHeap implements ComparatorInterface<Object> {

	@Override
	public int compare(Object e1, Object e2) {
		int sol = -99;
		if (e1.getClass().getName().equals(e2.getClass().getName())) {
			//if (e1.getClass().getName().equals("java.lang.String")) {
			if (e1 instanceof String) {
				String a = e1.toString();
				String b = e2.toString();
				int i = a.compareToIgnoreCase(b);
				if (i != 0) {
					if (i < 0) {
						sol = LESS;
					} else {
						sol = GREATER;
					}
				} else {
					sol = EQUAL;
				}
			}
			if (e1 instanceof Number) {
				String aux = e1.toString();
				String aux2 = e2.toString();
				double a = Double.parseDouble(aux);
				double b = Double.parseDouble(aux2);
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
