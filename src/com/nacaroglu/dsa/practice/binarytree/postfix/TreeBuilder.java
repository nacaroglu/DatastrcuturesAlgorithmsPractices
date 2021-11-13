package com.nacaroglu.dsa.practice.binarytree.postfix;

import java.util.Stack;

public class  TreeBuilder {
    public Node buildTree(String[] postfix) {
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = null;
        
        for(int i=0; i< postfix.length; i++){
            
            if(Character.isDigit(postfix[i].charAt(0))){
                stack.add(new TreeNode(postfix[i]));
            }else {
                if(node == null){
                    node = new TreeNode(postfix[i]);
                    node.left = stack.pop();
                    node.right = stack.pop();
                }else{
                    
                    TreeNode newNode = new TreeNode(postfix[i]);
                    newNode.right = stack.pop();
                    newNode.left = node;
                    node = newNode;
                }
            }
        }
        
        return node;
    }
};
