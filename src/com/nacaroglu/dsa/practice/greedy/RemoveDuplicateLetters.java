package com.nacaroglu.dsa.practice.greedy;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoveDuplicateLetters rm = new RemoveDuplicateLetters();
		
		System.out.println(rm.removeDuplicateLetters("fecbacba"));
		System.out.println(rm.removeDuplicateLetters( "cbacdcbc"));
		System.out.println(rm.removeDuplicateLetters( "bcabc"));

	}

	public String removeDuplicateLetters(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		SortedSet<Character> set = new  TreeSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		
		Character start = set.first();
		
		HashSet<Character> temp = new HashSet<Character>();
		
		
		for (int i = s.indexOf(start); i < s.length() && temp.size()<=set.size(); i++) {
			
			if(!temp.contains(s.charAt(i))){
				temp.add(s.charAt(i));
				sb.append(s.charAt(i));
			}
		}
		
		StringBuilder sb2 = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			
			if(!temp.contains(s.charAt(i))){
				temp.add(s.charAt(i));
				sb2.append(s.charAt(i));
			}
		}

		return sb2.toString() + sb.toString();
	}
}
