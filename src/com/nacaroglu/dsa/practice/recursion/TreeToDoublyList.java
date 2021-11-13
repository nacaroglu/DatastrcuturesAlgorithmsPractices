package com.nacaroglu.dsa.practice.recursion;

public class TreeToDoublyList {
	
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
	};

	public static void main(String[] args) {
		
		TreeToDoublyList ttdl = new TreeToDoublyList();
		
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
				
		Node result = ttdl.treeToDoublyList(root);

	}
	
	public Node treeToDoublyList(Node root) {
		
		inOrder(root, null);
        
		return null;
    }

	private void inOrder(Node root, Node prev ) {
		
		if(root==null) {
			return;
		}
		
		inOrder(root.left, root);
		String prevVal = prev==null?" null" : String.valueOf(prev.val);
		System.out.println(root.val + "prevVal: " + prevVal);
		inOrder(root.right, root);		
	}

}
