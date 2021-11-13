package com.nacaroglu.dsa.practice.heaps;

import java.util.PriorityQueue;

public class MedianOfAStream {
	
	PriorityQueue<Integer>minQ;	
	PriorityQueue<Integer>maxQ;

	public MedianOfAStream() {
		super();		
		this.minQ = new PriorityQueue<>((n1, n2) -> n1 - n2);
		this.maxQ = new PriorityQueue<>((n1, n2) -> n2 - n1);
	}

	public void insertNum(int num) {		
		
		 if (maxQ.isEmpty() || maxQ.peek() >= num)
		      maxQ.add(num);
		    else
		      minQ.add(num);
		
		 if (maxQ.size() > minQ.size() + 1)
		      minQ.add(maxQ.poll());
		    else if (maxQ.size() < minQ.size())
		      maxQ.add(minQ.poll());
	}

	public double findMedian() {
		
		if (maxQ.size() == minQ.size()) {
		      // we have even number of elements, take the average of middle two elements
		      return maxQ.peek() / 2.0 + minQ.peek() / 2.0;
		    }
		    // because max-heap will have one more element than the min-heap
		    return maxQ.peek();
	}

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(9);
		medianOfAStream.insertNum(27);
		medianOfAStream.insertNum(6);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}

}
