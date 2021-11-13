package com.nacaroglu.dsa.practice.arrrays;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ReverseString rs = new ReverseString();
		
		char[] s = "hello".toCharArray();
		rs.reverseString(s);
		System.out.println(s);
		
		s = "ahmet faruk".toCharArray();
		rs.reverseString(s);
		System.out.println(s);

	}
	
	public void reverseString(char[] s) {
        
		if(s==null || s.length<=1) {
			return;
		}
		
		int start = 0;
		int end = s.length-1;
		
		for (int i = 0; i < s.length/2; i++) {
			swap(s, start+i, end-i);
		}
    }

	private void swap(char[] s, int i, int j) {
		
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;		
	}

}
