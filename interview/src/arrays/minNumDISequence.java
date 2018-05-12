package arrays;

import java.util.Scanner;
import java.util.Stack;

public class minNumDISequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = new char[sc.nextInt()];
		arr = sc.next().toCharArray();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'D') {
				st.push(i + 1);
			} else {
				st.push(i + 1);
				while (!(st.isEmpty())) {
					System.out.print(st.pop());
				}
			}
		}
		System.out.print(st.pop());
		System.out.print(arr.length + 1);
	}
}
