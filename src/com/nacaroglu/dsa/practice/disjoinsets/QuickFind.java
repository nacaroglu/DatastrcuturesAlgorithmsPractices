package com.nacaroglu.dsa.practice.disjoinsets;

public class QuickFind {

	private int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {        
        return root[x];        
    }
		
    public void union(int x, int y) {
    	
    	int xVal = find(x);
    	int yVal = find(y);
    	
    	if (xVal != yVal) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == yVal) {
                    root[i] = xVal;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) throws Exception {
    	 QuickFind uf = new QuickFind(10);
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
