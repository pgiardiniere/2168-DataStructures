import java.util.*;

public class ChessGrid {
	// instance vars
	private int rows = 8;
	private int cols = 8;
	private int[][] board = new int[8][8];

	public static void main(String[] args) {
		ChessGrid chess = new ChessGrid();

		System.out.println("\n    Make board");
		chess.display();

		// Set a random position to Knight start
		int initRow = (int) (Math.random()/.125);
		int initCol = (int) (Math.random()/.125);
		chess.board[initRow][initCol] = 1;

		System.out.println("\n    Place Knight");
		chess.display();

		// Record start position(row, col) in 2 stacks
		Stack<Integer> rowStack = new Stack<Integer>();
		Stack<Integer> colStack = new Stack<Integer>();
		rowStack.push(initRow);
		colStack.push(initCol);
		int jumpCount = 1;

		// move knight across board until all 
		while (chess.hasAnyUnvisited()) {
			int row = rowStack.peek();
			int col = colStack.peek();

			// Try move NNE
			if (row - 2 > 0 && col + 1 < 7 && chess.board[row - 2][col + 1] == 0) {
				jumpCount++;

				
			}

			// else try move NEE
			else if (row - 1 > 0 && col + 2 < 7 && chess.board[row - 1][col + 2] == 0) {
				jumpCount++;
				chess.board[row - 1][col + 2] = jumpCount;
			}

			// else try move SEE
			else if (row + 1 < 7 && col + 2 < 7 && chess.board[row + 1][col + 2] == 0) {
				jumpCount++;
				chess.board[row + 1][col + 2] = jumpCount;
			}
			// else try move SSE
			else if (row + 2 < 7 && col + 1 < 7 && chess.board[row + 2][col + 1] == 0) {
				jumpCount++;
				chess.board[row + 2][col + 1] = jumpCount;
			}
			// else try move SSW
			else if (row + 2 < 7 && col - 1 > 0 && chess.board[row + 2][col - 1] == 0) {
				jumpCount++;
				chess.board[row + 2][col - 1] = jumpCount;
			}
			// else try move SWW
			else if (row + 1 < 7 && col - 2 > 0 && chess.board[row + 1][col - 2] == 0) {
				jumpCount++;
				chess.board[row + 1][col - 2] = jumpCount;
			}
			// else try move NWW
			else if (row - 1 > 0 && col - 2 > 0 && chess.board[row - 1][col - 2] == 0) {
				jumpCount++;
				chess.board[row - 1][col - 2] = jumpCount;
			}
			// else try move NNW
			else if (row - 2 > 0 && col - 1 > 0 && chess.board[row - 2][col - 1] == 0) {
				jumpCount++;
				chess.board[row - 2][col - 1] = jumpCount;
			}
			// else, at DEAD END. Back-track
			else { 
				rowStack.pop();
				colStack.pop();
			}

		}

	}

	public ChessGrid() {
		this.rows = rows;
		this.cols = cols;
		this.board = board;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0)	{ 
					System.out.print("		"); 
				}
				System.out.print(board[i][j] + " ");
				if (j == cols - 1) { 
					System.out.print("\n"); 
				}
			}
		}
	}

	public boolean hasAnyUnvisited() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}

}