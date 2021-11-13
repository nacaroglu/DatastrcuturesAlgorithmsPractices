package com.nacaroglu.dsa.practice.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class KSmallestLargestElementsInBST {

	public static void main(String[] args) {
		
		KSmallestLargestElementsInBST k = new KSmallestLargestElementsInBST();
		
		TreeNode root = buildTree0();		
		System.out.println(k.kthSmallest(root, 3));
		System.out.println(k.kthLargest(root, 3));

	}
	
	private static TreeNode buildTree0() {
		
		TreeNode root = new TreeNode(19,15);
		
		root.left = new TreeNode(7,6);
		
		root.left.left = new TreeNode(3,2);
		root.left.left.left = new TreeNode(2,0);
		root.left.left.right = new TreeNode(5,0);
		
		root.left.right = new TreeNode(11,2);
		root.left.right.right = new TreeNode(17,1);
		root.left.right.right.left = new TreeNode(13,0);	

		
		root.right = new TreeNode(43,7);
		
		root.right.left = new TreeNode(23,4);
		root.right.left.right = new TreeNode(37,3);
		root.right.left.right.right = new TreeNode(41,0);
		root.right.left.right.left = new TreeNode(29,1);
		root.right.left.right.left.right = new TreeNode(31,0);
		
		root.right.right = new TreeNode(47,1);
		
		root.right.right.right = new TreeNode(53,0);
		
		
		return root;
	}
	
	 public int kthSmallest(TreeNode root, int k) {
		 
		 List<Integer> list = inorderTraversalIterative(root);
		 return list.get(k-1);
	        
	 }
	 
	 public int kthLargest(TreeNode root, int k) {
		 
		 List<Integer> list = inorderTraversalIterative(root);
		 return list.get(list.size()-k);
	        
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
