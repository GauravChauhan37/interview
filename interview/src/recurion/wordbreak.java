package recurion;

import java.util.HashSet;
import java.util.Scanner;

public class wordbreak {
	public static void wordBreak(HashSet<String> hs, String s, int idx, String ans, String prefix) {
		if (idx == s.length()) {
			if (prefix.isEmpty()) {
				System.out.println(ans);
			}
			return;
		}
		if (idx < s.length()) {
			char ch = s.charAt(idx);
			if (hs.contains(prefix + ch)) {
				wordBreak(hs, s, idx + 1, ans + prefix + ch+" ", "");
				wordBreak(hs, s, idx + 1, ans, prefix + ch);
			} else {
				wordBreak(hs, s, idx + 1, ans, prefix + ch);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like",
				"ice", "cream" };
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hs.add(arr[i]);
		}
		wordBreak(hs, s, 0, "", "");
	}

}
