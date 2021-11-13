package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InorderTraversal {

	public static void main(String[] args) {
		
		InorderTraversal pre = new InorderTraversal();
		
		TreeNode root = buildTree0();		
		List<Integer> result = pre.inorderTraversalIterative(root);		
		printList(result);		
		
		/*
		TreeNode root2 = buildTree2();
		result = pre.inorderTraversal(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = pre.inorderTraversal(root3);
		printList(result);  
		
		/*
		TreeNode root = buildTree();		
		List<Integer> result = pre.inorderTraversalIterative(root);		
		printList(result);		
		
		
		TreeNode root2 = buildTree2();
		result = pre.inorderTraversalIterative(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = pre.inorderTraversalIterative(root3);
		printList(result);  */
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
	
	private static TreeNode buildTree0() {
		
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

	private static TreeNode buildTree() {
		TreeNode root = new TreeNode(1);		
		root.right = new TreeNode(2);
		
		
		root.right.left = new TreeNode(3);
		return root;
	}
	
	private static TreeNode buildTree2() {
		TreeNode root = null;
		return root;
	}
	
	private static TreeNode buildTree3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);				
		return root;
	}
	
	public List<Integer> inorderTraversalIterative(TreeNode root) {	
        
		List<Integer> result = new ArrayList<Integer>();
		
		if(root==null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		
		while(curr!= null || !stack.isEmpty()) {			
			 
            while (curr !=  null)
            {
                stack.push(curr);
                curr = curr.left;
            } 
            
            curr = stack.pop(); 
            result.add(curr.val); 
            
            curr = curr.right;			
		}		
		
		return result;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<Integer>();		
		helper(root, result);		
		return result;
    }

	private void helper(TreeNode root, List<Integer> result) {
		
		if(root==null) {
			return;
		}		
		
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);		
	}

}
