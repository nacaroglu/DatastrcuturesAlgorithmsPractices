package com.nacaroglu.dsa.practice.recursion;

public class Search2DMatrix_2 {

	public static void main(String[] args) {
		
		Search2DMatrix_2 s = new Search2DMatrix_2();
		
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

		System.out.println(s.searchMatrix(matrix, 5));
		System.out.println(s.searchMatrix(matrix, 18));
		System.out.println(s.searchMatrix(matrix, 20));
		System.out.println(s.searchMatrix(matrix, 30));
		System.out.println(s.searchMatrix(matrix, 35));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {        
		
		int startRow = matrix.length-1;
		int startCol = 0;
		
		return helper(matrix, target, startRow, startCol);
		
    }

	private boolean helper(int[][] matrix, int target, int row, int col) {
		
		if(row<0 || row>=matrix.length) return false;
		if(col<0 || col>=matrix[0].length) return false;
		
		if(matrix[row][col]==target) {
			return true;
		}
		
		if(matrix[row][col]>target) {
			return helper( matrix, target, row-1, col);
		}else {
			return helper(matrix, target, row, col+1);
		}	
	}
}
