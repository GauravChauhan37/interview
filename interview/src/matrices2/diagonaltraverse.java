package matrices2;

import java.util.Scanner;

public class diagonaltraverse {
	private static void printZigZag(int[][] mat) {
		for (int i = 1; i < mat.length; i++) {
			int row = i - 1, col = 0;
			while (row >= 0 && col <= i) {
				System.out.print(mat[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
		for (int j = 0; j < mat[0].length; j++) {
			int row = mat.length - 1, col = j;
			while (row >= 0 && col <= mat[0].length - 1) {
				System.out.print(mat[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
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
		printZigZag(arr);
	}
}
