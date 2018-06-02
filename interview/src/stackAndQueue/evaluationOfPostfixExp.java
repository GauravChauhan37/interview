package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class evaluationOfPostfixExp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		Stack<Integer> st = new Stack<>();
		int ans = postFix(s, st);
		System.out.println(ans);
	}

	private static int postFix(String s, Stack<Integer> st) {

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				st.push(ch - '0');
			} else {
				int val1 = st.pop();
				int val2 = st.pop();
				int res = cal(val1, ch, val2);
				st.push(res);
			}
		}
		return st.pop();
	}

	private static int cal(int val1, char ch, int val2) {
		int ans = 0;
		switch (ch) {
		case '+':
			ans = val1 + val2;
			break;
		case '-':
			ans = Math.abs(val1 - val2);
			break;
		case '*':
			ans = val1 * val2;
			break;
		case '/':
			ans = val1 / val2;
			break;
		}
		return ans;
	}
}
