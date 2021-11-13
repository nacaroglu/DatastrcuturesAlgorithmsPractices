package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

	public static void main(String[] args) {
		
		SudokuSolver ss = new SudokuSolver();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		ss.solveSudoku(board);
		
		System.out.println("bitti..");

	}
	
	
	/*
		  def backtrack(candidate):
	    if find_solution(candidate):
	        output(candidate)
	        return
	    
	    # iterate all possible candidates.
	    for next_candidate in list_of_candidates:
	        if is_valid(next_candidate):
	            # try this partial candidate solution
	            place(next_candidate)
	            # given the candidate, explore further.
	            backtrack(next_candidate)
	            # backtrack
	            remove(next_candidate)
	 */
	
	
	
	public void solveSudoku(char[][] board) {        
		backtrack(0,0, board);        
    }

	private boolean backtrack(int col, int row, char[][] board) {
						
		if (col == board.length) {
			col = 0; // Starts a new row.
			row++;
			
			if (row == board.length) {
				return true;
			}
		}		
		
		if(board[row][col]!= '.') {
			return backtrack(col+1, row, board);			
		}				
		
		for(int val =1; val<=board[row].length; val++) {								
			
			if(canplace(board, row, col, val)) {				
				board[row][col] = (char) ('0' + (val));				
				if(backtrack(col+1, row, board)) {
					return true;
				}
			}
		}	
		
		board[row][col] = '.';
		return false;		
	}


	private boolean canplace(char[][] board, int row, int column, int val) {
		
		// row scan		
		for(int c=0; c<board.length; c++) {
			if(board[row][c]-'0' == (char)val) {
				return false;
			}
		}
		
		// column scan
		for(int r=0; r<board.length; r++) {		
			
			if( board[r][column] - '0'== (char)val) {
				return false;
			}
		}
		
		// sub square scan
		int r = row/3;
		int c = column/3;
		
		for(int i=0;i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[r*3+i][c*3+j]-'0' ==(char)val) {
					return false;
				}
			}
		}
		
		return true;
	}
}
