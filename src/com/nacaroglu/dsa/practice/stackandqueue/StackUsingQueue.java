package com.nacaroglu.dsa.practice.stackandqueue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<Integer> q1;
	Queue<Integer> q2;	

	public StackUsingQueue() {
		super();
		q1 = new ArrayDeque<Integer>();
		q2 = new ArrayDeque<Integer>();
	}

	public static void main(String[] args) {

		StackUsingQueue s = new StackUsingQueue();
		
		for(int i=0; i<5; i++) {
			s.push(i);
		}
		
		System.out.println(s.pop());
		System.out.println(s.pop());		
		System.out.println(s.pop());		
		
		
		for(int i=1; i<5; i++) {
			s.push(i*3);
		}
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}
	
	public void push(int val) {
		
		if(q1.isEmpty() && !q2.isEmpty()) {
			Queue<Integer> tempQ = new ArrayDeque<Integer>();
			q1 = tempQ;
			q1 = q2;
			q2 = tempQ;		
		}
		
		q1.add(val);		
	}
	
	public int pop() {
		
		if(q1.isEmpty() && q2.isEmpty()) {
			throw new EmptyStackException();
		}
		
		if(q1.isEmpty()) {
			Queue<Integer> tempQ = new ArrayDeque<Integer>();
			q1 = tempQ;
			q1 = q2;
			q2 = tempQ;		
		}
		
		int val = q1.poll();
		while(!q1.isEmpty()){						
			q2.add(val);
			val = q1.poll();
		} ;
		
		return val;		
	}
}
