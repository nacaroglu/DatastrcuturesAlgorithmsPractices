package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	public static void main(String[] args) {
		
		GenerateParentheses gp = new GenerateParentheses();
		List<String>  result = gp.generateParenthesis(3);
		
		for (String string : result) {
			System.out.println(string);
		}

	}

	public List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<String>();		
		backtrack(n, 0, new StringBuffer(), result);		
		return result;
	}
	
	public void backtrack(int n, int level, StringBuffer current, List<String> result) {
		
		if(level>=n*2) {			
			if(isValid(current)) {
				result.add(current.toString());
			}			
			return;
		}
		
		current.append('(');
		backtrack(n, level+1, current, result);
		current.deleteCharAt(current.length()-1);
		current.append(')');
		backtrack(n, level+1, current, result);
		current.deleteCharAt(current.length()-1);	
	}

	private boolean isValid(StringBuffer current) {	
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<current.length(); i++) {
			char c = current.charAt(i);
			if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				if(stack.isEmpty()) {					
					return false;
				}else {
					stack.pop();
				}
					
			}
		}
		
		return stack.isEmpty();				
	}

}
