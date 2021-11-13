package com.nacaroglu.dsa.practice.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ValidateBST {

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

		ValidateBST vBst = new ValidateBST();
		
		//System.out.println(vBst.isValidBST(buildTreeForCase1()));
		
		System.out.println(vBst.isValidBST2(buildTreeForCase2()));
		//System.out.println(vBst.isValidBST(new TreeNode(99)));
		//System.out.println(vBst.isValidBST(buildTreeForCase3()));
		//System.out.println(vBst.isValidBST(buildTreeForCase4()));		
		//System.out.println(vBst.isValidBST(buildTreeForCase5()));
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
	}

	private static TreeNode buildTreeForCase1() {
		TreeNode root = new TreeNode(2);
		TreeNode node_1 = new TreeNode(1);
		TreeNode node_3 = new TreeNode(3);

		root.left = node_1;
		root.right = node_3;
		return root;
	}

	private static TreeNode buildTreeForCase2() {
		TreeNode root = new TreeNode(5);

		TreeNode node_1 = new TreeNode(1);
		TreeNode node_7 = new TreeNode(7);

		root.left = node_1;
		root.right = node_7;

		TreeNode node_9 = new TreeNode(9);
		TreeNode node_3 = new TreeNode(3);
		node_7.left = node_3;
		node_7.right = node_9;

		return root;
	}
	
	private static TreeNode buildTreeForCase3() {
		TreeNode root = new TreeNode(1);

		TreeNode node_1 = new TreeNode(1);
		root.left = node_1;
		return root;
	}
	
	
	private static TreeNode buildTreeForCase4() {
		
		TreeNode root = new TreeNode(5);

		TreeNode node_4 = new TreeNode(4);		
		TreeNode node_6 = new TreeNode(6);
		

		root.left = node_4;
		root.right = node_6;

		TreeNode node_7 = new TreeNode(7);
		TreeNode node_3 = new TreeNode(3);
		node_6.left = node_3;
		node_6.right = node_7;

		return root;
	}
	
	private static TreeNode buildTreeForCase5() {
		TreeNode root = new TreeNode(5);

		TreeNode node_3 = new TreeNode(3);
		TreeNode node_6 = new TreeNode(6);
		
		root.left = node_3;
		root.right = node_6;
		
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_4 = new TreeNode(4);
		
		node_3.left = node_2;
		node_3.right = node_4;

		TreeNode node_1 = new TreeNode(1);
		node_2.left = node_1;
		
		return root;
	}
	
	
	

	public boolean isValidBST(TreeNode root) {

		if (root.left != null && root.val <= root.left.val) {
			return false;
		}

		if (root.right != null && root.val >= root.right.val) {
			return false;
		}

		if (root.left != null) {

			boolean leftSide = isValidBST(root.left);

			if (!leftSide) {
				return false;
			}
		}

		if (root.right != null) {
			boolean rightSide = isValidBST(root.right);

			if (!rightSide) {
				return false;
			}
		}

		return true;
	}
	
	
	
	//--------------------------------------------------
	
	public boolean isValidBST2(TreeNode root) {

		ArrayList<TreeNode> myList = new ArrayList<TreeNode>();
		
		inOrder(root, myList);
		
		int prevValue = myList.get(0).val;
		
		for (int i = 1; i<myList.size(); i++) {
			
			int current = myList.get(i).val;
			if(current<=prevValue) {
				return false;
			}	
			
			prevValue = current;
		}
		
		return true;
	}

	private void inOrder(TreeNode root, ArrayList<TreeNode> myList) {
		
		if(root==null) 
			return;		
		
		inOrder(root.left, myList);
		myList.add(root);
		inOrder(root.right, myList);
	}

}
