package dp;

import java.util.Scanner;

public class evenLengthLongestSubStringSuchThatSumOfFirstAndSecndHalfIsSame {
	public static int findLength(String str, int n) {
		int ans = 0;
		for (int i = 0; i < n-1; i++) {
			int left = i, right = i + 1;
			int leftsum = 0, rightsum = 0;
			while (right < n && left >= 0) {
				leftsum += str.charAt(left) - '0';
				rightsum += str.charAt(right) - '0';
				left--;
				right++;
				if (leftsum == rightsum) {
					ans = Math.max(ans, right - left + 1);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int ans = findLength(s, s.length());
		System.out.println(ans);
	}

}
