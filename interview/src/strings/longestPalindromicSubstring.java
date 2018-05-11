package strings;

import java.util.Scanner;

public class longestPalindromicSubstring {
	public static void longestPalinSubLeft(String s) {
		int maxLength = 1;
		int omax = 0;
		for (int axis = 0; axis < s.length(); axis++) {
			for (int lorbit = axis - 1, rorbit = axis + 1; lorbit >= 0
					&& rorbit <= s.length() - 1; lorbit--, rorbit++) {
				if (s.charAt(lorbit) == s.charAt(rorbit)) {
					maxLength += 2;
				}
				if (omax < maxLength) {
					omax = maxLength;
				}
			}
		}
		System.out.println(omax);

	}

	public static void longestPalinSubRight(String s) {
		int maxLength = 0;
		int omax = 0;
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double lorbit = axis - 0.5, rorbit = axis + 0.5; lorbit >= 0
					&& rorbit <= s.length() - 1; lorbit--, rorbit++) {
				if (s.charAt((int) (lorbit)) == s.charAt((int) (rorbit))) {
					maxLength += 2;
				}
				if (omax < maxLength) {
					omax = maxLength;
				}
			}
		}
		System.out.println(omax);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		if (s.length() % 2 != 0) {
			longestPalinSubLeft(s);
		} else {
			longestPalinSubRight(s);
		}
	}
}
