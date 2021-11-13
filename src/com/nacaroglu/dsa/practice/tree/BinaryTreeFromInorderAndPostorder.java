package com.nacaroglu.dsa.practice.tree;

import java.util.HashMap;


public class BinaryTreeFromInorderAndPostorder {
	
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
		
		BinaryTreeFromInorderAndPostorder b = new BinaryTreeFromInorderAndPostorder();
		
		
		int[] postOrder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		
		
		/*		
		int[] inOrder = {8,9,10,3,15,20,7};
		int[] postOrder = {8,10,9,15,7,20,3};*/
		
		
		b.buildTree(postOrder, inorder);
		
		System.out.println("Bitti");		
		
	}

	int posOrderIndex;

	public TreeNode buildTree(int[] postorder, int[] inorder) {
		
		if(postorder==null || inorder==null) {
			return null;
		}
		
		if(postorder.length==0 || inorder.length==0) {
			return null;
		}
		
		posOrderIndex = postorder.length - 1;
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<inorder.length; i++) {
			map.put(inorder[i],i);
		}
		
		TreeNode root= build(postorder, map, 0, postorder.length-1);		
		
		return root;
	    
	}

	//	inorder = [9,3,15,20,7]
	//	postorder = [9,15,7,20,3]
	
	//	[8,9,10,3,15,20,7]
	//	[8,10,9,15,7,20,3]
	
	private TreeNode build(int[] postorder, HashMap<Integer, Integer> map, int inLeft, int inRight) {
		
		
		if(posOrderIndex<0) {
			System.out.println(inLeft + "-" + inRight );
		}
		
		if(inLeft>inRight) {
			return null;
		}		
		
		System.out.println(posOrderIndex);
		
		TreeNode head = new TreeNode(postorder[posOrderIndex]);	
		int mid = map.get(head.val);
		
		posOrderIndex--;
		
		head.right = build(postorder, map, mid+1, inRight);	
		head.left = build(postorder, map, inLeft, mid-1);		
		
		return head;
	}
}
