package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CountUnivalueSubtrees {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "val: " + val;
		}		
	}

	public static void main(String[] args) {
	
		
		
		CountUnivalueSubtrees cuvt = new CountUnivalueSubtrees();
		
		TreeNode root = buildTestTree_1();		
		System.out.println(cuvt.countUnivalSubtrees(root));
		
		root = buildTestTree_2();		
		System.out.println(cuvt.countUnivalSubtrees(root));
		
		System.out.println(cuvt.countUnivalSubtrees(null));
		
		System.out.println(cuvt.countUnivalSubtrees(new TreeNode(13)));
				
	}

	private static TreeNode buildTestTree_1() {
		TreeNode root = new TreeNode(5);
		
		TreeNode first_left = new TreeNode(1);
		TreeNode first_right = new TreeNode(5);
		root.left = first_left;
		root.right = first_right;
		
		TreeNode first_left_left = new TreeNode(5);
		TreeNode first_left_right = new TreeNode(5);
		first_left.left = first_left_left;
		first_left.right = first_left_right;
		
		TreeNode first_right_left = new TreeNode(5);
		TreeNode first_right_right = new TreeNode(5);
		//first_right.left = first_right_left;
		first_right.right = first_right_right;
		return root;
	}
	
	private static TreeNode buildTestTree_2() {
		TreeNode root = new TreeNode(5);
		
		TreeNode first_left = new TreeNode(5);
		TreeNode first_right = new TreeNode(5);
		root.left = first_left;
		root.right = first_right;
		
		TreeNode first_left_left = new TreeNode(5);
		TreeNode first_left_right = new TreeNode(5);
		first_left.left = first_left_left;
		first_left.right = first_left_right;
		
		TreeNode first_right_left = new TreeNode(5);
		TreeNode first_right_right = new TreeNode(5);
		//first_right.left = first_right_left;
		first_right.right = first_right_right;
		return root;
	}
	
	public int countUnivalSubtrees(TreeNode root) {
		
		if(root==null) {
			return 0;
		}
		
		List<TreeNode> trees = levelOrder(root);
		
		int count = 0;
		
		for (TreeNode tree : trees) {
			
			if(tree.left==null && tree.right==null) {
				count++;
				continue;
			}			
			
			Set<Integer> set = levelOrder_set(tree);
			if(set.size()==1) {
				count++;
			}		
		}
		
		return count;        
    }
	
	public List<TreeNode> levelOrder(TreeNode root) {
		
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		List<TreeNode> trees = new ArrayList<TreeNode>();
		
		myQueue.add(root);
		
		while(!myQueue.isEmpty()) {
			
			TreeNode node  = myQueue.poll();
			//System.out.println(node.val);
			trees.add(node);
			
			if(node.left!= null) {
				myQueue.add(node.left);
			}
			
			if(node.right!=null) {
				myQueue.add(node.right);
			}			
		}	
		
		return trees;
	}
	
	public Set<Integer> levelOrder_set(TreeNode root) {
		
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		Set<Integer> values = new HashSet<Integer>();
		
		myQueue.add(root);
		
		while(!myQueue.isEmpty()) {
			
			TreeNode node  = myQueue.poll();
			//System.out.println(node.val);
			values.add(node.val);
			
			if(node.left!= null) {
				myQueue.add(node.left);
			}
			
			if(node.right!=null) {
				myQueue.add(node.right);
			}			
		}	
		
		return values;
	}
}
