package arrays;

import java.util.Scanner;

public class coutingSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] count = new int[n];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] sorted = new int[n];
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] != 0) {
				sorted[count[arr[i]]] = arr[i];
				count[arr[i]]--;
			}
		}
		for (int i = 0; i < sorted.length; i++) {
			if (sorted[i] != 0)
				System.out.print(sorted[i] + " ");
		}
	}
}
