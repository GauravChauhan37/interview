package arrays;

import java.util.Scanner;

public class stockBuySellTwoTimes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int min = arr[0];
		int[] minSoFar = new int[arr.length];
		minSoFar[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			if (min <= arr[i]) {
				minSoFar[i] = Math.max(minSoFar[i - 1], arr[i] - min);
			} else {
				min = arr[i];
				minSoFar[i] = minSoFar[i - 1];
			}
		}
		int max = arr[arr.length - 1];
		int[] maxSoFar = new int[arr.length];
		maxSoFar[maxSoFar.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (max >= arr[i]) {
				maxSoFar[i] = Math.max(maxSoFar[i + 1], max - arr[i]);
			} else {
				max = arr[i];
				maxSoFar[i] = maxSoFar[i + 1];
			}
		}
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < maxSoFar.length; i++) {
			if (minSoFar[i] + maxSoFar[i] > maxProfit) {
				maxProfit = minSoFar[i] + maxSoFar[i];
			}
		}
		System.out.println(maxProfit);
	}
}
