package com.nacaroglu.dsa.practice.binarysearch;

import java.util.Stack;

public class BSTIterator {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right = new TreeNode(15);
		node.right.left = new TreeNode(9);
		node.right.right = new TreeNode(20);		

		BSTIterator it = new BSTIterator(node);
		//   "hasNext", "next", "hasNext"
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());	
		
		

	}
	
	TreeNode root;
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {		
		this.root = root;
		this.stack = new Stack<TreeNode>();
	}

	public int next() {
		
		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		root = stack.pop();
		int result = root.val;

		root = root.right;
		
		return result;		
	}

	public boolean hasNext() {		
		return root != null || !stack.isEmpty();		
	}

	

}
