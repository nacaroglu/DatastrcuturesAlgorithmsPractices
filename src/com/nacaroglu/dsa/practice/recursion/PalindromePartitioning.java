package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {

		PalindromePartitioning pp = new PalindromePartitioning();
		pp.partition("abccba");
	}

	public List<List<String>> partition(String s) {

		List<List<String>> result = new ArrayList<List<String>>();
		helper(s, 0, result, new ArrayList<String>());
		return result;
	}

	private void helper(String s, int start, List<List<String>> result, List<String> curr) {
		
		if(s.length()==start) {
			result.add(new ArrayList<>(curr));		
			return;
		}

		for (int n = start +1; n<=s.length(); n++) {		

			String prefix = s.substring(start , n);
			
			if (isPalindrome(prefix)) {				
				curr.add(prefix);
				helper(s,n, result,curr);
				curr.remove(curr.size()-1);
			}		
		}	
	}
	
	private boolean isPalindrome(String s) {
		
		int l = 0;
		int r = s.length() - 1;

		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}	
		}

		return true;
	}

}
