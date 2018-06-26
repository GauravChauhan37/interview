
package strings;

import java.util.Arrays;
import java.util.Scanner;

public class printAllAnagrams {
	static class Pairs implements Comparable<Pairs> {
		int index;
		String word;

		public int compareTo(Pairs o) {
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		Pairs[] words = new Pairs[arr.length];
		for (int i = 0; i < words.length; i++) {
			words[i] = new Pairs();
		}
		for (int i = 0; i < words.length; i++) {
			words[i].word = arr[i];
			words[i].index = i;
		}
		for (int i = 0; i < words.length; i++) {
			boolean[] count = new boolean[26];
			String s = words[i].word;
			for (int j = 0; j < s.length(); j++) {
				if (count[s.charAt(j) - 'a'] == false) {
					count[s.charAt(j) - 'a'] = true;
				}
			}
			String ss = "";
			for (int j = 0; j < count.length; j++) {
				if (count[j] == true) {
					char ch = (char) (j + 'a');
					ss += ch;
				}
			}
			words[i].word = ss;
		}
		Arrays.sort(words);
		for (int i = 0; i < words.length; i++) {
			System.out.println(arr[words[i].index]);
		}
	}
}
