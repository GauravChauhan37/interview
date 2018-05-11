package matrices;

public class inplacerotatesqmatrix {
	public static void rotate(int[][] mat) {
		for (int i = 0; i < mat.length / 2; i++) {
			for (int j = i; j < mat.length - 1 - i; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][mat.length - 1 - i];
				mat[j][mat.length - 1 - i] = mat[mat.length - 1 - i][mat.length - 1 - j];
				mat[mat.length - 1 - i][mat.length - 1 - j] = temp;
			}
		}
	}

	static void displayMatrix(int N, int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(mat);
		displayMatrix(mat.length, mat);
	}
}
