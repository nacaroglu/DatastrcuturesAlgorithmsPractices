package com.nacaroglu.dsa.practice.binarysearchtree;

public class InsertIntoBST {
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

		@Override
		public String toString() {
			return "val: " + val;
		}
	}

	public static void main(String[] args) {

	}
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
		
		if(root==null) {
			return new TreeNode(val);
		}
		
		doInsert(root,val);
		
		return root;
	}
	
	

	private void doInsert(TreeNode root, int val) {
		
		if(root.val>val) {
			if(root.left==null) {
				root.left = new TreeNode(val);
			}else {
				doInsert(root.left, val);
			}
		}
		
		if(root.val<val) {
			if(root.right==null) {
				root.right = new TreeNode(val);
			}else {
				doInsert(root.right, val);
			}		
		}		
	}

}
