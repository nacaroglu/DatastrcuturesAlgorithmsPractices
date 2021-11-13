package com.nacaroglu.dsa.practice.linkedlist;

public class ReverseLinkedList {
	
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		      
		  }

	public static void main(String[] args) {
		
		ReverseLinkedList reverse = new ReverseLinkedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode temp = new ListNode(6);
		head.next.next.next.next.next = temp;		
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverse.reverseList(head, 1,4);
		
		while(result!= null) {
			System.out.print(result.val + "-->");
			result = result.next;
		}

	}
	
	public ListNode reverseList(ListNode head, ListNode tail) {
								
		if(head==null || head.next==null) {
			return head;
		}		
		
		ListNode prev = head;
		ListNode curr = head.next;
		
		while(curr!=tail) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		head.next = null;
		return prev;
	}
	
	public ListNode reverseList(ListNode head, int p, int q) {		
		
		ListNode firstTail = null;
		ListNode curr = head;
		
		int counter = 0;
		
		while(curr!= null && counter<=p) {
			
			firstTail = curr;
			curr = curr.next;
			counter++;
		}
		
		ListNode subTail = null;
		
		while(curr!= null && counter<=q) {
			
			subTail = curr;
			curr = curr.next;
			counter++;
		}
		
		ListNode nextHead = subTail.next;
		ListNode firstTailCopy = firstTail.next;
		
		ListNode subHead = reverseList(firstTail.next, subTail.next);
		
		firstTail.next = subHead;
		firstTailCopy.next = nextHead;
		
		
		return head;
    }

}
