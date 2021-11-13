package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InorderTraversalConstanSpace {

	public static void main(String[] args) {
		
		InorderTraversalConstanSpace pre = new InorderTraversalConstanSpace();

		
		TreeNode root = buildTree0();		
		List<Integer> result = pre.inorderTraversalIterative(root);		
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
		TreeNode root = new TreeNode(4);		
		
				
		root.left = new TreeNode(9);		
		root.left.left = new  TreeNode(5);
		root.left.right = new TreeNode(1);
		
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(8);
		root.right.left.left = new TreeNode(18); 
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);
		
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

}
