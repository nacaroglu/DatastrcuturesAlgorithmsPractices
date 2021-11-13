package com.nacaroglu.dsa.practice.linkedlist;

import com.nacaroglu.dsa.practice.linkedlist.OddEvenList.ListNode;

public class PartitionList {

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
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		//head.next.next.next.next.next.next = new ListNode(7);
		//head.next.next.next.next.next.next.next = new ListNode(8);

		PartitionList pl = new PartitionList();
		ListNode result = pl.partition(head, 3);

		while (result != null) {
			System.out.print(result.val + "-->");
			result = result.next;
		}
		 
	}

	public ListNode partition(ListNode head, int x) {

		if (head == null)
			return head;

		ListNode firstHead = null;
		ListNode firstTail = null;

		ListNode secondHead = null;
		ListNode secondTail = null;

		ListNode current = head;

		while (current != null) {

			if (current.val < x) {

				if (firstHead == null) {
					firstHead = current;
					firstTail = current;
				}else{
					firstTail.next = current;
					firstTail = current;
				}		

			} else {

				if (secondHead == null) {
					secondHead = current;
					secondTail = current;
				}else{
					secondTail.next = current;
					secondTail = current;
				}

				
				
			}
			
			current = current.next;
		}

		firstTail.next = secondHead;
		secondTail.next = null;

		return firstHead;

	}

}
