package com.nacaroglu.dsa.practice.binarysearch;

public class FindMinimumRotatedSortedArray {

	public static void main(String[] args) {

		FindMinimumRotatedSortedArray findMin = new FindMinimumRotatedSortedArray();

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		// System.out.println(findMin.findMin(nums));

		int[] nums2 = { 0, 1, 2, 4, 5, 6, 7 };
		// System.out.println(findMin.findMin(nums2));

		int[] nums3 = { 11, 13, 15, 17 };
		System.out.println(findMin.findMin(nums3));

	}

	public int findMin(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		if (nums[nums.length - 1] > nums[0]) {
			return nums[0];
		}

		int left = 0, right = nums.length - 1;

		// Binary search way
		while (right >= left) {

			// Find the mid element
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}

			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}

			if (nums[mid] > nums[0]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;

	}

}
