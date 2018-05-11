package matrices;

public class rotateMatrixElements {
	private static void rotateMatrix(int[][] mat) {
		int counter = mat.length * mat[0].length;
		int temp1 = 0;
		int temp2 = 0;
		int srow = 0, scol = 0, erow = mat.length - 1, ecol = mat[0].length - 1;
		while (counter > 0) {
			temp1 = mat[srow][ecol];
			for (int i = ecol; i > ecol && counter > 0; i--) {
				mat[srow][i] = mat[srow][i - 1];
			}
			srow++;
	
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix(mat);
	}
}
