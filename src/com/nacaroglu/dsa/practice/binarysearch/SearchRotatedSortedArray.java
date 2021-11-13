package com.nacaroglu.dsa.practice.binarysearch;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SearchRotatedSortedArray bs = new SearchRotatedSortedArray();
		int[] nums = { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 };

		/*
		 * System.out.println(bs.search_recursive(nums, 0));
		 * System.out.println(bs.search_recursive(nums, 3));
		 * System.out.println(bs.search_recursive(nums, 4));
		 * System.out.println(bs.search_recursive(nums, -5));
		 * System.out.println(bs.search_recursive(nums, 2));
		 */

		System.out.println(bs.search(nums, 550));
		
		System.out.println(bs.search(nums, 234));
		System.out.println(bs.search(nums, 368));
		System.out.println(bs.search(nums, 478));
		System.out.println(bs.search(nums, 279));
		 
	}

	public int search(int[] arr, int target) {

		int l = 0;
		int h = arr.length - 1;

		while (l <= h) {

			int mid = l + (h - l) / 2;			

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] >= arr[l]) { // rotated
				  if (target >= arr[l] && target < arr[mid]) 
					  h = mid - 1;
			      else 
			    	  l = mid + 1;
			}else { // not rotated
				 if (target <= arr[h] && target > arr[mid]) 
					 l = mid + 1;
			     else h = mid - 1;
			}		
		}

		return -1;
	}

	public int search_recursive(int[] nums, int target) {

		return helper(nums, 0, nums.length - 1, target);

	}

	private int helper(int[] nums, int l, int h, int target) {

		if (l > h) {
			return -1;
		}

		int mid = l + (h - l) / 2;

		if (nums[mid] == target) {
			return mid;
		}

		int left = helper(nums, l, mid - 1, target);
		if (left != -1) {
			return left;
		}

		int right = helper(nums, mid + 1, h, target);
		if (right != -1) {
			return right;
		}

		return -1;

	}

}
