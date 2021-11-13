package com.nacaroglu.dsa.practice.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {

	public static void main(String[] args) {
		
		IsValidBST pre = new IsValidBST();
		
		TreeNode root = buildTree0();		
		
		System.out.println(pre.isValidBST(root));
		System.out.println(pre.isValidBST_1(root));		
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
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);		
		
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);		
		root.right.right = new TreeNode(10);
		return root;		
	}
	
	public boolean isValidBST(TreeNode root) {		 
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	        
	}

	private boolean helper(TreeNode root, int min, int max) {
		
		if(root==null) {
			return true;
		}
		
		
		if(root.val<min || root.val>max) {
			return false;
		}
		
		if(!helper(root.left, min, root.val)) {
			return false;
		}
		
		if(!helper(root.right, root.val, max)) {
			return false;
		}
		
		return true;
				
	}
	
	 public boolean isValidBST_1(TreeNode root) {
		 
		 List<Integer> list = inorderTraversalIterative(root);
		 
		 for (int i=1; i<list.size(); i++) {
			if(list.get(i-1)>list.get(i)) {
				return false;
			}
		}
		 
		 return true;
	        
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
