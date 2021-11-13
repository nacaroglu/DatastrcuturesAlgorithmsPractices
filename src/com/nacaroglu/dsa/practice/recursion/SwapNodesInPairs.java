package com.nacaroglu.dsa.practice.recursion;


public class SwapNodesInPairs {
	
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
		
				ListNode node4 = new ListNode(4, null);
		ListNode node3 = new ListNode(3, node4); 
		
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
	
		SwapNodesInPairs sp = new SwapNodesInPairs();
		ListNode node = sp.swapPairs(head);
		System.out.println(node);

	}
	
	public ListNode swapPairs(ListNode head) {
		
		if(head==null) {
			return head;
		}
		
		if(head.next==null) {
			return head;
		}		
		
		ListNode firstNode = head;		
		ListNode secondNode = head.next;
		
		
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;
		
		return secondNode;					
	}
	
	
	
	
	

	

}
