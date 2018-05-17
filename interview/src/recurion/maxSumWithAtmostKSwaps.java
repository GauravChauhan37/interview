package recurion;

import java.util.Scanner;

public class maxSumWithAtmostKSwaps {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		sc.close();
		maxSum(s, n);
		System.out.println(max);
	}

	private static void maxSum(String s, int k) {
		if (max < Integer.parseInt(s)) {
			max = Integer.parseInt(s);
		}
		if (k == 0) {
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				s = swap(s, i, j);
				maxSum(s, k - 1);
				s = swap(s, i, j);
			}
		}
	}

	private static String swap(String s, int i, int j) {
		String first = s.substring(0, i);
		String mid = s.substring(i + 1, j);
		String last = s.substring(j + 1);
		return first + s.charAt(j) + mid + s.charAt(i) + last;
	}
}
