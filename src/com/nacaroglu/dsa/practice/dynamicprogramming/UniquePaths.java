package com.nacaroglu.dsa.practice.dynamicprogramming;

public class UniquePaths {

	public static void main(String[] args) {
				
		UniquePaths up  = new UniquePaths();
		
		System.out.println(up.uniquePaths(10, 20));
				

	}
	
	public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        int foo = helper(0, 0, dp, m, n);
        
        return foo;
    }
    
    public int helper(int row, int col, int[][] dp, int m, int n){
        
        if(m-1==row && n-1==col){
        	dp[row][col] = 0;
            return 1;
        }
        
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int down =  -1;        
        if(row+1<m) {
            down = helper(row+1, col, dp, m, n);
        }   
        
        int right = -1;
        if(col+1<n){
            right = helper(row, col+1, dp, m, n);
        }
        
        int sum = 0;
        if(down!=-1){
            sum = sum + down;
        }
        
        if(right != -1){
            sum = sum + right;
        }
        
        dp[row][col] = sum;
        
        return sum;
    }

}
