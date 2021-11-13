package com.nacaroglu.dsa.practice.string;

public class ReplaceAndRemove {

	public static void main(String[] args) {
		
		ReplaceAndRemove rr =new ReplaceAndRemove();
		char[] s = {'a','c','d','b','b','c','a'};		
		
		System.out.println(rr.replaceAndRemove2(s.length, s));
		
		char[] s2 = {'a','b','a','c', '_'};
		System.out.println(rr.replaceAndRemove2(s2.length+1, s2));
	}
	
	public int replaceAndRemove (int size, char[] s) {
		
		int aCount = 0;
		int bCount = 0;
		
		for (char c : s) {
			if(c=='a') 
				aCount++;
			
			if(c=='b')
				bCount++;
			
		}
		
		char arr[ ] = new char[size+aCount-bCount];
		int read =0; 
		int write =0;
		
		while(read<size) {
			
			if(s[read]=='a') {
				arr[write]='d';
				arr[write+1] = 'd';
				write=write+2;				
			}else if(s[read]!='b') {			
				arr[write]= s[read];				
				write++;
			}
			
			read++;
		}
		
		return arr.length;
	}
	
	public int replaceAndRemove2 (int size, char[] s) {
		
		int aCount = 0;
		int bCount = 0;
		
		// clear b's
		for (int i = 0; i < s.length; i++) {
			
			if(s[i]=='a') 
				aCount++;
			
			if(s[i]=='b') {
				bCount++;
				s[i]='_';
			}
			
		} 
		
		
		int read = 0; 
		int write =0;
		
		// shift to left
		while(read<s.length) {
			
			s[write] = s[read];
			
			if(s[read]!='_') {
				write++;
			}
			
			read++;			
		}
		
		// write last n chars as "_"
		for(int i=0; i<bCount; i++) {
			s[s.length-i-1]='_';
		}
		
		read = s.length-1; 
		write =s.length-1;
		

		while(read>=0) {
					
			if(s[read]=='_') {				
				read--;
			}else if(s[read]!='a') {
				s[write] = s[read];
				write--;
				read--;
			}else {
				s[write] = 'd';
				s[write-1] = 'd';
				write = write-2;;
				read--;
			}				
		}
		
		return size;
	}

}
