package matrices2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class printAllinsortedorderFromRowAndCol {
	static class Pair implements Comparable<Pair> {
		int val;
		int row;
		int col;

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[sc.nextInt()][sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		Pair[][] pair = new Pair[arr.length][arr[0].length];

		for (int i = 0; i < pair.length; i++) {
			for (int j = 0; j < pair[0].length; j++) {
				pair[i][j] = new Pair();
				pair[i][j].val = arr[i][j];
				pair[i][j].row = i;
				pair[i][j].col = j;
			}
		}
		PriorityQueue<Pair> p = new PriorityQueue<>();
		for (int i = 0; i < arr[0].length; i++) {
			p.add(pair[0][i]);
		}
		while (!(p.isEmpty())) {
			Pair rem = p.remove();
			System.out.println(rem.val);
			int row = rem.row + 1;
			int col = rem.col;
			if (row < arr.length && col < arr[0].length) {
				Pair a = new Pair();
				a.val = arr[row][col];
				a.row = row;
				a.col = col;
				p.add(a);
			}
		}
	}
}