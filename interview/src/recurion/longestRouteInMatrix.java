package recurion;

import java.util.Scanner;

public class longestRouteInMatrix {
	static int omax = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		longestRoute(0, 0, arr, visited, 0);
		System.out.println(omax);
	}

	public static void longestRoute(int srow, int scol, int[][] maze, boolean[][] visited, int max) {
		if (srow == maze.length - 1 && scol == maze[0].length - 1) {
			if (omax < max) {
				omax = max;
			}
			return;
		}
		if (check(maze, srow, scol, visited)) {
			return;
		}
		visited[srow][scol] = true;
		longestRoute(srow, scol - 1, maze, visited, max + 1);
		longestRoute(srow + 1, scol, maze, visited, max + 1);
		longestRoute(srow, scol + 1, maze, visited, max + 1);
		longestRoute(srow - 1, scol, maze, visited, max + 1);
		visited[srow][scol] = false;
	}

	public static boolean check(int[][] maze, int srow, int scol, boolean[][] visited) {
		if (srow >= maze.length)
			return true;
		if (scol >= maze[0].length)
			return true;
		if (srow < 0)
			return true;
		if (scol < 0)
			return true;
		if (maze[srow][scol] == 0)
			return true;
		if (visited[srow][scol] == true)
			return true;

		return false;
	}

}
