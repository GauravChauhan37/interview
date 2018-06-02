package strings;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// error
//geeksforgeeks
//3
public class rearrangeAStringSoThatAllCharBecomesKDistanceAvail {
	public static class Pair implements Comparable<Pair> {
		public Pair(char i, int j) {
			this.val = i;
			this.freq = j;
		}

		char val;
		int freq;

		@Override
		public int compareTo(Pair o) {
			return this.freq - o.freq;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k = sc.nextInt();
		sc.close();
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		PriorityQueue<Pair> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				Pair e = new Pair((char) (i + 'a'), freq[i]);
				q.add(e);
			}
		}
		char[] arr = new char[s.length()];
		int oidx = 0;
		while (!(q.isEmpty())) {
			Pair g = q.remove();
			for (int i = oidx; g.freq > 0; i += k) {
				if (i >= arr.length) {
					System.out.println("not possible");
					return;
				}
				arr[i] = g.val;
				g.freq--;
			}
			if (oidx >= k) {
				System.out.println("not possbile");
				return;
			}
			oidx++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
