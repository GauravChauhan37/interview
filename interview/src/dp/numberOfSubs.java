package dp;

import java.util.Scanner;

public class numberOfSubs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int[][] count = new int[s.length()][3];
		if (s.charAt(0) == 'a') {
			count[0][0] = 1;
		}
		if (s.charAt(0) == 'b') {
			count[0][1] = 1;
		}
		if (s.charAt(0) == 'b') {
			count[0][2] = 1;
		}
		for (int i = 1; i < count.length; i++) {
			if (s.charAt(i) == 'a') {
				count[i][0] = 1 + 2 * count[i - 1][0];
				count[i][1] = count[i - 1][1];
				count[i][2] = count[i - 1][2];
			}
			if (s.charAt(i) == 'b') {
				count[i][1] = count[i - 1][0] + 2 * count[i - 1][1];
				count[i][0] = count[i - 1][0];
				count[i][2] = count[i - 1][2];
			}
			if (s.charAt(i) == 'c') {
				count[i][2] = count[i - 1][1] + 2 * count[i - 1][2];
				count[i][1] = count[i - 1][1];
				count[i][0] = count[i - 1][0];
			}
		}
		System.out.println(count[count.length - 1][2]);
	}
}
