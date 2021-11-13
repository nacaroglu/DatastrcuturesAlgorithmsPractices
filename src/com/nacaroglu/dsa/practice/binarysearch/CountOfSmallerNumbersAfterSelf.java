package com.nacaroglu.dsa.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		
		CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
		//int[] nums = {5,2,6,1};
		//int[] nums = {-1};
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		c.countSmaller(nums);
		
		/*
		int arr1[] = {10,27,10,35,12,22,28,9,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0};
			
		int arr2[] = {10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0};
		
		for (int i = 0; i < arr2.length; i++) {
			if(arr1[i] != arr2[i]) {
				System.out.println(arr1[i] + ": " + arr2[i]);
			}
		}*/
		
	}
	
	public List<Integer> countSmaller(int[] nums) {
	
		List<Integer> result = new ArrayList<Integer>(nums.length);
		
		for(int i=0; i< nums.length; i++) {
			
			int arr[] = Arrays.copyOfRange(nums, i, nums.length);			
			Arrays.sort(arr);
			int count = Arrays.binarySearch(arr, nums[i]);
			result.add(count);			
		}	
		
		return result;        
    }

}
