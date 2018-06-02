package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class printNumbersInAscOrderWhichContains123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			if (s.contains("1") && s.contains("2") && s.contains("3")) {
				al.add(s);
			}
		}
		Collections.sort(al);
		System.out.println(al);
	}
}
