package com.nacaroglu.dsa.practice.linkedlist;

class PalindromeChallenge {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(2);
		list1.insertAtEnd(1);
		System.out.print("1st ");
		list1.printList();
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		list2.insertAtEnd(6);
		list2.insertAtEnd(8);
		list2.insertAtEnd(6);
		list2.insertAtEnd(6);
		System.out.print("2nd ");
		list2.printList();
		System.out.println("Is 1st list a palindrome?  " + isPalindrome(list1));
		System.out.println("Is 2nd list a palindrome?  " + isPalindrome(list2));

	}

	public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {

		if (list.headNode == null || list.size == 0 || list.size == 1) {
			return true;
		}

		DoublyLinkedList.Node front = list.getHeadNode();
		DoublyLinkedList.Node end = list.getTailNode();

		int counter = 0;

		while (counter < list.getSize() / 2 && front != null && end != null) {

			if (front.data != end.data) {
				return false;
			}

			front = front.nextNode;
			end = end.prevNode;
		}

		return true;
	}
}
