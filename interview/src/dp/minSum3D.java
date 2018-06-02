package dp;

import java.util.Scanner;

public class minSum3D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][][] arr = new int[sc.nextInt()][sc.nextInt()][sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					arr[i][j][k] = sc.nextInt();
				}
			}
		}
		// int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 4, 8 }, { 5, 2 } } };
		sc.close();
		int[][][] ssf = new int[arr.length][arr[0].length][arr[0][0].length];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				for (int k = arr[0][0].length - 1; k >= 0; k--) {
					Integer min = null;
					if (i < arr.length - 1) {
						min = min == null ? ssf[i + 1][j][k] : Math.min(ssf[i + 1][j][k], min);
					}
					if (j < arr[0].length - 1) {
						min = min == null ? ssf[i][j + 1][k] : Math.min(ssf[i][j + 1][k], min);
					}
					if (k < arr[0][0].length - 1) {
						min = min == null ? ssf[i][j][k + 1] : Math.min(ssf[i][j][k + 1], min);
					}
					if (min != null) {
						ssf[i][j][k] = min + arr[i][j][k];
					} else {
						ssf[i][j][k] = arr[i][j][k];
					}
				}
			}
		}
		System.out.println(ssf[0][0][0]);
	}
}
