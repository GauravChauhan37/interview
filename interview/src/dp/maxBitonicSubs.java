package dp;

import java.util.Scanner;

public class maxBitonicSubs {
	public static void longestBitSub(int[] arr) {
		int[] incCount = new int[arr.length];
		int[] decCount = new int[arr.length];
		int maxSub = Integer.MIN_VALUE;
		incCount[0] = arr[0];
		for (int i = 1; i < incCount.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (incCount[i] < incCount[j]) {
						incCount[i] = incCount[j];
					}
				}
			}
			incCount[i] += arr[i];
		}
		decCount[decCount.length - 1] = arr[decCount.length - 1];
		for (int i = decCount.length - 2; i >= 0; i--) {
			for (int j = decCount.length - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					if (decCount[i] < decCount[j])
						decCount[i] = decCount[j];
				}
			}
			decCount[i] += arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			if (incCount[i] + decCount[i] > maxSub)
				maxSub = incCount[i] + decCount[i] - arr[i];
		}
		System.out.println(maxSub);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		longestBitSub(arr);
	}

}
