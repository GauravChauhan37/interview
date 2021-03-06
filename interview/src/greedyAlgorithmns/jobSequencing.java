package greedyAlgorithmns;

import java.util.Arrays;
import java.util.Scanner;

public class jobSequencing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Job[] jobs = new Job[scn.nextInt()];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(scn.next().charAt(0), scn.nextInt(), scn.nextInt());
		}

		Arrays.sort(jobs);

		Character[] ch = new Character[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			for (int j = jobs[i].deadline - 1; j >= 0; j--) {
				if (ch[j] == null) {
					ch[j] = jobs[i].JobID;
					break;
				}
			}
		}

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != null)
				System.out.print(ch[i] + " ");
		}

	}

	static class Job implements Comparable<Job> {
		char JobID;
		int deadline;
		int Profit;

		public Job(char JobID, int deadline, int profit) {
			this.JobID = JobID;
			this.deadline = deadline;
			this.Profit = profit;
		}

		public int compareTo(Job o) {
			return o.Profit - this.Profit; // decreasing
		}

	}

}