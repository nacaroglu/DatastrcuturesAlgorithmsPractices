package com.nacaroglu.dsa.practice.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class InorderSuccessorBST {

public static void main(String[] args) {
		
		InorderSuccessorBST pre = new InorderSuccessorBST();
		
		TreeNode root = buildTree2();		
		//System.out.println(pre.inorderSuccessor(root, root.left).val);		
		
		//root = buildTree1();		
		TreeNode result = pre.inorderSuccessor(root, root.left);
		System.out.println(result!= null ? result.val: "NULL" );
		
		/*
		result = pre.inorderSuccessor(root, root.left.left);
		System.out.println(result!= null ? result.val: "NULL" );		
		
		result = pre.inorderSuccessor(root, root.left.left.left);		
		System.out.println(result!= null ? result.val: "NULL" );
		
		result = pre.inorderSuccessor(root, root.right);
		System.out.println(result!= null ? result.val: "NULL" ); */
	}

	
	
	private static TreeNode buildTree0() {
		
		TreeNode root = new TreeNode(2);
		//root.left = new TreeNode(1);		
		root.right = new TreeNode(3);
		return root;		
	}
	
	private static TreeNode buildTree1() {
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(1);
		
		return root;		
	}
	
	
	private static TreeNode buildTree2() {
		
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);		
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);		
		root.left.right.right = new TreeNode(5);
		
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);	
		
		return root;		
	}
	
	int foundIndex = -1;
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
		return inorderTraversalIterative(root, p);
    }

	public TreeNode inorderTraversalIterative(TreeNode root, TreeNode target) {		
		
		if(root==null) {
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		boolean isLeaf = false;
		boolean isLeftChild = false;
		
		while(curr!= null) {
			
			stack.add(curr);
			
			if(curr==target) {
				if(curr.right!= null) {
					stack.add(curr.right);
				}			
				
				isLeaf = curr.left==null && curr.right==null;
				
				break;
			}			
			
			if(curr.val<target.val) {
				curr = curr.right;
				isLeftChild = false;
			}else {
				curr = curr.left;
				isLeftChild = true;
			}
			
			
		}
		
		
		while(isLeaf && !stack.isEmpty()) {
			
			TreeNode node= stack.pop();
			
			if(node.val>target.val) {
				return node;
			}
		}
		
		if(!isLeftChild) {
			return root.right;
		}else {
			
			if(curr.right!= null) {
				curr = curr.right;
			}
			
			while(curr!=null) {
				if(curr.left== null) {
					break;
				}
				
				curr = curr.left;
			}
			
			return curr;
		}	
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
