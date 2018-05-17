package bitsManipulation;

import java.util.Scanner;

public class nibbleSwap {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int k = 4;
		int num1 = num & (1 << k) - 1;
		int num2 = num & ~((1 << k) - 1);
		num1 <<= k;
		num2 >>=  k;
		int result = num1 | num2;
		System.out.println(result);
	}
}