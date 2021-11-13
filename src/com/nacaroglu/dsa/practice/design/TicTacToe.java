package com.nacaroglu.dsa.practice.design;

public class TicTacToe {

	public static void main(String[] args) {
		/*
		TicTacToe t = new TicTacToe(3);
		
		// ["TicTacToe", "move", 	"move",		"move", 	"move", 	"move", 	"move", 	"move"]
		//[[3],			 [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], 	[2, 0, 1], [1, 0, 2], 	[2, 1, 1]]//
		
		System.out.println(t.move(0, 0, 1));
		System.out.println(t.move(0, 2, 2));
		System.out.println(t.move(2, 2, 1));
		System.out.println(t.move(1, 1, 2));
		System.out.println(t.move(2, 0, 1));
		System.out.println(t.move(1, 0, 2));
		System.out.println(t.move(2, 1, 1));
		
		
		
		//	["TicTacToe","move","move","move"]
		//	[[2],[0,1,1],[1,1,2],[1,0,1]]
		TicTacToe t2 = new TicTacToe(2);
		System.out.println(t2.move(0, 1, 1));
		System.out.println(t2.move(1, 1, 2));
		System.out.println(t2.move(1, 0, 1));
		*/
		
		// ["TicTacToe","move",	"move",	"move",	"move",	"move",	"move"]
		//[[3],			[1,2,2],[0,2,1],[0,0,2],[2,0,1],[0,1,2],[1,1,1]]
		TicTacToe t3 = new TicTacToe(3);
		System.out.println(t3.move(1,2,2));
		System.out.println(t3.move(0,2,1));
		System.out.println(t3.move(0,0,2));
		System.out.println(t3.move(2,0,1));
		System.out.println(t3.move(0,1,2));
		System.out.println(t3.move(1,1,1));
		
		
		
	}

	int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	
    	board[row][col] = player;
    	
    	boolean oppositeFound = false;
        
    	// scan diagonal
    	if(row==col) {
    		
    		for(int i=0; i<board.length; i++) {
    			if(board[i][i]!= player) {
    				oppositeFound= true;
    				break;
    			}
    		} 
    		
    		if(!oppositeFound) {
        		return player;
        	} 
    	}
    	
    	oppositeFound = false;
    	// scan diagonal
    	if(row+col+1==board.length) {
    		
    		int r = 0;
    		int c = board[0].length-1;
    		
    		while(r<board.length && c>=0) {
    			 		
    			if(board[r][c]!= player) {
    				oppositeFound= true;
    				break;
    			}
    			
    			r++;
    			c--;
    		} 
    		
    		if(!oppositeFound) {
        		return player;
        	} 
    	}   
    	
    	oppositeFound = false;
    	for(int c=0; c< board.length; c++) {
    		if(board[row][c]!= player) {
    			oppositeFound= true;
				break;
			}
    	}
    	
    	if(!oppositeFound) {
    		return player;
    	}
    	
    	oppositeFound = false;
    	for(int r=0; r< board[0].length; r++) {
    		if(board[r][col]!= player) {
    			oppositeFound= true;
				break;
			}
    	}
    	
    	if(!oppositeFound) {
    		return player;
    	}
    	
    	return 0;    	
    }

}
