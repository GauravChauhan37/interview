package strings;

import java.util.Scanner;

public class transformOneStringToAnotherUsingMinimumNumberOfGivenOperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		sc.close();
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int count = 0;
		while (j >= 0) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i--;
				j--;
			} else {
				j--;
				count++;
			}
		}
		System.out.println(count);
	}
}
