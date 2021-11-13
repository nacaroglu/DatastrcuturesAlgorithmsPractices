package com.nacaroglu.dsa.practice.backtracking;

public class WordSearch {

	public static void main(String[] args) {
			
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		
		//char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
				
	
		WordSearch s = new WordSearch();
		
		//System.out.println(s.exist(board, "ABCESEEEFS"));
		
		
		System.out.println(s.exist(board, "ABCCED"));		
		System.out.println(s.exist(board, "SEE"));
		System.out.println(s.exist(board, "SEEN"));
		System.out.println(s.exist(board, "SEED"));
		System.out.println(s.exist(board, "CESEEDA"));
		
		
		char[][] board2 = {{'b','a'}};
		//System.out.println(s.exist(board2, "ab")); */
	}
	
	
	 public boolean exist(char[][] board, String word) {
			
			int r = board.length;
			int c = board[0].length;		
			
			 for (int row = 0; row < r; ++row)
			      for (int col = 0; col < c; ++col) {
			    	  boolean visited[][] = new boolean[r][c];
			    	  if(backtrack(word.toCharArray(), 0, board, row, col, visited)) {
			    		  return true;
			    	  }
			      }
			
			return false;			
	    }


		private boolean backtrack(char[] word, int i, char[][] board, int r, int c, boolean visited[][]) {
						
							
			if(word[i]==board[r][c]) {
				i = i+1;
			}
			else{
				return false;
			}
			
			if(i==word.length) {
				return true;
			}
			
			
			if(canMove(r,c+1,board, visited)) {			
				if(backtrack(word, i, board, r, c+1, visited)) {
					visited[r][c] = true;
					return true;				
				};
			}
			
			if(canMove(r,c-1,board, visited)) {	
				if(backtrack(word, i, board, r, c-1, visited)) {
					visited[r][c] = true;
					return true;
				};
			}
			
			if(canMove(r+1,c,board, visited)) {	
				if(backtrack(word, i, board, r+1, c, visited)) {	
					visited[r][c] = true;
					return true;
				};
			}
			
			if(canMove(r-1,c,board, visited)) {	
				if(backtrack(word, i, board, r-1, c, visited)) {
					visited[r][c] = true;
					return true;
				};
			}
			
			return false;
		}


		private boolean canMove(int r, int c, char[][] board, boolean visited[][]) {
			
			
			
			if(r<0 ||  r==board.length || c<0 || c==board[0].length ) {
				return false;
			}
			
			if(visited[r][c]) {
				return false;
			}
			
			
			
			return true;
		}
}
