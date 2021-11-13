package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class BoundryOfBinaryTree {

	public static void main(String[] args) {

		BoundryOfBinaryTree pre = new BoundryOfBinaryTree();

		TreeNode root = pre.buildTree();
		pre.printList(pre.findBoundry(root));	
		
		

	}

	private void printList(List<Integer> result) {

		if (result == null || result.isEmpty()) {
			System.out.print("boş");
		}

		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}

		System.out.println("");
	}

	private  TreeNode buildTree() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);		

		return root;
	}
	
	public List<Integer> findBoundry(TreeNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(root.val);
		List<Integer> leftBoundry = findLeftBoundry(root.left);
		List<Integer> leaves = findLeaves(root);
		List<Integer> rightBoundry = findRightBoundry(root.right);
		Collections.reverse(rightBoundry);
		
		result.addAll(leftBoundry);
		result.addAll(leaves);
		result.addAll(rightBoundry);
		
		return result;
	}

	public List<Integer> findLeftBoundry(TreeNode left) {

		LinkedList<Integer> result = new LinkedList<Integer>();
		
		if (left == null)
			return result;		
				
		findLeftBoundryHelper(left, result);
		return result;
	}
	
	private void findLeftBoundryHelper(TreeNode left, LinkedList<Integer> result) {

		if (left == null) {
			return;
		}	
		
		if(left.left!=null) {
			result.add(left.val);
			findLeftBoundryHelper(left.left, result);
		}else if(left.right != null) {
			result.add(left.val);
			findLeftBoundryHelper(left.right, result);
		}
	}
	
	public List<Integer> findRightBoundry(TreeNode right) {

		LinkedList<Integer> result = new LinkedList<Integer>();
		
		if (right == null)
			return result;		
				
		findRightBoundryHelper(right, result);
		return result;
	}
	
	private void findRightBoundryHelper(TreeNode right, LinkedList<Integer> result) {

		if (right == null) {
			return;
		}
		
		if(right.right!=null) {
			result.add(right.val);
			findRightBoundryHelper(right.right, result);
		}else if(right.left != null) {
			result.add(right.val);
			findRightBoundryHelper(right.left, result);
		}
	}
	

	public List<Integer> findLeaves(TreeNode root) {

		LinkedList<Integer> result = new LinkedList<Integer>();
		findLeavesHelper(root, result);
		return result;
	}

	private void findLeavesHelper(TreeNode root, LinkedList<Integer> result) {

		if (root == null) {
			return;
		}

		findLeavesHelper(root.left, result);
		
		if(root.left==null && root.right==null)
			result.add(root.val);
		
		findLeavesHelper(root.right, result);
	}
}
