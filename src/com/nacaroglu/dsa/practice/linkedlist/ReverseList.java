package com.nacaroglu.dsa.practice.linkedlist;

public class ReverseList {

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

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
	}

	public static void main(String[] args) {

		
		ListNode node5 = new ListNode(5, null);

		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4); 
		
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);

		ReverseList rl = new ReverseList();
		ListNode node = rl.reverseList(head);
		
		System.out.println("next");
	}
	
	public ListNode reverseList(ListNode head) {
		
		if(head==null) {
			return null;
		}
		
		ListNode next = head.next;	
		ListNode newHead = reverse(head, next);	
		head.next = null;
		return 	newHead;
	}
	
	public ListNode reverse(ListNode head, ListNode next) {
		
				
		if(next==null) {
			return head;
		}
		
		ListNode newNode = next.next;
		next.next = head;	
		//head.next = null;
		
		return reverse(next, newNode);
	}

	public ListNode reverseListIterative(ListNode head) {

		ListNode prev = head;

		if (head == null) {
			return null;
		}

		ListNode current = head.next;
		ListNode nextNode = null;
		ListNode myHead = head;

		while (current != null) {
			nextNode = current.next;
			myHead.next = nextNode;
			current.next = prev;
			prev = current;
			current = nextNode;
		}

		return prev;
	}

}
