package bitsManipulation;

import java.util.Scanner;

public class powerOfTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>= 1;
		}
		if (count == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
