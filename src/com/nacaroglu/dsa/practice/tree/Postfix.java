package com.nacaroglu.dsa.practice.tree;

import com.nacaroglu.dsa.practice.binarytree.postfix.Node;
import com.nacaroglu.dsa.practice.binarytree.postfix.TreeBuilder;


public class Postfix {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		TreeBuilder tb = new TreeBuilder();
		
		String[] postfix = {"3","4","+","2","*","7","/"};
		
		Node node = tb.buildTree(postfix);		
		System.out.println(node.evaluate());
		
		

		String[] postfix2 = {"4","5","7","2","+","-","*"};
		System.out.println(tb.buildTree(postfix2).evaluate());
		
		String[] postfix3 = {"4","2","+","3","5","1","-","*","+"};
		System.out.println(tb.buildTree(postfix3).evaluate());
		
		String[] postfix4 = {"100","200","+","2","/","5","*","7","+"};
		System.out.println(tb.buildTree(postfix4).evaluate());
		
	}
	
	



	
	

}
