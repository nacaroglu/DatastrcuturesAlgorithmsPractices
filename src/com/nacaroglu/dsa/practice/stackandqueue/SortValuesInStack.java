package com.nacaroglu.dsa.practice.stackandqueue;

import java.util.Stack;

public class SortValuesInStack {

	public static void main(String[] args) {

		SortValuesInStack s = new SortValuesInStack();

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(23);
		stack.push(60);
		stack.push(42);
		stack.push(4);
		stack.push(97);
		stack.push(2);

		s.sortStack(stack);
	}

	public static void sortStack(Stack<Integer> stack) {

		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();

		if (stack.isEmpty()) {
			return;
		}

		while(!stack.isEmpty()) {
			
			int top = Integer.MIN_VALUE;

			while (!stack.isEmpty()) {

				if (top==Integer.MIN_VALUE) {
					top = stack.pop();
					result.push(top);
				} else {

					if (stack.peek() < top) {
						result.pop();
						temp.push(top);
						top = stack.pop();
						result.push(top);
					} else {
						temp.push(stack.pop());
					}
				}
			}
			
			Stack<Integer> temp2 = new Stack<Integer>();
			temp2= stack;
			stack = temp;
			temp = temp2;			
		}
		
		

		System.out.println("Bitti");
	}

}
