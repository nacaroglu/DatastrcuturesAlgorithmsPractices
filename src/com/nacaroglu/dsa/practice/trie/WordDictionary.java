package com.nacaroglu.dsa.practice.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
	
	class TrieNode {
        public boolean isWord; 
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }
	
	public static void main(String[] args) {
		
		//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
		//	[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
		
		WordDictionary wd = new WordDictionary();
		String[] commands = {"addWord","addWord","addWord","search","search","search","search"};
		String[] params = { "bad", "dad", "mad", "pad", "bad", ".ad", "b.."};
		
		for(int i=0; i<commands.length; i++) {
			if(commands[i].equals("addWord")) {
				wd.addWord(params[i]);
			}else {
				System.out.println(wd.search(params[i]));
			}
		}
	}
    
    private TrieNode root; 


    public WordDictionary() {
        root = new TrieNode();
    }    
    
    public void addWord(String word) {
        insert(word);
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }
    
    private boolean searchHelper(String word, TrieNode node, int depth) {
    	
    	if(node==null) {
    		return false;
    	}
    	
    	if(depth==word.length()) {
    		return node.isWord;
    	}    	
    	
    	char c = word.charAt(depth);
    	
    	if(c=='.') {
    		for (TrieNode childNode : node.childrenMap.values()) {
				
    			if(searchHelper(word.substring(depth+1), childNode, 0)) {
    				return true;
    			}
			}
    		
    		return false;
    	}
    	
    	return searchHelper(word, node.childrenMap.get(c), depth+1);   	
    		
    }
    
   
    
    public boolean do_search(String word) {
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c); 
        }
        cur.isWord = true;
    }
        
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }

	
}
