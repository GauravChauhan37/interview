package bitsManipulation;

import java.util.Scanner;

public class Calculate7n8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int ans = (n << 3);
		ans -= n;
		ans >>= 3;
		System.out.println(ans);
	}
}
