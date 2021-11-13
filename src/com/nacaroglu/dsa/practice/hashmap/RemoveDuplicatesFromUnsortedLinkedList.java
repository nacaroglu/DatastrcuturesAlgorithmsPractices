package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedLinkedList {

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
			return "ListNode [val=" + val + "]";
		}	
		
	}

	public static void main(String[] args) {
		
		RemoveDuplicatesFromUnsortedLinkedList rmd = new RemoveDuplicatesFromUnsortedLinkedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		
		ListNode result = rmd.deleteDuplicatesUnsorted(head);

		System.out.println(result.val);
	}
	
	
	public ListNode deleteDuplicatesUnsorted(ListNode head) {

		ListNode dummyHead = new ListNode(); // temporary node as a temp head in case the head is one of the nodes needs
												// to be deleted or head is null
		dummyHead.next = head; // set temporary node next to head

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode curr = head;

		while (curr != null) {

			if (map.containsKey(curr.val)) {
				map.put(curr.val, map.get(curr.val) + 1);
			} else {
				map.put(curr.val, 1);
			}

			curr = curr.next;
		}

		ListNode prev = dummyHead;
		curr = dummyHead.next;

		while (curr != null) {

			if (map.get(curr.val) > 1) {
				prev.next = curr.next;
				curr.next = null;
				curr = prev;
			}

			prev = curr;
			curr = curr.next;
		}

		prev = null;

		return dummyHead.next;
	}
	
	
}
