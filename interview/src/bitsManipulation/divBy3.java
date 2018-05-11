package bitsManipulation;

import java.util.Scanner;

public class divBy3 {
	public static boolean isMultipleOf3(int num) {
		int odd_count = 0;
		int even_count = 0;
		while (num != 0) {
			if ((num & 1) != 0)
				odd_count++;
			num = num >> 1;
			if ((num & 1) != 0)
				even_count++;
			num = num >> 1;
		}

		return (Math.abs(odd_count - even_count) % 3) == 0;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		if (isMultipleOf3(num))
			System.out.println("multiple");
		else
			System.out.println("not a multiple");
	}
}
