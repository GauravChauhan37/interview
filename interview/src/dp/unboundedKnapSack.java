package dp;

import java.util.Scanner;

public class unboundedKnapSack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		int[] val = new int[sc.nextInt()];
		for (int i = 0; i < val.length; i++) {
			val[i] = sc.nextInt();
		}
		int[] weights = new int[sc.nextInt()];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = sc.nextInt();
		}
		sc.close();
		int[] count = new int[weight + 1];
		for (int i = 1; i < count.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (i >= weights[j]) {
					int v = 0;
					if (i - weights[j] >= 0) {
						v += val[j] + count[i - weights[j]];
					} else {
						v = val[j];
					}
					if (count[i] < v) {
						count[i] = v;
					}
				}
			}

		}
		System.out.println(count[weight]);
	}
}
