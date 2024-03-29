package com.structures.Graph;

public class GraphMatrix {
	
	private int n;
	private double[][] matrix;

	public GraphMatrix(int n) {
		this.n = n;
		matrix = new double[this.n][this.n];
        //Initial matrix 
        for(int i=1; i<= n; i++){
            for(int j=1; j<= n; j++){
            	matrix[i-1][j-1] = 0;
            }            
        }
	}
	
	/**
	* Return the number of vertex.
	* @return the number of vertex.
	*/
	public int numVertex() {
		return n;
	}
	
	/**
	* Insert a new vertex into the graph.
	* @return a graph including the new vertex.
	*/
	public void insertVertex() {
		n++;
		double[][] matrix_aux = new double[n][n];
		for(int i=1; i<= n; i++){
            for(int j=1; j<= n; j++){
            	if(i == n) matrix_aux[i-1][j-1] = 0;
            	if(j == n) matrix_aux[i-1][j-1] = 0;
            }            
        }
		matrix = matrix_aux;
	}
	
	/**
	* Return the number of edges.
	* @return the number of edges.
	*/
	public int numEdges() {
		int num = 0;
		for(int i=1; i<= n; i++){
            for(int j=1; j<= n; j++){
            	if(matrix[i-1][j-1] != 0) num++;
            }
		}
		return num;
	}
	
	/**
	* Check if exist a edge between both vertex.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return true if edge exists.
	*/
	public boolean existsEdge(int v1, int v2) {
		return (matrix[v1-1][v2-1] != 0);
	}
	
	/**
	* Return weight between both vertex.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return  weight between both vertex.
	*/
	public double weightEdge(int v1, int v2) {
		return matrix[v1-1][v2-1];
	}
	
	/**
	* Insert a new edge into the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @return a graph including the new edge.
	*/
	public void insertEdge(int v1, int v2) {
		insertEdgeP(v1, v2, 1);
	}
	
	/**
	* Insert a new weighted edge into the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	* @param weight between vertex.
	* @return a graph including the new edge.
	*/
	public void insertEdgeP(int v1, int v2, double w) {
		matrix[v1-1][v2-1] = w;
	}
	
	/**
	* Delete an edge belongs the graph.
	* @param an origin vertex.
	* @param an destiny vertex.
	*/
	public void deleteEdge(int v1, int v2) {
		matrix[v1-1][v2-1] = 0;
	}
	
	/**
	 * Print matrix
	 */
	public void printMatrix(){
		for(int i=1; i<= n; i++){
            for(int j=1; j<= n; j++){
                System.out.print( matrix[i-1][j-1] + "  " );        
            }
            System.out.println();
        }  
    }
	
}
