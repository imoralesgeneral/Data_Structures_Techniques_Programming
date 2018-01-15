package com.techniques.DivideAndConquer;

public class MajorityElement {

	public int MElement(int i, int j, int[] v) {
		
		int m,s,t;
		
		if(i==j) return v[i];
		else {
			m = (i+j)/2;
			System.out.println("m: "+m);
			s = MElement(i,m,v);
			System.out.println("s: "+s);
			t = MElement(m+1,j,v);
			System.out.println("t: "+t);
			return Combine(s,t,v);
		}
	}
	
	private int Combine(int a, int b, int[] v) {
		
		int sol = -99;
		
		if(a==-1 && b==-1) sol = -1;
		if(a==-1 && b!=-1) sol = CheckMajority(b,v);
		if(a!=-1 && b==-1) sol = CheckMajority(a,v);
		if(a!=-1 && b!=-1) {
			if(CheckMajority(a,v) == a) sol = a;
			else if(CheckMajority(b,v) == b) sol = b;
		}
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		System.out.println("sol: "+sol);
		return sol;
	}
	
	private int CheckMajority(int x, int[] v) {
		
		int c = 1;
		
		for(int k=1; k<v.length;k++) {
			if(v[k]==x) c++;
		}
		System.out.println("c: "+c);
		if(c > (v.length/2)) return c;		
		else {
			System.out.println("c: -1"); 
			return -1;
		}
	}
}
