package bitsManipulation;

import java.util.Scanner;

public class printBinaryRepresentation {
	private static void printBin(int num) {
		if (num == 0) {
			System.out.println("0");
			return;
		}
		StringBuilder sb = new StringBuilder();
		// printBin(num / 2); //recursive way
		// System.out.print(num % 2);
		while (num != 0) {
			if ((num & 1) == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			num>>=1;
		}
		sb.reverse();
		System.out.println(sb);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printBin(n);
	}
}