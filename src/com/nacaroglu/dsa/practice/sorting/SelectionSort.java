package com.nacaroglu.dsa.practice.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		SelectionSort selectionSort = new SelectionSort();
		int[] arr =   {7,10,5,3,4,4,2,3,2};
		selectionSort.sort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
	
	public void sort(int[] arr) {
		
		if(arr==null || arr.length<2 ) 
			return;
		
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			
			swap(arr, i, min);
		}
	}

	private void swap(int[] arr, int i, int min) {
		if(arr[min]<arr[i]) {
			int temp = min;
			int iVal = arr[i];
			arr[i] = arr[min];
			arr[temp] = iVal;
		}
	}
}
