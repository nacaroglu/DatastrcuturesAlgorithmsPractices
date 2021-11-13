package com.nacaroglu.dsa.practice.recursion;

public class SearchInBST {
	
	
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
		
		TreeNode node_1 = new TreeNode(1);
		TreeNode node_3 = new TreeNode(3);
		
		TreeNode node_2 = new TreeNode(2);
		node_2.left = node_1;
		node_2.right = node_3;
		
		TreeNode node_7 = new TreeNode(7);
		
		TreeNode root = new TreeNode(4);
		root.left = node_2;
		root.right = node_7;

		SearchInBST s = new SearchInBST();
		TreeNode result = s.searchBST(root, 2);
		System.out.println(result==null);
	}
	
	public TreeNode searchBST(TreeNode root, int val) {
		
		if(root==null) {
			return null;
		}
        
		if(root.val== val) {
			return root;
		}
		
		if(val> root.val) {
			return searchBST(root.right, val);
		}
		else {
			return searchBST(root.left, val);
		}		
    }

}
