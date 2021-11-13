package com.nacaroglu.dsa.practice._mixed;

public class NextLetter {

	public static void main(String[] args) {
	    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
	    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
	    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
	    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	  }

	public static char searchNextLetter(char[] letters, char key) {
		
		if(letters==null || letters.length==0) {
			return 'a';
		}
		
		if(key>=letters[letters.length-1]) {
			return letters[0];
		}
		
		int low = 0;
		int high = letters.length-1;
		int mid  = 0;		
		
		while(low<=high) {
		
			mid = low + (high-low)/2;
			
			if(letters[mid]==key) {				
				return letters[mid];
			}
			
			if(letters[mid]<key) {				
				low = mid+1;
			}else {	
				
				high = mid-1;
			}				
		}	

		return letters[low];
	}
}
