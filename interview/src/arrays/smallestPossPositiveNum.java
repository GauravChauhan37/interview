package arrays;

import java.util.Scanner;

public class smallestPossPositiveNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum + 1 < arr[i]) {
				System.out.println(sum + 1);
			} else {
				sum += arr[i];
			}
		}
		System.out.println(sum+1);
	}
}
