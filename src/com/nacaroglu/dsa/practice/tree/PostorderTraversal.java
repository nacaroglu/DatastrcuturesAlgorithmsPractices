package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

	public static void main(String[] args) {
		
		PostorderTraversal post = new PostorderTraversal();

		
		TreeNode root = buildTree0();		
		List<Integer> result = post.postorderTraversalIterative(root);		
		printList(result);		
		
		/*
		TreeNode root2 = buildTree2();
		result = pre.preorderTraversal(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = pre.preorderTraversal(root3);
		printList(result);  */
		
		/*
		TreeNode root = buildTree();		
		List<Integer> result = post.postorderTraversalIterative(root);		
		printList(result);		
		
		
		TreeNode root2 = buildTree2();
		result = post.postorderTraversalIterative(root2);
		printList(result);
		
		TreeNode root3 = buildTree3();
		result = post.postorderTraversalIterative(root3);
		printList(result); */ 
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
		
		TreeNode root = new TreeNode(19);
		
		root.left = new TreeNode(7);
		
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(5);
		
		root.left.right = new TreeNode(11);
		root.left.right.right = new TreeNode(17);
		root.left.right.right.left = new TreeNode(13);	

		
		root.right = new TreeNode(43);
		
		root.right.left = new TreeNode(23);
		root.right.left.right = new TreeNode(37);
		root.right.left.right.right = new TreeNode(41);
		root.right.left.right.left = new TreeNode(29);
		root.right.left.right.left.right = new TreeNode(31);
		
		root.right.right = new TreeNode(47);
		root.right.right.right = new TreeNode(53);		
		
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
		root.left = null;
		root.right = new TreeNode(2);		
		return root;
	}
	
	public List<Integer> postorderTraversalIterative(TreeNode root) {	
        
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		if(root==null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			 // pop a node from the stack and push the data into the output stack
            TreeNode curr = stack.pop();
            result.push(curr.val);
    
            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            if (curr.right != null) {
                stack.push(curr.right);
            }		
		}		
		
		return result;
    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<Integer>();		
		helper(root, result);		
		return result;
    }

	private void helper(TreeNode root, List<Integer> result) {
		
		if(root==null) {
			return;
		}		
		
		helper(root.left, result);
		helper(root.right, result);
		result.add(root.val);
	}

}
