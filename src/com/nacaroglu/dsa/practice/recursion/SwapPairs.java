package com.nacaroglu.dsa.practice.recursion;

public class SwapPairs {

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
		
		SwapPairs sp = new SwapPairs();

		ListNode head= new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);

		ListNode result = sp.swapPairs(head);
		System.out.println(result.val);
	}

	public ListNode swapPairs(ListNode head) {

		if (head == null) {
			return head;
		}

		return helper(head);
	}

	public ListNode helper(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode next = head.next;

		if (next == null) {
			return head;
		}

		head.next = next.next;
		next.next = head;

		return helper(head.next);
	}

}
