package com.techniques.DynamicProgramming;

public class Floyd {

	private int[][] graph, mid, itinerary;
	private int len;
	private static  final int INF = 1000;//Integer.MAX_VALUE;
	
	public Floyd(int[][] g) {
		
		this.graph = g;
		len = g.length;
		mid = new int[len][len];
		itinerary = new int[len][len];
		FloydIt();
		showItinerary();
		//printMatrix(itinerary);
		//printMatrix(mid);
	}
	
	private void FloydIt() {
		
		int tmp;
		
		for(int i=1; i<len; i++) {
			for(int j=1; j<len; j++) {
				mid[i][j] = graph[i][j];
				itinerary[i][j] = 0;
			}
		}
		
		for(int k=1; k<len; k++) {
			for(int i=1; i<len; i++) {
				for(int j=1; j<len; j++) {
					tmp = mid[i][k] + mid[k][j];
					if(tmp < mid[i][j]) {
						mid[i][j] = tmp;
						itinerary[i][j] = k;
					}
				}
			}
		}
	}
	
	private void showItinerary() {
		
		for(int i=1; i<len; i++) {
			for(int j=1; j<len; j++) {
				if(mid[i][j] != INF) {
					System.out.println("Ruta de "+i+" a "+j+" :");
					System.out.println(i);
					PrintItinerary(i,j);
					System.out.println(j);
				}
			}
		}
	}
	
	private void PrintItinerary(int i, int j) {
		
		int k = itinerary[i][j];
		
		if(k != 0) {
			PrintItinerary(i,k);
			System.out.println(k);
			PrintItinerary(k,j);
		}
	}
	
	public void printMatrix(int[][] a) {
		
		for (int x=1; x < a.length; x++) {
	        System.out.print("|");
	        for (int y=1; y < a[x].length; y++) {
	          System.out.print (a[x][y]);
	          if (y!=a[x].length-1) System.out.print("\t");
	        }
	        System.out.println("|");
	      }
	}
	
}
