package bitsManipulation;

import java.util.Scanner;

public class countNoOfBitsToBeFlipped {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int xor = n ^ m;
		int count = 0;
		while (xor != 0) {
			if ((xor & 1) == 1) {
				count++;
			}
			xor >>= 1;
		}

	}
}