package arrays;

import java.util.Scanner;

public class maxSumSubarrayWithAtleastKelements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int[] maxSumSoFar = new int[arr.length];
		int sum = arr[0];
		maxSumSoFar[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum + arr[i] > arr[i]) {
				sum += arr[i];
				maxSumSoFar[i] = sum;
			} else {
				sum = arr[i];
				maxSumSoFar[i] = arr[i];
			}
		}
		int currSum = 0;
		for (int i = 0; i < k; i++) {
			System.out.println(3);
		}
	}
}
