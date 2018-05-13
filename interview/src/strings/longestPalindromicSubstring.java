package strings;

import java.util.Scanner;

public class longestPalindromicSubstring {
	public static String longestPalinSubOdd(String s) {
		String maxString = "";
		String maxStringSoFar = "";
		for (int axis = 0; axis < s.length(); axis++) {
			for (int lorbit = axis - 1, rorbit = axis + 1; lorbit >= 0
					&& rorbit <= s.length() - 1; lorbit--, rorbit++) {
				if (s.charAt(lorbit) == s.charAt(rorbit)) {

					maxString = s.substring(lorbit, rorbit + 1);
				} else {
					break;
				}
			}
			if (maxStringSoFar.length() < maxString.length()) {
				maxStringSoFar = maxString;
			}
		}
		return maxStringSoFar;
	}

	public static String longestPalinSubEven(String s) {
		String maxString = "";
		String maxStringSoFar = "";
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double lorbit = axis - 0.5, rorbit = axis + 0.5; lorbit >= 0
					&& rorbit <= s.length() - 1; lorbit--, rorbit++) {
				if (s.charAt((int) (lorbit)) == s.charAt((int) (rorbit))) {
					maxString = s.substring((int) (lorbit), (int) (rorbit + 1));
				} else {
					break;
				}
			}
			if (maxStringSoFar.length() < maxString.length()) {
				maxStringSoFar = maxString;
			}
		}
		return maxStringSoFar;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();

		String odd = longestPalinSubOdd(s);
		String even = longestPalinSubEven(s);
		if (odd.length() > even.length()) {
			System.out.println(odd);
		} else {
			System.out.println(even);
		}
	}
}
