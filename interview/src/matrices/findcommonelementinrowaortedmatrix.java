package matrices;

import java.util.Arrays;

public class findcommonelementinrowaortedmatrix {
	private static int findCommonElement(int[][] mat) {
		int min = Integer.MAX_VALUE;
		int[] temp = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			if (min > mat[i][mat[0].length - 1]) {
				min = mat[i][mat[0].length - 1]; // find min value in row
			}
		}
		Arrays.fill(temp, mat[0].length - 1); // fill the array with last col
												// index
		int min_row = 0;
		while (temp[0] >= min_row) {
			for (int i = 0; i < mat.length; i++) {
				if (mat[i][temp[i]] < mat[min_row][temp[min_row]])
					min_row = i; // denoting row of min element
			}
			int count = 0;
			for (int i = 0; i < mat.length; i++) {
				if (mat[i][temp[i]] > mat[min_row][temp[min_row]]) {
					if (temp[i] == 0)
						return -1; // if we have reached the last value, we can
									// further decrement from here so return -1

					temp[i] -= 1; // if curr val is greater than min element,
									// then dec the val of index in temp
				} else {
					count++; // else inc count value
				}
			}
			if (count == mat.length - 1) {
				return mat[min_row][temp[min_row]];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 }, };
		System.out.println(findCommonElement(mat));
	}
}
