package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLowHigh {

	public static void main(String[] args) {
		
		Integer[] arr = { 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20 };
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		
		FindLowHigh f = new FindLowHigh();
		System.out.println(f.findLowIndex(list, 5));	
		System.out.println(f.findHighIndex(list, 5));
		
	}

	public int findLowIndex(List<Integer> list, int key) {
		
		Integer[] arr = new Integer[list.size()];		
		arr = list.toArray(arr);
		
		int minIndex = -1;
		int index = arr.length-1;		
		int high = arr.length-1;
		
		
		do {			
			index = Arrays.binarySearch(arr, 0, high-1, key);
			
			if(index>=0) {
				minIndex = index;
			}						
			
			high=index;
			
		}while(index>=0);

		return minIndex;
	}

	public int findHighIndex(List<Integer> list, int key) {
		
		Integer[] arr = new Integer[list.size()];		
		arr = list.toArray(arr);
		
		int maxIndex = -1;
		int index = arr.length-1;		
		int low = 0;
		int n = arr.length-1;
		
		
		do {			
			index = Arrays.binarySearch(arr, low+1, n, key);
			
			
			if(index>=0) {
				maxIndex = index;
			}						
			
			low=index;
			
		}while(index>=0);

		return maxIndex;
	}

}
