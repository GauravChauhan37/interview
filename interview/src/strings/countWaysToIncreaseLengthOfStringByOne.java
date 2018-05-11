package strings;

import java.util.Scanner;

public class countWaysToIncreaseLengthOfStringByOne {
	public static void lcs(int[][] arr, String s1, String s2) {
		int k = s1.length() - 1;
		for (int j = arr[0].length - 1; j >= 0; j--) {
			if (s1.charAt(k) == s2.charAt(j)) {
				arr[k][j] = 1;
			}
		}
		int l = s2.length() - 1;
		for (int p = arr.length - 1; p >= 0; p--) {
			if (s2.charAt(l) == s1.charAt(p)) {
				arr[p][l] = 1;
			}
		}
		for (int j = arr[0].length - 2; j >= 0; j--) {
			for (int i = arr.length - 2; i >= 0; i--) {
				if (s1.charAt(i) == s1.charAt(j)) {
					arr[i][j] = 1 + arr[i + 1][j + 1];
				} else {
					arr[i][j] = Math.max(arr[i][j + 1], arr[i + 1][j]);
				}
			}
		}
		System.out.println(arr[0][0]);
	}

	public static void reverseString(String s) {
		char[] ch = new char[s.length()];
		for (int i = 0; i < ch.length; i++) {
			ch[i] = s.charAt(i);
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		s = ch.toString();
	}

	public static void appendAndCheck(String s1, String s2, int[][] suffix, int[][] prefix) {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		int[][] suffix = new int[s1.length()][s2.length()];
		lcs(suffix, s1, s2);
		String s3 = s1;
		String s4 = s2;
		reverseString(s3);
		reverseString(s4);
		int[][] prefix = new int[s3.length()][s4.length()];
		lcs(prefix, s3, s4);
		appendAndCheck(s1, s2, suffix, prefix);
	}
}
