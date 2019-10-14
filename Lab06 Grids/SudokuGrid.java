import java.util.*;

public class SudokuGrid {
	private int rows = 9;
	private int cols = 9;
	private int[][] board = new int[9][9];

	private ArrayList<Integer> curRow = new ArrayList<Integer>(9);
	private ArrayList<Integer> curCol = new ArrayList<Integer>(9);
	private ArrayList<Integer> curTile = new ArrayList<Integer>(9);

	public static void main(String[] args) {		
		SudokuGrid sudoku = new SudokuGrid();

		System.out.println("\n    Make empty board:");
		sudoku.display();

		System.out.println("\n    Draw board begin state:");
		sudoku.populate();
		sudoku.display();

		System.out.println("\n    Solve sudoku board");
		sudoku.solve();
		sudoku.display();

	}

	public SudokuGrid() {
		this.rows = rows;
		this.cols = cols;
		this.board = board;

		this.curRow = curRow;
		this.curCol = curCol;
		this.curTile = curTile;

		for (int i = 0; i < 9; i++) {
			curRow.add(0);
			curCol.add(0);
			curTile.add(0);
		}
	}

	public void populate() {
		board[0][2] = 6; board[0][5] = 2; board[0][6] = 5; board[0][7] = 9;
		board[0][8] = 3; board[1][5] = 4; board[2][2] = 5; board[2][4] = 7;
		board[2][6] = 4; board[2][7] = 1; board[3][0] = 4; board[3][2] = 3;
		board[3][4] = 6; board[5][4] = 8; board[5][6] = 2; board[5][8] = 7;
		board[6][1] = 3; board[6][2] = 7; board[1][1] = 2; board[6][4] = 2;
		board[6][6] = 9; board[7][3] = 6; board[7][7] = 2; board[8][0] = 8;
		board[8][1] = 1; board[8][2] = 2; board[8][3] = 9; board[8][6] = 6;
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

	public boolean isFilled() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) return false;
			}
		}
		return true;
	}

	public void solve() {
		solveNext(board, 0, 0);
	}

	public boolean solveNext(int[][] grid, int row, int col) {
		if (this.isFilled()) {
			return true;
		}

		// solve current row/col provided. Then recursively call method on next row/col
		else {
			this.curUpdate(row, col);			
			
			if (board[row][col] == 0) {
				for (int val = 1; val <= 9; val++) {
					if (!curRow.contains(val) && !curCol.contains(val) && !curTile.contains(val)) { 
						board[row][col] = val;
						break;
					}
				}
			}

			System.out.println("\n    Solved step of sudoku board");
			this.display();			

			if (col != 8) { col++; }
			else 		  { col = 0; row++; }
			
			return solveNext(grid, row, col);
		}
	}

	public void curUpdate(int row, int col) {
		// update curRow
		for (int i = 0; i < cols; i++) {
			curRow.set(i, board[row][i]);
		}
		System.out.println("curRow now:");
		System.out.println(curRow.toString());

		// update curCol
		for (int i = 0; i < rows; i++) {
			curCol.set(i, board[i][col]);
		}
		System.out.println("\n" + "curCol now:");
		System.out.println(curCol.toString());

		// update curTile
		// get Sudoku grid ninth (0-8 scale), feed that ninth's data to curTile ArrayList:
		int ninthPosition = (row / 3)*3 + col/3;
		this.curTileUpdate(ninthPosition);

		System.out.println("\n" + "curTile now:");
		System.out.println(curTile.toString());

	}

	public void curTileUpdate(int ninth) {
		int tileIter = 0;

		if (ninth == 0) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 1) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j <= 5; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 2) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 6; j <= 8; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 3) {
			for (int i = 3; i <= 5 ; i++) {
				for (int j = 0; j <= 2; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 4) {
			for (int i = 3; i <= 5 ; i++) {
				for (int j = 3; j <= 5; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 5) {
			for (int i = 3; i <= 5 ; i++) {
				for (int j = 6; j <= 8; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 6) {
			for (int i = 6; i <= 8 ; i++) {
				for (int j = 0; j <= 2; j++) {
					curTile.set(tileIter++, board[i][j]);
				}	
			}
		}
		if (ninth == 7) {
			for (int i = 6; i <= 8 ; i++) {
				for (int j = 3; j <= 5; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
		if (ninth == 8) {
			for (int i = 6; i <= 8 ; i++) {
				for (int j = 6; j <= 8; j++) {
					curTile.set(tileIter++, board[i][j]);
				}
			}
		}
	}

}