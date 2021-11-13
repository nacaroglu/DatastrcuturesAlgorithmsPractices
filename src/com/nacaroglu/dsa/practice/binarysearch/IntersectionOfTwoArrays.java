package com.nacaroglu.dsa.practice.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		
		IntersectionOfTwoArrays it2a = new IntersectionOfTwoArrays();
		
		int[] nums2 = {4,9,5 };
		int[] nums1 = { 9,4,9,8,4};
		int[] result = it2a.intersection(nums1, nums2);

		System.out.println(result.length);
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		int[] big = nums1;
		int[] small = nums2;
		
		if(nums2.length>nums1.hashCode()) {
			big = nums2;
			small = nums1;
		}
		
		Arrays.sort(big);
		
		
		for(int i=0; i<small.length; i++) {
		
			if(set.contains(small[i])) {
				continue;
			}
			
			if(binarySearch(big, small[i])>-1) {
				set.add(small[i]);
			}
		}
		
		int[] result = new int[set.size()];
		int index = 0;
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			result[index] = it.next();
			index++;
		}
        
		return result;
    }
	
	public int binarySearch(int[] nums, int target) {
		
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


}
