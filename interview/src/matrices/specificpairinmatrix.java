package matrices;

public class specificpairinmatrix {
	private static void findMaxPair(int[][] mat, int[][] maxsoffar) {
		int max = Integer.MIN_VALUE;
		int[][] maxarr = new int[mat.length][mat[0].length];
		int maxcol = mat[0].length - 1;
		int maxrow = mat.length - 1;
		int currmax = Integer.MAX_VALUE;

	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 6, 1, 3 }, { -4, -1, 1, 7, -6 },
				{ 0, -4, 10, -5, 1 } };
		int[][] maxsoffar = new int[mat.length][mat[0].length];
		findMaxPair(mat, maxsoffar);
	}
}
