package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	
	public static class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new  Node(4);
		root.left = new Node(2);
		root.left.right = new Node(3);
		root.left.left = new Node(1);
		root.right = new Node(5);
		
		ConvertBinarySearchTreeToSortedDoublyLinkedList x = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
		Node result = x.treeToDoublyList(root);
		System.out.println(result.val);
	}
	
	public Node treeToDoublyList(Node root) {
		
		List<Node> list = new ArrayList<Node>(); 
		
		helper(root, list);	
		
		Node prev = null;
		
		for (int i=0; i<list.size(); i++) {
			
			if(i!=0) {
				list.get(i).left = list.get(i-1);
			}
			
			if(i!=list.size()-1) {
				list.get(i).right = list.get(i+1);
			}		 
		}
		
		list.get(0).left = list.get(list.size()-1);
		list.get(list.size()-1).right = list.get(0);
        
		return  list.get(0);
    }

	private void helper(Node root, List<Node> list) {
		
		if(root==null) {
			return;
		}
		
		helper(root.left, list);
		list.add(root);
		helper(root.right, list);
		
	}

}
