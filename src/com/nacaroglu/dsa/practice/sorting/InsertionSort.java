package com.nacaroglu.dsa.practice.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		
		InsertionSort selectionSort = new InsertionSort();
		int[] arr =   {7,10,5,3,8,4,2,9,6};
		selectionSort.sort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
	
	public void sort(int[] arr) {
		
		if(arr==null || arr.length<2 ) 
			return;
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=i; j>0; j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr, j, j-1);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;			
	}
}
