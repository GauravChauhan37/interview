package recurion;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class removeInvalidParenthesis {
	static HashMap<String, Integer> hs = new HashMap<>();
	static int minCount = Integer.MAX_VALUE;

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		int top = st.size();
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) == '(' || s.charAt(i) == ')')) {
				continue;
			} else if (s.charAt(i) == '(') {
				st.push(s.charAt(i));
				top++;
			} else if (s.charAt(i) == ')' && top != 0) {
				st.pop();
				top--;
			} else if (s.charAt(i) == ')' && top == 0) {
				return false;
			}
		}
		if (!(st.isEmpty())) {
			return false;
		} else {
			return true;
		}
	}

	public static void removeparth(String s, int count) {
		if (s.length() == 1) {
			return;
		}
		if (isValid(s)) {
			if (!(hs.containsKey(s))) {
				hs.put(s, count);
				// add count
			} else {

			}
		}

		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			removeparth(left + right, count + 1);
		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		removeparth(s, 0);

	}
}