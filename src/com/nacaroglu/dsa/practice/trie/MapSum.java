package com.nacaroglu.dsa.practice.trie;

public class MapSum {

	public static class TrieNode {

		Character chr;
		boolean isEnd;
		int val;
		TrieNode left;
		TrieNode middle;
		TrieNode right;

		public TrieNode(Character chr) {
			super();
			this.chr = chr;			
		}

		@Override
		public String toString() {
			return "TrieNode [char=" + chr + ", val= " + val + ", isEnd=" + isEnd + "]";
		}
	}

	public static void main(String[] args) {

		MapSum m = new MapSum();

		
		// ["MapSum","insert","sum","insert","sum", "insert", "sum"]
		// [[],["apple",3],["ap"],["app",2],["ap"], ["application",9], ["app"]]

		m.insert("apple", 3);
		System.out.println(m.sum("ap"));
		m.insert("app", 2);
		System.out.println(m.sum("ap"));
		m.insert("application", 9);
		System.out.println(m.sum("app")); 
		
		/*
		["MapSum","insert","sum","insert","sum"]
		[[],["a",3],["ap"],["b",2],["a"]]
		m.insert("a", 3);
		//System.out.println(m.sum("ap"));
		m.insert("b", 2);
		System.out.println(m.sum("a")); */
	}

	TrieNode root;

	public MapSum() {

		root = new TrieNode(null);
	}
	
	public void insert(String word, int val) {
		root.middle = insert_helper(root.middle, word, 0, val);
	}

	private TrieNode insert_helper(TrieNode node, String word, int depth, int val) {

		char c = word.charAt(depth);

		if (node == null) {
			node = new TrieNode(c);
		}

		if (c < node.chr) {
			node.left = insert_helper(node.left, word, depth, val);
		} else if (c > node.chr) {
			node.right = insert_helper(node.right, word, depth, val);
		} else if (depth < word.length() - 1) {
			node.middle = insert_helper(node.middle, word, depth + 1, val);
		} else {
			node.val = val;
			node.isEnd = true;
		}

		return node;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {

		return search_helper(root.middle, word, 0);
	}

	private boolean search_helper(TrieNode node, String word, int depth) {

		if (node == null) {
			return false;
		}

		char c = node.chr;
		if (depth == word.length() - 1) {

			if (c == word.charAt(depth)) {
				return node.isEnd;
			}
		} else {

			if (c == word.charAt(depth)) {
				return search_helper(node.middle, word, depth + 1);
			} else if (c > word.charAt(depth)) {
				return search_helper(node.left, word, depth);
			} else {
				return search_helper(node.right, word, depth);
			}
		}

		return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

		return startsWith_helper(root.middle, prefix, 0);
	}

	private boolean startsWith_helper(TrieNode node, String word, int depth) {

		if (node == null) {
			return false;
		}

		char c = node.chr;

		if (depth == word.length() - 1) {

			if (c == word.charAt(depth)) {
				return true;
			}
		}

		if (c == word.charAt(depth)) {
			return startsWith_helper(node.middle, word, depth + 1);
		} else if (c > word.charAt(depth)) {
			return startsWith_helper(node.left, word, depth);
		} else {
			return startsWith_helper(node.right, word, depth);
		}
	}

	public int sum(String prefix) {

		TrieNode curr = root.middle;
		int sum = 0;

		char[] prefixArr = prefix.toCharArray();
		int depth = 0;

		while (curr != null) {

			char chr = curr.chr;

			if (prefixArr[depth] < chr) {
				curr = curr.left;
			} else if (prefixArr[depth] > chr) {
				curr = curr.right;
			} else if (depth < prefixArr.length - 1) {
				curr = curr.middle;
				depth++;
			} else {
				break;
			}
		}
		
		sum = sumHelper(curr.middle) + curr.val;

		return sum;
	}

	private int sumHelper(TrieNode curr) {
		
		if(curr==null) {			
			return 0;
		}
		
		int left = sumHelper(curr.left);
		int right = sumHelper(curr.right);
		int middle = sumHelper(curr.middle);
		
		return curr.val + middle + left + right;
	}

}
