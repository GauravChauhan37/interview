package arrays;

import java.util.Scanner;

public class majorityElement {
	public static void majorityElement(int[] arr) {
		int tempIndex = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == tempIndex) {
				count++;
			} else if (arr[i] != tempIndex && count != 0) {
				count--;
			} else if (count == 0) {
				tempIndex = arr[i];
				count = 1;
			}
		}
		int countOfTempIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == tempIndex){
				countOfTempIndex++;
			}
		}
		if(countOfTempIndex > arr.length/2){
			System.out.println(tempIndex);
		}else{
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		majorityElement(arr);
	}

}
