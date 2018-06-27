package strings;

import java.util.HashMap;
import java.util.Scanner;

public class lexiocoGraphicRankOfAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int total = 1;
		int curr = 0;
		HashMap<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {  // freq map of chars 
			if (freq.containsKey(s.charAt(i))) {
				int val = freq.get(s.charAt(i));
				val++;
				freq.put(s.charAt(i), val);
			} else {
				freq.put(s.charAt(i), 1);
			}
		}
		// duplicates not handled
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) > s.charAt(j)) {
					curr++;
				}
			}
			int fact = findFactorial(s.length() - (i + 1));
			total += (fact * curr);
			curr = 0;
		}
		System.out.println(total);
	}

	private static int findFactorial(int num) {
		int fact = 1;
		while (num > 0) {
			fact *= num;
			num--;
		}
		return fact;
	}
}
