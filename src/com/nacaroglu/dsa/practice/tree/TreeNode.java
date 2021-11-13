package com.nacaroglu.dsa.practice.tree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	int numOfChilderen;
	TreeNode next;
	

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

	@Override
	public String toString() {
		return "val=" + val;
	}
	
	
}
