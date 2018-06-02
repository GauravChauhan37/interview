package strings;

import java.util.Scanner;

public class isGivenSentIsCorrectOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		if (s.charAt(0) < 'A' || s.charAt(0) > 'Z') {
			System.out.println("false");
			return;
		}
		if (s.charAt(s.length() - 1) != '.') {
			System.out.println("false");
			return;
		}
		boolean ans = checkIfValid(s);
		System.out.println(ans);
	}

	private static boolean checkIfValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		String[] ch = s.split(" ");
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				count++;
			}
		}
		if (count > 1) {
			return false;
		} else {
			return checkIfValid(s.substring(ch.length));
		}
	}
}
