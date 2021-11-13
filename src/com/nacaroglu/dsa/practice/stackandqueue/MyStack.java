package com.nacaroglu.dsa.practice.stackandqueue;

public class MyStack<T> {
	
	public static class Node<T>{
		
		public T data;
		public Node<T> next;
		
		public Node(T data) {
			super();
			this.data = data;
		}

		public Node(T data, Node<T> next) {
			super();
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}		
	}
	
	int size;
	Node<T> first;	

	public MyStack() {		
		super();
		
		size = 0;
		first = null;
	}
	
	public boolean isEmpty() {
		return size <= 0;
	}
	
	public void push(T data) {
		
		Node<T> node = new Node<T>(data);
		
		if(first==null) {
			first = node;
		}else {
			node.next = first;
			first = node;
		}
		
		size+=1;
	}
	
	public T pop() {
		
		T result = null;
		
		if(size>0) {
			Node<T> node = first;
			result = node.data;
			
			first = first.next;
			node = null;	
			size-=1;
		}
		
		return result;		
	}
	
	public T peek() {
		
		T result = null;
		
		if(size>0) {
			Node<T> node = first;
			result = node.data;
		}
		
		return result;		
	}
}
