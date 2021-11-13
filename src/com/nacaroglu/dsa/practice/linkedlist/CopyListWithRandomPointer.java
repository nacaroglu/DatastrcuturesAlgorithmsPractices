package com.nacaroglu.dsa.practice.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;

import com.nacaroglu.dsa.practice.linkedlist.CopyListWithRandomPointer.Node;

public class CopyListWithRandomPointer {

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
		
		 @Override
			public String toString() {
				return "Node [val=" + val + "]";
			}
	}

	public static void main(String[] args) {

		CopyListWithRandomPointer c = new CopyListWithRandomPointer();

		Node head = new Node(7);

		Node node13 = new Node(13);
		head.next = node13;

		Node node11 = new Node(11);
		node13.next = node11;

		Node node10 = new Node(10);
		node11.next = node10;

		Node node1 = new Node(1);
		node10.next = node1;

		head.random = null;
		node13.random = head;
		node11.random = node1;
		node10.random = node11;
		node1.random = head;

		Node result = c.copyRandomList(head);

		System.out.println("Bitti...");
	}

	public Node copyRandomList(Node head) {
		
		Node myNode = head;
		Node newHead = null;
		Node prevNewNode = null;
		
		HashMap<Node, Integer> nodes = new HashMap<Node,Integer>();	
		
		while(myNode!= null) {		
			
			Node newNode = new Node(myNode.val);
			if(prevNewNode!= null) 	prevNewNode.next = newNode;
			
			if(newHead==null) {
				newHead = newNode;
			}
			
			int ix = getRandomNodeIndex(myNode.random, head);
			
			nodes.put(newNode, ix);
			
			prevNewNode = newNode;			
			myNode = myNode.next;			
		}
		
		Node myNode2 = newHead;
		
		while(myNode2!= null) {
			
			int index = nodes.get(myNode2);
			myNode2.random = getNodeAtIndex(newHead, index);
			
			myNode2 = myNode2.next;
		}

		return newHead;
	}

	private int getRandomNodeIndex(Node random, Node head) {
		
		Node myNode = head;
		
		int index = 0;
		
		while(myNode!= null) {	
		
			if(random == myNode)
			{
				return index;
			}
			
			myNode = myNode.next;	
			index ++;
		}
		
		
		return -1;
	}
	
	private Node getNodeAtIndex( Node head, int index) {
		
		Node myNode = head;
		
		int i = 0;
		
		while(myNode!= null) {	
		
			if(i == index)
			{
				return myNode;
			}
			
			myNode = myNode.next;	
			i ++;
		}
		
		
		return null;
	}

}
