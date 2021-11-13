package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeBoundary {

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
		
		BinaryTreeBoundary bb = new BinaryTreeBoundary();
		
		/*
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
		
		System.out.println(bb.boundaryOfBinaryTree(root)); */
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
				
		System.out.println(bb.boundaryOfBinaryTree(root));

	}
	
	 public List<Integer> boundaryOfBinaryTree(TreeNode root) {	 
		 		 
		 List<Integer> result = new ArrayList<Integer>();
		 
		 if(root==null) {
			 return result;
		 }
		 
		 List<TreeNode> leftTree = buildLeftSide(root);
		 
		 List<TreeNode> rightTree = buildRightSide(root);
		 rightTree.remove(0);
		 Collections.reverse(rightTree);
		 
		 List<TreeNode> leaves = buildLeaves(root);
		 
		 leftTree = removeDuplicates(leftTree, rightTree);
		 leaves = removeDuplicates(leaves, leftTree);		 
		 rightTree = removeDuplicates(rightTree, leaves);		
		 
		addToResult(result, leftTree);		
		addToResult(result, leaves); 		
		addToResult(result, rightTree); 
		 
		 return result;
	        
	   }

	private List<TreeNode> removeDuplicates(List<TreeNode> rightTree, List<TreeNode> leaves) {
		List<TreeNode> newTree = new ArrayList<TreeNode>();
		 for (TreeNode node: rightTree) {
			if(!leaves.contains(node)) {
				newTree.add(node);
			}			
		}
		 
		 rightTree = newTree;
		return rightTree;
	}

	private void addToResult(List<Integer> result, List<TreeNode> leftTree) {
		for (TreeNode node: leftTree) {
			result.add(node.val);
		}
	}

	private List<TreeNode> buildLeaves(TreeNode root) {	
		
		List<TreeNode> leaves = new ArrayList<TreeNode>();		
		traverseForLeaves(root, leaves);		
		return leaves;	
	}

	private void traverseForLeaves(TreeNode root, List<TreeNode> leaves) {
		
		if(root==null) {
			return;
		}
		
		if(root.left==null && root.right==null) {
			leaves.add(root);
			return;
		}
		
		traverseForLeaves(root.left, leaves);
		traverseForLeaves(root.right, leaves);
	}

	private List<TreeNode> buildRightSide(TreeNode root) {		
		
		List<TreeNode> rightTree = new ArrayList<TreeNode>();		
		traverseRightTree(root, rightTree);		
		return rightTree;	
		
	}

	private List<TreeNode> buildLeftSide(TreeNode root) {		
		
		List<TreeNode> leftTree = new ArrayList<TreeNode>();		
		traverseLeftTree(root, leftTree);	
		return leftTree;
	}

	private void traverseLeftTree(TreeNode root, List<TreeNode> leftTree) {
		
		if(root==null) {
			return;
		}
		
		leftTree.add(root);
		
		if(root.left!= null) {
			traverseLeftTree(root.left, leftTree);
		}else {
			traverseLeftTree(root.right, leftTree);
		}		
	}
	
	private void traverseRightTree(TreeNode root, List<TreeNode> rightTree) {
		
		if(root==null) {
			return;
		}
		
		rightTree.add(root);
		
		if(root.right!= null) {
			traverseRightTree(root.right, rightTree);
		}else {
			traverseRightTree(root.left, rightTree);
		}	
	}

}
