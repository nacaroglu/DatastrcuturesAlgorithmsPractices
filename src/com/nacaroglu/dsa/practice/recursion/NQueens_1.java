package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens_1 {

	public static void main(String[] args) {

		NQueens_1 nq = new NQueens_1();
		System.out.println(nq.solveNQueens(4));
	}

	public List<List<String>> solveNQueens(int n) {

		List<List<String>> result = new ArrayList<List<String>>();

		boolean board[][] = new boolean[n][n];
		backtrack(0, board, result);

		return result;
	}

	private void backtrack(int row, boolean[][] board, List<List<String>> result) {

		for (int col = 0; col < board.length; col++) {

			if (!is_under_attack(row, col, board)) {

				place_queen(row, col, board);

				if (row + 1 == board.length) {
					List<String> resultItem = buildResultItem(board);					
					result.add(resultItem);
				} else {
					backtrack(row + 1, board, result);
				}

				remove_queen(row, col, board);
			}
		}
	}

	private List<String> buildResultItem(boolean[][] board) {
		List<String> resultItem = new ArrayList<String>();

		for (int i = 0; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j] ? "Q" : ".");
			}
			sb.toString();
			resultItem.add(sb.toString());
		}
		return resultItem;
	}

	private void place_queen(int row, int col, boolean[][] board) {
		board[row][col] = true;
	}

	private void remove_queen(int row, int col, boolean[][] board) {
		board[row][col] = false;
	}

	private boolean is_under_attack(int row, int col, boolean[][] board) {

		// row search
		for (int i = 0; i < board.length; i++) {
			if (i == col) {
				continue;
			}

			if (board[row][i]) {
				return true;
			}
		}

		// column search
		for (int i = 0; i < board.length; i++) {
			if (i == row) {
				continue;
			}

			if (board[i][col]) {
				return true;
			}
		}

		// right diagonal below
		for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {

			if (board[i][j]) {
				return true;
			}
		}

		// left diagonal upper
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

			if (board[i][j]) {
				return true;
			}
		}

		// left diagonal below
		for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {

			if (board[i][j]) {
				return true;
			}
		}

		// right diagonal upper
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {

			if (board[i][j]) {
				return true;
			}
		}

		return false;
	}

}
