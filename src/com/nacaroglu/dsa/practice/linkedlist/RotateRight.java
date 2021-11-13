package com.nacaroglu.dsa.practice.linkedlist;

public class RotateRight {

	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode() {
		}

		LinkedListNode(int val) {
			this.val = val;
		}

		LinkedListNode(int val, LinkedListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		
		RotateRight rm = new RotateRight();
				
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		head.next.next.next.next.next = new LinkedListNode(6);
		head.next.next.next.next.next.next = new LinkedListNode(7);
		head.next.next.next.next.next.next.next = new LinkedListNode(8);
		
		rm.rotateRight(head,13);

	}

	public LinkedListNode rotateRight(LinkedListNode head, int n) {
				
		if(head==null) return null;

	    if(n==0) return head;

	    int size = 0;
	    LinkedListNode tail = head;
	    LinkedListNode prevTail = null;
	    while(tail!=null){
	      size++;
	      prevTail = tail;
	      tail = tail.next;
	    }

	    if(n%size==0) return head;

	    n = n%size;

	    LinkedListNode front = head;
	    for(int i=0; i< n; i++){
	      front = front.next;
	    }

	    LinkedListNode end = head;
	    LinkedListNode prev = null;

	    while(front!= null){
	      prev = end;
	      front = front.next;
	      end = end.next;
	    }

	    prevTail.next = head;
	    prev.next = null;
	    head = end;

	    return head;
	}
		

}
