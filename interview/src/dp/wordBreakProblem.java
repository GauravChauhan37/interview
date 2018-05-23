package dp;

import java.util.HashSet;
import java.util.Scanner;

public class wordBreakProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = { "i", "like", "Gaurav" };
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hs.add(arr[i]);
		}
		String s = sc.next();
		sc.close();
		boolean[] ans = new boolean[s.length()];
		for (int i = 0; i < ans.length; i++) {
			String c = s.substring(0, i + 1);
			if (hs.contains(c)) {
				ans[i] = true;
			} else { 
				for (int j = 0; j < i; j++) {
					if (ans[j] = true) {
						if (hs.contains(s.substring(j+1, i + 1))) {
							ans[i] = true;
						}
					}
				}
			}
		}
		System.out.println(ans[s.length() - 1]);
	}
}
