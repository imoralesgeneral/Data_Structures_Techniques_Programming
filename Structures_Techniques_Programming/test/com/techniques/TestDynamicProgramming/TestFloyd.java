package com.techniques.TestDynamicProgramming;

import com.techniques.DynamicProgramming.Floyd;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFloyd {
	
	Random r = new Random();
	private static  final int INF = 1000;//Integer.MAX_VALUE;
	private int[][] matA = new int[4][4];
	private int[][] matB = new int[6][6];
	
	
	@Test
	public void testFloydIt() {
		
		matA[0][0] = INF;
		matA[0][1] = INF;
		matA[0][2] = INF;
		matA[0][3] = INF;
		matA[1][0] = INF;
		matA[1][1] = INF;
		matA[1][2] = 60;
		matA[1][3] = 30;
		matA[2][0] = INF;
		matA[2][1] = 10;
		matA[2][2] = INF;
		matA[2][3] = INF;
		matA[3][0] = INF;
		matA[3][1] = INF;
		matA[3][2] = 15;
		matA[3][3] = INF;
		FillMatrix(matB);
		Floyd Fa = new Floyd(matA);
		Floyd Fb = new Floyd(matB);	
		System.out.println("Mat B: ");
		Fb.printMatrix(matB);
		
		assertNotNull(Fa);
		assertNotNull(Fb);
	}
	
	public void FillMatrix(int[][] a) {
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				a[i][j] = r.nextInt(100)+1;
			}
		}
	}
}
