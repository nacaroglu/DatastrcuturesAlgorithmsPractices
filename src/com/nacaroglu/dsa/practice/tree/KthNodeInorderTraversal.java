package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;


public class KthNodeInorderTraversal {

	public static void main(String[] args) {
		
		KthNodeInorderTraversal pre = new KthNodeInorderTraversal();
		
		TreeNode root = buildTree0();		
		List<Integer> result = pre.inorderTraversal(root);		
		printList(result);	
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
		
		TreeNode root = new TreeNode(25);
		root.numOfChilderen = 10;
				
		root.left = new TreeNode(20);	
		root.left.numOfChilderen = 2;
		root.left.left = new  TreeNode(1);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(13);
		root.right.numOfChilderen = 6;
		root.right.left = new TreeNode(5);
		
		root.right.right = new TreeNode(8);
		root.right.right.numOfChilderen = 4;
		root.right.right.right = new TreeNode(9);
		
		root.right.right.left = new TreeNode(19);
		root.right.right.left.numOfChilderen = 2;
		root.right.right.left.left = new TreeNode(23);
		root.right.right.left.right = new TreeNode(37);
		
		return root;
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
