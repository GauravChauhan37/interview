package bitsManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class grayCode {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<String> al = solve(n);
		for (String str : al) {
			System.out.println(str);
		}

	}

	private static ArrayList<String> solve(int n) {
		if (n == 0) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}

		ArrayList<String> al = solve(n - 1);
		for (int j = al.size() - 1; j >= 0; j--) {
			al.add(al.get(j));
		}
		ArrayList<String> ans = new ArrayList<>();
		for (int j = 0; j < al.size(); j++) {

			String str = al.get(j);
			if (j < al.size() / 2)
				str = '0' + str;
			else
				str = '1' + str;
			ans.add(str);

		}

		return ans;
	}
}
