package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class countTripletswithSumSmallerthanGivenValue {
	public static int findTriplets(int[] arr, int sum){
				Arrays.sort(arr);
				int ans = 0;
				for (int i = 0; i < arr.length - 2; i++)
				{
					int j = i + 1, k = arr.length - 1;
					while (j < k)
					{
						if (arr[i] + arr[j] + arr[k] >= sum)
							k--;
						else
						{
							ans += (k - j);
							j++;
						}
					}
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
		int sum = sc.nextInt();
		sc.close();
		System.out.println(findTriplets(arr, sum));
	}

}
