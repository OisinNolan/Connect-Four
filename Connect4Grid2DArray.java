
public class Connect4Grid2DArray implements Connect4Grid{
	
	public char[][] grid;
	public static final int NUM_OF_ROWS = 6;
	public static final int NUM_OF_COLUMNS = 7;

	public Connect4Grid2DArray() {
		grid = new char[NUM_OF_ROWS][NUM_OF_COLUMNS];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = 'O';
			}
		}
	}
	
	public void emptyGrid() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = 'O';
			}
		}
	}
	public String toString() {
		String gridString = "\n";
		for(int i=0;i<grid.length;i++) {
			gridString += "| ";
			for(int j=0;j<grid[i].length;j++) {
				gridString += grid[i][j] + " ";
			}
			gridString += "|\n";
		}
		return gridString;
	}
	public boolean isValidColumn(int column) {
		if(column > 0 && column <= NUM_OF_COLUMNS) {
			return true;
		}
		return false;
	}
	public boolean isColumnFull(int column) {
		for(int i=0;i<grid.length;i++) {
			if(grid[i][column] == 'O') {
				return false;
			}
		}
		return true;
	}
	public void dropPiece(ConnectPlayer player, int column) {
		int i=0;
		boolean dropped = false;
		while(!dropped && i<grid.length) {
			if(grid[i][column] == 'O') {
				if(i==(grid.length-1)) {
					grid[i][column] = player.piece;
					if(i>0) {
						grid[i-1][column] = 'O';
					}
					dropped = true;
				} else if(grid[i+1][column] != 'O') {
					grid[i][column] = player.piece;
					if(i>0) {
						grid[i-1][column] = 'O';
					}
					dropped = true;
				}	
			}
			i++;
		}
	}
	public boolean didLastPieceConnect4() {
		for(int i=0;i<(grid.length);i++) {
			for(int j=0;j<(grid[i].length);j++) {
				if(grid[i][j] == 'R' || grid[i][j] == 'Y') {
					if((i+3 < grid.length)) {
						if(grid[i][j] == grid[i+1][j] && grid[i+1][j] == grid[i+2][j] && grid[i+2][j] == grid[i+3][j]) {
							return true;
						}
					}
					if(j+3 < grid[i].length ) {
						if(grid[i][j] == grid[i][j+1] && grid[i][j+1] == grid[i][j+2] && grid[i][j+2] == grid[i][j+3]) {
							return true;
						}
					}
					if((i+3<grid.length) && (j+3<grid[i].length)) {
						if(grid[i][j] == grid[i+1][j+1] && grid[i+1][j+1] == grid[i+2][j+2] && grid[i+2][j+2] == grid[i+3][j+3]) {
							return true;
						}
					}
					if((i+3 < grid.length) && (j-3 >= 0)) {
						if(grid[i][j] == grid[i+1][j-1] && grid[i+1][j-1] == grid[i+2][j-2] && grid[i+2][j-2] == grid[i+3][j-3]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean isGridFull() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 'O') {
					return false;
				}
			}
		}
		return true;
	}
}
