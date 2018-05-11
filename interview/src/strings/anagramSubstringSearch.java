
package strings;

import java.util.Arrays;
import java.util.Scanner;

public class anagramSubstringSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String pat = sc.nextLine();
		sc.close();
		int[] originalCount = new int[26];
		for (int i = 0; i < pat.length(); i++) {
			originalCount[pat.charAt(i) - 'a']++;
		}
		int[] varCount = originalCount.clone();
		int i = 0;
		int j = i;
		while (j < s.length()) {
			if (varCount[s.charAt(j) - 'a'] != 0) {
				varCount[s.charAt(j) - 'a']--;
			}
			if (Arrays.equals(new int[26], varCount)) {
				System.out.println(i);
				i++;
				j = i - 1;
				varCount = originalCount.clone();
			}
			if (j - i + 1 >= pat.length()) {
				i++;
				j = i - 1;
				varCount = originalCount.clone();
			}
			j++;
		}
	}
}
