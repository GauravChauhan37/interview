package dp;

import java.util.Scanner;

public class minStepsToDeleteAStringAfterRepeatedDeletionInAPalindromicSubStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int[][] mat = new int[s.length()][s.length()];
		for (int gap = 0; gap < mat.length; gap++) {
			for (int i = 0, j = gap; j < mat[0].length; i++, j++) {
				if (gap == 0) {
					mat[i][j] = 1;
				}
				if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						mat[i][j] = 1;
					} else {
						mat[i][j] = 1 + Math.min(mat[i][j - 1], mat[i + 1][j]);
					}
				}
				if (gap >= 2) {
					if (s.charAt(i) == s.charAt(j)) {
						mat[i][j] = mat[i + 1][j - 1];
					} else {
						int min = Integer.MAX_VALUE;
						for (int row = i + 1, col = i; col < j; row++, col++) {
							int sum = mat[i][col] + mat[row][j];
							min = Math.min(min, sum);
						}
						mat[i][j] = min;
					}
				}
			}
		}
		System.out.println(mat[0][mat[0].length - 1]);
	}
}
