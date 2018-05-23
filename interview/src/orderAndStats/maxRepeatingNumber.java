package orderAndStats;

import java.util.Scanner;

public class maxRepeatingNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			int index = (arr[i] % k);
			arr[index] = arr[index] + k;
		}
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[maxIndex] < arr[i])
				maxIndex = i;
		}
		System.out.println(maxIndex);
	}

}
