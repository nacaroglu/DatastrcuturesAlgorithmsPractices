package com.nacaroglu.dsa.practice.binarysearch;

public class SortedArrayForEntryEqualToItsIndex {

	public static void main(String[] args) {

		SortedArrayForEntryEqualToItsIndex xxx = new SortedArrayForEntryEqualToItsIndex();
		int[] nums = {-2,0, 2, 3, 6, 7, 9};
		System.out.print(xxx.searchEntryEqualToItsIndex(nums));

	}
	
	public int searchEntryEqualToItsIndex (int nums[]) {
		
		int l= 0; 
		int h = nums.length-1;
		
		int result = -1;
		
		while(l<=h) {
			
			int mid = l + (h-l)/2;
			
			if(nums[mid]==mid) {
				result = mid;
				h = mid - 1;
			}else if(nums[mid]>mid) {
				h = mid-1;
			}else {
				l = mid+1;
			}	
		}
		
		return result;		
	}

}
