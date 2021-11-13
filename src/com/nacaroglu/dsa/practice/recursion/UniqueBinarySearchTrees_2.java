package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees_2 {

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
	}

	public static void main(String[] args) {

		UniqueBinarySearchTrees_2 uni = new UniqueBinarySearchTrees_2();
		uni.generateTrees(3);
	}

	public List<TreeNode> generateTrees(int n) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();		
		int arr[] = new int[n];		
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		helper(arr, 0, n-1, list,1);
		
		return null;
	}

	private void helper(int[] arr, int s, int e, List<TreeNode> list, int level) {
		
		if(s==e) {
			//System.out.println("Leaf: " + s);
			return;
		}

		for(int i=s; i<e;i++) {
			
			int rootVal = i;
			int leftStart = s;
			int leftEnd = i;
			int rightStart = i+1;
			int rightEnd = e;
			
			//System.out.println(" Level: " + level + " root: " + rootVal + " [" + leftStart + "," + leftEnd + "] [" + rightStart + ", " + rightEnd + "]");
			
			TreeNode root = new TreeNode(rootVal);
			//root.left = helper(arr, leftStart, leftEnd, list);
			//root.right = helper(arr, rightStart, rightEnd, list);	
			
		}
		
		
	}

}
