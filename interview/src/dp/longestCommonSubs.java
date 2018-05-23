package dp;

import java.util.Scanner;

public class longestCommonSubs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		sc.close();
		int[][][] mat = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				for (int k = s3.length() - 1; k >= 0; k--) {
					if (s3.charAt(k) == s2.charAt(j) && s2.charAt(j) == s1.charAt(i)) {
						mat[i][j][k] = 1 + mat[i + 1][j + 1][k + 1];
					} else {
						mat[i][j][k] = Math.max(mat[i + 1][j][k], Math.max(mat[i][j + 1][k], mat[i][j][k + 1]));
					}
				}
			}
		}
		System.out.println(mat[0][0][0]);
	}
}
