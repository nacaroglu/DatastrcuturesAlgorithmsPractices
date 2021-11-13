package com.nacaroglu.dsa.practice.linkedlist;

public class InsertIntoCyclicSortedList {
	
	static class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _next) {
	        val = _val;
	        next = _next;
	    }
	    
	    @Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
	}

	public static void main(String[] args) {
		
		/*
		Node head = new Node(3);
		Node node4 = new Node(4);
		Node node1 = new Node(1);
		
		head.next = node4;
		node4.next = node1;
		node1.next = head; */
		
		
		Node head = new Node(1);
		Node node2 = new Node(3);
		Node node3 = new Node(5);
		
		
		head.next = node2;
		node2.next = node3;
		node3.next = head;
		
		
		InsertIntoCyclicSortedList icsl = new InsertIntoCyclicSortedList();
		icsl.insert(head, 0);

	}
	
	public Node insert(Node head, int insertVal) {
		 if(head== null) {
				head = new Node(insertVal);
				head.next = head;
				return head;
			}
			
			if(head.next==head) {
				Node newNode = new  Node(insertVal);
				newNode.next = head;
				head.next = newNode;			
				return head;
			}
			
			Node miNode = head;
			Node current = head.next;
		
			while(current!= head) {
				
				if(current.val<miNode.val) {
					miNode = current;
				}
				
				current = current.next;			
			}
			
			if(miNode.val> insertVal) {
				Node newoNode = new Node(insertVal);
				
				Node prevNode = findPrev(miNode, head);
				
				prevNode.next = newoNode;
				newoNode.next = miNode;
				
				return head;
			}
			
			
			current = miNode;
			
			do {
				
				if(current.val<=insertVal && current.next.val>=insertVal) {
					Node newoNode = new Node(insertVal);
					
					Node nextNode = current.next;
					current.next = newoNode;
					
					newoNode.next = nextNode;
					
					break;
				}
				
				current = current.next;
				
			}while(current!= miNode);
			
			return head;
	    }

	private Node findPrev(Node miNode, Node head) {
		
		Node current = head;
		
		while(current!= null) {
			
			if(current.next==miNode) {
				return current;
			}
			
			current= current.next;
		}
		
		return null;
	}
    
}
