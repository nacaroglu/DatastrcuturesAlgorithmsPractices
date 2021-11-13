package com.nacaroglu.dsa.practice.linkedlist;

public class OddEvenList {

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
		
				
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		OddEvenList o = new OddEvenList();
		ListNode result = o.oddEvenList(head);
		while(result!=null) {
			System.out.print(result.val + "-->");
			result = result.next;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
		
		if(head==null) return head;
		if(head.next== null) return head;
		
		ListNode evenHead = new ListNode();
		ListNode oddHead = new ListNode();
		
		ListNode current = head;
		ListNode evenTail = evenHead;
		ListNode oddTail = oddHead;
		int counter = 0;
		
		while(current!= null) {
			
			if(counter%2==0) {
				evenTail.next = current;
				evenTail = current;
			} else {
				oddTail.next = current;
				oddTail = current;
			}
			
			current= current.next;
			counter++;			
		}
		
		evenTail.next = oddHead.next;
		oddTail.next = null;
		
		return evenHead.next;        
    }
}
