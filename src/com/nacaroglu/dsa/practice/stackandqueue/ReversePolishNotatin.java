package com.nacaroglu.dsa.practice.stackandqueue;

public class ReversePolishNotatin {

	public static void main(String[] args) {
		

		ReversePolishNotatin rpn = new ReversePolishNotatin();
		
		String[] tokens = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
		System.out.println(rpn.evalRPN(tokens));		
		
	}
	
	 public int evalRPN(String[] tokens) {
		 
		 int temp = 0;
		 
		 if(tokens==null || tokens.length==0) {
			 return temp;
		 }
		 
		 MyStack<Integer> stack = new MyStack<Integer>();
		 
		 for (String token : tokens) {
			 
			 if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				 
				 int num1 = stack.pop();
				 int num2 = stack.pop();				
				 
				 if(token.equals("/")) {
					 temp = num2 / num1;
				 } else	 if(token.equals("*")) {
					 temp = num2 * num1;
				 }
				 else if(token.equals("+")) {
					 temp = num2 + num1;
				 }
				 else	 if(token.equals("-")) {
					 temp = num2 - num1;
				 }
				 
				 stack.push(temp);
				 
			 }else {
				 boolean negative = false;
				 int val = 0;
				 if(token.startsWith("-")) {
					 negative = true;
					 val = Integer.valueOf(token.substring(1));
				 }if(token.startsWith("+")) {
					 val = Integer.valueOf(token.substring(1));
				 }else {
					 val = Integer.valueOf(token);
				 }
				 
				 if(negative) {
					 val = val * -1;
				 }
				 
				 stack.push(val);
			 }
			
		 }
		 
		 return stack.pop();
		 
	 }

}
