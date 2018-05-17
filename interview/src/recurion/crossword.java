package recurion;

import java.util.Scanner;

public class crossword {
	public static boolean isValidHor(int row, int col, char[][] arr, String s, int idx) {
		int count = 0;
		for (int i = col; idx < s.length(); i++) {
			if (i == arr[0].length)
				return false;
			if (arr[row][i] == '-' || arr[row][i] == s.charAt(idx)) {
				count++;
			} else {
				break;
			}
			idx++;
		}
		if (count >= s.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean[] setHor(int row, int col, char[][] arr, String s) {
		boolean[] resetHelper = new boolean[s.length()];
		int idx = 0;
		for (int i = col; i < s.length() + col; i++) {
			char ch = s.charAt(idx);
			if (arr[row][i] == '-') {
				resetHelper[idx] = true;
				arr[row][i] = ch;
			}
			idx++;
		}
		return resetHelper;
	}

	private static void resetHor(int row, int col, char[][] arr, String s, boolean[] resetHelper) {
		int k = 0;
		for (int i = col; k < resetHelper.length; i++, k++) {
			if (resetHelper[k] == true) {
				arr[row][i] = '-';
				resetHelper[k] = false;
			}
		}
	}

	public static boolean isValidVer(int row, int col, char[][] arr, String s, int idx) {
		int count = 0;
		for (int i = row; idx < s.length(); i++) {
			if (i == arr.length)
				return false;
			if (arr[i][col] == '-' || arr[i][col] == s.charAt(idx)) {
				count++;
			} else {
				break;
			}
			idx++;
		}
		if (count >= s.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean[] setVer(int row, int col, char[][] arr, String s) {
		boolean[] resetHelper = new boolean[s.length()];
		int idx = 0;
		for (int i = row; i < s.length() + row; i++) {
			char ch = s.charAt(idx);
			if (arr[i][col] == '-') {
				arr[i][col] = ch;
				resetHelper[idx] = true;
			}
			idx++;
		}
		return resetHelper;
	}

	public static void resetVer(int row, int col, char[][] arr, String s, boolean[] resetHelper) {
		for (int i = row, k = 0; k < resetHelper.length; i++, k++) {
			if (resetHelper[k] == true) {
				arr[i][col] = '-';
				resetHelper[k] = false;
			}
		}
	}

	public static void solve(char[][] arr, String[] words, int index) {
		if (index >= words.length) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + "");
				}
				System.out.println();
			}
			return;
		}
		String s = words[index];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == '-' || arr[row][col] == s.charAt(0)) {
					// can i place hor
					if (isValidHor(row, col, arr, s, 0)) {
						// if yes , put it
						boolean[] resetHelper = setHor(row, col, arr, s);
						solve(arr, words, index + 1);
						// reset hor
						resetHor(row, col, arr, s, resetHelper);
					}
					// can i put ver
					if (isValidVer(row, col, arr, s, 0)) {
						// if yes put it
						boolean[] resetHelper = setVer(row, col, arr, s);
						solve(arr, words, index + 1);
						// reset ver
						resetVer(row, col, arr, s, resetHelper);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for (int i = 0; i < arr.length; i++) {
			String s = sc.nextLine();
			arr[i] = s.toCharArray();
		}
		String s = sc.nextLine();
		sc.close();
		String[] words = s.split(";");
		solve(arr, words, 0);

	}

}
