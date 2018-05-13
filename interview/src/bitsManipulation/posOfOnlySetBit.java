package bitsManipulation;

import java.util.Scanner;

public class posOfOnlySetBit {
	public static int countSetBit(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	public static void findPos(int n) {
		int count = countSetBit(n);
		if (count != 1) {
			System.out.println(false);
			return;
		}
		int index = 0;
		while (true) {
			if ((n & 1) == 1) {
				System.out.println(index+1);
				return;
			}
			index++;
			n = n >> 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		findPos(n);
	}
}
