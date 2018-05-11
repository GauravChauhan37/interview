package arrays;

import java.util.Scanner;

public class findRepeatingAndMissingElements {
	public static void findRepeatingAndMissing(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int idx= Math.abs(arr[i]);
			if (arr[idx - 1] > 0) {
				arr[idx -1]*=-1;
			} else {
				arr[idx -1]=0;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				System.out.println(++i);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				System.out.println(++i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		findRepeatingAndMissing(arr);
	}

}
