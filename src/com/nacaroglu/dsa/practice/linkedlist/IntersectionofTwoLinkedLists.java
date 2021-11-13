package com.nacaroglu.dsa.practice.linkedlist;

public class IntersectionofTwoLinkedLists {
	
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
		

	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		int sizeA = findSize(headA);
		int sizeB = findSize(headB);
		
		ListNode smallHead = headA;
		ListNode bigHead = headB;
		
		int skipCount = Math.abs(sizeA - sizeB);
		
		if(sizeA>sizeB) {
			smallHead = headB;
			bigHead = headA;
		}
		
		int skipIndex = 0;
		while(bigHead!=null && skipIndex<skipCount) {
			bigHead = bigHead.next;
			skipIndex++;		
		}
		
		
		while(smallHead!= null && bigHead!= null) {
			if(smallHead==bigHead) {
				return smallHead;
			}
			
			smallHead= smallHead.next;
			bigHead = bigHead.next;
		}		 
        
		return null;
    }

	private int findSize(ListNode headA) {
		
		int count = 0;
		
		ListNode node = headA;
		
		while(node!= null) {
			node = node.next;
			count++;
		}
		
		return count;
	}

}
