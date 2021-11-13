package com.nacaroglu.dsa.practice.linkedlist;

public class MergeTwoSortedList {

	public static class ListNode<T> {
		public T val;
		public ListNode<T> next;
		
		public ListNode(T data) {
			super();
			this.val = data;
		}
		
		
	}

	public static void main(String[] args) {
		
		ListNode<Integer> L1 = new ListNode<Integer>(1);
		L1.next = new ListNode<Integer>(2);
		L1.next.next = new ListNode<Integer>(4);
		
		ListNode<Integer> L2 = new ListNode<Integer>(1);
		L2.next = new ListNode<Integer>(3);
		L2.next.next = new ListNode<Integer>(4);
		
		ListNode<Integer> result = merge(L1, L2);
		while(result!= null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2) {	
		
		if(l1==null) 
			return l2;
		
		if(l2==null)
			return l1;
		
		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> node = head;
		
		while(l1!=null && l2!= null) {
			
			if(l1.val<l2.val) {
				node.next = l1;
				l1= l1.next;
			}else {
				node.next = l2;
				l2 = l2.next;
			}
			
			node = node.next;
		}
		
		if(l1!= null) {
			node.next= l1;
		}
		
		if(l2!=null) {
			node.next=l2;
		}		

		return head.next;
	}	
	
	public static ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2) {	
		
		if(l1==null && l2==null) {
			return null;
		}
		
		if(l2==null && l1!= null) {
			return l1;
		}
		
		if(l1==null && l2!=null) {
			return l2;
		}	
		
		if(l1.val<l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}else {
			l2.next = merge(l1, l2.next);
			return l2;
		}

	}
}
