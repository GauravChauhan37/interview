package strings;

import java.util.Scanner;

public class checkIfBinaryRepOfTwoNumsAreAnagram {
	private static boolean checkIfAnagramOrNot(int x, int y) {
		int count = 0;
		while (x != 0) {
			if ((x & 1) == 1) {
				count++;
			}
			x = x >> 1;
		}

		while (y != 0) {
			if ((y & 1) == 1) {
				count--;
			}
			y = y >> 1;
		}
		if (count == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		boolean ans = checkIfAnagramOrNot(x, y);
		System.out.println(ans);
	}
}
