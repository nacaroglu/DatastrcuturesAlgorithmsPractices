package com.nacaroglu.dsa.practice.linkedlist;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }

	@Override
	public String toString() {
		return "[value= " + value + "]";
	}
	  
  
}

class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
   
	ListNode result =  helper(head, k);   
	  
    return result;
  }

  private static ListNode helper(ListNode head, int k) {
	  
	  if(head==null)
		  return head;
	
	  ListNode current = head;
	  int counter = 0;
	  
	  while(current!=null && counter<k) {
		  current = current.next;
		  counter++;
	  }
	  
	  if(counter<k) {
		  //base case
		  return head;
	  }else {  
		  
		  ListNode newTail = helper(current, k);
		 		  
		  ListNode newHead = doReverse(head, current, k);
		  
		  
		  
		  return newHead;
	  }
	
}

private static ListNode doReverse(ListNode head, ListNode tail, int k) {
	
	ListNode prev = null;	
	ListNode curr = head;	
	
	while(k>0) {
		
		ListNode tempNext = curr.next;
		curr.next = prev;
		prev = curr;
		curr = tempNext;
		k --;
	}
	
	head.next = tail;
	
	return prev;
}

public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);
    head.next.next.next.next.next.next.next.next = new ListNode(9);
    head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
    head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
    head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);
    head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(14);


    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
