package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {

		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(2));

	}
	
	public List<String> generateParenthesis(int n) {
    
		List<String> list = new ArrayList<String>();
		
		backTrack(list, 0, 0, "", n);
		
		
		return list;
    }

	private void backTrack(List<String> list, int openCount, int ClosedCount, String str, int n) {

		if(str.length()==n*2) {
			list.add(str);
			return;
		}
		
		if(openCount<n) {
			backTrack(list, openCount+1, ClosedCount, str+"(", n);
		}
		if(ClosedCount<openCount) {
			backTrack(list, openCount, ClosedCount+1, str+ ")", n);
		}		
	}
}
