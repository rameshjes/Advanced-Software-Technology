package exercise5;

import java.util.Scanner;

/*
 * 
 * Author : Ramesh Kumar
 */
public class Exercise5a {
	// First we are creating method to find prime numbers in Largest Integers
	public void findPrimeLargestInt(int high) {

		System.out.println("The Prime Numbers in Largest Integer are : ");
		int largevalue = high;
		//int largevalue = Integer.MAX_VALUE;

		int count = 0;
		// long startTime = System.currentTimeMillis();
		for (int i = 2; i < largevalue; i++) {

			count = 0;
			for (int n = 1; n <= i; n++) {
				int p = i % n;
				if (p == 0) {
					count = count + 1;
				}

			}
			if (count == 2) {
				System.out.println(i);
			}

		}

	}

	// Now we are creating method to prime numbers in Largest long integers.
	public void findPrimeLargestLongint(int high) {

		System.out.println("The Prime Numbers in Largest Long Integer are : ");

		long largestvaluelong = high;
		int count1 = 0;

		for (int k = 2; k < largestvaluelong; k++) {

			count1 = 0;
			for (int d = 1; d <= k; d++) {
				int l = k % d;
				if (l == 0) {
					count1 = count1 + 1;
				}

			}
			if (count1 == 2) {
				System.out.println(k);
			}

		}

	}

	public static void main(String[] args) {
		Exercise5a value = new Exercise5a();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number till that you want to compute prime numbers");
		int number = in.nextInt();
		value.findPrimeLargestInt(number);
		value.findPrimeLargestLongint(number);

	}
}
