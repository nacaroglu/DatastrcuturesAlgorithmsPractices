package com.nacaroglu.dsa.practice._mixed;

import java.util.Arrays;

public class SmallestCommonNumber {

	public static void main(String[] args) {
		
		int arr1[] = { 6, 7, 10, 25, 30, 63, 64 };
		int arr2[] = { 1, 4, 5, 16, 7, 8, 50 };
		int arr3[] = { 1, 6, 10, 14};
		
		SmallestCommonNumber scn = new SmallestCommonNumber();
		System.out.println(scn.findLeastCommonNumber(arr1, arr2, arr3));

	}
	
	public int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
		
		for(int i=0; i<arr1.length && i<arr2.length && i<arr3.length; i++) {
			
			int key = arr1[i];
			
			if(Arrays.binarySearch(arr2, key)>0) {
				
				
				
				if(Arrays.binarySearch(arr3, key)>0) {
					return key;
				}
			}		
		}		
		
		return -1;
	}

}
