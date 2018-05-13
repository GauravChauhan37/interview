package strings;

import java.util.Scanner;

public class ncrCombinations {
	public static void ncr(int[] arr, int noOfElements, String ans, int last_Placed) {
		if (noOfElements * 2 == ans.length()) {
			System.out.println(ans);
			return;
		}
		for (int i = last_Placed + 1; i < arr.length; i++) {
			ncr(arr, noOfElements, ans + arr[i] + " ", i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int noOfElements = sc.nextInt();
		sc.close();
		ncr(arr, noOfElements, "", -1);
	}

}
