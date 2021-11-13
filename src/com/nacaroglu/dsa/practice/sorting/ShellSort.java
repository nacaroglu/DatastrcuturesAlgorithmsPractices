package com.nacaroglu.dsa.practice.sorting;

public class ShellSort {

	public static void main(String[] args) {

		ShellSort shellSort = new ShellSort();
		int[] arr = { 7, 10, 5, 3, 8, 4, 2, 9, 6 };
		
		printArr(arr);
		shellSort.sort(arr);

		
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;

		int h = 1;
		while (h < arr.length / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			
			System.out.println("\nh: " + h);
			
			for (int i = h; i < arr.length; i++) {

				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {

					swap(arr, j, j - h);

				}
			}

			printArr(arr);
			h = h / 3;
		}

	}

	private void swap(int[] arr, int i, int j) {

		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
