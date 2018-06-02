package strings;

import java.util.HashSet;
import java.util.Scanner;

public class functionToFindNumberOfCustomersWhoCouldNotGetComputer {
	// 3
	// GACCBDDBAGEE
	// output --> D D
	// exp ouput ---> D
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		String s = sc.next();
		int k = 0;
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (hs.contains(s.charAt(i))) {
				hs.remove(s.charAt(i));
				k--;
			} else {
				if (k < capacity) {
					hs.add(s.charAt(i));
					k++;
				} else {
					System.out.print(s.charAt(i) + " ");
				}
			}
		}
	}
}
