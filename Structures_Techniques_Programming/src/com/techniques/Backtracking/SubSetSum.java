package com.techniques.Backtracking;


public class SubSetSum {

	int m, C;
	
	public SubSetSum(int m, int C)
	{
		this.m = m;
		this.C = C;
	}
	
	public String SubSets(int[] v, boolean[]vB, int k, int sum, int su)
	{
		if(sum == m) 
		{
			if(su == C)
			{
				//System.out.println(Arrays.toString(vB));
				System.out.println(Sol(vB, v));
			}
		}
		else 
		{
			if(k <= v.length-1)
			{
				vB[k] = false;
				SubSets(v,vB,k+1,sum,su);			
				if(su + v[k] <= C)
				{
					vB[k] = true;
					su += v[k];					
					sum++;
					SubSets(v,vB,k+1,sum,su);
				}
			}
		}
		return "FIN";
	}
	
	public String Sol(boolean[] vB, int[] v)
	{
		String aux = "";
		for (int i = 0; i < vB.length; i++) {
			if(vB[i]) aux += v[i]+"  ";			
		}
		return aux;
	}
	
}
