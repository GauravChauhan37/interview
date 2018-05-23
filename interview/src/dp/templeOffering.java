package dp;

import java.util.Scanner;
import java.util.Stack;

public class templeOffering {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int count = 0;
		int num = 1;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				st.push(num);
				while (!(st.isEmpty())) {
					int c = st.pop();
					count += c;
					num = 1;
				}
			} else {
				st.push(num);
				num++;
			}
		}
		st.push(arr[arr.length - 1]);
		while (!(st.isEmpty())) {
			int c = st.pop();
			count += c;
		}
		System.out.println(count);
	}
}
