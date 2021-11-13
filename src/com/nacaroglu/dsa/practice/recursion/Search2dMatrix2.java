package com.nacaroglu.dsa.practice.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Search2dMatrix2 {

	public static void main(String[] args) {
		
		Search2dMatrix2 s = new Search2dMatrix2();

		
		/*
		int[][] matrix = { {1,4,7,11,15},
							{2,5,8,12,19},
							{3,6,9,16,22},
							{ 10,13,14,17,24},
							{18,21,23,26,30}};
		s.searchMatrix(matrix, 5);
		
		int[][] matrix2 = { {1,1,3} };
		System.out.println(s.searchMatrix(matrix2, 0));
		
		int[][] matrix3 = { {1},{1}, {5}  };
		System.out.println(s.searchMatrix(matrix3, 0));
		
		int[][] matrix4 = { {-5}  };
		System.out.println(s.searchMatrix(matrix4, -2));
		
		int[][] matrix5 = {{4,6,9,10,15},{9,12,13,15,16}};
		System.out.println(s.searchMatrix(matrix5, 14));
		
		int[][] matrix6= { {5,6,10,14}, {6,10,13,18}, {10,13,18,19}};
		System.out.println(s.searchMatrix(matrix6, 14));
		*/
		
		int[][] matrix7 = { {-1}, {-1}};
		System.out.println(s.searchMatrix(matrix7, 0));
		


		
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        
	        int r = matrix.length;
	        int c = matrix[0].length;
	        
	        if(r==1) {
	        	return Arrays.binarySearch(matrix[0], target) >= 0;
	        }
	        
	        if(c==1) {
	        	int[] arr = new int[r];
	        	
	        	for(int i=0; i<r; i++) {
	        		arr[i] = matrix[i][0];
	        	}
	        	
	        	return Arrays.binarySearch(arr, target)>=0;
	        }	        
	        
	       
	        
	        HashSet<String> visited = new HashSet<String>();
	        
	        return helper(matrix, r/2, c/2, target,visited);
	    }
	    
	    boolean helper(int[][] matrix, int r, int c, int target, HashSet<String> visited){
	    	
	    	int current = matrix[r][c];
	    	
	    	//System.out.println("r: "+ r + " c: " + c +  " val: " + current);
	    	
	    	String foo = String.valueOf(r) + String.valueOf((c));
	    	
	    	if(visited.contains(foo)) {
	    		return false;
	    	}
	    	
	    	visited.add(foo);
	        
	        if(current==target){
	            return true;
	        }
	        
	        if(current > target){
	           
	            //  sola veya yukari
	            if(r>0){
	                boolean result = helper(matrix, r-1, c, target,visited);
	                if(result) return result;
	            }
	            
	            if(c>0){
	                boolean result = helper(matrix, r, c-1, target, visited );
	                if(result) return result;
	            }            
	                        
	        }else{ // saga veya asagi
	           
	            if(r+1<matrix.length){
	                boolean result = helper(matrix, r+1, c, target, visited);
	                if(result) return result;
	            }
	            
	             if(c+1<matrix[r].length){
	                boolean result = helper(matrix, r, c+1, target, visited);
	                if(result) return result;
	            }
	        }
	        
	        return false;
	    }
	    
	    
	    public int climbStairs(int n) {
	        
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int result = helper(n, map);
	        
	        return result;
	    }
	    
	    private int helper(int n,  HashMap<Integer, Integer> map){
	        
	        if(n==1) return 1;
	        if(n==2) return 2;
	        
	        if(map.containsKey(n)){
	            return map.get(n);
	        }
	        
	        int result = helper(n-1, map) + helper(n-2, map);
	        
	        map.put(n,result);
	        
	        return result;
	    }
	    
	    

}
