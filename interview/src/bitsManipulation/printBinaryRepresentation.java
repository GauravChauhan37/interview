package bitsManipulation;

import java.util.Scanner;

public class printBinaryRepresentation {
	private static void printBin(int num) {
		if (num == 0) {
			return;
		}
		printBin(num / 2);
		System.out.print(num % 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printBin(n);
	}
}