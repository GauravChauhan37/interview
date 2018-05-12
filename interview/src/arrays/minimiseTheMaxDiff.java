package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class minimiseTheMaxDiff {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		Arrays.sort(arr);
		int low = arr[0] + k;
		int high = arr[arr.length - 1] - k;
		for (int i = 1; i < arr.length - 1; i++) {
			int add = arr[i] + k;
			int sub = arr[i] - k;
			if(low<=sub || add<=high){
				//do nothing
			}
			else if (add-high < low - sub) {
				high=add;
			} else if (add-high > low - sub) {
				low=sub;
			}
		}
		int ans = Math.min(Math.abs(high - low), arr[arr.length-1] - arr[0]);
		System.out.println(ans);
	}
}
