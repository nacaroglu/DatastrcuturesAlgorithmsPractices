package com.nacaroglu.dsa.practice.binarytree.postfix;

public class TreeNode extends Node{
    
    public TreeNode(String v){
        val = v;
    }
    
    public int  evaluate(){
        
         if(Character.isDigit(val.charAt(0))){
        	 
             return Integer.valueOf(val);
         }
        
        if(val.equals("+")){
        	int result = right.evaluate() + left.evaluate();
        	System.out.println("Toplama: " + result);
            return result;
        }else if(val.equals("-")){
        	int result = right.evaluate() - left.evaluate();
        	System.out.println("Cikarma: " + result);
            return result;
        }else if(val.equals("*")){
        	int result = right.evaluate() * left.evaluate();
        	System.out.println("Carpma: " + result);
            return result;
        }else if(val.equals("/")){
        	int result = right.evaluate() / left.evaluate();
        	System.out.println("Bolme: " + result);
            return result;
        }
        
        return Integer.MAX_VALUE;
    }
    
}

