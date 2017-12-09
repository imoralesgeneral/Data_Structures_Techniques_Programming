package com.techniques.DynamicProgramming;

import com.structures.List.ListDynamic;

public class UnboundedKnapsack {
	
	private int[][] M;
    private int[] objects;
    private ListDynamic<String> res;
    
    /**
     * Constructor for objects of class Algoritmo
     */
    public UnboundedKnapsack(int[] vol, int[] ben, int n, int V)
    {
        // initialise instance variables
        M = new int[n+1][V+1];
        objects = new int[n+1];
        MochilaEntera(vol, ben, n, V, this.M);
        ObjetosMochila(vol, this.M, n, V, this.objects);
        res = result(this.objects, vol, ben);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private void MochilaEntera(int[] vol, int[] ben, int n, int V, int[][] M)
    {
        // put your code here
        int i,j;
        
        for (i=1; i<n; i++) {
            M[i][0] = 0;
        }
        
        for (j=1; j<V; j++) {
            M[0][j] = 0;
        }

        for (i=1; i<=n; i++) {
            for (j=1; j<=V; j++) {
                if(vol[i] > j) {
                    M[i][j] = M[i-1][j];
                } else {
                    M[i][j] = max(M[i-1][j], M[i-1][j-vol[i]] + ben[i]);
                }
            }
        }
    }
    
    private int max(int i, int j)
    {
        if(i > j) return i;
        else return j;
    }
    
    private void ObjetosMochila(int[] vol, int[][] M, int n, int V, int[] objects)
    {
        int i,W;
        W = V;
        
        for(i=n; i>=1; i--) {
            if(M[i][W] == M[i-1][W]) {
                objects[i] = 0;
            } else {
            	objects[i] = 1;
                W = W - vol[i];
            }
        }
    }
    
    private ListDynamic<String> result(int[] objects, int[] vol, int[] ben)
    {
        ListDynamic<Integer> objVol = new ListDynamic<Integer>();
        ListDynamic<String> result = new ListDynamic<String>();
        int benefit = 0;
        
        for(int i=0; i<objects.length; i++)
        {
            if(objects[i] == 1) {
                objVol.insert(vol[i]);
                benefit += ben[i];
            }
        }
        
        String aux = objVol.toString();
        String aux_ = aux.replace("ListDynamic -[", "").replace("]","");
        result.insert("Volume objects: "+aux_);
        result.insert("Benefit: "+benefit);
        
        return result;
    }
    
    public ListDynamic<String> devResultado()
    {
        return res;
    }
    
}
