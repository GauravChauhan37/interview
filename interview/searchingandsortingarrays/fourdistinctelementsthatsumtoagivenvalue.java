package searchingandsortingarrays;

import java.util.Arrays;
import java.util.Scanner;

public class fourDistinctElementsThatSumToAGivenValue {
	static class cool implements Comparable<cool> {
		int sum;
		int value1;
		int value2;

		public int compareTo(cool o) {
			return  o.sum - this.sum;
			// if both are equal return zero
			// if you think o.sum is > then it should return +ve
			// else -ve
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int valueToFind = sc.nextInt();
		sc.close();
		cool[] aux = new cool[(a.length * a.length - 1) / 2];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new cool();
		}
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				aux[k].sum = a[i] + a[j];
				aux[k].value1 = a[i];
				aux[k].value2 = a[j];
				k++;
			}
		}
		Arrays.sort(aux);
		int i =0;
		int j = aux.length-1;
		while(i<j){
			while(j>=0){
				if (aux[i].sum + aux[j].sum == valueToFind) {
					if (aux[i].value1 != aux[j].value1 && aux[i].value1 != aux[j].value2
							&& aux[i].value2 != aux[j].value1 && aux[i].value2 != aux[j].value2) {
						System.out.println(aux[i].value1 + " " + aux[i].value2 + " " + aux[j].value1 + " " + aux[j].value2);
						return;
					}
				}
				j--;
				}
			i++;
			j=aux.length-1;
			}
		}
	}
}
