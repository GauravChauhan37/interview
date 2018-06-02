package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class sortAStackUsingRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Stack<Integer> input = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			input.push(arr[i]);
		}
		recurse(input);
		print(input);

	}

	public static void recurse(Stack<Integer> st) {

		if (st.isEmpty())
			return;

		int x = st.pop();
		recurse(st);
		sort(st, x);

	}
 
	private static void sort(Stack<Integer> st, int x) {

		if ( st.isEmpty()||st.peek() < x ) {
			st.push(x);
			return;
		} else {

			int temp = st.pop();
			sort(st, x);
			st.push(temp);
		}

	}
	private static void print(Stack<Integer>st){
		while(!st.isEmpty()){
			int x=st.pop();
			System.out.print(x+" ");
		}
	}

}