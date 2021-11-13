package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class ReconstructPreorder {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		list.add(null);
		list.add(3);
		list.add(4);
		list.add(null);
		list.add(null);
		list.add(5);
		list.add(null);
		list.add(null);
		
		ReconstructPreorder rc  =new ReconstructPreorder();
		TreeNode root = rc.reconstructPreorder(list);
		System.out.println(root.val);
	}

	int subtreelndex;

	public TreeNode reconstructPreorder(List<Integer> preorder) {
		subtreelndex = 0;
		return reconstructPreorderSubTree(preorder);
	}

	private TreeNode reconstructPreorderSubTree(List<Integer> preorder) {
		
		Integer val = preorder.get(subtreelndex);
			
		// leaf node
		if(val==null) {
			subtreelndex  = subtreelndex + 1;
			return null;
		}
		
		TreeNode node = new TreeNode(val);
		subtreelndex  = subtreelndex + 1;
		
		if(val!=null) {			
			node.left = reconstructPreorderSubTree(preorder);
			node.right = reconstructPreorderSubTree(preorder);	
		}
		
		return node;
	}

}
