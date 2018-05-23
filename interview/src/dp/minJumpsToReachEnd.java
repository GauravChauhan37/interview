package dp;

import java.util.Scanner;

public class minJumpsToReachEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] count = new int[arr.length];
		for (int i = count.length - 2; i >= 0; i--) {
			if (arr[i] >= count.length - i) {
				count[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; i < count.length && j <= i + arr[i]; j++) {
					if (min > count[j]) {
						min = count[j];
					}
				}
				count[i] = 1 + min;
			}
		}
		System.out.println(count[0]);
	}
}
