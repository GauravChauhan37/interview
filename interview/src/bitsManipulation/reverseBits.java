package bitsManipulation;

import java.util.Scanner;

public class reverseBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int revnum = 0;
		while (n != 0) {
			revnum <<= 1;
			revnum = (n & 1) | revnum;
			n = n >> 1;
		}
		System.out.println(revnum);
	}
}
