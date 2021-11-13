package com.nacaroglu.dsa.practice.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearch bs = new BinarySearch();
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(bs.search(nums, 9));
		System.out.println(bs.search(nums, 2));
		System.out.println(bs.search(nums, 5));
		System.out.println(bs.search(nums, -5));
		System.out.println(bs.search(nums, 35));
		
		System.out.println(bs.search_recursive(nums, 9));
		System.out.println(bs.search_recursive(nums, 2));
		System.out.println(bs.search_recursive(nums, 5));
		System.out.println(bs.search_recursive(nums, -5));
		System.out.println(bs.search_recursive(nums, 35));
		
		
	}
	
	public int search(int[] nums, int target) {
		
		int l= 0; 
		int h = nums.length-1;
		
		while(l<=h) {
			
			int mid = l + (h-l)/2;
			
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid]>target) {
				h = mid-1;
			}else {
				l = mid+1;
			}	
		}
		
		return -1;		
    }
	
	public int search_recursive(int[] nums, int target) {
		
		return helper(nums,0,nums.length-1, target);
		
    }

	private int helper(int[] nums, int l, int h, int target) {
		
		if(l>h) {
			return -1;
		}
		
		int mid = l + (h-l)/2;
		
		if(nums[mid]==target) {
			return mid;
		}else if(nums[mid]>target) {
			return helper(nums,l,mid-1,target);
		}else {
			return helper(nums,mid+1, h, target);
		}	
	}

}
