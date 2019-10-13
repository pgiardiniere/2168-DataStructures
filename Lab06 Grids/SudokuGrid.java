public class SudokuGrid {
	private int rows = 9;
	private int cols = 9;
	private int[][] sudoku = new int[9][9];

	public SudokuGrid() {
		this.rows = rows;
		this.cols = cols;
		
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
		// do Sudoku puzzle 
		new SudokuGrid();
	}
}