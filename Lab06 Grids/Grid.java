public class Grid {

	// instance vars
	private int sudorows = 9;
	private int sudocols = 9;
	private int chessrows = 8;
	private int chesscols = 8;

	private int[][] sudoku = new int[9][9];
	private int[][] chess = new int[8][8];

	public Grid(int[][] grid) {

	}

	public void display(int[][] grid) {
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++) {
				if (j == grid[i].length-1)
					System.out.print("\n");
				System.out.print(grid[i][j] + " ");
			}
		}
	}

	public static void main(String[] args) {
		// Do Chess Puzzle, 
		new Grid();

		// Do Sudoku Puzzle
		// new Grid(sudoku)
	}
}