package greedyAlgorithmns;

import java.util.Scanner;

public class egyptianFraction {
	public static void egypt(int nm, int dm) {
		if (nm == 0 || dm == 0) {
			return;
		}
		if (dm % nm == 0) {
			System.out.println("1/" + dm / nm);
			return;
		}
		if (nm % dm == 0) {
			System.out.println(nm / dm);
			return;
		}
		int rem = dm / nm;
		rem += 1;
		System.out.println("1/" + rem);
		egypt(nm * rem - dm, dm * rem);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nm = sc.nextInt();
		int dn = sc.nextInt();
		egypt(nm, dn);
	}

}
