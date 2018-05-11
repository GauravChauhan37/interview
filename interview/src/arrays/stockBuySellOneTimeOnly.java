package arrays;

import java.util.Scanner;

public class stockBuySellOneTimeOnly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int maxProfit = Integer.MIN_VALUE;
		int minSoFar = arr[0];
		int profitSoFar = 0;
		for (int i = 1; i < arr.length; i++) {
			if (minSoFar < arr[i]) {
				profitSoFar = arr[i] - minSoFar;
				if(profitSoFar > maxProfit){
					maxProfit = profitSoFar;
				}
			} else {
				minSoFar = arr[i];
				profitSoFar = 0;
			}
		}
		System.out.println(maxProfit);
	}
}
