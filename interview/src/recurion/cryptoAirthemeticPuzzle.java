package recurion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class cryptoAirthemeticPuzzle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Integer> available = new HashSet<>();
		for (int i = 0; i < s3.length(); i++) {
			if (!(map.containsKey(s3.charAt(i)))) {
				map.put(s3.charAt(i), -1);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!(map.containsKey(s2.charAt(i)))) {
				map.put(s2.charAt(i), -1);
			}
		}
		for (int i = 0; i < s1.length(); i++) {
			if (!(map.containsKey(s1.charAt(i)))) {
				map.put(s1.charAt(i), -1);
			}
		}
		for (int i = 0; i <= 9; i++) {
			available.add(i);
		}
		crpyt(s1, s2, s3, map, available, s1.length() - 1, 0);
	}

	private static void crpyt(String s1, String s2, String s3, HashMap<Character, Integer> hp, HashSet<Integer> hs,
			int idx, int carry) {
		if (idx < 0) {
			if (carry == s3.charAt(0)) {
				ArrayList<Character> al = new ArrayList<>(hp.keySet());
				for (int i = 0; i < al.size(); i++) {
					System.out.print(al.get(i) + " " + hp.get(i) + " ");
				}
				return;
			} else {
				return;
			}
		}
		for (int i = 0; i <= 9; i++) {
			int value1 = 0;
			int value2 = 0;
			boolean[] resetHelper = new boolean[hs.size()];
			if (hs.contains(i)) {
				if (hp.get(s1.charAt(idx)) == -1) {
					hp.put(s1.charAt(idx), i);
					value1 = i;
					hs.remove(i);
				} else {
					value1 = hp.get(s1.charAt(idx));
				}
				if (hp.get(s2.charAt(idx)) == -1) {
					hp.put(s2.charAt(idx), i);
					value2 = i;
					hs.remove(i);
				} else {
					value2 = hp.get(s2.charAt(idx));
				}
				if (value1 != 0 && value2 != 0) {
					if (hp.containsKey(s3.charAt(idx))) {
						int value3 = hp.get(s3.charAt(idx));
						if (value1 + value2 + carry != value3) {
							return;
						}
					} else {
						int value3 = hp.get(s1.charAt(idx)) + hp.get(s2.charAt(idx)) + carry;
						hp.put(s3.charAt(idx), value3);
						hs.remove(value3);
					}
					carry = hp.get(s1.charAt(idx) + hp.get(s2.charAt(idx)));
					carry /= 10;
					crpyt(s1, s2, s3, hp, hs, idx - 1, carry);
					// remove(resetHelper,)
				}
			}
		}
	}
}
