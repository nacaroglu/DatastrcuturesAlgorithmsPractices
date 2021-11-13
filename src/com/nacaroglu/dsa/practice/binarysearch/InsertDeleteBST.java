package com.nacaroglu.dsa.practice.binarysearch;

public class InsertDeleteBST {

	public static void main(String[] args) {

		InsertDeleteBST insert = new InsertDeleteBST();
		TreeNode root = buildTree2();
//		TreeNode newRoot = insert.insertIntoBST(root, 4);
		
		TreeNode newRoot = insert.deleteNode(root, 5);
		System.out.println(newRoot.val);
		
	}

	private static TreeNode buildTree() {

		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(1);

		return root;
	}

	private static TreeNode buildTree0() {

		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		root.right = new TreeNode(60);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(80);

		return root;
	}

	private static TreeNode buildTree1() {

		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(14);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(77);
		root.right.right.right = new TreeNode(95);

		return root;
	}
	
	private static TreeNode buildTree2() {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		

		return root;
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null) {
			return new TreeNode(val);
		}

		TreeNode head = root;

		while (true) {

			if (head == null) {
				return new TreeNode(val);
			}

			if (head.left == null && head.right == null) {
				if (val > head.val) {
					head.right = new TreeNode(val);
					return root;
				} else {
					head.left = new TreeNode(val);
					return root;
				}
			}

			if (val > head.val) {

				if (head.right == null) {
					head.right = new TreeNode(val);
					return root;
				}

				head = head.right;

			} else {

				if (head.left == null) {
					head.left = new TreeNode(val);
					return root;
				}

				head = head.left;
			}
		}
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		
		if(root==null) return root;	
		
		TreeNode head = root;
		TreeNode parent = root;
		
		if(key==root.val) {
			
			if(!isLeaf(root)) {
				TreeNode minOfRightSub  = getMinOfTree(head.right);			
				minOfRightSub.left = head.left;
				return parent.right;
			}	
		}
		
		
		
		Boolean isLeft = true;
		
		while(true) {
			
			if(head==null) {
				return root;
			}
			
			if(key==head.val) {
				
				// no child
				if(isLeaf(head)) {
					
					if(isLeft) {
						parent.left = null;
					}else {
						parent.right = null;
					}
					
					return root;
				}
				
				// one child
				if(head.left==null) {
					if(isLeft) {
						parent.left = head.right;
					}else {
						parent.right = head.right;
					}						
				}else if(head.right==null) {
					if(isLeft) {
						parent.left = head.left;
					}else {
						parent.right = head.left;
					}					
				}
				
				if(isLeft) {
					TreeNode minOfRightSub  = getMinOfTree(head.right);
					parent.left = head.right;
					minOfRightSub.left = head.left;
				}else {
					TreeNode minOfRightSub  = getMinOfTree(head.right);
					parent.right = head.right;
					minOfRightSub.left = head.left;
				}
				
				return root;
				
			}
			
			if (key > head.val) {
				parent = head;
				head = head.right;
				isLeft =false;
			} else {		
				parent = head;	
				head = head.left;
				isLeft = true;
			}
		}	
        
    }

	private TreeNode getMinOfTree(TreeNode right) {
		
		TreeNode node = right;
		
		while(node.left!=null) {
			node = node.left;
		}
		
		return node;
	}

	private boolean isLeaf(TreeNode head) {
		
		return head.left==null && head.right==null;
	}
}
