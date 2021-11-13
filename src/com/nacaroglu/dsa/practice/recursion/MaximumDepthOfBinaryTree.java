package com.nacaroglu.dsa.practice.recursion;

public class MaximumDepthOfBinaryTree {
	
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
		
		TreeNode node_18  =new TreeNode(18);
				
		TreeNode node_15 = new TreeNode(15);
		node_15.left = node_18;
		TreeNode node_7 = new TreeNode(7);
		
		TreeNode node_20 = new TreeNode(20);
		node_20.left = node_7;
		node_20.right = node_15;
		
		TreeNode node_9 = new TreeNode(9);
		
		TreeNode root = new TreeNode(3);
		root.left = node_9;
		root.right = node_20;

		MaximumDepthOfBinaryTree max = new MaximumDepthOfBinaryTree();
		int result = max.maxDepth(root);
		System.out.println(result);		
		System.out.println(max.maxDepth(node_18));
		System.out.println(max.maxDepth(null));
		System.out.println(max.maxDepth(node_20));

	}
	
	 public int maxDepth(TreeNode root) {
		 
		 if(root==null) {
			 return 0;			 
		 }
		 
		 if(root.left==null && root.right==null) {
			 return 1;
		 }
		 
		 int leftCount = maxDepth(root.left);
		 int rightCount = maxDepth(root.right);
		 
		 int result = leftCount;
		 
		 if(rightCount> leftCount) {
			 result = rightCount;
		 }
		 
		 return result+1;	        
	 }

}
