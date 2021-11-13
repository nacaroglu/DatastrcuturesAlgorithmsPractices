package com.nacaroglu.dsa.practice.trie;

public class Trie {

	public static class TrieNode {

		Character chr;
		boolean isEnd;
		TrieNode left;
		TrieNode middle;
		TrieNode right;

		public TrieNode(Character val) {
			super();
			this.chr = val;
		}

		@Override
		public String toString() {
			return "TrieNode [val=" + chr + ", isEnd=" + isEnd + "]";
		}

	}

	public static void main(String[] args) {

		Trie t = new Trie();

		/*
		 * //System.out.println(t.search("ahmet")); t.insert("faruk");
		 * //System.out.println(t.search("faruk")); t.insert("ahmet");
		 * //System.out.println(t.search("ahmet")); t.insert("nacaroglu");
		 * //System.out.println(t.search("ahmak"));
		 * //System.out.println(t.search("nacar")); t.insert("nacar");
		 * //System.out.println(t.search("nacar"));
		 * System.out.println(t.startsWith("na"));
		 * System.out.println(t.startsWith("f"));
		 * System.out.println(t.startsWith("fa"));
		 * System.out.println(t.startsWith("faz"));
		 * System.out.println(t.startsWith("an"));
		 * System.out.println(t.startsWith("ah")); System.out.println("bitti");
		 */

		
		
		
		
		
							

		

	}

	TrieNode root;

	public Trie() {

		root = new TrieNode(null);
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		root.middle = insert_helper(root.middle, word, 0);
	}

	private TrieNode insert_helper(TrieNode node, String word, int depth) {

		char c = word.charAt(depth);

		if (node == null) {
			node = new TrieNode(null);
			node.chr = c;
		}

		if (c < node.chr) {
			node.left = insert_helper(node.left, word, depth);
		} else if (c > node.chr) {
			node.right = insert_helper(node.right, word, depth);
		} else if (depth < word.length() - 1) {
			node.middle = insert_helper(node.middle, word, depth + 1);
		} else {
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
				// return node.isEnd;
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
	
	

}
