package dp;

import java.util.Scanner;

public class minInsertionsToMakeAPalindrome {
	public static int findMinInsertionsDP(char str[], int n) {
		int table[][] = new int[n][n];
		int row, col, gap;
		for (gap = 1; gap < n; ++gap)
			for (row = 0, col = gap; col < n; ++row, ++col)
				table[row][col] = (str[row] == str[col]) ? table[row + 1][col - 1]
						: (Integer.min(table[row][col - 1], table[row + 1][col]) + 1);
		return table[0][n - 1];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		sc.close();
		int ans =findMinInsertionsDP(s1.toCharArray(), s1.length());
		System.out.println(ans);
	}
}
