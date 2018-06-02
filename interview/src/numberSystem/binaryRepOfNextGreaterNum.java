package numberSystem;

import java.util.Arrays;
import java.util.Scanner;

public class binaryRepOfNextGreaterNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		char[] nums = s.toCharArray();
		int i;
		for (i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				break;
			}
		}
		if (i == 0) {
			System.out.println("no greater number can be generated");
			return;
		}
		char temp = nums[i];
		nums[i] = nums[i - 1];
		nums[i - 1] = temp;

		char[] t = new char[nums.length];
		for (int j = i + 1; j < nums.length; j++) {
			t[j] = nums[j];
		}

		Arrays.sort(t);

		for (int j = i + 1; j < nums.length; j++) {
			nums[j] = t[j];
		}
		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j] + " ");
		}
	}
}
