package com.nacaroglu.dsa.practice.tree;

public class TreeFromOrderedArray {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		
		int nums[] =  {5,10,15,20,25,30,35};
		
		TreeFromOrderedArray tree = new TreeFromOrderedArray();
		
		TreeNode root = tree.buildTree(nums);
		System.out.println("bitt");
	}
	
	private TreeNode buildTree(int nums[]) {
		
		if(nums==null || nums.length==0) {
			return null;
		}
		
		TreeNode root = helper( 0, nums.length-1, nums);				
		return root;		
	}
	
	private TreeNode helper( int min, int max, int[]nums) {
		
		int mid = (max+min)/2;
					
		if(min>max) {
			return null;
		}
		
		TreeNode myNode = new TreeNode(nums[mid]);
		
		System.out.println("Val: " +  nums[mid]  + " Min:" + min + " Mid: " + mid + " Max: " + max);
				
		myNode.left = helper(min, mid-1, nums);
		myNode.right =helper(mid+1, max, nums);	
		
		return myNode;
	}
}
