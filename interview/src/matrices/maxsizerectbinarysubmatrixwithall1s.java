package matrices;

public class maxsizerectbinarysubmatrixwithall1s {
	public static void calArea(int[][] mat, int[][] area) {
		for (int i = 0; i < area[0].length; i++) {
			if (mat[0][i] == 1) {
				area[0][i] = 1;
			}
		}
		for (int i = 1; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				if (mat[i][j] == 0) {
					area[i][j] = 0;
				} else {
					area[i][j] = area[i - 1][j] + 1;
				}
			}
		}
		int masf = Integer.MIN_VALUE; // maxareasofar
		int noOfNonZero = 0;
		int minval = Integer.MAX_VALUE;
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				if (area[i][j] != 0)
					noOfNonZero++;
				if (minval > area[i][j] && area[i][j] != 0)
					minval = area[i][j];
			}
			if (masf < noOfNonZero * minval) {
				masf = noOfNonZero * minval;
			}
			minval = Integer.MAX_VALUE;
			noOfNonZero = 0;
		}
		System.out.println(masf);
	}

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int[][] area = new int[mat.length][mat[0].length];
		calArea(mat, area);
	}

}
