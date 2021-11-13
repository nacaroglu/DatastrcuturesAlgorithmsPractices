package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_2 {

	public static void main(String[] args) {
		
		PascalTriangle_2 pt = new PascalTriangle_2();
		
		List<Integer> result = pt.getRow_3(10);

		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
	}
	
	 public List<Integer> getRow(int rowIndex) {		 
		
		 int arr[][] = new int[rowIndex+1][];
		 
		 arr[0] = new int[1];
		 arr[0][0] = 1;
		 
		 for(int i=1; i<rowIndex+1; i++) {
			 
			 arr[i] = new int[i+1];
			 
			 arr[i][0] = 1;
			 arr[i][i] = 1;
			 
			 for(int j=1; j<i; j++) {
				 arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			 }
			 
		 }
		 
		 List<Integer> result = new ArrayList<Integer>();
		 
		 for(int i=0; i< arr[rowIndex].length; i++) {
			 result.add(arr[rowIndex][i]);
		 }
		 
		 return result;
	        
	 }
	 
	 public List<Integer> getRow_2(int rowIndex) {		 
			
		 List<Integer> result = new ArrayList<Integer>();
		 
		 result.add(1);
		 
		 for(int i=1; i<rowIndex+1; i++) {
			 
			 List<Integer> temp = new ArrayList<Integer>(rowIndex+1);
			 
			 temp.add(1);			 
			 
			 for(int j=1; j<i; j++) {
				 temp.add(j, result.get(j-1) + result.get(j));
			 }
			 
			 temp.add(1);
			 
			 result = temp;
			 
		 }
		 
		 return result;
	        
	 }
	 
	 public List<Integer> getRow_3(int rowIndex) {		 			
		return getRowHelper(rowIndex);	        
	 }
	 
	 public List<Integer> getRowHelper(int rowIndex) {
		 
		 List<Integer> result = new ArrayList<Integer>();
			
		 
		 if(rowIndex==0) {			
			 result.add(1);
			 return result;
		 }	 
			 
		 result.add(1);				 
		 
		 
		 List<Integer> list = getRowHelper(rowIndex-1);
		 
		 for(int j=1; j<rowIndex; j++) {
			 result.add(j, list.get(j-1) + list.get(j));
		 }
		 
		 result.add(1);		 
		 
		 return result;
	        
	 }

}
