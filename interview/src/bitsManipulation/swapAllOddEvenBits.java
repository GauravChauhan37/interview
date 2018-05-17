package bitsManipulation;

import java.util.Scanner;

public class swapAllOddEvenBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int bm1 = 85;
		int bm2 = ~(bm1);
		int ans = (n & bm1) << 1;
		int ans1 = (n & bm2) >> 1;
		int ans3 = ans | ans1;
		System.out.println(ans3);
	}
}
