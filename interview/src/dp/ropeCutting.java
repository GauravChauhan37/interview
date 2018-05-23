package dp;

import java.util.Scanner;

public class ropeCutting {
	public static int maxProd(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 0;
		f[2] = 1;
		for (int val = 3; val < f.length; val++) {
			for (int i = 1; i <= val / 2; i++) {
				f[val] = Math.max(f[val], Math.max(i * (val - i), i * f[val - i]));
			}
		}
		return f[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(maxProd(n));
	}
}
