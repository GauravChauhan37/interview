package dp;

import java.util.Scanner;

public class printShortestCommonSuperSeq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		sc.close();
		int[][] mat = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0)
					mat[i][j] = j;
				else if (j == 0)
					mat[i][j] = i;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					mat[i][j] = 1 + mat[i - 1][j - 1];
				else {
					mat[i][j] = 1 + Math.min(mat[i - 1][j], mat[i][j - 1]);
				}
			}
		}

		String ans = "";
		int i = mat.length - 1;
		int j = mat[0].length - 1;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				ans += (char) (s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (mat[i][j-1] < mat[i-1][j]) {
					ans += (char) (s2.charAt(j - 1));
					j--;
				} else {
					ans += (char) (s1.charAt(i - 1));
					i--;
				}
			}
		}
		if (i > 0) {
			while (i > 0) {
				ans += (char) (s1.charAt(i - 1));
				i--;
			}
		}
		if (j > 0) {
			while (j > 0) {
				ans += (char) (s2.charAt(j - 1));
				j--;
			}
		}
		StringBuilder sb = new StringBuilder(ans);
		sb.reverse();
		System.out.println(sb.toString());
	}
}