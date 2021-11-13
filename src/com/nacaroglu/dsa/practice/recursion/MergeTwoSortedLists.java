	package com.nacaroglu.dsa.practice.recursion;

public class MergeTwoSortedLists {
	
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
		
		ListNode l1 = new ListNode(1);
		
		ListNode node2 = new ListNode(2);
		l1.next = node2;

		ListNode node4 = new ListNode(4);
		node2.next = node4;
		
		ListNode l2 = new ListNode(1);
		
		ListNode node33 = new ListNode(3);
		l2.next = node33;

		ListNode node44 = new ListNode(4);
		node33.next = node44;
		
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		ListNode head = merge.mergeTwoLists(l1, l2);
		System.out.println(head.val);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1==null && l2==null) {
			return null;
		}
		
		if(l1==null) {
			return l2;
		}
		
		if(l2==null) {
			return l1;
		}
		
		ListNode dummyHead = new ListNode(999);
		
		doMerge(l1, l2, dummyHead);
		
		
		return dummyHead.next;
	}

	private void doMerge(ListNode l1, ListNode l2, ListNode tailNode) {
		
		if(l1==null && l2==null) {
			return;
		}
		
		if(l1==null) {
			tailNode.next = l2;
			 doMerge(l1, l2.next, tailNode.next);
			 return;
		}
		
		if(l2==null) {
			tailNode.next = l1;
			 doMerge(l1.next, l2, tailNode.next);
			 return;
		}
		
		if(l1.val < l2.val) {
			tailNode.next = l1;
			doMerge(l1.next, l2, tailNode.next);
		}else {
			tailNode.next = l2;
			 doMerge(l1, l2.next, tailNode.next);
		}	
	}

}
