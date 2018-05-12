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
		int lo = 0;
		int hi = k - 1;
		int max = Integer.MIN_VALUE;
		int ov_max = Integer.MIN_VALUE;
		while (hi < arr.length) {
			for (int i = lo; i <= hi; i++) {
				currSum += arr[i];
			}
			if (lo == 0) {
				if (currSum > max) {
					max = currSum;
					lo++;
					hi++;
					currSum = 0;
				}
			} else {
				if (currSum + maxSumSoFar[lo - 1] > max && maxSumSoFar[lo - 1] > 0) {
					max = currSum + maxSumSoFar[lo - 1];
				} else if (currSum > max) {
					max = currSum;
				}

				lo++;
				hi++;
				currSum = 0;

			}
			if (ov_max < max) {
				ov_max = max;
			}
		}
		System.out.println(ov_max);
	}
}
