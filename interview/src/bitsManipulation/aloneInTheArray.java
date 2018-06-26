package bitsManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class aloneInTheArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<Integer, Boolean> hp = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i]);
			hp.put(arr[i], true);
		}
		int uniSum = 0;
		ArrayList<Integer> al = new ArrayList<>(hp.keySet());
		for (int i = 0; i < al.size(); i++) {
			int digit = al.get(i);
			uniSum += 3 * digit;
		}
		int ans = uniSum - sum;
		ans /= 2;   // cz element is left twice as big as itself
		System.out.println(ans);
	}
}