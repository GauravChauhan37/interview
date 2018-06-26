package arrays;

import java.util.Scanner;

public class ceilingandfloor {
	public static int findFloor(int[] arr, int x, int low, int high) {
		if (high - low == 1) {
			return arr[low];
		}
		int ans = -1;
		int mid = (low + high) / 2;
		if (arr[mid] == x) {
			return arr[mid];
		} else if (arr[mid] < x) {
			ans = findFloor(arr, x, mid, high);
		} else if (arr[mid] > x) {
			ans = findFloor(arr, x, low, mid);
		}
		return ans;
	}

	public static int findCeil(int[] arr, int x, int low, int high) {
		if (high - low == 1) {
			return arr[high];
		}
		int ans = -1;
		int mid = (low + high) / 2;
		if (arr[mid] == x) {
			return arr[mid];
		} else if (arr[mid] < x) {
			ans = findCeil(arr, x, mid, high);
		} else if (arr[mid] > x) {
			ans = findCeil(arr, x, low, mid);
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int element = sc.nextInt();
		sc.close();
		// two more base cases for floor
//		if (element > arr[arr.length - 1]) {
//			System.out.println(arr[arr.length - 1]);
//			return;
//		}
//		if (element < arr[0]) {
//			System.out.println("There is no floor");
//			return;
//		}
		// System.out.println(findFloor(arr, element, 0, arr.length - 1));
		
		
		// two more base cases for ceil
		if (element <= arr[0]) {
			System.out.println(arr[0]);
			return;
		}
		if (element > arr[arr.length - 1]) {
			System.out.println("There is no ceiling");
			return;
		}
		System.out.println(findCeil(arr, element, 0, arr.length - 1));
	}

}
