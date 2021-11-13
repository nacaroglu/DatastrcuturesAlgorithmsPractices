package com.nacaroglu.dsa.practice.tree;

import java.util.HashMap;


public class BinaryTreeFromPreorderAndInorder {
	
	int preIndex;
	
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
			// TODO Auto-generated method stub
			return "val: " + val;
		}
		
		
	}

public static void main(String[] args) {
		
		
		/*
		   		3
			   / \
			  9   20
			 /   /  \
			  15   7
		 */

		
		TreeNode node_9 = new TreeNode(9);
		TreeNode node_20 = new TreeNode(20);
		
		TreeNode root = new TreeNode(3);
		root.left = node_9;
		root.right = node_20;
		
		/*
		TreeNode node_18 = new TreeNode(18);
		node_9.left = node_18; */
		
		TreeNode node_15 = new TreeNode(15);
		TreeNode node_7 = new TreeNode(7);
		node_20.left = node_15;
		node_20.right = node_7;	
		
		/*
		preorder = [3,9,8,6,20,15,7]
		inorder = [6,9,8,3,15,20,7]*/
		
		BinaryTreeFromPreorderAndInorder b = new BinaryTreeFromPreorderAndInorder();
		
		int[] preOrder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		/*
		int[] preOrder = {3,9,8,6,20,15,7};
		int[] inorder = {6,9,8,3,15,20,7}; */
		
		/*
		int[] preOrder = {1,2,3};
		int[] inorder = {3,2,1};
		*/
		
		b.buildTree(preOrder, inorder);
		
		System.out.println("Bitti");		
		
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		if(preorder==null || inorder==null) {
			return null;
		}
		
		if(preorder.length==0 || inorder.length==0) {
			return null;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i< inorder.length; i++) {
			map.put(inorder[i], i);
		}
				
		
		TreeNode root= build(preorder, inorder, map, 0, inorder.length-1);		
		
		return root;
	    
	}

	//	preorder = [3,9,20,15,7]
	//	inorder = [9,3,15,20,7]
	private TreeNode build(int[] preOrder, int[] inOrder, HashMap<Integer, Integer> map, int inLeft, int inRight) {
		
		//Arrays.copyOfRange(src, 0, 2);
		
		if(inLeft==inRight) {
			return null;
		}		
		
		TreeNode head = new TreeNode(preOrder[preIndex]);
		
	
		int mid = map.get(head.val);	
		
		preIndex++;
		
		head.left = build(preOrder, inOrder, map, inLeft, mid);
		head.right = build(preOrder, inOrder, map, mid+1, inRight);
		
		
		
		return head;
	}
}
