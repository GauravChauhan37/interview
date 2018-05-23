package recurion;

import java.util.Scanner;

public class findPathFromCornerToCenter {
	public static void findpath(int[][] maze, int srow, int scol, int drow, int dcol, String asf, boolean[][] visited) {
		if (srow == drow && scol == dcol) {
			System.out.println(asf);
		}
		if (isInvalid(maze, srow, scol, visited)) {
			return;
		}

	}

	public static boolean isInvalid(int[][] maze, int sr, int sc, boolean[][] visited) {
		if (sr < 0) {
			return true;
		} else if (sc < 0) {
			return true;
		} else if (sr == maze.length) {
			return true;
		} else if (sc == maze[0].length) {
			return true;
		} else if (maze[sr][sc] == 0 || maze[sr][sc] == 2) {
			return true;
		} else if (visited[sr][sc] == true) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int[][] maze = new int[sc.nextInt()][sc.nextInt()];
		// for (int i = 0; i < maze.length; i++) {
		// for (int j = 0; j < maze[0].length; j++) {
		// maze[i][j] = sc.nextInt();
		// }
		// }
		int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 }, { 6, 7, 5, 6, 6, 2, 6, 6, 2 }, { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
				{ 6, 5, 5, 1, 2, 3, 6, 5, 6 }, { 3, 3, 4, 3, 0, 1, 4, 3, 4 }, { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
				{ 3, 5, 4, 3, 2, 6, 4, 4, 3 }, { 3, 5, 1, 3, 7, 5, 3, 6, 4 }, { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };
		sc.close();
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int midrow = maze.length / 2;
		int midcol = maze[0].length / 2;
		for (int i = 0; i < maze.length; i++) {
			visited[i][0] = true;
			findpath(maze, i, 0, midrow, midcol, "", visited);
			visited[i][0] = false;
		}
	}
}
