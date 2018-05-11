package bitsManipulation;

import java.util.Scanner;

public class findOddOccuringElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int xorOfTwo = 0;
		for (int i = 0; i < arr.length; i++) {
			xorOfTwo ^= arr[i];
		}
		int setBit = xorOfTwo & ~(xorOfTwo - 1);
		int x = 0, y = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & setBit) == setBit) {
				x ^= arr[i];
			} else {
				y ^= arr[i];
			}
		}
		System.out.println(x);
		System.out.println(y);
	}

}
