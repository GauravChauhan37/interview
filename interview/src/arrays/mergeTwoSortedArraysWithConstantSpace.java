package arrays;

import java.util.Scanner;

public class mergeTwoSortedArraysWithConstantSpace {
	public static void mergeAndSort(int[] arr, int[] arr2) {
		int indexFirst = arr.length - 1;
		int indexScnd = arr2.length - 1;
		while (indexScnd >= 0) {
			if (arr[indexFirst] > arr2[indexScnd]) {
				int temp = arr[indexFirst];
				arr[indexFirst] = arr2[indexScnd];
				arr2[indexScnd] = temp;
				indexScnd--;
				
				int i = indexFirst;
				int temp2=0;
				while (arr[i--] > arr[indexFirst]);
				temp2 = arr[indexFirst];
				while (i < arr.length - 1) {
					arr[i + 1] = arr[i];
				}
				arr[--i] = temp2;
			}else{
				indexFirst--;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int arraySize2 = sc.nextInt();
		int[] arr2 = new int[arraySize2];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		mergeAndSort(arr, arr2);
		for(int i =0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
	}

}
