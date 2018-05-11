package strings;

import java.util.Scanner;

public class generateAllBinaryStringsFromGivenPattern {
	public static void print(char s[], int vidx) {
		if (vidx == s.length) {
			System.out.println(s);
			return;
		}

		if (s[vidx] == '?') {
			s[vidx] = '0';
			print(s, vidx);
			s[vidx] = '1';
			print(s, vidx);
			s[vidx] = '?';
		} else
			print(s, vidx + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] str = s.toCharArray();
		print(str, 0);
		sc.close();
	}

}
