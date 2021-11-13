package com.nacaroglu.dsa.practice.binarysearch;

public class SortedArrayToBST {

	public static void main(String[] args) {
		
		SortedArrayToBST sa2bst = new SortedArrayToBST();
		int[] nums = {1,2,3,4,5,6,7,8,9};
		TreeNode root = sa2bst.sortedArrayToBST(nums);
		System.out.println(root.val);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums, 0, nums.length-1);       
    }

	private TreeNode helper(int[] nums, int start, int end) {
		
		if(start>end) {
			return null;
		}
		
		if(start==end) {
			return new TreeNode(nums[start]);
		}
		
		int mid = start + (end-start)/2;
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums,start, mid-1);
		root.right = helper(nums, mid+1, end);
		
		return root;
	}

}
