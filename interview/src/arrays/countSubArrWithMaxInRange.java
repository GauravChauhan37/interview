package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class countSubArrWithMaxInRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		// ArrayList<Integer> incl = new ArrayList<>();
		// ArrayList<Integer> excl = new ArrayList<>();
		// int incl_Count = 0;
		// int excl_Count = 0;
		// int count_Of_Subarr = 0;
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i] < lo) {
		// incl.add(arr[i]);
		// } else if (arr[i] > hi) {
		// incl_Count += incl.size();
		// excl_Count += excl.size();
		// incl.clear();
		// excl.clear();
		// count_Of_Subarr += ((incl.size() * (incl.size() + 1) / 2) -
		// (excl.size() * (excl.size() + 1) / 2));
		// } else {
		// excl_Count += excl.size();
		// excl.clear();
		// count_Of_Subarr = -(excl.size() * (excl.size() + 1) / 2);
		// }
		// }
		// System.out.println(count_Of_Subarr);
		int inc = 0, exc = 0, sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < lo) {
				inc++;
				exc++;
			} else if (lo <= arr[i] && arr[i] <= hi) {
				sum -= (exc * (exc + 1)) / 2;
				exc = 0;
				inc++;
			} else {
				sum += (inc * (inc + 1)) / 2;
				sum -= (exc * (exc + 1)) / 2;
				inc = 0;
				exc = 0;
			}
		}
		sum += (inc * (inc + 1)) / 2;
		sum -= (exc * (exc + 1)) / 2;
		System.out.println(sum);
	}
}
