package dp;

import java.util.Scanner;

public class optimalSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[][] ans = new int[arr.length][arr.length];
		for (int gap = 0; gap < arr.length; gap++) {
			for (int i = 0, j = gap; j < arr.length; i++, j++) {
				if (gap == 0) {
					ans[i][j] = arr[i];
				} else if (gap == 1) {
					ans[i][j] = Math.max(arr[i], arr[j]);
				} else {
					int f1 = Math.min(ans[i + 2][j], ans[i + 1][j - 1]);
					int f2 = Math.min(ans[i + 1][j - 1], ans[i][j - 2]);
					ans[i][j] = Math.max(arr[i] + f1, arr[j] + f2);
				}
			}
		}
		System.out.println(ans[0][ans[0].length - 1]);
	}
}