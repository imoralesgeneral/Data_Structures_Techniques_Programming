package com.techniques.DivideAndConquer;

public class BinarySearch {
	
	public boolean  BSearch(int i, int j, int[] v, int x) {
		
		boolean sol = false;
		int m;
		
		if(i == j) {
			if(v[i] == x) sol = true;
			else sol = false;
		} else {
			m = (i+j)/2;
			if(v[m] >= x) sol = BSearch(i,m,v,x);
			else sol = BSearch(m+1,j,v,x);
		}
		return sol;
	}
	
}
