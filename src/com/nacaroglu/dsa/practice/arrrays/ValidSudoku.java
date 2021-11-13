package com.nacaroglu.dsa.practice.arrrays;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidSudoku vs = new ValidSudoku();

		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(vs.isValidSudoku(board));

		char[][] board2 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(vs.isValidSudoku(board2));
	}

	public boolean isValidSudoku(char[][] board) {

		if (!processHorizontal(board)) {
			return false;
		}

		if (!processVertical(board)) {
			return false;
		}

		for (int x = 0; x < 3; x++) {

			for (int y = 0; y < 3; y++) {

				if (!processSubGroup(x, y, board)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean processVertical(char[][] board) {
		for (int i = 0; i < board[0].length; i++) {

			HashSet<Character> set = new HashSet<Character>();

			for (int j = 0; j < board.length; j++) {

				if (board[j][i] != '.') {
					if (set.contains(board[j][i])) {
						return false;
					} else {
						set.add(board[j][i]);
					}
				}
			}
		}

		return true;
	}

	private boolean processHorizontal(char[][] board) {
		for (int i = 0; i < board.length; i++) {

			HashSet<Character> set = new HashSet<Character>();

			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
		}
		return true;
	}

	private boolean processSubGroup(int x, int y, char[][] board) {

		HashSet<Character> set = new HashSet<Character>();
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				int i = x * 3 + k;
				int j = y * 3 + l;
				// System.out.println("[" + i + ","+ j +"]: " + board[i][j]);
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
		}

		return true;
	}

}
