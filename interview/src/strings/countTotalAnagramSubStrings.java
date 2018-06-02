package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class countTotalAnagramSubStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		HashMap<String, Integer> hp = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char[] ch = s.substring(i, j + 1).toCharArray();
				Arrays.sort(ch);
				String ans = new String(ch);
				if (hp.containsKey(ans)) {
					int val = hp.get(ans);
					val++;
					hp.put(ans, val);
				} else {
					hp.put(ans, 1);
				}
			}
		}
		int count = 0;
		ArrayList<String> al = new ArrayList<>(hp.keySet());
		for (int i = 0; i < al.size(); i++) {
			int val = hp.get(al.get(i));
			int p = val - 2 > 0 ? val - 2 : 2 - val;
			int valueToPut = fact(val) / (fact(p) * 2);
			count += valueToPut;
		}
		System.out.println(count);
	}

	private static int fact(int val) {
		int fact = 1;
		while (val != 0) {
			fact *= val;
			val--;
		}
		return fact;
	}
}
