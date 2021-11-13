package com.nacaroglu.dsa.practice.binarysearchtree;

import java.util.ArrayList;

public class KthLargestElementInAStream {
	
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
	
	int nums[];
	int k;
	TreeNode root;	
	
	
	public KthLargestElementInAStream(int[] nums, int k) {
		super();
		this.nums = nums;
		this.k = k;
		
		this.root = buildTree();
	}

	private TreeNode buildTree() {
		
		if(nums == null || nums.length == 0) {
			return null;
		}
		
		TreeNode root = new TreeNode(nums[0]);
		
		for(int i=1; i<nums.length; i++) {
			doInsert(root, nums[i]);
		}
		
		return root;
	}
	
	private void doInsert(TreeNode root, int val) {
		
		if(root== null) {
			this.root= new TreeNode(val);
			return;
		}
		
		if(root.val>=val) {
			if(root.left==null) {
				root.left = new TreeNode(val);
			}else {
				doInsert(root.left, val);
			}
		}
		
		if(root.val<val) {
			if(root.right==null) {
				root.right = new TreeNode(val);
			}else {
				doInsert(root.right, val);
			}		
		}		
	}
	
	public static void main(String[] args) {	
		
		int[] nums = {4, 5, 8, 2};
		
		//KthLargestElementInAStream kthElement = new KthLargestElementInAStream(nums , 3);
		
		/*
		System.out.println(kthElement.add(3));
		System.out.println(kthElement.add(5));
		System.out.println(kthElement.add(10));
		System.out.println(kthElement.add(9));
		System.out.println(kthElement.add(4));*/
		
		int[] nums2 = null;
		
		KthLargestElementInAStream kthElement = new KthLargestElementInAStream(nums2 , 1);
		System.out.println(kthElement.add(-2));
		/*System.out.println(kthElement.add(5));
		System.out.println(kthElement.add(10));
		System.out.println(kthElement.add(9));
		System.out.println(kthElement.add(4));*/
		
		System.out.println("Bitti...");

	}

	
	
	public int add(int val) {

		ArrayList<TreeNode> myList = new ArrayList<TreeNode>();
		doInsert(this.root, val);
		
		inOrder(this.root, myList);	
		
		return myList.get(myList.size()-k).val;
		
	}
	
	private void inOrder(TreeNode root, ArrayList<TreeNode> myList) {
		
		if(root==null) 
			return;		
		
		inOrder(root.left, myList);
		myList.add(root);
		inOrder(root.right, myList);
	}

}
