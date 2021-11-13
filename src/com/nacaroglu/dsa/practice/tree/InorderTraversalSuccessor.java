package com.nacaroglu.dsa.practice.tree;

import java.util.LinkedList;
import java.util.List;


public class InorderTraversalSuccessor {

	public static void main(String[] args) {

		InorderTraversalSuccessor pre = new InorderTraversalSuccessor();

		TreeNode root = buildTree0();
		
		
		TreeNode result = pre.findSuccessor(root);
		System.out.println(result.val);
		
		result = pre.findSuccessor(root.left.right.right);
		System.out.println(result.val);
		
		result = pre.findSuccessor(root.right.left.right.right);
		System.out.println(result.val);

	}

	private static void printList(List<Integer> result) {

		if (result == null || result.isEmpty()) {
			System.out.print("boş");
		}

		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}

		System.out.println("");
	}

	private static TreeNode buildTree0() {

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

	public TreeNode findSuccessor(TreeNode node) {

		if (node.right == null) {

			//node = node.parent;

			while (node. parent != null && node . parent . right == node) {
				node = node.parent;
			}

			return node.parent;

		} else {
			LinkedList<TreeNode> list = inorderTraversal(node.right);

			if (list != null && list.getFirst() != null) {
				return list.getFirst();
			} else {
				return null;
			}
		}
	}

	public LinkedList<TreeNode> inorderTraversal(TreeNode root) {

		LinkedList<TreeNode> result = new LinkedList<TreeNode>();
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, LinkedList<TreeNode> result) {

		if (root == null) {
			return;
		}

		helper(root.left, result);
		result.add(root);
		helper(root.right, result);
	}
}
