package arrays;

import java.util.Scanner;

public class searchAnElementWhoseAdjElementDiffByk {
	public static void search(int[] arr, int k, int elementToBeSearched) {
		for (int i = 0; i < arr.length;) {
			if (i == 0) {
				if (arr[i] == elementToBeSearched && arr[i + 1] <= arr[i] + k) {
					System.out.println(i);
					return;
				}
				i++;
			} else if (i == arr.length - 1) {
				if (arr[i] == elementToBeSearched && arr[i - 1] <= arr[i] + k) {
					System.out.println(i);
					return;
				}
				i++;
			} else if (arr[i] == elementToBeSearched && arr[i + 1] <= arr[i] + k && arr[i - 1] <= arr[i] + k) {
				System.out.println(i);
				return;
			} else {
				int diff = Math.abs(elementToBeSearched - arr[i]);
				int jump = diff / k;
				i += jump > 0 ? jump : 1;
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
		int k = sc.nextInt();
		int x = sc.nextInt();
		sc.close();
		search(arr, k, x);
	}

}
