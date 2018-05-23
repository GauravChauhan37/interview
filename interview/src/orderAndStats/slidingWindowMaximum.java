package orderAndStats;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class slidingWindowMaximum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			p.add(arr[i]);
		}
		System.out.print(p.peek() + " ");
		int lo = 0;
		p.remove(arr[lo]);
		lo++;
		for (int i = k; i < arr.length; i++) {
			p.add(arr[i]);
			System.out.print(p.peek() + " ");
			p.remove(arr[lo]);
			lo++;
		}
	}
}
