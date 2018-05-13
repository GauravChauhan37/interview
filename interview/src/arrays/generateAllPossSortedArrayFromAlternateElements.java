package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class generateAllPossSortedArrayFromAlternateElements {
	private static void generateAllPairs(int[] arr, int[] arr2, int fixed, int vidx1, int vidx2, boolean flag,
			ArrayList<Integer> al, int last_Number_Used) {
		if (al.size() % 2 == 0 && al.size() != 0) {
			System.out.println(al);
		}
		if (vidx2 >= arr2.length && vidx1 >= arr.length) {
			generateAllPairs(arr, arr2, fixed + 1, fixed + 1, 0, false, new ArrayList<Integer>(), 0);
		}
		if (fixed >= arr.length) {
			return;
		}
		if (flag == false && vidx1 < arr.length) {
			while (arr[vidx1++] < last_Number_Used);
			vidx1--;
			al.add(arr[vidx1]);
			generateAllPairs(arr, arr2, fixed, vidx1 + 1, vidx2, true, al, arr[vidx1]);
		} else {
			if (vidx2 < arr2.length) {
					while (last_Number_Used > arr2[vidx2++]);
					vidx2--;
					for(int i=vidx2;i<arr2.length;i++){
					al.add(arr2[i]);
					generateAllPairs(arr, arr2, fixed, vidx1, vidx2 + 1, false, al, arr2[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr2 = new int[sc.nextInt()];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		generateAllPairs(arr, arr2, 0, 0, 0, false, new ArrayList<Integer>(), 0);
	}

}
