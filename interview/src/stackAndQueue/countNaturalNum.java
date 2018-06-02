package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class countNaturalNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Stack<Integer> st = new Stack<>();
		for (int i = 1; i <= 9; i++) {
			st.push(i);
		}
		int count = 0;
		while (!(st.isEmpty())) {
			int val = st.pop();
			count++;
			int index = val % 10;
			for (int i = index; i <= 9; i++) {
				int ans = val * 10 + i;
				if (ans <= n) {
					st.push(ans);
				} else {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
