import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MazeGridPanel extends JPanel {
	private int rows;
	private int cols;
	private Cell[][] maze;

	// Extra credit
	public void generateMazeByDFS() {
		boolean[][] visited;
		Stack<Cell> stack = new Stack<Cell>();
		Cell start = maze[0][0];
		stack.push(start);
	}

	public void solveMaze() {
		Stack<Cell> stack = new Stack<Cell>();
		Cell start = maze[0][0];
		start.setBackground(Color.GREEN);
		Cell finish = maze[rows - 1][cols - 1];
		finish.setBackground(Color.RED);
		stack.push(start);
		
		// My implmentation here
		while (!visited(rows - 1, cols - 1) && !stack.empty() ) {
			Cell position = stack.peek();
			// try move EAST
			if (position.col+1 < cols && !position.eastWall && !visited(position.row, position.col+1)){
				position = maze[position.row][position.col + 1];
				position.setBackground(Color.GREEN);
				stack.push(position);
			}
			// else try move SOUTH
			else if (position.row+1 < rows && !position.southWall && !visited(position.row+1, position.col)) {
				position = maze[position.row + 1][position.col];
				position.setBackground(Color.GREEN);
				stack.push(position);
			}
			// else try move WEST
			else if (position.col-1 > 0 && !position.westWall && !visited(position.row, position.col-1)) {
				position = maze[position.row][position.col - 1];
				position.setBackground(Color.GREEN);
				stack.push(position);
			}
			// else try move NORTH
			else if (position.row-1 > 0 && !position.northWall && !visited(position.row-1, position.col)) {
				position = maze[position.row - 1][position.col];
				position.setBackground(Color.GREEN);
				stack.push(position);
			}
			// else at DEAD END. Back-track
			else {
				position = stack.pop();
			}
		}
	}

	public boolean visited(int row, int col) {
		Cell c = maze[row][col];
		Color status = c.getBackground();
		if (status.equals(Color.WHITE) || status.equals(Color.RED)) {
			return false;
		}

		return true;
	}

	public void generateMaze() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				if (row == 0 && col == 0) {
					continue;
				} else if (row == 0) {
					maze[row][col].westWall = false;
					maze[row][col - 1].eastWall = false;
				} else if (col == 0) {
					maze[row][col].northWall = false;
					maze[row - 1][col].southWall = false;
				} else {
					boolean north = Math.random() < 0.5;
					if (north) {
						maze[row][col].northWall = false;
						maze[row - 1][col].southWall = false;
					} else {
						maze[row][col].westWall = false;
						maze[row][col - 1].eastWall = false;
					}
					maze[row][col].repaint();
				}
			}
		}

		this.repaint();
	}

	public MazeGridPanel(int rows, int cols) {
		this.setPreferredSize(new Dimension(800, 800));
		this.rows = rows;
		this.cols = cols;
		this.setLayout(new GridLayout(rows, cols));
		this.maze = new Cell[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				maze[row][col] = new Cell(row, col);
				this.add(maze[row][col]);
			}
		}

		this.generateMaze();
		this.solveMaze();
	}
}
