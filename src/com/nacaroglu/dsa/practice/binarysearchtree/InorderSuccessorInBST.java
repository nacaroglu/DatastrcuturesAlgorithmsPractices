package com.nacaroglu.dsa.practice.binarysearchtree;

import java.util.Stack;

public class InorderSuccessorInBST {

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

		InorderSuccessorInBST vBst = new InorderSuccessorInBST();
		/*
		System.out.println(vBst.isValidBST(buildTreeForCase1()));
		System.out.println(vBst.isValidBST(buildTreeForCase2()));
		System.out.println(vBst.isValidBST(new TreeNode(99)));
		System.out.println(vBst.isValidBST(buildTreeForCase3()));
		System.out.println(vBst.isValidBST(buildTreeForCase4()));
		*/
		
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
		
		//System.out.println(vBst.inorderSuccessor(root, node_6).val);
		
		TreeNode root_2 = new TreeNode(2);
		TreeNode node_11 = new TreeNode(1);
		TreeNode node_33 = new TreeNode(3);

		root_2.left = node_11;
		root_2.right = node_33;
		
		System.out.println(vBst.inorderSuccessor(root_2, node_11).val);
		
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
		TreeNode node_4 = new TreeNode(4);

		root.left = node_1;
		root.right = node_4;

		TreeNode node_6 = new TreeNode(6);
		TreeNode node_3 = new TreeNode(3);
		node_4.left = node_3;
		node_4.right = node_6;

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
	
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode prev = null;
		
		inOrder(root, stack);		
		
		while(!stack.isEmpty()) {
			
			TreeNode  currNode = stack.pop();
			
			if(currNode.val==target.val) {
				return prev;
			}
			
			prev = currNode;
		}
		
		
		return null;
	}

	private void inOrder(TreeNode root, Stack<TreeNode> stack) {
		
		if(root==null) 
			return;		
		
		inOrder(root.left, stack);
		stack.add(root);
		inOrder(root.right, stack);
	}

	

}
