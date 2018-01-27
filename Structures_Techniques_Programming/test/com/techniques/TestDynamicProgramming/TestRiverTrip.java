package com.techniques.TestDynamicProgramming;

import com.techniques.DynamicProgramming.RiverTrip;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRiverTrip {
	
	Random r = new Random();
	private int[][] matA = new int[3][3];
	private int[][] matB = new int[7][7];
	private int[][] matC = new int[4][4];
	private static  final int INF = 10000000;
	
	@Test
	public void testRiverTrip() {
		FillMatrix(matA);
		FillMatrix(matB);
		matC[0][0] = INF;
		matC[0][1] = INF;
		matC[0][2] = INF;
		matC[0][3] = INF;
		matC[1][0] = INF;
		matC[1][1] = INF;
		matC[1][2] = 5;
		matC[1][3] = 25;
		matC[2][0] = INF;
		matC[2][1] = 500;
		matC[2][2] = INF;
		matC[2][3] = 55;
		matC[3][0] = INF;
		matC[3][1] = INF;
		matC[3][2] = 1000;
		matC[3][3] = INF;
		
		RiverTrip Fa = new RiverTrip(matA);
		RiverTrip Fb = new RiverTrip(matB);
		RiverTrip Fc = new RiverTrip(matC);
		
		System.out.println("Fa - table");
		Fa.impMat(Fa.getTable());
		System.out.println("Fa - cost");
		Fa.impMat(Fa.getCost());
		System.out.println("Fa - em");
		Fa.impMat(Fa.getEm());
		
		System.out.println("Fb - table");
		Fb.impMat(Fb.getTable());
		System.out.println("Fb - cost");
		Fb.impMat(Fb.getCost());
		System.out.println("Fb - em");
		Fb.impMat(Fb.getEm());
		
		System.out.println("Fc - table");
		Fc.impMat(Fc.getTable());
		System.out.println("Fc - cost");
		Fc.impMat(Fc.getCost());
		System.out.println("Fc - em");
		Fc.impMat(Fc.getEm());
		
		assertNotNull(Fa.getCost());
		assertNotNull(Fb.getCost());
	}
	
	public void FillMatrix(int[][] a) {
		
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[0].length; j++) {
				a[i][j] = r.nextInt(5)+1;
			}
		}
	}
}
