package bitsManipulation;

import java.util.Scanner;

public class copyBitsInRange {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int y = scn.nextInt();
		int l = scn.nextInt();
		int r = scn.nextInt();
		int mask = 1;
		mask = mask << r - l + 1;
		mask -= 1;
		mask = mask << (l - 1);

		mask = mask & y;
		mask = mask | x;
		System.out.println(mask);
	}
}