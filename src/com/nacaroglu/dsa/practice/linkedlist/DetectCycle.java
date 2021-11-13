package com.nacaroglu.dsa.practice.linkedlist;

public class DetectCycle {

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
		// 3,2,0,-4
		DetectCycle d = new DetectCycle();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head;
		System.out.println(d.hasCycle(head));
		
		
	}
	
	public static boolean  hasCycle(ListNode head) {
		
		if(head.next==null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null && fast.next!=null) {
			
			if(slow==fast) {
				return true;
			}
			
			if(fast.next==null) {
				return false;
			}
			
			fast = fast.next.next;
			slow = slow.next;
		}
	
		return false;
	}

}
