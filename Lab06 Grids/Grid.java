public class Grid {

	// instance vars
	private int rows;
	private int cols;
	private int[9][9] Sudoku;
	private int[8][8] Chess;

	public Grid(int[][] grid) {
		for (int[] col : grid) {
			for (int row : col) {
				// populate grid with info needed
			}
		}
	}

	public static void main(String[] args) {
		// Do Sudoku Puzzle
		new Grid(Sudoku);

		// Do Chess Puzzle
		new Grid(Chess);
	}
}