package orderAndStats;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<Integer, Integer> hp = new HashMap<>();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (!(st.isEmpty()) && arr[i] > st.peek()) {
				while (!(st.isEmpty()) && arr[i] > st.peek()) {
					int element = st.pop();
					hp.put(element, arr[i]);
				}
				st.push(arr[i]);
			} else {
				st.push(arr[i]);
			}
		}
		if (!(st.isEmpty())) {
			int el = st.pop();
			hp.put(el, -1);
		}
		System.out.println(hp);
	}
}
