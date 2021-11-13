package com.nacaroglu.dsa.practice.binarysearch;

import java.util.Arrays;

public class SearchForRange {

	public static void main(String[] args) {
		
		SearchForRange sfr = new SearchForRange();
		
		int nums[] = { 5,7,7,8,8,10 };
		//System.out.println(sfr.searchRange(nums, 8));
		
		//System.out.println(sfr.searchRange(nums, 6));
//		System.out.println(sfr.searchRange(nums, 66));
		
		int nums2[] = new int[0];
		System.out.println(sfr.searchRange(nums2, 6));

	}
	
	public int[] searchRange(int[] nums, int target) {
		
		int result[] = {-1,-1};
		
		if(nums==null || nums.length==0) return result;
		
		int index = Arrays.binarySearch(nums, target);
		
		if(index<0) return result;
		
		int min = findMinIndex(nums, index, target);
		int max = findMaxIndex(nums, index, target);
		
		result[0] = min;
		result[1] = max;				
		
		return result;
        
    }

	private int findMinIndex(int[] nums, int index, int target) {
		
		for(int left = index-1; left>=0; left--) {
			if(nums[left]!=target) {
				return left+1;
			}
		}		
		return 0;
	}
	
	private int findMaxIndex(int[] nums, int index, int target) {
		
		for(int rigth = index; rigth<nums.length; rigth++) {
			if(nums[rigth]!=target) {
				return rigth-1;
			}
		}		
		return nums.length-1;
	}


}
