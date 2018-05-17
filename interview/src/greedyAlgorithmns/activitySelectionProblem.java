package greedyAlgorithmns;

import java.util.Arrays;
import java.util.Scanner;

public class activitySelectionProblem {
	public static class Pairs implements Comparable<Pairs> {
		int startTime;
		int endTime;

		public Pairs(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}

		public int compareTo(Pairs o) {
			return this.endTime - o.endTime;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int[] startTime = new int[p];
		for (int i = 0; i < startTime.length; i++) {
			startTime[i] = sc.nextInt();
		}
		int[] endTime = new int[p];
		for (int i = 0; i < endTime.length; i++) {
			endTime[i] = sc.nextInt();
		}
		Pairs[] pair = new Pairs[startTime.length];
		for (int i = 0; i < pair.length; i++) {
			pair[i] = new Pairs(startTime[i], endTime[i]);
		}
		Arrays.sort(pair);
		int curr = 0;
		System.out.println(pair[curr].startTime + " " + pair[curr].endTime);
		for (int i = 1; i < pair.length; i++) {
			if (pair[curr].endTime <= pair[i].startTime) {
				System.out.print(pair[i].startTime + " " + pair[i].endTime);
				curr = i;
				System.out.println();
			}
		}
	}
}
