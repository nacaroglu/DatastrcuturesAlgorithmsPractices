package com.nacaroglu.dsa.practice.binarysearch;

public class PairlncludesAncestorAndDescendantOfM {

	public static void main(String[] args) {

		PairlncludesAncestorAndDescendantOfM k = new PairlncludesAncestorAndDescendantOfM();

		TreeNode root = buildTree0();
		
		//System.out.println(k.pairlncludesAncestorAndDescendantOfHC(root, root.right.left.right, root.right.left));
		//System.out.println(k.pairlncludesAncestorAndDescendantOfHC(root.right, root.right.left.right.left.right, root.right.left));
		//System.out.println(k.pairlncludesAncestorAndDescendantOfHC(root.right, root.right.right.right, root.right.left));
		System.out.println(k.pairlncludesAncestorAndDescendantOfHC(root.right.left, root.right.left.right, root.right.left));



	}

	private static TreeNode buildTree0() {

		TreeNode root = new TreeNode(19, 15);

		root.left = new TreeNode(7, 6);

		root.left.left = new TreeNode(3, 2);
		root.left.left.left = new TreeNode(2, 0);
		root.left.left.right = new TreeNode(5, 0);

		root.left.right = new TreeNode(11, 2);
		root.left.right.right = new TreeNode(17, 1);
		root.left.right.right.left = new TreeNode(13, 0);

		root.right = new TreeNode(43, 7);

		root.right.left = new TreeNode(23, 4);
		root.right.left.right = new TreeNode(37, 3);
		root.right.left.right.right = new TreeNode(41, 0);
		root.right.left.right.left = new TreeNode(29, 1);
		root.right.left.right.left.right = new TreeNode(31, 0);

		root.right.right = new TreeNode(47, 1);

		root.right.right.right = new TreeNode(53, 0);

		return root;
	}

	boolean middleFound;

	public boolean pairlncludesAncestorAndDescendantOfHC(TreeNode possibleAncOrDesc1, TreeNode possibleAncOrDesc2,
			TreeNode middle) {
		
		middleFound = false;

		if (possibleAncOrDesc1.val == middle.val || possibleAncOrDesc2.val == middle.val) {
			return false;
		}

		TreeNode big = possibleAncOrDesc1;
		TreeNode small = possibleAncOrDesc2;

		if (possibleAncOrDesc1.val < possibleAncOrDesc2.val) {
			big = possibleAncOrDesc2;
			small = possibleAncOrDesc1;
		}

		if(helper(small.right, big, middle) && middleFound) {
			return true;
		}
		
		middleFound = false;
		
		if(helper(big.left, small, middle) && middleFound) {
			return true;
		}

		return false;
	}

	private boolean helper(TreeNode root, TreeNode target, TreeNode middle) {
		
		if(root==null) {
			return false;
		}
		
		if(root.val==middle.val) {
			middleFound = true;
		}
		
		if(root.val==target.val) {
			return true;
		}
		
		return helper(root.left, target, middle) || helper(root.right, target, middle);	
	}
}
