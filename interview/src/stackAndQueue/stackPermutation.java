package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class stackPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] first = new int[sc.nextInt()];
		for (int i = 0; i < first.length; i++) {
			first[i] = sc.nextInt();
		}
		int[] scnd = new int[sc.nextInt()];
		for (int i = 0; i < scnd.length; i++) {
			scnd[i] = sc.nextInt();
		}
		sc.close();
		Stack<Integer> st = new Stack<>();
		int i, j;
		for (i = 0, j = 0; i < first.length && j < scnd.length;) {
			if (st.isEmpty()) {
				if (first[i] != scnd[j]) {
					st.push(first[i]);
					i++;
				} else {
					i++;
					j++;
				}
			} else {
				if (scnd[j] == st.peek()) {
					st.pop();
					j++;
				} else {
					if (first[i] == scnd[j]) {
						i++;
						j++;
					} else {
						st.push(i);
						i++;
					}
				}
			}
		}
		if (j < scnd.length) {
			while (!(st.empty())) {
				if (st.peek() == scnd[j]) {
					j++;
					st.pop();
				} else {
					System.out.println("false");
					return;
				}
			}
		}
		System.out.println("true");
	}
}