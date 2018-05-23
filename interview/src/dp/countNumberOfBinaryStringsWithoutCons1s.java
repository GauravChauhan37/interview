package dp;

import java.util.Scanner;

public class countNumberOfBinaryStringsWithoutCons1s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long oneCount = 1;
		long zeroCount = 1;
		int idx = 1;
		while (idx <= n) {
			long temp = zeroCount;
			zeroCount = zeroCount + oneCount;
			oneCount = temp;
			idx++;
		}
		System.out.println(oneCount);
		System.out.println(zeroCount);
	}
}
