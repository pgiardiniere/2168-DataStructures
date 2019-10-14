public class SudokuGrid {
	private int rows = 9;
	private int cols = 9;
	private int[][] board = new int[9][9];

	public static void main(String[] args) {		
		SudokuGrid sudoku = new SudokuGrid();

		System.out.println("\n    Make empty board:");
		sudoku.display();

		System.out.println("\n    Draw board begin state:");
		sudoku.populate();
		sudoku.display();

	}


	public SudokuGrid() {
		this.rows = rows;
		this.cols = cols;
		this.board = board;
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

}