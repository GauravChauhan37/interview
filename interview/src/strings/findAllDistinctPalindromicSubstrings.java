package strings;

import java.util.HashMap;
import java.util.Scanner;

public class findAllDistinctPalindromicSubstrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		HashMap<String, Integer> hp = new HashMap<>();

		findPalin(s, hp);
		findPalinodd(s, hp);
		System.out.println(hp);
	}

	private static void findPalinodd(String s, HashMap<String, Integer> hp) {
		int radix;
		int left;
		int right;
		for (radix = 1; radix < s.length(); radix++) {
			for (left = radix - 1, right = radix + 1; right < s.length() && left >= 0; left--, right++) {
				if (s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				} else {
					String s1 = s.substring(left + 1, right);
					if (!(hp.containsKey(s1))) {
						hp.put(s1, 1);
					} else {
						int val = hp.get(s1);
						val++;
						hp.put(s1, val);
					}
					break;
				}
			}
		}
	}

	private static void findPalin(String s, HashMap<String, Integer> hp) {
		int radix = 0;
		int left;
		int right;
		for (radix = 0; radix < s.length(); radix++) {
			for (left = radix, right = radix + 1; right < s.length() && left >= 0; left--, right++) {
				if (s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				} else {
					String s1 = s.substring(left + 1, right);
					if (!(hp.containsKey(s1))) {
						hp.put(s1, 1);
					} else {
						int val = hp.get(s1);
						val++;
						hp.put(s1, val);
					}
					break;
				}
			}
		}
	}
}
