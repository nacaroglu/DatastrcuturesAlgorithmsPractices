package com.nacaroglu.dsa.practice._mixed;

public class SortedArraySquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedArraySquares sas = new SortedArraySquares();
		
		int[] arr = { -7,-3,2,3,11};
		
		
		arr = sas.makeSquares(arr);
		for (int i : arr) {
			System.out.println(i + ", ");
		}

	}

	public int[] makeSquares(int[] arr) {
    	
		int maxNegativeIndex = -1;
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i]<0) {
				maxNegativeIndex = i;
			}
			
			arr[i] = arr[i] * arr[i];
		}
		
		if(maxNegativeIndex==-1) {
			return arr;
		}
		
		int[] squares = new int[arr.length];
		
		int leftIndex = maxNegativeIndex;
		int rightIndex = maxNegativeIndex+1;
		int writeIndex = 0;
		
		while(leftIndex >= 0 && rightIndex<arr.length) {
			
			if(arr[leftIndex]<arr[rightIndex]) {
				squares[writeIndex] = arr[leftIndex];
				leftIndex--;
			}else {
				squares[writeIndex] = arr[rightIndex];
				rightIndex++;
			}
			
			writeIndex++;
		}
		
		while(writeIndex<arr.length && rightIndex<arr.length) {
			squares[writeIndex] = arr[rightIndex];
			rightIndex++;
			writeIndex++;
		}
		
		while(writeIndex<arr.length && leftIndex>=0) {
			squares[writeIndex] = arr[leftIndex];
			leftIndex--;
			writeIndex++;
		}
		
		// TODO: Write your code here
		return squares;
	}
}
