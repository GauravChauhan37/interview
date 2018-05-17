package bitsManipulation;

import java.util.Scanner;

public class sumofBitDifferencesAmongPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int zeroCount = 0;
		int oneCount = 0;
		int ans = 0;
		for (int j = 0; j < 32; j++) {
			for (int i = 0; i < arr.length; i++) {
				if ((arr[i] & 1) != 1) {
					zeroCount++;
				}
				if ((arr[i] & 1) == 1) {
					oneCount++;
				}
				arr[i] >>= 1;
			}
			ans += zeroCount * oneCount * 2;
			zeroCount = 0;
			oneCount = 0;
		}
		System.out.println(ans);
	}
}
