package com.nacaroglu.dsa.practice._mixed;

public class MaxInBitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxInBitonicArray mba = new MaxInBitonicArray();
		
		int arr[] = {1, 3, 8, 12, 4, 2 };
		System.out.println(mba.findMax(arr));
		
		int arr2[] = {3, 8, 3, 1 };
		System.out.println(mba.findMax(arr2));
		
		int arr3[] = {1, 3, 8, 12 };
		System.out.println(mba.findMax(arr3));
		
		int arr4[] = {10,9,8};
		System.out.println(mba.findMax(arr4));
	}

	public int findMax(int[] arr) {
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			
			int mid = low + (high-low)/2;
			
			if(mid==0 && arr[mid]> arr[mid+1]) {
				return arr[mid];
			}
			
			if(mid==arr.length-1 && arr[mid]>arr[mid-1]) {
				return arr [mid];
			}
			
			if( arr[mid]>arr[mid+1]  && arr[mid]> arr[mid-1]) {
				return arr[mid];
			}
			
			if(arr[mid]+1> arr[mid-1]) {
				low = mid+1;
			}else {
				high = mid;
			}
		}

		return -1;
	}

}
