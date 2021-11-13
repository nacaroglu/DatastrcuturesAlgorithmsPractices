package com.nacaroglu.dsa.practice.binarysearch;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SearchInsertPosition bs = new SearchInsertPosition();
		int[] nums = {1,3,5,6};
		//System.out.println(bs.search(nums, 5));
		//System.out.println(bs.search(nums, 2));
		System.out.println(bs.search(nums, 7));
		System.out.println(bs.search(nums, 0));
		System.out.println(bs.search(nums, 35));
		
		
	}
	
	public int search(int[] nums, int target) {
		
		int l= 0; 
		int h = nums.length-1;
		int lowerIndex = -1;
		int higherIndex = -1;
		
		while(l<=h) {
			
			int mid = l + (h-l)/2;
			
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid]>target) {
				higherIndex = mid;
				h = mid-1;
			}else {
				lowerIndex = mid;
				l = mid+1;
			}	
		}
		
		if(lowerIndex==-1) {
			return 0;
		}else if(higherIndex==-1) {
			return nums.length;
		}
		
		return lowerIndex+1;		
    }
}
