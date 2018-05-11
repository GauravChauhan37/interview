package matrices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class commonelementsinallrows {
	private static void printCommonElements(int[][] mat) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < mat[0].length; i++) {
			mp.put(mat[0][i], 1);
		}
		for (int i = 1; i < mat.length; i++) {
			HashSet<Integer> h = new HashSet<>();
			for (int j = 0; j < mat[0].length; j++) {
				if (h.contains(mat[i][j]) == false) {
					h.add(mat[i][j]);
					if (mp.containsKey(mat[i][j])) {
						mp.put(mat[i][j], mp.get(mat[i][j]) + 1);
					}
				}
			}
		}
		ArrayList<Integer> keys = new ArrayList<>(mp.keySet());
		System.out.println(keys);
		for (int val : keys) {
			if (mp.get(val) == mat.length) {
				System.out.println(val);
			}
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 1, 4, 8 }, { 3, 7, 8, 5, 1 }, { 8, 7, 7, 3, 1 }, { 8, 1, 2, 7, 9 }, };
		printCommonElements(mat);
	}
}
