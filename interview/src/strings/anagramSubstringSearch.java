
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
			char ch = pat.charAt(i);
			originalCount[ch - 'A']++;
		}

		int[] varCount = originalCount.clone();
		int i = 0;
		int j = i;
		while (j < s.length()) {
			char ch =(char)(s.charAt(j) - 'A');
			if (varCount[ch] != 0) {
				varCount[s.charAt(j) - 'A']--;
			}
			if (Arrays.equals(new int[26], varCount)) {
				System.out.print(i+" ");
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
