package com.techniques.DynamicProgramming;

public class RiverTrip {

	private int emb;
	private int min;
	private int n;
	private int[][] table, cost, em;
	private static  final int INF = 10000000;
	
	public RiverTrip(int[][] table) {
		
		emb = 0;
		min = 0;
		this.table = table;
		this.n = table.length;
		cost = new int[table.length][table[0].length];
		em = new int[table.length][table[0].length];
		Trip();
	}
	
	private void Trip() {
		
		for(int i=1; i<n; i++) {
			cost[i][i] = 0;
		}
		for(int diag=1; diag<n-1; diag++) {
			for(int i=1; i<n-diag; i++) {
				MinMult(i,i+diag);
				cost[i][i+diag] = min;
				em[i][i+diag] = emb;
			}
 		}
	}
	
	private void MinMult(int i, int j) {
		
		min = INF;
		emb = i;
		for(int k=i+1; k<=j; k++) {
			if(cost[k][j] + table[i][k] < min) {
				min = cost[k][j] + table[i][k];
				emb = k;
			}
		}
	}
	
	public void impMat(int[][] matriz) {
	    
		for (int x=1; x < matriz.length; x++) {
	        System.out.print("|");
	        for (int y=1; y < matriz[x].length; y++) {
	          System.out.print (matriz[x][y]);
	          if (y!=matriz[x].length-1) System.out.print("\t");
	        }
	        System.out.println("|");
	      }
	}
	
	public int[][] getCost() {
		return cost;
	}
	
	public int[][] getEm() {
		return em;
	}
	
	public int[][] getTable() {
		return table;
	}
	
}
