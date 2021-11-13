package com.nacaroglu.dsa.practice.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
	
	public static void main(String[] args) {
		
		ReverseWords reverse = new ReverseWords();
		char[] input = "Alice likes Bob".toCharArray();
		System.out.println(reverse.reverseWords(input));		
	}
	
	public char[] reverseWords(char[] input) {
		
		if(input==null || input.length==0) {
			return input;
		}
		
		int currentSize = 0;	
		int size = input.length;
		List<Integer> wordSizes = findWordSizes(input, currentSize);
		
		char[] newArr = new char[size];
		
		int write = 0;
		int read = 0;
		int prevSizeSum = 0;
		for(int i=0; i<=wordSizes.size()-1; i++) {
			currentSize = wordSizes.get(wordSizes.size()-1-i);
			
			read = size-(currentSize+prevSizeSum) - (i);
			
			for(int j=0; j< currentSize; j++ ) {
				newArr[write] = input[read];
				write++;
				read++;
			}
			
			prevSizeSum = prevSizeSum+currentSize;
			//newArr[write] = '\n';
			write++;
		}
		
		return newArr;
		
	}

	private List<Integer> findWordSizes(char[] input, int currentSize) {
		List<Integer> wordSizes = new ArrayList<Integer>(); 
		
			
		for(int i=0; i<input.length; i++) {
			
			if(!Character.isSpace(input[i])) {
				currentSize++;
			}else {
				wordSizes.add(currentSize);
				currentSize=0;				
			}
		}
		
		wordSizes.add(currentSize);
		return wordSizes;
	}

}
