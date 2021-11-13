package com.nacaroglu.dsa.practice.tree;

public class LowestCommonAncestorParent {

	public static void main(String[] args) {
		
		LowestCommonAncestorParent lca = new LowestCommonAncestorParent();
		
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(5); 
		root.left.parent = root;
		
		root.right = new TreeNode(1);
		root.right.parent = root;
		
		root.left.left = new TreeNode(6);
		root.left.left.parent = root.left;
		
		root.left.right = new TreeNode(2);
		root.left.right.parent = root.left;
		
		root.left.right.left = new TreeNode(7);
		root.left.right.left.parent = root.left.right;
		
		root.left.right.right = new TreeNode(4);
		root.left.right.right.parent = root.left.right;
		
		root.right.left = new TreeNode(0);
		root.right.left.parent = root.right;
		
		root.right.right = new TreeNode(8);
		root.right.right.parent = root.right;
		
		System.out.println(lca.lowestCommonAncestor(root, root.left.left, root.right.left).val);

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		int depthP = findDepth(p);
		int depthQ = findDepth(q);
		
		if(depthQ>depthP) {
			TreeNode temp = p;
			p = q;
			q = temp;
			int temDepth = depthQ;
			depthQ = depthP;
			depthP = temDepth;
		}
		
		for(int i=depthP-depthQ; i>=1; i--) {
			 p = p.parent;
		}
						
		TreeNode result = null;
		while(p!=null && q!= null) {
			if(p==q) {
				return p;
			}
			
			p = p.parent;
			q = q.parent;
		}	
		
		return result;
	}

	private int findDepth(TreeNode n) {
		
		int depth = 1;
		
		while(n.parent!=null) {
			n = n.parent;
			depth++;
		}
		
		return depth;
	}
	
	
}
