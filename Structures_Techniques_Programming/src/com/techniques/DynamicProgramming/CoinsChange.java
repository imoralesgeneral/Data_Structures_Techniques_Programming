package com.techniques.DynamicProgramming;

//import java.util.Arrays;

public class CoinsChange {

	private int[] sol;
	private int quantity;
	private int[] coins;
	private int[][] table;
	private static  final int INF = Integer.MAX_VALUE;
	
	public CoinsChange(int quantity, int[] coins) {
		this.quantity = quantity;
		this.coins = coins;
		this.table = Changing();
		this.sol = Select();
	}
	
	private int[][] Changing() {
		
		int[][] t = new int[coins.length][quantity+1];
		
		for(int i=0; i<coins.length; i++) {
			t[i][0] = 0;
		}
		
		for(int j=1; j<=quantity; j++) {
			for(int i=0; i<coins.length; i++) {
				if(i == 0 && coins[i] > j) t[i][j] = INF;
				else {
					if(i==0) t[i][j] = 1+t[i][j-coins[i]];
					else {
						if(j<coins[i]) t[i][j] = t[i-1][j];
						else t[i][j] = min(t[i-1][j],t[i][j-coins[i]]+1);
					}
				}
			}
		}		
		return t;
	}
	
	private int[] Select() {
		
		int[] s = new int[coins.length];
		
		for(int i=0; i<s.length; i++) {
			s[i] = 0;
		}
		
		int i = coins.length-1;
		int j = quantity;
		
		while(j>0) {
			if(i>0 && table[i][j]==table[i-1][j]) i--;
			else {
				s[i] = s[i]+1;
				j = j-coins[i];
			}
		}
		
		return s;
	}
	
	public int[] devRes() {
		//System.out.println(Arrays.toString(sol));
		return this.sol;
	}
	
	private int min(int a, int b) {
		if(a <= b) return a;
		else return b;
	}
	
	
}
