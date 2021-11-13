package com.nacaroglu.dsa.practice.binarysearch;

public class PeakFinding {

	public static void main(String[] args) {

		PeakFinding pf = new PeakFinding();
		int[] nums = { 2 , 1 };
		System.out.println(pf.findPeakElement(nums));
		int[] nums2 = {1,2,1,3,5,6,4};
		System.out.println(pf.findPeakElement(nums2));
	}

	/*
	public int findPeakElement(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		return helper(nums, 0, nums.length - 1);
	}

	private int helper(int[] nums, int l, int h) {

		if (h == l) {
			return l;
		}

		int mid = (h + l) / 2;

		if (nums[mid] > nums[mid + 1]) {
			return helper(nums, l, mid);
			// right
		} else {
			return helper(nums, mid+1, h);
		}
	} */
	
	public int findPeakElement(int[] nums) {

		if (nums.length == 1) 
			return nums[0];

		int left = 0, right = nums.length-1;
		
		while (left < right) {
		
			int mid = left + (right - left) / 2;
			
			if ( mid+1<nums.length && nums[mid]>nums[mid+1] 
					&& mid-1>=0 && nums[mid]>nums[mid-1]) {
				return mid;
			}
						
			if (nums[mid]>nums[mid+1]) {
				right = mid;			
			} else {
				left = mid + 1;
			}
		}

		if (left != nums.length)
			return left;
		return -1;
	}

}
