package com.techniques.DynamicProgramming;

import com.structures.List.ListDynamic;

public class UnboundedKnapsack {
	
	private int[][] M;
    private int[] objects;
    private ListDynamic<String> res;
    
    /**
     * Constructor for objects of class UnboundedKnapsack
     */
    public UnboundedKnapsack(int[] vol, int[] ben, int n, int V)
    {

        M = new int[n+1][V+1];
        objects = new int[n+1];
        Knapsack(vol, ben, n, V, this.M);
        ObjectsKnapsack(vol, this.M, n, V, this.objects);
        res = result(this.objects, vol, ben);
    }
    
    /**
     * This method creates a table with the result
     * 
     * @param  vol. Array with volume of objects
     * @param  ben. Array with benefit of objects
     * @param  n. Number of objects.
     * @param  V. Volume of knapsack.
     * @param  M. Table to add results.
     * 
     */
    private void Knapsack(int[] vol, int[] ben, int n, int V, int[][] M)
    {
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
       
    /**
     * This method analyze with objects should be selected.
     * 
     * @param  vol. Array with volume of objects
     * @param  objects. Array to add selected objects.
     * @param  n. Number of objects
     * @param  V. Volume of knapsack.
     * @param  M. Table with provisional results.
     * 
     */
    private void ObjectsKnapsack(int[] vol, int[][] M, int n, int V, int[] objects)
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

    /**
     * 
     * This method indicates which value is greater.
     * @param i. Number.
     * @param j. Number.
     * 
     */
    private int max(int i, int j)
    {
        if(i > j) return i;
        else return j;
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
    
    public ListDynamic<String> devResult()
    {
        return res;
    }
    
}
