package arrays;

import java.util.Scanner;
public class maxproductofsub {
	private static void maxproduct(int[] arr) {
		int currMin = 1;
		int currMax = 1;
		int oMaxProd = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				oMaxProd = oMaxProd < 0 ? 0 : oMaxProd;
				currMax = 1;
				currMin = 1;
			}
			,++
			int min = currMin;
			currMin = Math.min(arr[i], Math.min(arr[i] * currMin, arr[i] * currMax));
			currMax = Math.max(arr[i], Math.max(arr[i] * min, arr[i] * currMax));
			oMaxProd = Math.max(oMaxProd, currMax);
		}
		System.out.println(oMaxProd);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		maxproduct(arr);
	}
}
