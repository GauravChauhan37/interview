package greedyAlgorithmns;

import java.util.Scanner;

public class combinationalSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		combinationalSum(arr, target, "", 0);
	}

	private static void combinationalSum(int[] arr, int target, String asf, int lp) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = lp; i < arr.length; i++) {
			combinationalSum(arr, target - arr[i], asf + arr[i] + " ", i);
		}
	}
}
