package com.nacaroglu.dsa.practice.tree;

import java.util.LinkedList;
import java.util.List;

public class LinkedListFromTheLeafOfTree {

	public static void main(String[] args) {

		LinkedListFromTheLeafOfTree pre = new LinkedListFromTheLeafOfTree();

		TreeNode root = pre.buildTree0();
		pre.printList(pre.inorderTraversal(root));	
		
		

	}

	private void printList(List<Integer> result) {

		if (result == null || result.isEmpty()) {
			System.out.print("boş");
		}

		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}

		System.out.println("");
	}

	private  TreeNode buildTree0() {

		TreeNode rootA = new TreeNode(314);

		TreeNode nodeB = new TreeNode(6);
		TreeNode nodeC = new TreeNode(271);
		TreeNode nodeD = new TreeNode(28);
		TreeNode nodeE = new TreeNode(0);
		TreeNode nodeF = new TreeNode(561);
		TreeNode nodeG = new TreeNode(3);
		TreeNode nodeH = new TreeNode(17);

		TreeNode nodeI = new TreeNode(6);
		TreeNode nodeJ = new TreeNode(2);
		TreeNode nodeK = new TreeNode(1);
		TreeNode nodeL = new TreeNode(401);
		TreeNode nodeM = new TreeNode(641);
		TreeNode nodeN = new TreeNode(257);
		TreeNode nodeO = new TreeNode(271);
		TreeNode nodeP = new TreeNode(28);

		rootA.left = nodeB;
		nodeB.parent = rootA;

		nodeB.left = nodeC;
		nodeC.parent = nodeB;

		nodeC.left = nodeD;
		nodeD.parent = nodeC;
		nodeC.right = nodeE;
		nodeE.parent = nodeC;

		nodeB.right = nodeF;
		nodeF.parent = nodeB;
		nodeF.right = nodeG;
		nodeG.parent = nodeF;
		nodeG.left = nodeH;
		nodeH.parent = nodeG;

		rootA.right = nodeI;
		nodeI.parent = rootA;

		nodeI.left = nodeJ;
		nodeJ.parent = nodeI;
		nodeJ.right = nodeK;
		nodeK.parent = nodeJ;
		nodeK.left = nodeL;
		nodeL.parent = nodeK;
		nodeK.right = nodeN;
		nodeN.parent = nodeK;
		nodeL.right = nodeM;
		nodeM.parent = nodeL;

		nodeI.right = nodeO;
		nodeO.parent = nodeI;
		nodeO.right = nodeP;
		nodeP.parent = nodeO;

		return rootA;
	}

	

	public List<Integer> inorderTraversal(TreeNode root) {

		LinkedList<Integer> result = new LinkedList<Integer>();
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, LinkedList<Integer> result) {

		if (root == null) {
			return;
		}

		helper(root.left, result);
		
		if(root.left==null && root.right==null)
			result.add(root.val);
		
		helper(root.right, result);
	}
}
