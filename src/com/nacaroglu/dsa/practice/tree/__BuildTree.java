package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayList;
import java.util.List;


public class __BuildTree {
	
public static void main(String[] args) {
		
		__BuildTree builder = new __BuildTree();

		
		
		TreeNode root = createTestTree();		
		List<Integer> result = builder.preorderTraversal(root);		
		printList(result);		
		
		result = builder.inorderTraversal(root);
		printList(result); 
	}

	private static void printList(List<Integer> result) {
		
		if(result == null || result.isEmpty()) {
			System.out.print("boş");
		}
		
		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}
		
		System.out.println("");
	}

	private static TreeNode createTestTree() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		//root.left.left = new TreeNode(8);
		//root.left.right = new TreeNode(6);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);		

		return root;
	}
	
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		List<Integer> preList = buildNodeList(preorder);
		List<Integer> inList = buildNodeList(inorder);
		
		int preStart=0, preEnd = preList.size()-1;
		int inStart=0, inEnd=inList.size()-1;
	
		
		TreeNode root = buildTreeHelper(preList, preStart, preEnd, inList, inStart, inEnd);
		
        return root;
    }

	private TreeNode buildTreeHelper(List<Integer> preList, int preStart, int preEnd, List<Integer> inList, int inStart, int inEnd ) {
		
		Integer rootVal = preList.get(preStart);
		
		
		
		int index = inList.indexOf(rootVal);
		
		List<Integer> leftInList = inList.subList(0, index);
		List<Integer> rightInList = inList.subList(index+1, inList.size()-1);
		
		TreeNode root = new TreeNode(rootVal);
		//root.left  = buildTreeHelper(preList, preStart+1, leftInList);
		//root.right = buildTreeHelper(preList, preStart+1, rightInList);
		
		return root;
	}

	private List<Integer> buildNodeList(int[] orderArr) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i= 0; i<orderArr.length; i++) {
			list.add(orderArr[i]);
		}
		
		return list;
	}
	
	
	
		
	public List<Integer> preorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<Integer>();		
		preOrderHelper(root, result);		
		return result;
    }

	private void preOrderHelper(TreeNode root, List<Integer> result) {
		
		if(root==null) {
			return;
		}
		
		result.add(root.val);
		preOrderHelper(root.left, result);
		preOrderHelper(root.right, result);		
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<Integer>();		
		inOrderHelper(root, result);		
		return result;
    }

	private void inOrderHelper(TreeNode root, List<Integer> result) {
		
		if(root==null) {
			return;
		}		
		
		inOrderHelper(root.left, result);
		result.add(root.val);
		inOrderHelper(root.right, result);		
	}

}
