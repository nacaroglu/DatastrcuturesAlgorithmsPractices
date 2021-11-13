package com.nacaroglu.dsa.practice.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateList {
	
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
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		
		ListNode node5 = new ListNode(5, null);
		
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);		
		ListNode head = new ListNode(1, node2);
		
		RotateList rl = new RotateList();
		rl.rotateRight(head, 2);
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        
		if(head==null) return null;
		if(head.next==null) return head;
		
		ListNode tailNode = head;
		ListNode prevNode = null;
		int length = 1;
		
		while(tailNode.next!= null) {
			
			length++;
			prevNode = tailNode;
			tailNode = tailNode.next;
		}
		
		int numberOfRotation = k%length;
		
		
		for(int i=0; i<numberOfRotation; i++) {
			prevNode.next = null;
			tailNode.next = head;
			head = tailNode;
			tailNode = prevNode;
			prevNode = findPrev(head);
		} 
		
		return head;
    }
	
	private ListNode findPrev(ListNode head) {
		
		ListNode tailNode = head;
		ListNode prevNode = null;		
		
		while(tailNode.next!= null) {			
			
			prevNode = tailNode;
			tailNode = tailNode.next;
		}
		
		return prevNode;
	}
}
