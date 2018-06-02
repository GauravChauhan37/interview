package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class waterJugproblem {
	static class Pair {
		int cc1;
		int cc2;

		public Pair(int i, int j) {
			cc1 = i;
			cc2 = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap1 = sc.nextInt();
		int cap2 = sc.nextInt();
		int res = sc.nextInt();
		sc.close();
		LinkedList<Pair> q = new LinkedList<>();
		Pair e = new Pair(0, 0);
		q.add(e);
		HashSet<Pair> hs = new HashSet<>();
		hs.add(e);
		fillWater(cap1, cap2, res, q, hs);
	}

	private static void fillWater(int cap1, int cap2, int res, LinkedList<Pair> q, HashSet<Pair> hs) {
		// empty
		while (!(q.isEmpty())) {
			Pair t = q.removeFirst();
			hs.remove(t);
			System.out.println(t.cc1 + " " + t.cc2);
			if (t.cc1 == res || t.cc2 == res) {
				return;
			}
			if (t.cc1 != 0) {
				Pair p = new Pair(0, t.cc2);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}
			if (t.cc2 != 0) {
				Pair p = new Pair(t.cc1, 0);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}

			// fill
			if (t.cc1 != cap1) {
				Pair p = new Pair(cap1, t.cc2);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}
			if (t.cc2 != cap2) {
				Pair p = new Pair(t.cc1, cap2);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}
			// transfer
			if (t.cc1 != cap1 && t.cc2 != 0) {
				int watReqd = cap1 - t.cc1;
				int waterC2Given = Math.min(watReqd, t.cc2);
				int val2 = t.cc2 - waterC2Given;
				int val1 = t.cc1 + waterC2Given;
				Pair p = new Pair(val1, val2);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}
			if (t.cc2 != cap2 && t.cc1 != 0) {
				int watReqd = cap2 - t.cc2;
				int waterC2Given = Math.min(watReqd, t.cc1);
				int val1 = t.cc2 + waterC2Given;
				int val2 = t.cc1 - waterC2Given;
				Pair p = new Pair(val1, val2);
				if (!(hs.contains(p))) {
					q.add(p);
					hs.add(p);
				}
			}
		}
	}
}