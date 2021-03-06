package arrays;

import java.util.Scanner;

public class kthLargestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		quickSelect(0, arr.length - 1, arr, k);
	}

	private static void quickSelect(int i, int j, int[] arr, int k) {
		int pivotIndex = partition(arr, i, j);

		if (pivotIndex < arr.length - k) {
			quickSelect(pivotIndex + 1, j, arr, k);
		} else if (pivotIndex > arr.length - k) {
			quickSelect(i, pivotIndex - 1, arr, k);
		} else {
			System.out.println(arr[pivotIndex]);
			return;
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		int j = start;
		
			while (j < end) {
				if (arr[j] <= pivot) {
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
			int temp = arr[i + 1];
			arr[i + 1] = arr[end];
			arr[end] = temp;
		
		return i + 1;
	}
}