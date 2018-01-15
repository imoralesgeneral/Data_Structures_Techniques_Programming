package com.techniques.DynamicProgramming;


/**
 * Binomial (n,k) = n! / (k! * (n-k)!) 
 * @author Isaac
 *
 */

public class Binomial {

	private int n;
	private int k;
	private int sol;
	
	public Binomial(int n, int k) {
		this.n = n;
		this.k = k;
		sol = Binom();
	}
	
	private int Binom() {
		
		int[][] t = new int[n+1][k+1];
		
		if(k <= 0 || k == n) return -1;
		else {
			for(int i=0; i<=n; i++) t[i][0] = 1;
			for(int i=1; i<=n; i++) t[i][1] = i;
			for(int i=2; i<=k; i++) t[i][i] = 1;
			for(int i=3; i<=n; i++){
				for(int j=2; j<=i-1; j++) {
					if(j<=k) {
						t[i][j] = t[i-1][j-1] + t[i-1][j];
					}
				}
			}
			return t[n][k];
		}
	}
	
	public int devRes() {
		return this.sol;
	}
}
