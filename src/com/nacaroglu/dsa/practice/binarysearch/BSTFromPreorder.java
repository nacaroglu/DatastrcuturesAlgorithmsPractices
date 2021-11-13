package com.nacaroglu.dsa.practice.binarysearch;

public class BSTFromPreorder {

	public static void main(String[] args) {
	
		BSTFromPreorder b = new BSTFromPreorder();
		
		int[] preorder = {8,5,1,7,10,12};
		//TreeNode root = b.bstFromPreorder(preorder);

		//System.out.println(root.val);
		
		int[] preorder2 = {15,13,12,18};
		TreeNode root = b.bstFromPreorder(preorder2);

		System.out.println(root.val);

	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

	private TreeNode helper(int[] arr, int start, int end) {

		TreeNode node = null; 
		if(start>end) {
			return node;
		}
				
		node = new TreeNode(arr[start]);
		
		if(start==end) {
			return node;
		}
		
		int firstGreater = -1;
		
		for(int i=start+1; i<=end; i++) {
			if(arr[i]>arr[start]) {
				firstGreater = i;
				break;
			}
		}
		
		if(firstGreater!=-1) {
			node.right = helper(arr,firstGreater, end);
			node.left = helper(arr, start+1, firstGreater-1);
		}else {
			node.left = helper(arr, start+1, end);
		}		
		
		return node;
	}

}
