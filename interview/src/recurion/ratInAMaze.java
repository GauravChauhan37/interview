
package recurion;

import java.util.Scanner;

public class ratInAMaze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int noOfMoves = sc.nextInt();
		sc.close();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		System.out.println(rat(0, 0, arr, visited, noOfMoves));
	}

	public static boolean rat(int srow, int scol, int[][] maze, boolean[][] visited, int noOfMoves) {
		if (srow == maze.length - 1 && scol == maze[0].length - 1) {
			return true;
		}
		if (check(maze, srow, scol, visited, noOfMoves)) {
			return false;
		}
		visited[srow][scol] = true;
		boolean ans1 = rat(srow, scol - 1, maze, visited, noOfMoves - 1);
		boolean ans2 = rat(srow + 1, scol, maze, visited, noOfMoves - 1);
		boolean ans3 = rat(srow, scol + 1, maze, visited, noOfMoves - 1);
		boolean ans4 = rat(srow - 1, scol, maze, visited, noOfMoves - 1);
		visited[srow][scol] = false;
		return ans1 || ans2 || ans3 || ans4;

	}

	public static boolean check(int[][] maze, int srow, int scol, boolean[][] visited, int noOfMoves) {
		if (srow >= maze.length)
			return true;
		if (scol >= maze[0].length)
			return true;
		if (srow < 0)
			return true;
		if (scol < 0)
			return true;
		if (maze[srow][scol] == 0)
			return true;
		if (visited[srow][scol] == true)
			return true;
		if (noOfMoves == 0)
			return true;

		return false;
	}

}
