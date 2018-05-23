package dp;

import java.util.HashMap;
import java.util.Scanner;

public class countDistnctSubs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int[] count = new int[s.length()];
		HashMap<Character, Integer> hp = new HashMap<>();
		count[0] = 2;
		hp.put(s.charAt(0), 0);
		for (int i = 1; i < count.length; i++) {
			if (hp.containsKey(s.charAt(i))) {
				count[i] = count[i - 1] * 2;
				int index = hp.get(s.charAt(i)) - 1;
				int sub = 0;
				if (index >= 0) {
					sub = count[index];
				} else {
					sub = 1;
				}
				hp.put(s.charAt(i), i);
				count[i] = count[i] - sub;
			} else {
				hp.put(s.charAt(i), i);
				count[i] = count[i - 1] * 2;
			}
		}
		System.out.println(count[count.length - 1]);
	}
}
