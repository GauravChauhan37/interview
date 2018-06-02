package matrices2;

import java.util.Scanner;

public class noOfIsland {
	public static void set(int[][] arr, int row, int col) {
		int[] rowMoves = {1,};
		int[] colMoves = {1,};
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
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					count++;
					set(arr, i, j);
				}
			}
		}
	}
}
