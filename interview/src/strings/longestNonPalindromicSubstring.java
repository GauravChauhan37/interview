package strings;

import java.util.Scanner;

public class longestNonPalindromicSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
//		Boolean flag = null;
//		for (int i = 0; i < s.length() - 1; i++) {
//			if (s.charAt(i) != s.charAt(i + 1)) {
//				flag = true;
//			}
//		}
//		if (flag != null && flag == false) {
//			System.out.println("NOT POSSIBLE");
//			return;
//		}
		int ans = checkPalin(s, 0, s.length() - 1);
		System.out.println(ans);
	}

	private static int checkPalin(String s, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int omin = Integer.MAX_VALUE;
		if (s.charAt(start) == s.charAt(end)) {
			min1 = checkPalin(s, start + 1, end);
			min2 = checkPalin(s, start, end - 1);
			omin = Math.max(min1, min2);
		} else {
			return end - start + 1;
		}
		return omin;
	}
}
