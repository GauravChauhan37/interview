package dp;

import java.util.Scanner;

public class possWaysToContructBuildings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int building = 1;
		int spaces = 1;
		int curr = 0;
		for (int i = 1; i < n; i++) {
			curr = building + spaces;
			building = spaces;
			spaces = curr;
		}
		int ans = building + spaces;
		ans *= ans;
		System.out.println(ans);
	}
}
