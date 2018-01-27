package com.techniques.Backtracking;

import java.util.Arrays;

//import com.structures.Graph.GraphMatrix;

public class GraphColoring {

	//GraphMatrix g;
	int[][] g;
	int m;
	int[] v;
	
	public GraphColoring(int[][] g, int m)
	{
		this.g = g;
		this.m = m;
		this.v = new int[g.length];
	}
	
	public String GraphColor(int k, boolean s) 
	{
		v[k] = 0;
		s = false;
		while(v[k] < m && !s)
		{
			v[k] = v[k] + 1;
			if(Complet(g,v,k))
			{
				if(k == v.length-1)
				{
					System.out.println(Arrays.toString(v));//Sol(v); 
					s = true;
				} 
				else 
				{
					GraphColor(k+1, s);
				}
			}
		}
		return "FIN";
	}
	
	private boolean Complet(int[][] g, int[] v, int k)
	{
		for(int i=0; i<=k-1; i++)
		{
			if(g[k][i] == 1 && v[k] == v[i])
			{
				return false;
			}
		}
		return true;
	}
	
}
