package com.nacaroglu.dsa.practice.tree;

public class SymmetricTree {

	public static void main(String[] args) {
		
		SymmetricTree st = new SymmetricTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		root.left.left = new TreeNode(3);		
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		
		
		root.right = new TreeNode(2);
		
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(7);
		
		root.right.right = new TreeNode(3);
		root.right.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(5);
		

		System.out.println(st.isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
		
		if(root==null) {
			return true;
		}
		
		return helper(root.left, root.right);		
	}

	private boolean helper(TreeNode left, TreeNode right) {
		
		if(left==null && right==null) {
			return true;
		}
		
		if(left==null || right == null) {
			return false;
		}
		
		if(left.val!=right.val) {
			return false;
		}
		
		if(!helper(left.left,right.right)) {
			return false;
		}		
		
		if(!helper(left.right, right.left)) {
			return false;
		}
		
		return true;
	}

}
