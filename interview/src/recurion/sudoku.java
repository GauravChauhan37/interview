package recurion;

import java.util.Scanner;

public class sudoku {
	public static void solvesud(int[][] maze, int row, int col, int[] rowMask, int[] colMask, int[][] subMask) {
		if (col == maze[0].length) {
			solvesud(maze, row + 1, 0, rowMask, colMask, subMask);
			return;
		}

		if (row == maze.length) {
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		if (maze[row][col] != 0) {
			solvesud(maze, row, col + 1, rowMask, colMask, subMask);
		} else {
			for (int value = 1; value <= 9; value++) {
				if (isSafe(value, rowMask, colMask, subMask, row, col)) {
					maze[row][col] = value;
					set(value, rowMask, colMask, subMask, row, col);
					solvesud(maze, row, col + 1, rowMask, colMask, subMask);
					maze[row][col] = 0;
					resetMasks(row, col, rowMask, colMask, subMask, value);
				}
			}
		}
	}

	private static void set(int value, int[] rowMask, int[] colMask, int[][] subMask, int row, int col) {
		rowMask[row] |= 1 << value;
		colMask[col] |= (1 << value);
		subMask[row / 3][col / 3] |= (1 << value);
	}

	private static void resetMasks(int row, int col, int[] rowMask, int[] colMask, int[][] subMask, int value) {
		rowMask[row] = rowMask[row] & (~(1 << value));
		colMask[col] &= (~(1 << value));
		subMask[row / 3][col / 3] &= (~(1 << value));
	}

	private static boolean isSafe(int value, int[] rowMask, int[] colMask, int[][] subMask, int row, int col) {
		if ((rowMask[row] & (1 << value)) == (1 << value)) {
			return false;
		}
		if ((colMask[col] & (1 << value)) == (1 << value)) {
			return false;
		}
		if ((subMask[row / 3][col / 3] & (1 << value)) == (1 << value)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int[][] arr = new int[sc.nextInt()][sc.nextInt()];
		// for (int i = 0; i < arr.length; i++) {
		// for (int j = 0; j < arr[0].length; j++) {
		// arr[i][j] = sc.nextInt();
		// }
		// }
		int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		// sc.close();
		int[] row = new int[arr.length];
		int[] col = new int[arr[0].length];
		int[][] sub = new int[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					row[i] |= 1 << arr[i][j];
				}
			}
		}
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][j] != 0) {
					col[j] |= 1 << arr[i][j];
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int ri = i / 3;
				int ci = j / 3;
				if (arr[i][j] != 0) {
					sub[ri][ci] |= 1 << arr[i][j];
				}
			}
		}

		solvesud(arr, 0, 0, row, col, sub);
	}
}
