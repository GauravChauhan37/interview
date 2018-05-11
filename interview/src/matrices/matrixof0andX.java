package matrices;

import java.util.Arrays;

public class matrixof0andX {

	private static void createMat(char[][] mat) {
		int rmin = 0;
		int cmin = 0;
		int rmax = mat.length - 1;
		int cmax = mat[0].length - 1;
		int counter = mat.length * mat[0].length;
		char var = 'x';
		while (counter > 0) {
			for (int i = rmin; i <= rmax && counter > 0; i++) {
				mat[i][cmin] = var;
				counter--;
			}
			cmin++;
			for (int i = cmin; i <= cmax && counter > 0; i++) {
				mat[rmax][i] = var;
				counter--;
			}
			rmax--;
			for (int i = rmax; i >= rmin && counter > 0; i--) {
				mat[i][cmax] = var;
				counter--;
			}
			cmax--;
			for (int i = cmax; i >= cmin && counter > 0; i--) {
				mat[rmin][i] = var;
				counter--;
			}
			rmin++;
			var = (var == '0') ? 'x' : '0';
		}
	}

	public static void main(String[] args) {
		char[][] mat = new char[5][5];
		createMat(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
