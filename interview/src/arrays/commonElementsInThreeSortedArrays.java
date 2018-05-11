package arrays;

import java.util.Scanner;

public class commonElementsInThreeSortedArrays {
	private static void findCommonElement(int[] arr, int[] arr2, int[] arr3) {
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		while (index1 < arr.length && index2 < arr2.length && index3 < arr3.length) {
			int first = arr[index1];
			int scnd = arr2[index2];
			int thrd = arr3[index3];
			if (first < scnd || first < thrd) {
				index1++;
			} else if (scnd < first || scnd < thrd) {
				index2++;
			} else if (thrd < first || thrd < scnd) {
				index3++;
			} else if (first == scnd && scnd == thrd) {
				System.out.print(scnd + " ");
				index1++;
				index2++;
				index3++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr2 = new int[sc.nextInt()];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		int[] arr3 = new int[sc.nextInt()];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = sc.nextInt();
		}
		sc.close();
		findCommonElement(arr, arr2, arr3);
	}
}
