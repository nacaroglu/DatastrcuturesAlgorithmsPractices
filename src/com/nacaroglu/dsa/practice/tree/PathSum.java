package com.nacaroglu.dsa.practice.tree;

public class PathSum {

	public static void main(String[] args) {

		PathSum ps = new PathSum();
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		System.out.println(ps.hasPathSum(root, 22));
		System.out.println(ps.hasPathSum(root, 37));
		System.out.println(ps.hasPathSum(root, 18));
		System.out.println(ps.hasPathSum(root, 0));

	}
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		
		if(root==null) {
			
			if(targetSum== 0) 
				return true;
			
			return false;
		}
    
		return helper(root, targetSum, 0);
    }

	private boolean helper(TreeNode node, int targetSum, int sum) {
		
		sum += node.val;
		
		if(node.left==null && node.right==null) {
			return targetSum == sum;
		}
		
		if( node.left!=null && helper(node.left, targetSum, sum)) {
			return true;
		}
		
		if(node.right!=null && helper(node.right, targetSum, sum)) {
			return true;
		}

		return false;
	}

}
