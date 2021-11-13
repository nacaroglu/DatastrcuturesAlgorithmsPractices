package com.nacaroglu.dsa.practice.recursion;

public class NQueens_2 {

	public static void main(String[] args) {
		
		NQueens_2 nq = new NQueens_2();
		System.out.println(nq.totalNQueens(8));
	}
	
	/*
	 	def backtrack_nqueen(row = 0, count = 0):
	    for col in range(n):
	        # iterate through columns at the curent row.
	        if is_not_under_attack(row, col):
	            # explore this partial candidate solution, and mark the attacking zone
	            place_queen(row, col)
	            if row + 1 == n:
	                # we reach the bottom, i.e. we find a solution!
	                count += 1
	            else:
	                # we move on to the next row
	                count = backtrack(row + 1, count)
	            # backtrack, i.e. remove the queen and remove the attacking zone.
	            remove_queen(row, col)
	    return count
	 */
	
	public int totalNQueens(int n) {
		
		boolean board[][] = new boolean[n][n];
		return backtrack(0, 0, board);
	}

	private int backtrack(int row, int count, boolean[][] board) {
		
		for(int col=0; col<board.length; col++) {
			
			if(!is_under_attack(row,col, board)) {
				
				place_queen(row, col, board);
				
				if(row+1==board.length) {
					count += 1;
				}else {
					count = backtrack(row+1, count, board);
				}				
			
				remove_queen(row,col, board);
			}
		}

		return count;
	}

	private void place_queen(int row, int col, boolean[][] board) {		
		board[row][col] = true;		
	}

	private void remove_queen(int row, int col, boolean[][] board) {
		board[row][col] = false;		
	}

	private boolean is_under_attack(int row, int col, boolean[][] board) {
		
		// row search
		for(int i=0; i<board.length; i++) {
			if(i==col) {
				continue;
			}
			
			if(board[row][i]) {
				return true;
			}
		}
		
		// column search
		for(int i=0; i<board.length; i++) {
			if(i==row) {
				continue;
			}
			
			if(board[i][col]) {
				return true;
			}
		}
		
		// right diagonal below
		for(int i=row+1, j=col+1 ; i<board.length && j<board.length; i++, j++) {
			
			if(board[i][j]) {
				return true;
			}
		}
		
		// left diagonal upper
		for(int i=row-1, j=col-1 ; i>=0 && j>=0; i--, j--) {
			
			if(board[i][j]) {
				return true;
			}
		}
		
		// left diagonal below
		for(int i=row+1, j=col-1 ; i<board.length && j>=0; i++, j--) {
			
			if(board[i][j]) {
				return true;
			}
		}
		
		// right diagonal upper
		for(int i=row-1, j=col+1 ; i>=0 && j<board.length; i--, j++) {
			
			if(board[i][j]) {
				return true;
			}
		}		

		return false;
	}

}
