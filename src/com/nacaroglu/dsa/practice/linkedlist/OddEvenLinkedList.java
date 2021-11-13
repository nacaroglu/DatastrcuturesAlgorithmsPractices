package com.nacaroglu.dsa.practice.linkedlist;



public class OddEvenLinkedList {
	
	static class ListNode {
	    public int val;
	    public ListNode next;

	    public ListNode() {}

	    public ListNode(int _val) {
	        val = _val;
	    }

	    public ListNode(int _val, ListNode _next) {
	        val = _val;
	        next = _next;
	    }
	    
	    @Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
	}

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		OddEvenLinkedList oell = new OddEvenLinkedList();
		System.out.println(oell.oddEvenList(head));
		
		// 2->1->3->5->6->4->7->NULL
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(1);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(5);
		head2.next.next.next.next = new ListNode(6);
		head2.next.next.next.next.next = new ListNode(4);
		head2.next.next.next.next.next.next = new ListNode(7);
		//System.out.println(oell.oddEvenList(head2));
		
		ListNode head3 = new ListNode(2);		
		//System.out.println(oell.oddEvenList(null));
	}
	
public ListNode oddEvenList(ListNode head) {
        
        if(head==null){
            return head;
        }
        
        ListNode tekHead=null; 
        ListNode tekNode=null;       
        
        if(head.next==null){
            return head;
        }
        
        
        ListNode ciftHead= head.next;
        ListNode ciftNode = head.next;
        
        ListNode curr = head;
        int counter = 0;
        
        while(curr!=null){
        	
        	ListNode next  = curr.next;
            
            if(counter%2==0){
                tekNode.next = curr; 
            }else{
                ciftNode.next = curr;
            }
            
            counter++;
            curr = next;
            
            System.out.println(curr.val);
        }
        
        tekNode.next = ciftHead;
        return tekHead;       
        
    }
	
	public ListNode oddEvenList2(ListNode head) {
		
		if(head==null) {
			return null;
		}
		
		ListNode tekHead=null, ciftHead=null;
		ListNode prevTek=null, prevCift= null;
		
		ListNode curr = head;
		int i = 1;
		
		while(curr!= null) {
			
			if(i%2==1) {
				
				if(tekHead==null) {
					tekHead = curr;					
				}else {
					prevTek.next = curr;					
				}	
				
				prevTek = curr;
				
			}else {
				if(ciftHead==null) {
					ciftHead=curr;					
				}else {
					prevCift.next = curr;					
				}
				
				prevCift = curr;
			}
			
			curr = curr.next;
			i++;
		}
		
		if(prevCift!=null) prevCift.next = null;
		if(prevTek!=null)  prevTek.next = null;
		
		if(prevTek!= null) 
			prevTek.next = ciftHead;
		
		return tekHead;        
    }

}
