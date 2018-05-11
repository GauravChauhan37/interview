package matrices;

public class findthelargestsusquaresurroundedbyX {
	public static void fillVerandHor(int[][] mat, int[][] ver, int[][] hor) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 'O') {
					ver[i][j] = 0;
					hor[i][j] = 0;
				} else if (mat[i][j] == 'X') {
					// left
				}
			}
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 'X', 'O', 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'X', 'X', 'O', 'O', 'X' }, { 'O', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O' }, };
		int[][] ver = new int[mat.length][mat[0].length];
		int[][] hor = new int[mat.length][mat[0].length];
		fillVerandHor(mat, ver, hor);
	}
}
