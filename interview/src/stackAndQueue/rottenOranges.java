package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rottenOranges {
	public static class Pair {
		int row;
		int col;

		public Pair(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[sc.nextInt()][sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		LinkedList<Pair> q = new LinkedList<>();
		preProcess(q, arr);
		rot(0, q, arr);
	}

	private static void rot(int time, LinkedList<Pair> q, int[][] arr) {
		while (!(q.isEmpty())) {
			if (valid(q, arr)) {
				System.out.println(time + 1);
				return;
			}
			Pair node = q.removeFirst();
			if (node.row == -1 && node.col == -1) {
				time++;
				if (q.isEmpty() && valid(q, arr) == false) {
					System.out.println("not poss");
					return;
				} else {
					Pair pair = new Pair(-1, -1);
					q.add(pair);
				}
			} else {
				int row = node.row;
				int col = node.col;
				set(arr, q, row, col);
			}
		}
	}

	private static void set(int[][] arr, LinkedList<Pair> q, int row, int col) {

		if (row - 1 >= 0) {
			if (arr[row - 1][col] == 1) {
				Pair pair = new Pair(row - 1, col);
				q.add(pair);
				arr[row - 1][col] = 2;
			}
		}
		if (col - 1 >= 0) {
			if (arr[row][col - 1] == 1) {
				Pair pair = new Pair(row, col - 1);
				q.add(pair);
				arr[row][col - 1] = 2;
			}
		}
		if (row + 1 < arr.length) {
			if (arr[row + 1][col] == 1) {
				Pair pair = new Pair(row + 1, col);
				q.add(pair);
				arr[row + 1][col] = 2;
			}
		}
		if (col + 1 < arr[0].length) {
			if (arr[row][col + 1] == 1) {
				Pair pair = new Pair(row, col + 1);
				q.add(pair);
				arr[row][col + 1] = 2;
			}
		}

	}

	private static boolean valid(LinkedList<Pair> q, int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void preProcess(Queue<Pair> q, int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					Pair pair = new Pair(i, j);
					q.add(pair);
				}
			}
		}
		Pair pair = new Pair(-1, -1);
		q.add(pair);
	}
}