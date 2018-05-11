package bitsManipulation;

import java.util.Scanner;

public class numberOccuringOddTime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			x ^= arr[i];
		}
		System.out.println(x);
	}

}
