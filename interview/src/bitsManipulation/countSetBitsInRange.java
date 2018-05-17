package bitsManipulation;

import java.util.Scanner;

public class countSetBitsInRange {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int count=countbits(n);
		
		int ans=0;
		
		for(int i=1; i<=count; i++) {
			int div =(1<<i);
			ans+=(1<<i-1)*((n+1)/div);
			int factor=1<<i;
			int rem=(n+1)%(1<<i);
			if(factor-rem < factor/2) {
				ans+=rem-factor/2;
			}
		}
		System.out.println(ans);
	}

	private static int countbits(int num) {
		int count=0;
		while(num!=0) {
			count++;
			num>>=1;
		}
		return count;
	}

}