package arrays;

import java.util.Scanner;
import java.util.Stack;

public class minNumDISequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		Stack<Integer> st = new Stack<>();
		int i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == 'D') {
				st.push(i + 1);
			} else {
				st.push(i + 1);
				while (!(st.isEmpty())) {
					System.out.print(st.pop());
				}
			}
		}
		st.push(i+1);
		while (!(st.isEmpty())) {
			System.out.print(st.pop());
		}
		
	}
}
