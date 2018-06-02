package strings;

import java.util.Scanner;

public class repeatedSubsOfLen2OrMore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] >= 3) {
				System.out.println("true");
				return;
			}
		}
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 2) {
				ans += s.charAt(i);
			}
		}
		int low = 0;
		int high = ans.length() - 1;
		while (low < high) {
			if (ans.charAt(low) != ans.charAt(high)) {
				System.out.println("true");
				return;
			}
			low++;
			high--;
		}
		System.out.println("false");
	}
}
