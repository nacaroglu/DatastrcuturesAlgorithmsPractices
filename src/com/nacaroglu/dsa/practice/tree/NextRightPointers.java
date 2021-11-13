package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightPointers {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		NextRightPointers l = new NextRightPointers();
		TreeNode node = l.levelOrder(root);
		
		System.out.println(node.val);
		
	}
	
	public TreeNode levelOrder(TreeNode root) {
		
		if(root==null) {
			return root;
		}
        		
		TreeNode node = root;
		
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);		 
		
		while(!q.isEmpty()) {
			
			int size = q.size();			
			TreeNode prev = null;
			
			for(int i=0; i< size; i++) {
				
				node = q.poll();				
				if(prev!= null)
					prev.next = node;
				
				prev = node;
				
				if(node.left!= null) 
					q.add(node.left);
				
				if(node.right!= null)
					q.add(node.right);
				
			}			
								
		}
		
		return root;
		
		
    }
		
}
