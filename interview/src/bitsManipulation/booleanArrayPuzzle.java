package bitsManipulation;

import java.util.Scanner;

public class booleanArrayPuzzle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		arr[1] = arr[arr[0]];
		arr[0] = arr[1];
		System.out.print(arr[0] + " " + arr[1]);
	}
}
