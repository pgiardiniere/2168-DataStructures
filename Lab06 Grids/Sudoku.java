import java.util.*;

public class Sudoku {

	private int rows = 9;
	private int cols = 9;
	private int[][] board = new int[9][9];

	public Sudoku() {
		this.rows = rows;
		this.cols = cols;
		this.board = board;
	}

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();

		System.out.println("\n    Make empty board:");
		sudoku.display();

		System.out.println("\n    Draw board begin state:");
		sudoku.populate();
		sudoku.display();

		System.out.println("\n    Solve sudoku board");
		sudoku.solve();
		sudoku.display();

	}

	public void solve() {
		solve(board);
	}

	public boolean solve(int[][] board) {
		int row = 0;
		int col = 0;
		boolean isFilled = true;

		// Recursion advancement:
		exit:
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isFilled = false;
					break exit;
				}
			}
		}

		// Recursive base case:
		if (isFilled) { return true; }

		// Recursive work: 
		// Fill in next position. If no solution from later recursive calls, back out changes, return false
		for (int val = 1; val <= 9; val++) {
			if (isValid(val, row, col)) {
				board[row][col] = val;

				// UNCOMMENT for Intermediate Display:
				// System.out.println("\n    Try next step of sudoku board");
				// this.display();

				if (solve(board)) { return true; }
				else board[row][col] = 0;
			}
		}
		return false;
	}

	public boolean isValid(int val, int row, int col) {
		// check for val in current row
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == val) return false;
		}
		// check for val in current col
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == val) return false;
		}
		// check for val in current ninth (i.e. tile)
		int tileRowIndex = row - row % 3;
		int tileColIndex = col - col % 3;
		for (int i = tileRowIndex; i <= tileRowIndex + 2; i++) {
			for (int j = tileColIndex; j <= tileColIndex + 2; j++) {
				if (board[i][j] == val) return false;
			}
		}
		return true;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0)	{ 
					System.out.print("		"); 
				}
				if (i != 0 && i % 3 == 0 && j == 0) {
					System.out.print("---------------------\n" + "		");
				}
				if (j != 0 && j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " ");
				if (j == cols - 1) { 
					System.out.print("\n"); 
				}
			}
		}
	}

	public void populate() {
		board = new int[][] {
			{0, 1, 0, 3, 9, 0, 0, 0, 0},
			{9, 4, 0, 0, 0, 8, 0, 0, 1},
			{6, 8, 0, 0, 1, 0, 0, 2, 0},
			{0, 3, 0, 2, 7, 0, 1, 0, 0},
			{1, 0, 7, 0, 0, 0, 4, 0, 2},
			{0, 0, 4, 0, 5, 9, 0, 3, 0},
			{0, 9, 0, 0, 2, 0, 0, 6, 3},
			{3, 0, 0, 9, 0, 0, 0, 4, 5},
			{0, 0, 0, 0, 4, 3, 0, 1, 0},
		};
	}	
}