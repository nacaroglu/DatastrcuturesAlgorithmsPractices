package com.nacaroglu.leetcode.practice.linkedlist;

import org.junit.Test;

import com.nacaroglu.dsa.practice.linkedlist.FlattenMultilevelDoublyLinkedList;
import com.nacaroglu.dsa.practice.linkedlist.FlattenMultilevelDoublyLinkedList.Node;

public class FlattenMultilevelDoublyLinkedListTest {

	@Test
	public void test() {
		FlattenMultilevelDoublyLinkedList f = new FlattenMultilevelDoublyLinkedList();
		Node head = new Node();
		f.flatten(head);
	}
}
