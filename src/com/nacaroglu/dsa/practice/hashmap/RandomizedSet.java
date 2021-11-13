package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class RandomizedSet {

	public static void main(String[] args) {
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		
		/*
			["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
			[[],				[1],	[2],	[2],	[],			[1],		[2]	,[]]					
		 */
		
		
		/*
		RandomizedSet s = new RandomizedSet();
		System.out.println(s.insert(1));
		System.out.println(s.remove(2));
		System.out.println(s.insert(2));
		System.out.println(s.getRandom());
		System.out.println(s.remove(1));
		System.out.println(s.insert(2));
		System.out.println(s.getRandom());
		
		/*
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
		randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
		randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
		randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
		randomizedSet.insert(2); // 2 was already in the set, so return false.
		randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
		*/
		
		int [] a = {2,1,5};
		int K = 806;
		
		RandomizedSet randomizedSet = new RandomizedSet();
		//randomizedSet.addToArrayForm(a, K);
				
				
		randomizedSet.backspaceCompare("xywrrmp","xywrrmu#p");
		

	}
	
	 public boolean backspaceCompare(String S, String T) {
	        
		 Stack<Character> sStack = new Stack<Character>();
		 Stack<Character> tStack = new Stack<Character>();
		 
		 for(int i=0; i< S.length(); i++) {
			 
			 if(S.charAt(i)!= '#') {
				 sStack.push(S.charAt(i));
			 }else {
				 if(!sStack.isEmpty()) {
					 sStack.pop();
				 }
			 }
		 }
		 
		 
		 for(int i=0; i< T.length(); i++) {
			 
			 if(T.charAt(i)!= '#') {
				 tStack.push(T.charAt(i));
			 }else {
				 if(!tStack.isEmpty()) {
					 tStack.pop();
				 }
			 }
		 }
		 
	     if(sStack.size()!= tStack.size()) {
	    	 return false;
	     }
	     
	     while(!sStack.isEmpty() && !tStack.isEmpty()) {
	    	 if(sStack.pop()!=tStack.pop()) {
	    		 return false;
	    	 }
	     }
		 
	     return true;  
	}
	
public List<Integer> addToArrayForm(int[] A, int K) {
        
	 List<Integer> kList = new ArrayList<Integer>();
     
     String kStr = String.valueOf(K);
     
     for(int i=0; i<kStr.length(); i++){
        kList.add(Integer.valueOf(kStr.substring(i, i+1)));
     }
     
     int carry = 0;
     
     int size = Math.max(A.length, kList.size());
     
    LinkedList<Integer> result = new LinkedList();     
     
     for(int i=1; i<=size; i++){
         
         int aDigit = 0;
         
         if(i<=A.length){
             aDigit = A[A.length-i];
         }
         
         int kDigit = 0;
         
         if(i<=kList.size()){
             kDigit = kList.get(kList.size()-i);
         }
         
         int sum = aDigit + kDigit + carry;
         
         if(sum>9){
             carry = 1;
         }else{
             carry = 0;
         }
         
         result.addFirst(sum%10);
     }
     
    
     if(carry==1){            
         result.addFirst(1);
     }         
       
    // Collections.reverse(result);
     
     return result;
    }
	
	Set<Integer> set;    

    /** Initialize your data structure here. */
    public RandomizedSet() {        
        set = new HashSet<Integer>();        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(set.contains(val)){
            return false;
        }else{
            set.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    
	/** Get a random element from the set. */
	public int getRandom() {

		Random rnd = new Random();
		int index = rnd.nextInt(set.size());		

		Integer arr[] = new Integer[set.size()];
		set.toArray(arr);
		
		int x = arr[index];
		set.remove(x);

		return x;
	}
}
