package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {
		
		PreorderTraversal pre = new PreorderTraversal();

		/*
		TreeNode root = buildTree();		
		List<Integer> result = pre.preorderTraversal(root);		
		printList(result);		
		
		TreeNode root2 = buildTree2();
		result = pre.preorderTraversal(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = pre.preorderTraversal(root3);
		printList(result);  */
		
		TreeNode root = buildTree();		
		List<Integer> result = pre.preorderTraversalIterative(root);		
		printList(result);		
		
		/*
		TreeNode root2 = buildTree2();
		result = pre.preorderTraversalIterative(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = pre.preorderTraversalIterative(root3);
		printList(result);*/  
	}

	private static void printList(List<Integer> result) {
		
		if(result == null || result.isEmpty()) {
			System.out.print("boş");
		}
		
		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}
		
		System.out.println("");
	}

	private static TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(7);		
		root.right.right = new TreeNode(8);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		return root;
	}
	
	private static TreeNode buildTree2() {
		TreeNode root = null;
		return root;
	}
	
	private static TreeNode buildTree3() {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);		
		return root;
	}
	
	public List<Integer> preorderTraversalIterative(TreeNode root) {	
        
		List<Integer> result = new ArrayList<Integer>();
		
		if(root==null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			TreeNode node = stack.peek();
			result.add(node.val);
			stack.pop();
			
			if(node.right!= null) {
				stack.push(node.right);
			}
			
			if(node.left!=null) {
				stack.push(node.left);
			}			
		}		
		
		return result;
    }
	
	public List<Integer> preorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<Integer>();		
		helper(root, result);		
		return result;
    }

	private void helper(TreeNode root, List<Integer> result) {
		
		if(root==null) {
			return;
		}
		
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);		
	}

}
