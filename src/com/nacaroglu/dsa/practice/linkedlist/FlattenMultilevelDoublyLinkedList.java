package com.nacaroglu.dsa.practice.linkedlist;

public class FlattenMultilevelDoublyLinkedList {
	
	public static class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
		
	    @Override
		public String toString() {
			return "Node [val=" + val + "]";
		}	    
	    
	};
	
	public static void main(String[] args) {
		
		FlattenMultilevelDoublyLinkedList f = new FlattenMultilevelDoublyLinkedList();
		
		Node head = createBasicCaseData2();
		
		Node result= f.flatten(head);
		
		System.out.println("Bitti...");
	}
	
	private static Node createBasicCaseData2() {
		Node head = new Node();
		head.val = 1;
		
		Node node2 = new Node();
		node2.val = 2;	
		head.child = node2;
		
		Node node3 = new Node();
		node3.val = 3;		
		node2.child = node3;
			
		return head;
	}
	
	private static Node createBasicCaseData() {
		Node head = new Node();
		head.val = 1;
		
		Node node2 = new Node();
		node2.val = 2;
		head.next = node2;
		node2.prev = head;
		
		Node node4 = new Node();
		node4.val = 4;
	
		Node node5 = new Node();
		node5.val = 5;
		node5.prev = node4;
		node4.next = node5;
		
		node2.child = node4;		
		
		Node node3 = new Node();
		node3.val = 3;
		node3.prev = node2;
		node2.next = node3;
					
			
		return head;
	}

	private static Node createMainCaseData() {
		Node head = new Node();
		head.val = 1;
		
		Node node2 = new Node();
		node2.val = 2;
		head.next = node2;
		node2.prev = head;
		
		Node node3 = new Node();
		node3.val = 3;
		node3.prev = node2;
		node2.next = node3;
		
			Node node7 = new Node();
			node7.val = 7;
		
			Node node8 = new Node();
			node8.val = 8;
			node8.prev = node7;
			node7.next = node8;
			
				Node node11 = new Node();
				node11.val = 11;
			
				Node node12 = new Node();
				node12.val = 12;
				node12.prev = node11;
				node11.next = node12;
				
			node8.child = node11;	
			
			Node node9 = new Node();
			node9.val = 9;
			node9.prev = node8;
			node8.next = node9;
			
			Node node10 = new Node();
			node10.val = 10;
			node10.prev = node9;
			node9.next = node10;
			
		node3.child = node7;
		
		Node node4 = new Node();
		node4.val = 4;
		node4.prev = node3;
		node3.next = node4;
		
		Node node5 = new Node();
		node5.val = 5;
		node5.prev = node4;
		node4.next = node5;
		
		Node node6 = new Node();
		node6.val = 6;
		node6.prev = node5;
		node5.next = node6;
		return head;
	}
	
	public Node flatten(Node head) {
		
		Node myNode = head;		
		
		while(myNode!=null) {			
			
			Node nextNode = myNode.next;
				
			if(myNode.child!= null) {
				Node childHead = flatten(myNode.child);
				Node childLast = findLast(childHead);
						
				
				myNode.next = childHead;
				childHead.prev = myNode;
				
				childLast.next = nextNode;
				
				if(nextNode!= null) {
					nextNode.prev = childLast;		
				}				
			
				myNode.child = null;
			}
			
			myNode = nextNode;			
		}
		
		return head;        
    }

	private Node findLast(Node childHead) {
		Node last = childHead;
		
		while(last.next!=null) {
			last = last.next;
		}
		
		return last;
	}
}
