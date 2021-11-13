package com.nacaroglu.dsa.practice.tree;


public class BalancedBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		BalancedBinaryTree bbt = new BalancedBinaryTree();

		System.out.println(bbt.isBalanced(root));
		
		

	}

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		return Math.abs(height(root.left) - height(root.right)) < 2 
				&& isBalanced(root.left) 
				&& isBalanced(root.right);
	}

	public int height(TreeNode node) {

		if (node == null) {
			return -1;
		}

		int left = height(node.left);
		int right = height(node.right);

		return Math.max(left, right) + 1;
	}
}
