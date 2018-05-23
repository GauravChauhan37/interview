package greedyAlgorithmns;

import java.util.Scanner;

public class fractionalKnapsack {
	static class Pair implements Comparable<PairF> {
		int value;
		int weight;

		Pair(int val, int weight) {
			this.value = val;
			this.weight = weight;
		}

		public int compareTo(Pair o) {
			
			return 0;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pair[] pair = new Pair[sc.nextInt()];
		int capacity = sc.nextInt();
		sc.close();
		for (int i = 0; i < pair.length; i++) {
			pair[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
	}
}
