
package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class countTreesWithSameAncestorMatrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		scn.close();
		System.out.println(solve(arr));
	}

	public static int solve(int[][] arr) {
		HashMap<Integer, ArrayList<Integer>> decCount = new HashMap<>();
		for (int i = 0; i < arr.length; i++) { // filling decCount
			int noOfDec = 0;
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					noOfDec++;
				}
			}
			if (!(decCount.containsKey(noOfDec))) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				decCount.put(noOfDec, al); // noOfDec -> Key
			} else {
				ArrayList<Integer> al = decCount.get(noOfDec);
				al.add(i);
				decCount.put(noOfDec, al); // update existing
			}
		}

		HashSet<Integer> available = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			available.add(i);
		}

		HashMap<Integer, Integer> noOfComb = new HashMap<>();
		ArrayList<Integer> zeroDec = decCount.get(0);
		for (int i = 0; i < zeroDec.size(); i++) {
			noOfComb.put(zeroDec.get(i), 1); // fill all with no dec
		}
		
		int combSoFar = 1;
		for (int i = 1; i < arr.length; i++) {
			if (decCount.get(i) != null) {
				ArrayList<Integer> parents = decCount.get(i);
				for (int j = 0; j < parents.size(); j++) {
					int row = parents.get(j);
					for (int col = 0; col < arr[0].length; col++) {
						if (arr[row][col] == 1 && available.contains(col)) {
							if (noOfComb.get(col) != null) {
								combSoFar *= noOfComb.get(col);
								available.remove(col);
							}
						}
					}
					noOfComb.put(row, 2 * combSoFar);
					combSoFar = 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> al = new ArrayList<>(noOfComb.keySet());
		for (int val : al) {
			if (noOfComb.get(val) > max) {
				max = noOfComb.get(val);
			}
		}
		return max;
	}
}