package dp;

import java.util.Scanner;

public class highwayBillBoard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[sc.nextInt()];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		int[] revenue = new int[sc.nextInt()];
		for (int i = 0; i < revenue.length; i++) {
			revenue[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		sc.close();
		int[] arr = new int[x.length];
		arr[0] = revenue[0];
		for (int i = 1; i < arr.length; i++) {
			int msf = Integer.MIN_VALUE;

			for (int j = i - 1; j >= 0; j--) {
				if (x[i] - x[j] > t) {
					msf = Math.max(msf, arr[j] + revenue[i]);
				}

			}
			arr[i] = Math.max(msf, Math.max(revenue[i], arr[i - 1]));
		}
		System.out.println(arr[arr.length - 1]);
	}

}
