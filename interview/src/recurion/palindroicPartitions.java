package recurion;

import java.util.Scanner;

public class palindroicPartitions {
	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static void palin(String s, String ans, int idx, String rem) {
		if (idx == s.length() && rem.isEmpty()) {
			System.out.println(ans);
			return;
		}
		if (idx < s.length()) {
			char ch = s.charAt(idx);
			// one char always palin
			if (isPalindrome(rem + ch)) {
				palin(s, ans + rem + ch + " ", idx + 1, "");
				palin(s, ans, idx + 1, rem + ch);
			} else {
				palin(s, ans, idx + 1, rem + ch);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String ans = "";
		palin(s, ans, 0, "");
	}
}