package strings;

import java.util.HashMap;
import java.util.HashSet;

public class findLongestSubstringWithKUniqueChracters {

	public static void main(String[] args) {
		String str = "aaabbb";
		int k = 3;
		Longest_K_Unique(str, k);

	}

	public static void Longest_K_Unique(String str, int k) {

		HashMap<Character, Integer> set = new HashMap<>();
		int l = 0;
		int r = 0;
		int maxLen = 0;
		int count = 0;
		while (r < str.length()) {
			char ch = str.charAt(r);
			if (!set.containsKey(ch)) {
				set.put(ch, 1);
				count++;
				r++;
			} else {
				set.put(ch, set.get(ch) + 1);
				r++;
			}
			if (count == k) {
				maxLen = Math.max(maxLen, r - l);
			}
			if (count > k) {
				int c = set.get(str.charAt(l));
				if (c > 1) {
					set.put(str.charAt(l), c - 1);
					l++;
				} else if (c == 1) {
					set.remove(str.charAt(l));
					count--;
					l++;
				}
			}
		}
		if (maxLen == 0 && set.size() != k) {
			maxLen = -1;
		}
		System.out.println(maxLen);
	}

}