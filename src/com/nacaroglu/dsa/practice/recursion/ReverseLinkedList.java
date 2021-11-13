package com.nacaroglu.dsa.practice.recursion;

public class ReverseLinkedList {

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
		
		ReverseLinkedList rll = new ReverseLinkedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		/*head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);*/

		ListNode resultNode = rll.reverseList(head);
		while(resultNode!=null) {
			System.out.print(resultNode.val + ", ");
			resultNode = resultNode.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {
        
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode newHead = head;
		ListNode prev = head;
		ListNode curr = head.next;
		
		while(curr!=null) {
			
			ListNode nextNode = curr.next;
			prev.next = curr.next;
			curr.next = newHead;
			newHead = curr;
			curr = nextNode;
		}
		
		return newHead;
    }

}
