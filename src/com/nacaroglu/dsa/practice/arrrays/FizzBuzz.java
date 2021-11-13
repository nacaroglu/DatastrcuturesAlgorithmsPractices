package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		
		FizzBuzz f = new FizzBuzz();
		
		List<String> l = f.fizzBuzz(15);
		System.out.println(l);
		
		

	}
	
	public List<String> fizzBuzz(int n) {
        
		List<String> list = new ArrayList<String>();
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(3, "Fizz");
		map.put(5, "Buzz");
		
		for(int i=1; i<=n; i++) {
			
			String replacement = "";
			
			for (int x : map.keySet()) {
				
				if(i%x==0) {
					replacement += map.get(x);
				}
			}
			
			if(replacement.isEmpty()) {
				list.add(String.valueOf(i));
			}else {
				list.add(replacement);
			}		
		}
		
		return list;
    }

}
