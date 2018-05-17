package arrays;

import java.util.Scanner;

public class maximumSumof3NonOverlappingSubarrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		int currSumSoFar = 0;
		for (int i = 0; i < k; i++) {
			currSumSoFar += arr[i];
		}
		int[] leftMaxSubArrSumSoFar = new int[arr.length];
		leftMaxSubArrSumSoFar[k - 1] = currSumSoFar;
		int lo = 0;
		for (int i = k; i < leftMaxSubArrSumSoFar.length; i++) {
			currSumSoFar -= arr[lo];
			lo++;
			currSumSoFar += arr[i];
			leftMaxSubArrSumSoFar[i] = Math.max(leftMaxSubArrSumSoFar[i - 1], currSumSoFar);
		}
		currSumSoFar = 0;
		for (int i = arr.length - 1; i >= arr.length - k; i--) {
			currSumSoFar += arr[i];
		}
		int[] rightMaxSubArrSumSoFar = new int[arr.length];
		rightMaxSubArrSumSoFar[arr.length - k] = currSumSoFar;
		int hi = arr.length - 1;
		for (int i = rightMaxSubArrSumSoFar.length - k - 1; i >= 0; i--) {
			currSumSoFar -= arr[hi];
			hi--;
			currSumSoFar += arr[i];
			rightMaxSubArrSumSoFar[i] = Math.max(currSumSoFar, rightMaxSubArrSumSoFar[i + 1]);
		}

		int left = k - 1;
		int max = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = left + 1; i <= left + k; i++) {
			currSum += arr[i];
		}
		int right = left + k + 1;
		while (right <= arr.length - k) {
			int currMax = 0;
			currMax = leftMaxSubArrSumSoFar[left] + currSum + rightMaxSubArrSumSoFar[right];
			if (max < currMax) {
				max = currMax;
			}
			left++;
			currSum -= arr[left];
			currSum += arr[right];
			right++;
		}
		System.out.println(max);
	}
}
