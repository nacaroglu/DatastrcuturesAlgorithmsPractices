package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueBinarySearchTrees2 {
	
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
			return "val: " + val;
		}	
	}

	public static void main(String[] args) {

		UniqueBinarySearchTrees2 x = new UniqueBinarySearchTrees2();
		x.generateTrees(3);
		
		int N = (int)(Math.log(33333) / Math.log(2)); 
		int size =  (int)Math.pow(2,(N+1));
		System.out.println(size);
		
	}
	
	public List<TreeNode> generateTrees(int n) {
		
		List<TreeNode> resultist = new ArrayList<TreeNode>();
		
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		
		List<Integer> list = new ArrayList<Integer>();	
		
		for(int i=1; i<=n; i++) {
			list.add(i);					
		}
		
		System.out.println("Basla");
		
		helper(list);		
		
		System.out.println("Bitti");
		return resultist;        
    }

	private void helper(List<Integer> list) {	
		
		if(list.size()==0) {
			return;			
		}
				
		for(Integer head: list) {
			
			List<Integer> left = new ArrayList<Integer>();
			List<Integer> right = new ArrayList<Integer>();
			
			//System.out.println("head:" + head);
			TreeNode node = new TreeNode(head);
			
			for(Integer j: list) {
				if(j<head) {
					left.add(j);
				}if(j>head) {
					right.add(j);
				}
			}
			
			
			
			//node.left = helper(left);		
			//node.right = helper(right);			
			
			return ;
		}
	}

}
