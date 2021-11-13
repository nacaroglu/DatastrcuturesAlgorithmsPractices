package com.nacaroglu.dsa.practice.stackandqueue;

import java.util.Stack;

public class QueueUsingStack<V> {
	
	Stack<V> stack;
	Stack<V> temp;
	

	public QueueUsingStack() {
		super();
		stack = new Stack<V>();
		temp = new Stack<V>();
	}


	public static void main(String[] args) {
		
		QueueUsingStack<Integer> q = new QueueUsingStack<Integer>();
		
		for(int i=1; i<=5; i++) {
			q.enqueue(i);
		}
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		for(int i=1; i<10; i++) {
			q.enqueue(i*5);
		}
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		System.out.println(q.toString());

	}
	
	public void enqueue(V val) {
		
		stack.push(val);
	}
	
	public V dequeue() {
		
		temp.clear();
		
		if(stack.isEmpty())
			return null;
		
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		
		V val = temp.pop();
		
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		
		return val;
	}

}
