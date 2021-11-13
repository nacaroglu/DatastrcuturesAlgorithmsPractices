package com.nacaroglu.dsa.practice.tree;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		System.out.println(s.sumNumbers(root));
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(9);
		root2.left.left = new TreeNode(5);
		root2.left.right = new TreeNode(1);
		root2.right = new TreeNode(0);
		
		//System.out.println(s.sumNumbers(root2));
		
		s.totalSum = 0;		
		TreeNode root3 = null;
		//System.out.println(s.sumNumbers(root3));
		
	}
	
	public int totalSum = 0;

	public int sumNumbers(TreeNode root) {
		
		if(root==null) {
			return totalSum;
		}
		
		helper(root, 0);		
		return totalSum;
	}

	private void helper(TreeNode node, int pathSum) {
		
		pathSum = (pathSum * 10) + node.val;
		
		if(node.left == null && node.right==null) {
			totalSum += pathSum;
			return;
		}
		
		if(node.left!=null) {
			helper(node.left, pathSum);
		}
		
		if(node.right!=null) {
			helper(node.right, pathSum);
		}		
	}
}
