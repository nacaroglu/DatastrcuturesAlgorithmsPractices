package com.nacaroglu.dsa.practice.disjoinsets;

import java.util.HashSet;
import java.util.Iterator;

public class QuickUnion {

	private int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
        
        HashSet<Integer> set;
        
       
        
    }

    public int find(int x) {
        while(root[x]!= x) {
        	x = root[x];
        }
        return x;        
    }
		
    public void union(int x, int y) {
    	
    	int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) throws Exception {
        QuickUnion uf = new QuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(1, 3);
        uf.union(4, 8);
        uf.union(5, 6);
        uf.union(5, 7);
        
        for (int x : uf.root) {
			System.out.println(x);
		}
        
        System.out.println("------------");
        
        uf.union(7, 9);
        
        for (int x : uf.root) {
			System.out.println(x);
		}
        
        System.out.println(uf.connected(0, 2));
        System.out.println(uf.connected(1, 5));
        System.out.println(uf.connected(7, 8));
    }
}
