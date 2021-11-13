package com.nacaroglu.dsa.practice.binarysearch;

public class BinarySearchTemplate3 {
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		
		BinarySearchTemplate3 s = new BinarySearchTemplate3();
		System.out.println(s.binarySearch(nums, 9));
		System.out.println(s.binarySearch(nums, 0));
		System.out.println(s.binarySearch(nums, 1));
		System.out.println(s.binarySearch(nums, 5));
	}	
	
	private int binarySearch(int[] nums, int target) {
				
		if(nums==null || nums.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length-1;
		
		while(left+1 < right) {
			
			int mid = left + (right-left)/2;
			
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid]<target) {
				left=mid;
			}else{
				right=mid;
			}		
		}
		
		if(nums[left]==target) return left;
		if(nums[right]==target) return right;		
		
		return -1;
	}
	
	

}
