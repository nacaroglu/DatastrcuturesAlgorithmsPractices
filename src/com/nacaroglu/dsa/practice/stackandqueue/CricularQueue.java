package com.nacaroglu.dsa.practice.stackandqueue;

public class CricularQueue {
	
	private final int SCALE_FACTOR =2 ;

	int capacity;
	int headIndex;
	int tailIndex;
	int[] list;
	int count;
	
	public static void main(String args[]) {
		
		CricularQueue cq = new CricularQueue(8);
		
		for(int i=0; i<8; i++) {
			cq.enqueu(i);
		}
		
		System.out.println(cq.count);
		
		System.out.println(cq.dequeu());
		System.out.println(cq.dequeu());
		System.out.println(cq.dequeu());
		cq.enqueu(9);
		cq.enqueu(10);
		cq.enqueu(11);
		cq.enqueu(12);
		cq.enqueu(13);
		
		System.out.println(cq.count);
	}
	
	
	public CricularQueue(int capacity) {
		super();
		this.capacity = capacity;
		list = new int[capacity];
		this.count = 0;
		tailIndex = -1;
		headIndex = 0;
	}	
	
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public void enqueu(int val) {
		
		if(count==capacity) {
			
			capacity = capacity * SCALE_FACTOR;
			int newList[] = new int[capacity];
			
			int newIndex = 0;
			for(int i=headIndex; i< list.length; i++) {
				newList[newIndex] = list[i];
				newIndex++;
			}
			
			if(tailIndex<headIndex) {
				for(int i=0; i<= tailIndex; i++) {
					newList[newIndex] = list[i];
					newIndex++;
				}
			}
			
			newList[count] = val;			
			headIndex =  0;
			tailIndex = count;	
			list = newList;
			 
			
		} else {
			tailIndex = (tailIndex + 1)%capacity;
			list[tailIndex]=val;			
		}
		
		count += 1;
	}
	
	public int dequeu() {
		int val = -1;
		
		val = list[headIndex];
		headIndex = (headIndex+1%capacity);
		count -= 1;
		
		return val;
	}
	
}
