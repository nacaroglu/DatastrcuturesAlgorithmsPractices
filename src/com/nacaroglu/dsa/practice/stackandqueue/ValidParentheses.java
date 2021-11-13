package com.nacaroglu.dsa.practice.stackandqueue;

public class ValidParentheses {

	public static void main(String[] args) {
		
		ValidParentheses vp = new ValidParentheses();
		
		System.out.println(vp.isValid("()"));
		System.out.println(vp.isValid("()[]{}"));
		System.out.println(vp.isValid("(]"));
		System.out.println(vp.isValid("([)]"));
		System.out.println(vp.isValid("{[]}"));
		

	}
	
	public boolean isValid(String s) {
		
		if(s==null || s.length()==0) {
			return true;
		}
		
		if(s.length()%2==1) {
			return false;
		}
		
		MyStack<Character> stack = new MyStack<Character>();
		
		Character chr;
		
		for(int i=0; i< s.length(); i++) {
			
			chr = s.charAt(i);
			
			if(chr == '(' || chr=='[' || chr =='{') {
				stack.push(chr);				
			}else {
				Character top = stack.pop();
				if(chr==')' && top != '(' ) {
					return false;
				}
				if(chr=='}' && top != '{' ) {
					return false;
				}
				
				if(chr==']' && top != '[' ) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
    }

}
