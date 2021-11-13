package com.nacaroglu.dsa.practice._mixed;

public class MinimumDifference {

	public static void main(String[] args) {
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 1));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
	}
	
	public static int searchMinDiffElement(int[] arr, int key) {
		
		if(arr==null || arr.length==0) {
			return -1;
		}
		
		if (key > arr[arr.length - 1]) {
			return arr[arr.length-1];
		}
		
		if(key<arr[0]) {
			return arr[0];
		}
		      
		
		int low = 0;
		int high = arr.length-1;
		int mid  = 0;
		int max = 0;
		int min = 0;
		
		while(low<=high) {
			
			mid = low + (high-low)/2;
			max = arr[high];
			min = arr[low];
			
			if(arr[mid]==key) {				
				return arr[mid];
			}
			
			if(arr[mid]<key) {				
				low = mid+1;
			}else {	
				
				high = mid-1;
			}				
		}
		
		if(Math.abs(max-key)<Math.abs(min-key)) {
			return max;
		}else {
			return min;
		}
	}

}
