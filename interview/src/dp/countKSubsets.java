package dp;

import java.util.Scanner;

public class countKSubsets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n + 1][k + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(i==0 || j==0 || i<j){
					arr[i][j]=0;
				}else if(j==1 || i==j){
					arr[i][j]=1;
				}else{
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j] * j;
				}
			}
		}
		System.out.println(arr[n][k]);
	}
}
