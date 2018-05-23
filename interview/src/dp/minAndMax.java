package dp;

import java.util.Scanner;

public class minAndMax {
	static class Pair {
		int min;
		int max;

		public Pair(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		Pair ans = airth(s);
		System.out.println(ans.max);
		System.out.println(ans.min);
	}

	private static Pair airth(String s) {
		if (s.length() == 1) {
			Pair p = new Pair(Integer.parseInt(s), Integer.parseInt(s));
			return p;
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Pair value = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Pair value1 = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
		for (int idx = 0; idx < s.length(); idx++) {
			if (s.charAt(idx) == '+' || s.charAt(idx) == '*') {
				value = airth(s.substring(0, idx));
				value1 = airth(s.substring(idx + 1));
				char ch = s.charAt(idx);
				if (ch == '+') {
					min = Math.min(value.min + value1.min, min);
					max = Math.max(value.max + value1.max, max);
				} else {
					min = Math.min(value.min * value1.min, min);
					max = Math.max(value.max * value1.max, max);
				}
			}
		}
		Pair ans = new Pair(max, min);
		return ans;
	}
}