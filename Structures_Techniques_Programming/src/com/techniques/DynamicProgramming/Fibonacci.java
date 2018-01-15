package com.techniques.DynamicProgramming;

/**
 * Fibonacci serie 1,1,2,3,5,8,13,21,34,55,89,...
 * @author Isaac
 *
 */

public class Fibonacci {
	
	private int n;
	private int sol;
	
	public Fibonacci(int n) {
		this.n = n;
		sol = Fibo(this.n);
	}
	
	private int Fibo(int n) {
		
		int s = 0;
		int a, b;
		
		if(n <= 1) s = 1;
		else {
			a = 1;
			b = 0;
			for(int i=2; i<=n; i++) {
				s = a+b;
				b = a;
				a = s;
			}
		}
		return s;
	}
	
	public int devRes() {
		return this.sol;
	}

}
