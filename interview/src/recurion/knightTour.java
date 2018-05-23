package recurion;

import java.util.Scanner;

public class knightTour {
	static int inc = 1;
	static boolean ans = false;

	public static Boolean isSafe(int[][] maze, int rowmove, int colmove) {
		if (rowmove < 0 || colmove < 0 || rowmove >= maze.length || colmove >= maze[0].length)
			return false;

		if (maze[rowmove][colmove] != 0) {
			return false;
		}
		return true;
	}

	public static void move(int[][] maze, int[] rowmove, int[] colmove, int srow, int scol) {
		maze[srow][scol] = inc;
		if (inc == maze.length * maze[0].length) {
			ans = true;
		}
		inc++;
		for (int idx = 0; idx < rowmove.length; idx++) {
			int rval = rowmove[idx] + srow;
			int cval = colmove[idx] + scol;
			if (isSafe(maze, rval, cval)) {
				move(maze, rowmove, colmove, rval, cval);
			}
		}
		maze[srow][scol] = 0;
		inc--;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int srow = sc.nextInt();
		int scol = sc.nextInt();
		int[][] maze = new int[n][n];
		int[] rowmove = { 2, 1, 2, -1, -2, -2, 1, -1 };
		int[] colmove = { 1, 2, -1, +2, +1, -1, -2, -2 };
		sc.close();
		move(maze, rowmove, colmove, srow, scol);
		System.out.println(ans);
	}
}
