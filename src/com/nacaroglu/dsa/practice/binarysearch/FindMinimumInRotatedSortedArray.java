package com.nacaroglu.dsa.practice.binarysearch;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {

		
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();

		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(f.findMin(nums));
		
		int[] nums2 = {3,4,5,1,2};
		System.out.println(f.findMin(nums2));
		
		int[] nums3 = {11,13,15,17};
		System.out.println(f.findMin(nums3));
		
		int[] nums4 = {11,17};
		System.out.println(f.findMin(nums4));
		
		int[] nums5 = {19,17};
		System.out.println(f.findMin(nums5));

		

	}
	
	public int findMin(int[] nums) {

		int foo = doBinarySearch(nums, 0, nums.length - 1);

		return nums[foo];

	}

	private int doBinarySearch(int[] arr, int min, int max) {

		if (max <= min) {
			return min;
		}

		int mid = (max + min) / 2;

		if (mid == 0) {

			if (arr[mid] < arr[mid + 1]) {
				return mid;
			} else if (arr[mid] > arr[mid + 1]) {
				return mid + 1;
			}

		}

		if (max == arr.length - 1 && arr[mid] < arr[mid - 1]) {
			return mid;
		}

		if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
			return mid;
		}

		int leftSide = doBinarySearch(arr, min, mid - 1);

		int rightSide = doBinarySearch(arr, mid + 1, max);

		if (arr[leftSide] < arr[rightSide]) {
			return leftSide;
		} else {
			return rightSide;
		}

	}

}
