package recurion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class hamiltonianCycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int inputs = sc.nextInt();
		while (inputs != 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			arr[row][col] = 1;
			arr[col][row] = 1;
			inputs--;
		}
		sc.close();
		HashSet<Integer> hs = new HashSet<>();
		hs.add(0);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		hamilton(hs, arr, 0, al);
	}

	private static void hamilton(HashSet<Integer> visited, int[][] arr, int srow, ArrayList<Integer> al) {
		if (al.size() == arr.length) {
			System.out.println("P:" + al);
			if (arr[0][al.get(al.size() - 1)] == 0) {
				System.out.println("C:" + "null");
			} else {
				System.out.println("C:" + al);
			}
			return;
		}
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[srow][i] != 0) {
				if (!(visited.contains(i))) {
					visited.add(i);
					al.add(i);
					hamilton(visited, arr, i, al);
					visited.remove(i);
					al.remove(al.size() - 1);
				}
			}
		}
	}
}
