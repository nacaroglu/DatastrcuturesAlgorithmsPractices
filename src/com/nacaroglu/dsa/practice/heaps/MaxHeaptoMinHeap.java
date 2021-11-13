package com.nacaroglu.dsa.practice.heaps;

public class MaxHeaptoMinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] maxHeap = {16,15,14,12,4,7,9,2,3,1};
		MaxHeaptoMinHeap.convertMax(maxHeap,0);

		for (int i : maxHeap) {
			System.out.print(i + ", ");
		}
	}

	public static void convertMax(int[] arr, int i) {
		
		if(2*i+1>=arr.length || 2*i+2>=arr.length) {
			return;
		}

		int minChildIndex = findMinChild(arr, i);
		
		int temp = arr[i];
		arr[i] = arr[minChildIndex];
		arr[minChildIndex] = temp;
		
		convertMax(arr, 2*i+1);
		convertMax(arr, 2*i+2);
	}

	private static int findMinChild(int[] arr, int i) {
		
		if(2*i+1>=arr.length && 2*i+2>=arr.length) {
			return i;
		}
		
		
		if(2*i+2>=arr.length) {
			return findMinChild(arr, 2*i+1);
		}
		
		if(2*i+2>=arr.length) {
			findMinChild(arr, 2*i+2);
		}
		
		int left = findMinChild(arr, 2*i+1);
		int right = findMinChild(arr, 2*i+2);
		
		if(arr[left]>arr[right]) {
			return right;
		}
		return left;		
	}

}
