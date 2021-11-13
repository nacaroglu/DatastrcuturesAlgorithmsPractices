package com.nacaroglu.dsa.practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "val: " + val;
		}		
	}

	public static void main(String[] args) {
		

	

		
		//TreeNode root = buildTree1();
		
		Codec codec= new Codec();
		TreeNode node = codec.deserialize("1,2,3,null,null,4,5");
		String data = codec.serialize(node);
		
		System.out.println("Bitti");

	}


	private static TreeNode buildTree1() {
		
		
		/*
   		3
	   / \
	  9   20
	 /   /  \
	18  15   7
 */
		TreeNode node_9 = new TreeNode(9);
		TreeNode node_20 = new TreeNode(20);
		
		TreeNode root = new TreeNode(3);
		root.left = node_9;
		root.right = node_20;
		
		TreeNode node_18 = new TreeNode(18);
		node_9.left = node_18;
		
		TreeNode node_15 = new TreeNode(15);
		TreeNode node_7 = new TreeNode(7);
		node_20.left = node_15;
		node_20.right = node_7;
		return root;
	}
	
	

    
    public String serialize(TreeNode root) {
		
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		
		myQueue.add(root);
		
		HashMap<TreeNode, String> treeMap = new HashMap<TreeNode, String>(); 
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		
		while(!myQueue.isEmpty()) {
			
			TreeNode node  = myQueue.poll();

			//System.out.println(node.val);
			list.add(node);

			
			if(node.left!= null) {
				myQueue.add(node.left);				
			}			
			else{
				treeMap.put(node, "Left");
			}
			
			if(node.right!=null) {
				myQueue.add(node.right);				
			}
			else {
				treeMap.put(node, "Right");
			}			
		}	
		
		list.addFirst(null);
		
		for (int i = 0; i < list.size(); i++) {
			
			if(treeMap.containsKey(list.get(i))){
				
				if(treeMap.get(list.get(i)).equalsIgnoreCase("Left")) {
					list.add(2*i, null);
				}else {
					list.add(2*i+1, null);
				}				
			}			
		}		
		
		StringBuffer sb = new StringBuffer(); 
		
		for (int i = 1; i < list.size(); i++) {
			
			TreeNode node = list.get(i);
			if(node== null) {
				sb.append("null");
			}else {
				sb.append(node.val);
			}
			
			if(i!=list.size()-1) {
				sb.append(",");
			}			
		}
		
		return sb.toString();
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	
    	String[] nodes = data.split(",");
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>(); 
    	
    	for (int i = 0; i < nodes.length; i++) {
    		if(nodes[i].equals("null")){
    			list.add(null);
    		}else {
    			list.add(new TreeNode(Integer.valueOf(nodes[i])));
    		}			
		}
    	
    	list.addFirst(null);
    	    	
    	for (int i = 1; i < list.size(); i++) {
    		
    		if(2*i<list.size()) {
    			list.get(i).left = list.get(2*i);
    		}		
    		
    		if(2*i+1<list.size()) {
    			list.get(i).right = list.get(2*i+1);
    		}   		
		}
        
    	return list.get(1);
    }

}
