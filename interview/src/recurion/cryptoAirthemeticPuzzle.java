package recurion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class cryptoAirthemeticPuzzle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Integer> available = new HashSet<>();
		for (int i = 0; i <= 9; i++) {
			available.add(i);
		}
		crpyt(s1, s2, s3, map, available, s1.length() - 1, s2.length() - 1, s3.length() - 1, 0);
	}
	//
	// public static int assign(HashSet<Integer> hs) {
	// int val = 0;
	// for (int i = 0; i <= 9; i++) {
	// if ((hs.contains(i))) {
	// hs.remove(i);
	// val = i;
	// break;
	// }
	// }
	// return val;
	// }
	//
	// public static boolean checkValid(int idxLeft, int idxResult, String left,
	// String result) {
	// while (idxLeft < 0) {
	//
	// idxLeft--;
	// idxResult--;
	// }
	// return true;
	// }

	private static void crpyt(String s1, String s2, String s3, HashMap<Character, Integer> hp, HashSet<Integer> hs,
			int idx1, int idx2, int idx3, int carry) {
		if (idx1 < 0 && idx2 < 0) {
			if (carry == s3.charAt(idx3)) {
				System.out.println(hp);
			} else {
				return;
			}
		}
		// if (idx1 < 0) {
		// boolean ans = checkValid(idx2, idx3, s2, s3);
		// if (ans) {
		// System.out.println(hp);
		// } else {
		// return;
		// }
		// }
		// if (idx2 < 0) {
		// boolean ans = checkValid(idx1, idx3, s1, s3);
		// if (ans) {
		// System.out.println(hp);
		// } else {
		// return;
		// }
		// }
		boolean[] visited = new boolean[3];
		char ch1 = s1.charAt(idx1);
		int val1 = 0;
		for (int i = 0; i <= 9; i++) {
			if (hs.contains(ch1)) {
				val1 = hp.get(ch1);
			} else {
				if ((hs.contains(i))) {
					hs.remove(i);
					val1 = i;
					hp.put(ch1, val1);
					visited[0] = true;
					break;
				}
			}
			int val2 = 0;
			char ch2 = s2.charAt(idx2);
			char ch3 = s3.charAt(idx3);
			if (hs.contains(ch2)) {
				val2 = hp.get(ch2);
			} else {
				for (int j = 0; j <= 9; j++) {
					val2 = -1;
					if ((hs.contains(j))) {
						hs.remove(j);
						val2 = j;
						hp.put(ch2, val2);
						visited[1] = true;
					}
					if (val2 != -1) {
						int val3 = 0;
						if (hp.containsKey(ch3)) {
							val3 = hp.get(ch3);
							if (val1 + val2 != val3) {
								continue;
							} else {
								carry = val3 / 10;
							}
						} else {
							int check = val1 + val2;
							if (hs.contains(check) == true) {
								val3 = val1 + val2;
								carry = val3 / 10;
								val3 = val3 % 10;
								hp.put(ch3, val3);
								visited[2] = true;
							} else {
								if (visited[1] == true) {
									int r = hp.remove(ch2);
									hs.add(r);
								}
							}
						}
					}
				}
				crpyt(s1, s2, s3, hp, hs, idx1 - 1, idx2 - 1, idx3 - 1, carry);
				if (visited[2] == true) {
					int r = hp.remove(ch3);
					hs.add(r);
				}
				if (visited[1] == true) {
					int r = hp.remove(ch2);
					hs.add(r);
				}
				if (visited[0] == true) {
					int r = hp.remove(ch1);
					hs.add(r);
				}
			}
		}
	}
}