package com.nacaroglu.dsa.practice.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import com.nacaroglu.dsa.practice.binarysearchtree.KthLargestElementInAStream.TreeNode;

public class LowestCommonAncestor {
	
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
		
		TreeNode root = new TreeNode(6);
		
		root.left = new TreeNode(2);
		
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
				
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		System.out.println(lca.lowestCommonAncestor(root, root.left, root.right ).val);
		

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		List<TreeNode> pList = new ArrayList<TreeNode>();
		List<TreeNode> qList = new ArrayList<TreeNode>();
		
		findPath(root, p, pList);
		findPath(root, q, qList);
		
		TreeNode found = null;
		
		int size = pList.size()<qList.size()?pList.size():qList.size();
		
		for(int i=0;i<size;i++) {
			if(pList.get(i)==qList.get(i)){
				found = pList.get(i);
			}else {
				break;
			}
		}		
        
		return found;
    }

	private void findPath(TreeNode root, TreeNode target, List<TreeNode> list) {
		
		if(root== null) {
			return;
		}
		
		list.add(root);		
		if(root.val==target.val) {			
			return;
		}
		
		if(root.val<target.val) {
			findPath(root.right, target, list);
		}else {
			findPath(root.left, target, list);
		}		
	}
}
