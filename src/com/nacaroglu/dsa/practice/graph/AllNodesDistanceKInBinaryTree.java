package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
		
	}

	public static void main(String[] args) {
		
		AllNodesDistanceKInBinaryTree x = new AllNodesDistanceKInBinaryTree();
		
		Queue<Integer> q = new ArrayDeque<Integer>();

	
		
		TreeNode root = basicTestCase2();
		
		x.distanceK(root, root.right.left, 3);	

	}

	private static TreeNode basicTestCase() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);		
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		return root;
	}
	
	private static TreeNode basicTestCase2() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		return root;
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		
		buildMapFromTree(map, root, null);
		
		Set<Integer> visited = new HashSet<Integer>();  
		
		dfs(map, target.val, K, 1, result, target.val, visited);
		
		return result;
	}

	private void dfs(HashMap<Integer, LinkedList<Integer>> map, int val, int k, int i, List<Integer> result, int target, Set<Integer> visited) {
		
		if(k<i) {
			return;
		}
		
		if(visited.contains(val)) {
			return;
		}
		
		visited.add(val);		
		
		List<Integer> list = map.get(val);
		
		if(i==k) {
		
			for(Integer x : list) {
				
				if(x!=target && !visited.contains(x)) {
					result.add(x);
				}
			}
			
			return;
		}
		
		for(Integer x : list) {
			dfs(map, x, k, i+1, result, target, visited);
		}
	}

	private void buildMapFromTree(HashMap<Integer, LinkedList<Integer>> map, TreeNode root, TreeNode parent) {
		
		if(root==null) {
			return;
		}
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		if(parent!= null) {
			list.add(parent.val);
		}
		
		if(root.left!= null) {
			list.add(root.left.val);
		}
		
		if(root.right!=null) {
			list.add(root.right.val);
		}
		
		map.put(root.val, list);
		
		buildMapFromTree(map, root.left, root);
		buildMapFromTree(map, root.right, root);		
		
	}
}
