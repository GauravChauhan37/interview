package arrays;

import java.util.Scanner;

public class generateNextpermutationOfGivenNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = n + "";
		int[] arr = new int[s.length()];
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = n % 10;
			n = n / 10;
		}
		int i = arr.length - 1;
		boolean flag = false;
		while (i > 0) {
			if (arr[i] < arr[i - 1]) {
				i--;
				flag = true;
			} else {
				i--;
				flag = false;
			}
		}
		if (i == 0 && flag == true) {
			// int j = arr.length - 1;
			// while (i < j) {
			// int temp = arr[i];
			// arr[i] = arr[j];
			// arr[j] = temp;
			// i++;
			// j--;
			// }
			for (int p = arr.length - 1; p >= 0; p--) {
				System.out.print(arr[p]);
			}
			return;
		}

		int index = 0;
		for (index = i + 1; index < arr.length - 1; index++) {
			if (arr[index] > arr[i] && arr[index + 1] < arr[i]) {
				break;
			}
		}
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
		i++;

		index = arr.length - 1;
		while (index > i) {
			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
			index--;
			i++;
		}
		for (int p = 0; p < arr.length; p++) {
			System.out.print(arr[p]);
		}
	}
}
