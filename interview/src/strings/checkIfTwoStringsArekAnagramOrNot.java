package strings;

import java.util.Scanner;

public class checkIfTwoStringsArekAnagramOrNot {
	public static boolean kAnagram(String s, String ss, int k) {
		if (s.length() != ss.length()) {
			return false;
		}
		int[] countOfs = new int[26];
		int[] countOfss = new int[26];
		for (int i = 0; i < s.length(); i++) {
			countOfs[s.charAt(i) - 'a']++;
			countOfss[ss.charAt(i) - 'a']++;
		}
		for (int p = 0; p < ss.length(); p++) {
			if (countOfs[ss.charAt(p) - 'a'] != 0) {
				countOfs[ss.charAt(p) - 'a']--;
			}
		}
		for (int p = 0; p < s.length(); p++) {
			if (countOfss[s.charAt(p) - 'a'] != 0) {
				countOfss[s.charAt(p) - 'a']--;
			}
		}
		
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < countOfs.length; i++) {
			if (countOfs[i] != 0) {
				count1++;
			}
			if (countOfss[i] != 0) {
				count2++;
			}
		}
		if (count1 == count2) {
			if (count1 <= k) {
				return true;
			} else {
				return false;
			}
		} else {
			if (Math.abs(count1 - count2) <= k) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String ss = sc.next();
		int k = sc.nextInt();
		sc.close();
		boolean ans = kAnagram(s, ss, k);
		System.out.println(ans);
	}

}
