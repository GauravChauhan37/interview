package dp;

import java.util.Scanner;

public class countPossibleDecodingOfAGivenDigitSeq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int[] count = new int[arr.length];
		count[0] = 1;
		for (int i = 1; i < count.length; i++) {
			if (arr[i] <= 26) {
				count[i] += count[i - 1];
			}
			if (arr[i] + arr[i - 1] <= 26) {
				if (i - 2 >= 0) {
					count[i] += count[i - 2];
				} else {
					count[i] += 1;
				}
			}
		}
		System.out.println(count[count.length - 1]);
	}
}
