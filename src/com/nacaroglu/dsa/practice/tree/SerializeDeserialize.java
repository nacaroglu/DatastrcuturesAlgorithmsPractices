package com.nacaroglu.dsa.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SerializeDeserialize {

	public static void main(String[] args) {

		SerializeDeserialize pre = new SerializeDeserialize();

		TreeNode root = buildTree0();
		//List<Integer> result = pre.serialize(root);
		//printList(result);
		List<List<Integer>> result = pre.levelOrder(root);
		
		for (List<Integer> list : result) {
			
			for (Integer integer : list) {
				System.out.print(integer + " ,");
			}
			
			System.out.println();
		}
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

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(7);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(15);
		root.right.right.right.right = new TreeNode(25);
		return root;
	}

	private static TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);

		root.right.left = new TreeNode(3);
		return root;
	}

	private static TreeNode buildTree2() {
		TreeNode root = null;
		return root;
	}

	private static TreeNode buildTree3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}

	public List<Integer> serialize(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.peek();
			result.add(node.val);
			stack.pop();

			if (node.right != null) {
				stack.push(node.right);
			} else {
				result.add(null);
			}

			if (node.left != null) {
				stack.push(node.left);
			} else {
				result.add(null);
			}
		}

		return result;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();

			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {

				TreeNode node = q.poll();
				list.add(node.val);

				if (node.left != null) {
					q.add(node.left);
				}else {
					list.add(null);
				}
					

				if (node.right != null) {
					q.add(node.right);
				}else {
					list.add(null);
				}
					

			}

			result.add(list);
		}

		return result;
	}
}
