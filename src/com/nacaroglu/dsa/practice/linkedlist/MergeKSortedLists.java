package com.nacaroglu.dsa.practice.linkedlist;

class MergeKSortedLists {

	public static class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

	public static ListNode merge(ListNode[] lists) {
				
		if(lists == null) {
			return null;
		}
		
		if(lists.length==1) {
			return lists[0];			
		}
		
		ListNode l1 = lists[0];
		
		for(int i=1; i<lists.length; i++) {
			ListNode l2 = lists[i];
			l1 = doMerge(l1, l2);
		}
		
		return l1;
	}

	private static ListNode doMerge(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		
		while(l1!=null && l2!= null) {
			
			if(l1.value<l2.value) {
				current.next = l1;
				l1 = l1.next;
			}else {
				current.next = l2;
				l2 = l2.next;
			}
			
			current = current.next; 
		}
		
		while(l1!=null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		
		while(l2!=null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);

		ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
		System.out.print("Here are the elements form the merged list: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
