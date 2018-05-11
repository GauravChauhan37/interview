package arrays;

import java.util.Scanner;

public class maxSumSuchThatNoTwoElementsAreAdjacent {
	public static void findMaxSum(int[] arr) {
		int incl = arr[0];
		int excl = 0;
		for (int i = 1; i < arr.length; i++) {
			int new_incl = excl + arr[i];
			int new_excl = Math.max(excl, incl);
			incl = new_incl;
			excl = new_excl;
		}
		System.out.println(incl);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		findMaxSum(arr);
	}

}
