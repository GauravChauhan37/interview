package strings;

import java.util.HashMap;
import java.util.Scanner;

public class checkIfTwoStringsAreIsomorphic {

	static boolean areIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Character> hp1 = new HashMap<>();
		HashMap<Character, Character> hp2 = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			char ch2 = str2.charAt(i);
			if (hp1.containsKey(ch)) {
				if (hp1.get(ch) != ch2) {
					return false;
				}
			} else if (hp2.containsKey(ch2)) {
				if (hp2.get(ch2) != ch) {
					return false;
				}
			} else {
				hp1.put(ch, ch2);
				hp2.put(ch2, ch);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String s = sc.next();
			String ss = sc.next();
			System.out.println(areIsomorphic(s, ss));
		}
	}
