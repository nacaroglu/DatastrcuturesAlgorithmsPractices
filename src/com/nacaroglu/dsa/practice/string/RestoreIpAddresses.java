package com.nacaroglu.dsa.practice.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> restoreIpAddresses(String s) {
		
		List<List<String>> result = new  ArrayList();
		
		helper(s,1,result);
        
        return null;
    }

	private void helper(String s, int partNo, List<List<String>> result) {
		
		if(s.length()==0) {
			return;
		}
		
		String strx = new String(s); 
		
		strx = s.substring(4-partNo);
		if(strx.length()>0) {
			strx = strx.substring(strx.length()-3);
		}
		
		
		
	}
}
