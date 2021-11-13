package com.nacaroglu.dsa.practice.heaps;

import java.util.PriorityQueue;

public class KSmallest {

	public static void main(String[] args) {

		int[] arr = { 9, 4, 7, 1, -2, 6, 5 };
		//findKSmallest(arr, 3);
		findKLargest(arr, 3);
	}

	public static int[] findKSmallest(int[] arr, int k) {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

		for (Integer integer : arr) {
			q.add(integer);

			if (q.size() > k) {
				q.poll();
			}
		}

		int[] result = new int[q.size()];

		for (int i = k - 1; i >= 0; i--) {
			result[i] = q.poll();
		}

		// Write - Your - Code
		return result;
	}
	
	public static int[] findKLargest(int[] arr, int k) {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		for (Integer integer : arr) {
			q.add(integer);

			if (q.size() > k) {
				q.poll();
			}
		}

		int[] result = new int[q.size()];

		for (int i = k - 1; i >= 0; i--) {
			result[i] = q.poll();
		}		

		// Write - Your - Code
		return result;
	}

}
