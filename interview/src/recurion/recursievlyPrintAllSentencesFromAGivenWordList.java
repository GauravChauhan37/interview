package recurion;

import java.util.Scanner;

public class recursievlyPrintAllSentencesFromAGivenWordList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// String[][] arr = new String[sc.nextInt()][sc.nextInt()];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = sc.next().split(",");
		// }
		String[][] arr = { { "you", "we" }, { "have", "are" }, { "sleep", "eat", "drink" } };
		sc.close();
		String ans = "";
		printAll(arr, 0, ans);
	}

	private static void printAll(String[][] arr, int row, String ans) {
		if (row >= arr.length) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr[0].length; i++) {
			printAll(arr, row + 1, ans + arr[row][i]+" ");
		}
	}
}
