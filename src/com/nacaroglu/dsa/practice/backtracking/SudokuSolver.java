package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SudokuSolver {

	public static void main(String[] args) {
		
		SudokuSolver ss = new SudokuSolver();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		ss.solveSudoku(board);

	}
	
	HashMap<Integer, HashSet<Character>> rowMap;
	HashMap<Integer, HashSet<Character>> colMap;
	HashMap<Integer, HashSet<Character>> boxMap;

	public void solveSudoku(char[][] board) {
		
		rowMap = new HashMap<Integer, HashSet<Character>>();
		colMap = new HashMap<Integer, HashSet<Character>>();
		boxMap = new HashMap<Integer, HashSet<Character>>();
		
		initRowMap(board);		
		initColMap(board);		
		initboxMap(board);

		backtrack(board, 0);
	}	

	public void backtrack(char[][] board, int row ) {

		for (int col = 0; col < board[0].length; col++) {

			if (row == board.length && col == board[0].length) {
				return;
			}

			if (board[row][col] != '.') {
				continue;
			}
			
			HashSet<Character> chars =  rowMap.get(row);
			
			List<Character> candidates = buildCandidates(board, chars);
			
			for (Character character : candidates) {
				
				if(canPlace(character, row, col)) {					
					placeCharToBoard(board, row, col, chars, character);					
					remove(character, row, col);					
				}
				else {
					System.out.println("yenisi ekleyemiyorum...");
				}
			}
			
			backtrack(board, row);

		}

	}

	private void placeCharToBoard(char[][] board, int row, int col, HashSet<Character> chars, Character character) {
		chars.add(character);
		HashSet<Character> charsCol =  colMap.get(col);
		charsCol.add(character);					
		int boxIndex =  (row/3)*3 + col/3;
		HashSet<Character> boxSet = boxMap.get(boxIndex);
		boxSet.add(character);
		board[row][col] = character;
	}

	private void remove(Character character, int row, int col) {
		
		
	}

	private boolean canPlace(Character character, int row, int col) {
		
		HashSet<Character> rowSet = rowMap.get(row);
		if(rowSet.contains(character)) {
			return false;
		}
		
		HashSet<Character> colSet = colMap.get(col);
		if(colSet.contains(character)) {
			return false;
		}
		
		int boxIndex =  (row/3)*3 + col/3;
		HashSet<Character> boxSet = boxMap.get(boxIndex);
		if(boxSet.contains(character)) {
			return false;
		}
		
		return true;
	}

	private List<Character> buildCandidates(char[][] board, HashSet<Character> chars) {
		List<Character> candidates = new ArrayList<Character>();
		
		for(int i=1; i<= board.length; i++) {
			if(chars.contains((char)(i+ '0'))) {
				continue;
			}
			candidates.add( new Character( (char)(i+ '0')));
		}
		return candidates;
	}
	
	private void initboxMap(char[][] board) {
		for(int i=0; i< board.length; i++) {
			boxMap.put(i, new HashSet<Character>());
		}
		
		for(int i=0; i< board.length; i++) {
					
			for(int j=0; j< board[0].length; j++) {
				if(board[i][j]!= '.') {
					
					int boxIndex =  (i/3)*3 + j/3;
					
					HashSet<Character> set = boxMap.get(boxIndex);
					set.add(board[i][j]);					
				}
			}
		}
	}

	private void initColMap(char[][] board) {
		for(int i=0; i< board[0].length; i++) {
			
			HashSet<Character> set = new HashSet<Character>();
			colMap.put(i, set);
			
			for(int j=0; j< board.length; j++) {
				if(board[j][i]!= '.') {
					set.add(board[j][i]);
				}
			}
		}
	}

	private void initRowMap(char[][] board) {
		for(int i=0; i< board.length; i++) {
			
			HashSet<Character> set = new HashSet<Character>();
			rowMap.put(i, set);
			
			for(int j=0; j< board[0].length; j++) {
				if(board[i][j]!= '.') {
					set.add(board[i][j]);					
				}
			}
		}
	}

}
