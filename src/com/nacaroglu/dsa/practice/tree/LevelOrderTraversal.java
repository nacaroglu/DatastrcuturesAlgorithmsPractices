package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		LevelOrderTraversal l = new LevelOrderTraversal();
		List<List<Integer>> result = l.levelOrder(root);
		
		for (List<Integer> list : result) {
			
			for (Integer integer : list) {
				System.out.print(integer + " ,");
			}
			
			System.out.println();
		}
		
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);		 
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			List<Integer> list = new ArrayList<Integer>();
			
			for(int i=0; i< size; i++) {
				
				TreeNode node = q.poll();			
				list.add(node.val);
				
				if(node.left!= null) 
					q.add(node.left);
				
				if(node.right!= null)
					q.add(node.right);
				
			}
			
			result.add(list);					
		}			
		
		return result;
    }
		
}
