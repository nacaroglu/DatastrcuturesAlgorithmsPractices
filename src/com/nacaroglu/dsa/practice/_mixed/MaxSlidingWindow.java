package com.nacaroglu.dsa.practice._mixed;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxSlidingWindow ms = new MaxSlidingWindow();

		int[] A = {-4, 2, -5, 3, 6};
		
		System.out.println(ms.findMaxSlidingWindow(A, 3));
	}
	
	public int findMaxSlidingWindow(int[] arr, int windowSize) {
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<windowSize; i++) {
			q.add(arr[i]);
		}
		
		int max = q.peek();
		
		for(int i=windowSize; i<arr.length; i++) {
			q.add(arr[i]);
			q.remove(arr[i-windowSize]);
			max = Math.max(max, q.peek());
		}		
		
		return max;
	}

}
