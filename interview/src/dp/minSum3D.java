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
		sc.close();
		int[][][] ssf = new int[arr.length][arr[0].length][arr[0][0].length];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				for (int k = arr[0][0].length - 1; k >= 0; k--) {
					Integer min = null;
					
				}
			}
		}
		System.out.println(ssf[ssf.length - 1][ssf[0].length - 1][ssf[0][0].length - 1]);
	}
}
