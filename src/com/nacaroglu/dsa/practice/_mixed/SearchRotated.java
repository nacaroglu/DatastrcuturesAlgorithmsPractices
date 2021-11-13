package com.nacaroglu.dsa.practice._mixed;

import java.util.Arrays;

public class SearchRotated {

	public static void main(String[] args) {
		
		SearchRotated sr = new SearchRotated();			

		int arr[] = { 176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162 };
		
		System.out.println(sr.binarySearchRotated(arr, 200));
		
		
	}
	
	public int binarySearchRotated(int[] arr,int key) {
		
		return doSearch(arr, key, 0, arr.length-1);
	}
	
	public int doSearch(int[] arr, int key, int low, int high) {
		
		if(low>high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(arr[mid]==key)
			return mid;
		
		
		int left = doSearch(arr,key,low,mid-1);
			
		if(left!=-1) {
			return left;
		}
		
		
		int right = doSearch(arr, key, mid+1, high);
		
		return right;
	}

}
