package com.nacaroglu.dsa.practice.linkedlist;

public class RemoveNthFromEnd {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		
		RemoveNthFromEnd rm = new RemoveNthFromEnd();
				
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		rm.removeNthFromEnd(head, 3);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		if(head==null) {
			return null;
		}
		
		ListNode front = head;
		ListNode end = head;
		ListNode prev = null;
		
		int counter = 1;
		
		while(front!= null && counter<= n) {		
			
			front = front.next;
			counter++;
		}
		
		if(counter<n) {
			return null;
		}
		
		
		while(front.next!= null) {
			
			prev = end;
			end = end.next;
			front = front.next;
		}
		
		prev.next = end.next;

		return head;
	}
}
