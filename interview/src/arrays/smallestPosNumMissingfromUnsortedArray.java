package arrays;

import java.util.Scanner;

public class smallestPosNumMissingfromUnsortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		smallestPos(arr);
	}

	private static void smallestPos(int[] arr) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				arr[j] = 10;
				j++;
			}

		}
		for (int i = j; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (index < arr.length) {
				arr[index] = -arr[index];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				System.out.println(i + 1);
				return;
			}
		}
	}
}
