package bitsManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class josephusProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			al.add(i);
		}
		int k = 2;
		int currPos = 1;
		while (al.size() > 1) {
			int index = (currPos - 1 + k - 1) % al.size();
			al.remove(index);
			currPos = al.get(index);
		}
		int ans = al.get(0);
		System.out.println(ans);
	}
}
