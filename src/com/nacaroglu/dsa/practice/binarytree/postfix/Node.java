package com.nacaroglu.dsa.practice.binarytree.postfix;

public abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String val;
    Node left;
    Node right;
	@Override
	public String toString() {
		return "Node [val=" + val +"]";
	}
    
    
};
