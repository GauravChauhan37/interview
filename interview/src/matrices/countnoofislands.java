package matrices;

public class countnoofislands {

	private static boolean isValidSpot(int[][] mat, boolean[][] visited, int row, int col) {
		if (row - 1 >= 0) {
			if (visited[row - 1][col] == true)
				return false;
		}
		if (col - 1 >= 0) {
			if (visited[row][col - 1] == true)
				return false;
		}
		if (row + 1 < mat.length) {
			if (visited[row + 1][col] == true)
				return false;
		}
		if (col + 1 < mat[0].length) {
			if (visited[row][col + 1] == true)
				return false;
		}
		if (row - 1 >= 0 && col - 1 >= 0) {
			if (visited[row - 1][col - 1] == true)
				return false;
		}
		if (row - 1 >= 0 && col + 1 < mat[0].length) {
			if (visited[row - 1][col + 1] == true)
				return false;
		}
		if (row + 1 < mat.length && col + 1 < mat[0].length) {
			if (visited[row + 1][col + 1] == true)
				return false;
		}
		if (row - 1 >= 0 && col + 1 < mat[0].length) {
			if (visited[row - 1][col + 1] == true)
				return false;
		}
		return true;
	}

	private static int countIslands(int[][] mat, int row, int col, boolean[][] visited) {
		if (row >= mat.length) {
			return 0;
		}
		int count = 0;
		if (col >= mat[0].length) {
			count += countIslands(mat, row + 1, 0, visited);
			return count;
		}
		if (mat[row][col] == 1) {
			if (isValidSpot(mat, visited, row, col)) {
				visited[row][col] = true;
				count += 1;
			}
		}
		count += countIslands(mat, row, col + 1, visited);
		return count;

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		System.out.println(countIslands(mat, 0, 0, visited));
	}
}
