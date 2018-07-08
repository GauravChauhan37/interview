package matrices;

import java.util.Scanner;

public class FindSpecificPair {
	public static int findPair(int[][] arr) {
		int[][] mat = new int[arr.length][arr[0].length];
		int max = Integer.MIN_VALUE;
		for (int j = arr[0].length - 1; j >= 0; j--) {
			max = Math.max(max, arr[arr.length - 1][j]);
			mat[arr.length - 1][j] = max;
		}
		max = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			max = Math.max(max, arr[i][arr[0].length - 1]);
			mat[i][arr[0].length - 1] = max;
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[0].length - 2; j >= 0; j--) {
				max = Math.max(max, mat[i + 1][j + 1] - arr[i][j]); // max diff
																	// update
				mat[i][j] = Math.max(arr[i][j], Math.max(mat[i + 1][j], mat[i][j + 1])); // max
																							// element
																							// update
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(findPair(arr));
	}

}
