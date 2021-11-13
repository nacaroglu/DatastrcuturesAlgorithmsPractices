package com.nacaroglu.dsa.practice.binarysearch;

public class FindPeakElement {

	public static void main(String[] args) {
		
		FindPeakElement fpe = new FindPeakElement();
			
		int[] nums = {1,2,1,3,5,6,4};
		System.out.println(fpe.findPeakElement(nums));
		
		
		int[] nums2 = {1,2,3,1};
		System.out.println(fpe.findPeakElement(nums2));
		
		int[] nums5 = {1};
		System.out.println(fpe.findPeakElement(nums5));
		
		int[] nums3 = {1,2};
		System.out.println(fpe.findPeakElement(nums3));
		
		int[] nums33 = {1,2,3};
		System.out.println(fpe.findPeakElement(nums33));
		
		int[] nums4 = {3,1};
		System.out.println(fpe.findPeakElement(nums4)); 

	}
	
	public int findPeakElement(int[] nums) {
		
		if(nums==null || nums.length == 0) {
			return -1;
		}
		
		if(nums.length==1) {
			return 0;
		}
		
		
		int left = 0;
		int right = nums.length-1;
		
		while(left+1 < right) {
			
			int mid = left + (right-left)/2;
			
			if(mid==nums.length-1 && nums[mid]>nums[mid-1]) {
				return mid;
			}
			
			if((mid==0) && nums[mid]>nums[mid+1]) {
				return mid;
			}
			
			if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
				return mid;
			}else if(nums[mid]<nums[mid+1]&& nums[mid]>nums[mid-1]) {
				left=mid;
			}else{
				right=mid;
			}		
		}
		
		if(left==nums.length-1 && nums[left]>nums[left-1]) {
			return left;
		}

		if ((left == 0)) {
			if (nums[left] > nums[left + 1]) {

				return left;
			} else {
				return right;
			}
		}
		if(right==nums.length-1 &&  nums[right]>nums[right-1]) {
			return right;
		}
		
		if(nums[left]>nums[left-1] && nums[left]>nums[left+1]) return left;
		if(nums[right]>nums[right-1] && nums[right]>nums[right+1]) return right;		
		
		return -1;		     
	}
}
