package bitsManipulation;

import java.util.Scanner;

public class checkIfNumberIsABleak {
	public static int count1(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				count++;
			}
			num = num >> 1;
		}
		return count;
	}

	static boolean isBleak(int n) {
		int Set = (int) (Math.log(n) / Math.log(2));
		
		for (int i = n - 1; i >= n - Set; i--) {
			int bits = count1(i);
			if (i + bits == n)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (isBleak(num)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}	
		sc.close();
	}

}
