package recurion;

import java.util.Scanner;

public class printAllWaysToBreakAStringInBracketForm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		printAll(s, "");
	}

	private static void printAll(String ques, String ans) {
		if (ans.length() != 0)
			System.out.println("(" + ans + ")");
		for (int i = 0; i < ques.length(); i++) {
			ans = ques.substring(0, i + 1);
			ques = ques.substring(i + 1);
			printAll(ques, ans);
			ques = ans + ques;
		}
	}
}
