package dp;

import java.util.Scanner;

public class friendsPairingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			if (i <= 2) {
				arr[i] = i;
			} else {
				arr[i] = arr[i - 1] + arr[i - 2] * (i - 1);
			}
		}
		System.out.println(arr[n]);
	}
}
