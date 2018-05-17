package recurion;

import java.util.ArrayList;
import java.util.Scanner;

public class partitionKSubsets {

	static boolean ans = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		ArrayList<Integer>[] subset = new ArrayList[k];
		for (int i = 0; i < subset.length; i++) {
			subset[i] = new ArrayList<>();
		}
		int[] subsetsum = new int[k];
		solve(arr, subsetsum, subset, 0);
		if (ans) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static void solve(int[] arr, int[] subsetsum, ArrayList<Integer>[] subset, int vidx) {
		if (vidx == arr.length) {
			for (int i = 1; i < subsetsum.length; i++) {
				if (subsetsum[i] != subsetsum[i - 1])
					return;
			}

			ans = true;
			return;
		}

		for (int i = 0; i < subset.length; i++) {
			subsetsum[i] += arr[vidx];
			subset[i].add(arr[vidx]);
			solve(arr, subsetsum, subset, vidx + 1);

			subsetsum[i] -= arr[vidx];
			subset[i].remove(subset[i].size() - 1);
		}
	}

}