package com.techniques.Backtracking;

import java.util.Arrays;

public class HamiltonianGraph {

	// GraphMatrix g;
	int[][] g;
	int[] v;
	boolean[] vB;

	public HamiltonianGraph(int[][] g) 
	{
		this.g = g;
		this.v = new int[g.length+1];
		this.vB = new boolean[g.length+1];
	}

	private void HamPath(int[][] g, int k, int[] v, boolean[] vB) 
	{
		for(int i=2; i<=g.length-1; i++)
		{
			if(g[v[k-1]][i] == 1 && !vB[i])
			{
				v[k] = i;
				vB[i] = true;
				if(k == g.length-1) 
				{
					if(g[v[g.length]][1] == 1) 
					{
						System.out.println(Sol(v));
					}
				}
				else
				{
					HamPath(g, k+1, v, vB);
				}
				vB[i] = false;
			}
		}
	}

	public String Path() 
	{
		v[1] = 1;
		vB[1] = true;
		for(int i=2; i<=g.length; i++)
		{
			vB[i] = false;
		}
		HamPath(g, 2, v, vB);
		return "FIN";
	}
	
	private String Sol(int[] v)
	{
		int[] ve = new int[v.length];
		for (int i=0; i<v.length; i++) 
		{
			ve[i] = v[i]+1;
		}
		return (Arrays.toString(ve));
	}

}
