package com.nacaroglu.dsa.practice.linkedlist;

import com.nacaroglu.dsa.practice.linkedlist.RemoveNthFromEnd.ListNode;

public class RemoveDuplicatesFromSortedList {
	
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
		
		RemoveDuplicatesFromSortedList rm = new RemoveDuplicatesFromSortedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		rm.removeDuplicates(head);

	}
	
	public static ListNode removeDuplicates (ListNode head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode current = head;
		ListNode prev = current;
		current = current.next;
		
		while(current!= null) {
			
			if(prev.val==current.val) {				
				prev.next = current.next;
				current = current.next;				 
			}else {
				prev = current;
				current = current.next;
			}
		}
		
		return head;
	}

}
