package matrices2;

import java.util.Scanner;

public class createAlternating0andXs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[sc.nextInt()][sc.nextInt()];
		sc.close();
		char ch = 'O';
		int counter = arr.length * arr[0].length;
		int rmin = 0, cmin = 0, rmax = arr.length - 1, cmax = arr[0].length - 1;
		while (counter > 0) {
			for (int i = cmin; i <= cmax && counter > 0; i++) {
				arr[rmin][i] = ch;
				counter--;
			}
			rmin++;
			for (int i = rmin; i <= rmax && counter > 0; i++) {
				arr[i][cmax] = ch;
				counter--;
			}
			cmax--;
			for (int i = cmax; i >= cmin && counter > 0; i--) {
				arr[rmax][i] = ch;
				counter--;
			}
			rmax--;
			for (int i = rmax; i >= rmin && counter > 0; i--) {
				arr[i][cmin] = ch;
				counter--;
			}
			cmin++;
			ch = ch == 'O' ? 'X' : 'O';
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
