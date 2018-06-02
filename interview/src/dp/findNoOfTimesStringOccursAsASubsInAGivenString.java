package dp;

import java.util.Scanner;

public class findNoOfTimesStringOccursAsASubsInAGivenString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String patt = sc.next();
		int[] dp = new int[patt.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = 0; j < patt.length(); j++) {
				if (s.charAt(i) == patt.charAt(j)) {
					if (j == patt.length() - 1) {
						dp[j]++;
					} else {
						dp[j] += dp[j + 1];
					}
				}
			}
		}
		System.out.println(dp[0]);
	}
}
