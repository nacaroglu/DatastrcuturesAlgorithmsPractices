package com.nacaroglu.dsa.practice.binarysearchtree;

import java.util.Currency;
import java.util.Stack;

import com.nacaroglu.dsa.practice.binarysearchtree.InorderSuccessorInBST.TreeNode;

public class DeleteNodeBST {
	
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
		
		TreeNode root = new TreeNode(5);

		TreeNode node_3 = new TreeNode(3);
		TreeNode node_6 = new TreeNode(6);
		
		root.left = node_3;
		root.right = node_6;
		
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_4 = new TreeNode(4);
		
		node_3.left = node_2;
		node_3.right = node_4;
		
		TreeNode node_1 = new TreeNode(1);
		//node_2.left = node_1;

		TreeNode node_7 = new TreeNode(7);
		node_6.right = node_7;
		
		DeleteNodeBST deleter = new DeleteNodeBST();
		TreeNode resultNode = deleter.deleteNode(new TreeNode(0), 0);
		System.out.println(resultNode.val);
		

	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		
		if(root==null) {
			return null;
		}
		
		TreeNode cur = root;
		TreeNode parent = root;
		TreeNode targetNode = null;
		
		while (cur != null) {
			
			if(cur.val == key) {
				targetNode = cur;
				
				//Case1: targetNode is Leaf
				if( targetNode.left==null && targetNode.right==null){
					
					if(parent == root) {
						return null;
					}
					
					if( parent.left==targetNode) {
						parent.left = null;
					}else {
						parent.right = null;
					}
					
				}else if( targetNode.left == null){
					// one child ??
									
					if(parent.left==targetNode) {
						parent.left = targetNode.right;
					}else {
						parent.right = targetNode.right;
					}
					
				} else if( targetNode.right == null) {
					// one child ??
									
					if(parent.left==targetNode) {
						parent.left = targetNode.left;
					}else {
						parent.right = targetNode.left;
					}
				}else {
					
				
						
						TreeNode successor = inorderSuccessor(root, targetNode);
						
						if(parent.left==targetNode) {
							parent.left = successor;
						}else {
							parent.right = successor;
						}
						
						successor.left = targetNode.left;
						successor.right = targetNode.right;
						
						if(successor.left==successor) {
							successor.left = null;
						} 
						
						if(successor.right==successor) {
							successor.right = null;
						}						
									
				}
				
				break;				
			}
			
			if (key < cur.val) {
				parent = cur;
				cur = cur.left;
				
			} else {
				parent = cur;
				cur = cur.right;
			}
		}
		
		return root;
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode prev = null;

		inOrder(root, stack);

		while (!stack.isEmpty()) {

			TreeNode currNode = stack.pop();

			if (currNode.val == target.val) {
				return prev;
			}

			prev = currNode;
		}

		return null;
	}

private void inOrder(TreeNode root, Stack<TreeNode> stack) {
	
	if(root==null) 
		return;		
	
	inOrder(root.left, stack);
	stack.add(root);
	inOrder(root.right, stack);
}

}
