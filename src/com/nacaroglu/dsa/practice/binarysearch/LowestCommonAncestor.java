package com.nacaroglu.dsa.practice.binarysearch;

public class LowestCommonAncestor {

public static void main(String[] args) {
		
		KSmallestLargestElementsInBST k = new KSmallestLargestElementsInBST();
		
		TreeNode root = buildTree0();		
		System.out.println(k.kthSmallest(root, 3));
		System.out.println(k.kthLargest(root, 3));

	}
	
	private static TreeNode buildTree0() {
		
		TreeNode root = new TreeNode(19,15);
		
		root.left = new TreeNode(7,6);
		
		root.left.left = new TreeNode(3,2);
		root.left.left.left = new TreeNode(2,0);
		root.left.left.right = new TreeNode(5,0);
		
		root.left.right = new TreeNode(11,2);
		root.left.right.right = new TreeNode(17,1);
		root.left.right.right.left = new TreeNode(13,0);	

		
		root.right = new TreeNode(43,7);
		
		root.right.left = new TreeNode(23,4);
		root.right.left.right = new TreeNode(37,3);
		root.right.left.right.right = new TreeNode(41,0);
		root.right.left.right.left = new TreeNode(29,1);
		root.right.left.right.left.right = new TreeNode(31,0);
		
		root.right.right = new TreeNode(47,1);
		
		root.right.right.right = new TreeNode(53,0);
		
		
		return root;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		return helper(root, p, q);
    }

	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root==null) {
			return null;
		}
		
		if(root.val>p.val && root.val>q.val) {
			return helper(root.left, p,q);
		}else if (root.val<p.val && root.val <p.val) {
			return helper(root.right, p, q);
		}else {
			return root;
		}		
	}
}
