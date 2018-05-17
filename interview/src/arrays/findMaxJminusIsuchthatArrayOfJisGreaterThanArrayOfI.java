package arrays;

import java.util.Scanner;

public class findMaxJminusIsuchthatArrayOfJisGreaterThanArrayOfI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] maxSoFar = new int[arr.length];
		int[] minSoFar = new int[arr.length];
		maxSoFar[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			maxSoFar[i] = Math.max(arr[i], maxSoFar[i + 1]);
		}
		minSoFar[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			minSoFar[i] = Math.min(arr[i], minSoFar[i - 1]);
		}
		int maxDiffSoFar = Integer.MIN_VALUE;
		int i = 0, j = 0;
		while (i < maxSoFar.length && j < minSoFar.length) {
			if (maxSoFar[j] > minSoFar[i]) {
				if (maxDiffSoFar < j - i) {
					maxDiffSoFar = j - i;
				}
				j++;
			} else {
				i++;
			}

		}
		System.out.println(maxDiffSoFar);
	}
}
