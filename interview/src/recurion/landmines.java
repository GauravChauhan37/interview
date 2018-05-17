package recurion;

import java.util.Scanner;

public class landmines {
	static int min = Integer.MAX_VALUE;

	public static void markunsafe(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0) {
					if (i + 1 < a.length) {
						a[i + 1][j] = 2;
					}
					if (j + 1 < a[0].length) {
						a[i][j + 1] = 2;
					}
					if (i - 1 >= 0) {
						a[i - 1][j] = 2;
					}
					if (j - 1 >= 0) {
						a[i][j - 1] = 2;
					}
				}
			}
		}
	}

	public static void findminpath(int[][] arr, int srow, int scol, int drow, int dcol, boolean[][] visited,
			int currMin) {
		if (scol == dcol) {
			if (currMin < min) {
				min = currMin;
			}
			return;
		}
		if (isInvalid(arr, srow, scol, visited)) {
			return;
		}
		visited[srow][scol] = true;
		findminpath(arr, srow + 1, scol, drow, dcol, visited, currMin + 1);
		findminpath(arr, srow, scol + 1, drow, dcol, visited, currMin + 1);
		findminpath(arr, srow, scol - 1, drow, dcol, visited, currMin + 1);
		findminpath(arr, srow - 1, scol, drow, dcol, visited, currMin + 1);
		visited[srow][scol] = false;
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
		int[][] arr = new int[sc.nextInt()][sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		markunsafe(arr);
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			findminpath(arr, i, 0, arr.length - 1, arr[0].length - 1, visited, 0);
		}
		System.out.println(min);
	}
}
