package arrays;

import java.util.Scanner;

public class minSwapsReqToGatherKElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int swap_Score = 0;
		int over_Swap_Score = Integer.MAX_VALUE;
		int lo = 0;
		int hi;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				count++;
			}
		}
		hi = count - 1;
		for (int i = lo; i <= hi; i++) {
			if (arr[i] > k) {
				swap_Score++;
			}
		}
		while (hi + 1 < arr.length) {
			if (swap_Score < over_Swap_Score) {
				over_Swap_Score = swap_Score;
			}
			if (arr[lo] <= k) {
				swap_Score++;
			} else {
				swap_Score--;
			}
			lo++;
			hi++;
			if (arr[hi] > k) {
				swap_Score++;
			}
		}
		System.out.println(over_Swap_Score);
	}
}
