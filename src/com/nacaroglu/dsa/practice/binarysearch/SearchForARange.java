package com.nacaroglu.dsa.practice.binarysearch;

public class SearchForARange {

	public static void main(String[] args) {
		
		SearchForARange s = new SearchForARange();
		int[] nums = {5,7,7,8,8,8,8,8,8,8,10};
		int[] result = s.searchRange(nums, 8);

		System.out.println(result[0] + "-" + result[1]);
	}
	
	 public int[] searchRange(int[] nums, int target) {
		 
		int[] result = {-1,-1};		 
		 
		int l = 0;
		int h = nums.length - 1;
		int minIndex = -1;

		while (l <= h) {

			int mid = l + (h - l) / 2;

			if (nums[mid] == target) {
				minIndex= mid;
				h = mid-1;
			} else if (nums[mid] > target) {				
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		int maxIndex = -1;
		l = 0;
		h = nums.length - 1;
		
		while (l <= h) {

			int mid = l + (h - l) / 2;

			if (nums[mid] == target) {
				maxIndex= mid;
				l = mid+1;
			} else if (nums[mid] > target) {				
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}		
		
		result[0] = minIndex;
		result[1] = maxIndex;	
		 
		return result;	        
	 }
}
