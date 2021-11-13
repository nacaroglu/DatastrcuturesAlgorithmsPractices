package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		System.out.println(lca.lowestCommonAncestor(root, root.left, root.left.right.left).val);

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		Deque<TreeNode> listP = findNode(root,p);
		Deque<TreeNode> listQ = findNode(root,q);
						
		TreeNode result = null;
		
		while(!listP.isEmpty() && !listQ.isEmpty()) {
			
			if(listP.getLast().val==listQ.getLast().val) {
				result = listP.getLast();
				listP.removeLast();
				listQ.removeLast();
			}else {
				break;
			}
		}
		
		
		return result;
	}
	
	public Deque<TreeNode> findNode(TreeNode root ,TreeNode node){		
		
		Deque<TreeNode> list = new LinkedList<TreeNode>();
		
		findHelper(root, node, list);		
		
		return list;
	}

	private boolean findHelper(TreeNode root, TreeNode node, Deque<TreeNode> list) {
		
		if(root ==null) {
			return true;
		}		
		
		if(root.val==node.val) {
			list.addLast(root);
			return true;
		}
		
		if( root.left!= null && findHelper(root.left, node, list)) {
			list.addLast(root);
			return true;		
		}
		
		if(root.right!= null && findHelper(root.right, node, list)) {
			list.addLast(root);
			return true;
		}
		
		return false;
	}
}
