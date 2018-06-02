package recurion;

import java.util.Scanner;

public class removeAllajcdups {
	static int idx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		String ans = remove(s, 1, false);
		System.out.println(ans);
	}

	private static String remove(String s, int i, boolean flag) {
		if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return "empty";
			}
		}
		if (i >= s.length() - 1 && flag == true) {
			return "empty";
		}
		if (i >= s.length() - 1 && flag == false) {
			return s;
		}

		if (s.charAt(i) == s.charAt(idx) && s.charAt(i) == s.charAt(i + 1)) {
			return remove(s, i + 1, true);
		} else if (s.charAt(i) == s.charAt(idx) && s.charAt(i) != s.charAt(i + 1)) {
			s = s.substring(0, idx) + s.substring(i + 1);
			idx = (idx == 0) ? 0 : idx - 1;
			return remove(s, idx + 1, false);
		} else if (s.charAt(i) != s.charAt(idx)) {
			idx++;
			return remove(s, i + 1, false);
		}
		return s;
	}
}
