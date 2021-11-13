package com.nacaroglu.dsa.practice.binarysearch;

public class QuickSelect {

	public static void main(String[] args) {

		QuickSelect qs = new QuickSelect();
		int[] arr = {1,2,3,9,2,4,5,5,6};
		System.out.println(qs.quickSelect(arr,4));
	}
	
	public int quickSelect(int[] arr, int k) {
		
		return select(arr, 0, arr.length-1, k);
	}

	public int select(int[] arr, int left, int right, int k) {	

		if (left == right)
			return arr[left];

		int pivotIndex = partition(arr, left, right);

		if (k == pivotIndex) {
			return arr[k];
		} else if (k < pivotIndex)
			return select(arr, left, (pivotIndex - 1), k);
		else
			return select(arr, pivotIndex + 1, right, k);

	}

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left - 1, j = right + 1;

		while (true) {
			// Find leftmost element greater
			// than or equal to pivot
			do {
				i++;
			} while (arr[i] < pivot);

			// Find rightmost element smaller
			// than or equal to pivot
			do {
				j--;
			} while (arr[j] > pivot);

			// If two pointers met.
			if (i >= j)
				return j;

			// swap(arr[i], arr[j]);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
