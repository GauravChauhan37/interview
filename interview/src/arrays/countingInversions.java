package arrays;

import java.util.Scanner;

public class countingInversions {
	public static int mergeSort(int[] arr, int low, int high, int[] sortedArr) {
		if (low >= high) {
			return 0;
		}
		int mid = (low + high) / 2;
		int inversions = 0;
		inversions += mergeSort(arr, low, mid, sortedArr);
		inversions += mergeSort(arr, mid + 1, high, sortedArr);
		inversions += merge(arr, low, mid + 1, high, sortedArr);
		return inversions;
	}

	private static int merge(int[] arr, int start, int mid, int end, int[] sortedArr) {
		int inversions = 0;
		int i = start;
		int j = mid;
		int k = start;
		while (i < mid && j <= end) {
			if (arr[i] < arr[j]) {
				sortedArr[k] = arr[i];
				i++;
				k++;
			} else {
				sortedArr[k] = arr[j];
				j++;
				k++;
				inversions = mid - i;
			}
		}
		if (i < mid) {
			while (i < mid) {
				sortedArr[k] = arr[i];
				i++;
				k++;
			}
		}
		if (j <= end) {
			while (j <= end) {
				sortedArr[k] = arr[j];
				j++;
				k++;
			}
		}
		for (int p = start; p <= end; p++) {
			arr[p] = sortedArr[p];
		}
		return inversions;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int inversions = mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
		System.out.println(inversions);
	}

}
