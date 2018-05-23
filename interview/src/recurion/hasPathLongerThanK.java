package recurion;

import java.util.HashSet;
import java.util.Scanner;

public class hasPathLongerThanK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int inputs = sc.nextInt();
		while (inputs != 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int val = sc.nextInt();
			arr[row][col] = val;
			arr[col][row] = val;
			inputs--;
		}
		int srow = sc.nextInt();
		int target = sc.nextInt();
		sc.close();
		HashSet<Integer> visited = new HashSet<>();
		boolean ans = findPath(srow, target, arr, visited, 0);
		System.out.println(ans);

	}

	private static boolean findPath(int srow, int target, int[][] arr, HashSet<Integer> visited, int sum) {
		if (target <= sum) {
			return true;
		}
		boolean ans = false;
		visited.add(srow);
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[srow][i] != 0) {
				if (!(visited.contains(i))) {
					visited.add(i);
					ans = findPath(i, target, arr, visited, sum += arr[srow][i]);
					visited.remove(i);
				}
			}
		}
		visited.remove(srow);
		return ans;
	}
}
