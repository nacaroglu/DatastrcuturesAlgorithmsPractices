package com.nacaroglu.dsa.practice.stackandqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxStack extends MyStack<Integer> {
	
	
	PriorityQueue<Integer> queue;
	

	public MaxStack() {
		super();
		
		this.queue = new PriorityQueue<Integer>(Collections.reverseOrder()); 
	}


	@Override
	public void push(Integer data) {
		// TODO Auto-generated method stub
		super.push(data);
		
		queue.add(data);	
	}


	@Override
	public Integer pop() {		
		Integer val = super.pop();		
		queue.remove(val);		
		return val;
	}
	
	public Integer getMax() {
		return queue.peek();
	}
	

	public static void main(String[] args) {
		
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		MaxStack max = new MaxStack();
		max.push(3);
		max.push(13);
		max.push(33);
		max.push(444);
		max.push(23);
		max.push(43);
		max.push(-43);
		
		System.out.println(max.getMax());
		
	}

}
