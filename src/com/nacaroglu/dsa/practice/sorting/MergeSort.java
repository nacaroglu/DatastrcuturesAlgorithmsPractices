package com.nacaroglu.dsa.practice.sorting;

public class MergeSort {

	public static void main(String[] args) {
		
		
		
		MergeSort mergeSort = new MergeSort();
		
		int[] arr = {7, 10, 5, 3, 8, 4, 2, 9};
		printArr(arr);
		mergeSort.sort(arr);
		printArr(arr);

	}
	
	private static void printArr(int[] arr) {
		System.out.println("");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	private void sort(int[] arr) {
		
		helper(arr,0, arr.length-1);
	}

	private void helper(int[] arr, int l, int r) {
		
		if(r<=l) {
			return;
		}
		
		int mid = l + (r-l)/2;
		
		helper(arr, l, mid );
		helper(arr, mid+1, r);
		
		merge(arr, l, mid, r);		
	}

	private void merge(int[] arr,int l, int m, int r) {
		
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		
		int i=0; 
		int j=0;
		int k=l;
		
		while(i<n1 && j<n2) {
			
			if(L[i]<R[j]) {
				arr[k] = L[i];
				i++;								
			}else {
				arr[k] = R[j];
				j++;
			}
			
			k++;								
		}
		
		 while (i < n1) {
			arr[k] = L[i];
			k++;
			i++;
		}
		
		 while (j < n2) {
			arr[k] = R[j];
			k++;
			j++;
		}		
	}

}
