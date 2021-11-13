package com.nacaroglu.dsa.practice.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem {

	public static class TrieNode {

		Character chr;
		boolean isEnd;		
		TrieNode left;
		TrieNode middle;
		TrieNode right;
		StringBuffer sb;
		int count;

		public TrieNode(Character chr) {
			super();
			this.chr = chr;			
		}

		@Override
		public String toString() {
			return "TrieNode [char=" + chr + ", isEnd=" + isEnd + "]";
		}
	}
	
	public static class SearchResult implements Comparable<SearchResult>{
		
		String sentence;
		int count;		
		
		public SearchResult(String sentence, int count) {
			super();
			this.sentence = sentence;
			this.count = count;
		}

		@Override
		public int compareTo(SearchResult o) {			
			
			if(this.count!=o.count) {
				return o.count-this.count;
			}
			
			return this.sentence.compareToIgnoreCase(o.sentence);
		}

		@Override
		public String toString() {
			return "SearchResult [sentence=" + sentence + ", count=" + count + "]";
		}	
	}

	public static void main(String[] args) {
		
		//["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
		//[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["a"],["h"],["m"],["e"],["t"],["#"], ["a"],["h"],["m"],["e"],["t"],["#"]]

		String[] sentences = {"i love you","island","iroman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem searcher = new AutocompleteSystem(sentences, times);	
		
		char[] inputs = { 'i', ' ' , 'a' , '#', 'i', ' ' , 'a' , '#', 'i', ' ' , 'a' , '#'};
		
		List<List<String>> superList = new ArrayList();
		
		for (char keyword : inputs) {			
			List<String> result = searcher.input(keyword);
			superList.add(result);
		}
		
		System.out.println("Bitti");
	}

	TrieNode root;
	StringBuffer keyword;
	
	public AutocompleteSystem(String[] sentences, int[] times) {
		
		root = new TrieNode(null);
		keyword = new StringBuffer();
		
		for(int i=0; i<sentences.length; i++) {
			insert(sentences[i], times[i]);			                  
		}	
    }
		
	public void insert(String word, int count) {
		root.middle = insert_helper(root.middle, word, 0, new StringBuffer(), count);
	}

	private TrieNode insert_helper(TrieNode node, String word, int depth, StringBuffer sb, int count) {

		char c = word.charAt(depth);

		if (node == null) {
			node = new TrieNode(c);
			node.sb = new StringBuffer(sb.toString());
			node.sb.append(c);
		}		

		if (c < node.chr) {
			node.left = insert_helper(node.left, word, depth, sb, count);
		} else if (c > node.chr) {
			node.right = insert_helper(node.right, word, depth,sb, count);
		} else if (depth < word.length() - 1) {
			node.middle = insert_helper(node.middle, word, depth + 1, node.sb, count);
		} else {			
			
			if(node.isEnd) {
				node.count = node.count + 1;				
			}else {
				node.count = count;				
			}
			
			node.isEnd = true;			
		}

		return node;
	}		
	
	public List<String> input(char c) {
    	
    	List<String> result = new ArrayList<String>();
    	
    	if(c=='#') {
    		insert(keyword.toString(),1);	
    		keyword.setLength(0);    		
    		return result;
    	} 
    	
    	//System.out.print("keyword: " + keyword );
    	keyword.append(c);
    	
    	TrieNode curr = this.root.middle;
		curr = findPrefixIsExists(curr, keyword);		
		
		if(curr==null) {
			return result;
		}
		
		List<SearchResult> mathchList = new ArrayList<SearchResult>();
		
		if(curr.isEnd) {
			mathchList.add(new SearchResult(curr.sb.toString(), curr.count));
		}else {
			collectSearhcresultHelper(curr.middle, mathchList);
		}		 
		
		PriorityQueue<SearchResult> q = new PriorityQueue<>();
		for (SearchResult searchResult : mathchList) {
			q.add(searchResult);		
		}
		
		while(!q.isEmpty()) {
			result.add(q.poll().sentence);
			
			if(result.size()==3) {
				break;
			}
		}
    	
        return result;
    }	

	private TrieNode findPrefixIsExists(TrieNode curr, StringBuffer keyword) {
		
		int depth = 0;
		
		while (curr != null) {

			char chr = curr.chr;

			if (keyword.charAt(depth) < chr) {
				curr = curr.left;
			} else if (keyword.charAt(depth) > chr) {
				curr = curr.right;
			} else if (depth < keyword.length() - 1) {
				curr = curr.middle;
				depth++;
			} else {
				break;
			}
		}
		return curr;
	}	
	
	private void collectSearhcresultHelper(TrieNode curr, List<SearchResult> mathchList) {
		
		if(curr==null) {			
			return;
		}
		
		if(curr.isEnd) {
			mathchList.add(new SearchResult(curr.sb.toString(), curr.count));
		}
		
		collectSearhcresultHelper(curr.left, mathchList);
		collectSearhcresultHelper(curr.right, mathchList);
		collectSearhcresultHelper(curr.middle, mathchList);	 
	}
}
