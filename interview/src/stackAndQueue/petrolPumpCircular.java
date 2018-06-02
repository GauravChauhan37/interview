package stackAndQueue;

import java.util.Scanner;

public class petrolPumpCircular {
	static class petrol {
		int petrol;
		int distance;

		public petrol(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		petrol[] arr = new petrol[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new petrol(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		int def = 0;
		int left = 0;
		for (int i = 0; i < arr.length; i++) {
			if (left + arr[i].petrol < arr[i].distance) {
				def = arr[i].distance - left + arr[i].petrol;
				left = 0;
			} else {
				left = arr[i].petrol - arr[i].distance;
			}
		}
		if (def + left >= 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
