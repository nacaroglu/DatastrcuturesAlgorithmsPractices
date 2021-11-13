package com.nacaroglu.dsa.practice.sorting;

public class QuickSort {

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		int[] arr = {7, 10, 5, 3, 8, 4, 2, 9};
		qs.quickSort(arr);
		printArr(arr);
	}
	
	private static void printArr(int[] arr) {
		System.out.println("");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public void quickSort(int[] arr ) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int left, int right) {

		if (left >= right)
			return ;

		int pivotIndex = partition(arr, left, right);

		sort(arr, left, (pivotIndex - 1));
		sort(arr, pivotIndex + 1, right);

	}

	static int partition(int[] arr, int left, int right) {

		int pivot = arr[right];
		int i = left - 1;

		for (int j = left; j <= right - 1; j++) {

			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {

				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, right);
		return (i + 1);
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
