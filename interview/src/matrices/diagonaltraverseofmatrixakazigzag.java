package matrices;

public class diagonaltraverseofmatrixakazigzag {

	private static void printZigZag(int[][] mat) {
		for (int i = 1; i < mat.length; i++) {
			int row = i - 1, col = 0;
			while (row >= 0 && col <= i) {
				System.out.print(mat[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
		for (int j = 0; j < mat[0].length; j++) {
			int row = mat.length - 1, col = j;
			while (row >= 0 && col <= mat[0].length - 1) {
				System.out.print(mat[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		printZigZag(a);
	}

}
