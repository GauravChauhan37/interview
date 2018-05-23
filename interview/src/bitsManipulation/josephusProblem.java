package bitsManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class josephusProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Joseph(n);
	}

	public static void Joseph(int m) {
		int count = 0;
		int n = m;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		if (count == 1) {
			System.out.println(1);
		} else {
			int x = 2;

			while (x < m) {
				x = x * 2;
			}
			x = x / 2; // power of 2 less that n

			int diff = m - x;
			int val = 2 * diff + 1;
			System.out.println(val);
		}
	}
}