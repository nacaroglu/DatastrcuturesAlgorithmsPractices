package com.nacaroglu.dsa.practice.binarysearch;

public class Search2DMatrix {

	public static void main(String[] args) {
		

		Search2DMatrix searcher = new Search2DMatrix();
		int[][] matrix =   {{1,4,7,11,15},
							{2,5,8,12,19},
							{3,6,9,16,22},
							{10,13,14,17,24},
							{18,21,23,26,30}};
		System.out.println(searcher.searchMatrix(matrix, 18));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
    
	   int row = matrix.length-1;
        int col = 0;
        
       while(row>=0 && col<matrix[0].length) {
    	   
    	   if(matrix[row][col]==target) {
    		   return true;
    	   }else if (matrix[row][col]>target) {
    		   row=row-1;
    	   }else {
    		   col = col+1;
    	   }
    	   
       }

        return false;
   }
}
