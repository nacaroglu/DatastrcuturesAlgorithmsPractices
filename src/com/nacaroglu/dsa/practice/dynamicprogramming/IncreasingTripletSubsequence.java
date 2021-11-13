package com.nacaroglu.dsa.practice.dynamicprogramming;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {

		IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();

		/*
		int nums[] = { 8, 9, 2, 3, 1 };

		System.out.println(its.increasingTriplet(nums));

		int nums2[] = { 5, 4, 3, 2, 1 };

		System.out.println(its.increasingTriplet(nums2));

		int nums3[] = { 2, 1, 5, 10, 4, 6 };

		System.out.println(its.increasingTriplet(nums3));
		*/

		int nums4[] = { 20,100,10,12,5,13 };

		System.out.println(its.increasingTriplet(nums4));
	}
	
	public boolean increasingTriplet(int[] nums) {
		
		for(int i=nums.length-1;i>=0;i--) {
			for(int j=i-1; j>=0; j--) {
				if(nums[i]>nums[j]) {
					for(int k=j-1; k>=0; k--) {
						if(nums[j]>nums[k]) {
							return true;
						}
					}
				}
			}
		}
		
		
		return false;
		
	}

	public boolean increasingTriplet2(int[] nums) {
		return helper(nums, 1, 1, nums[0]);
	}

	public boolean helper(int nums[], int index, int counter, int max) {

		if (index >= nums.length) {
			return false;
		}

		if (nums[index] > max) {
			counter++;
			
			max = nums[index];

			if (counter == 3) {
				return true;
			}

			return helper(nums, index + 1, counter, max);

		} else {
			return helper(nums, index + 1, counter, max);
		}

	}

}
