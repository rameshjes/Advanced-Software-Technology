package exer;

import java.util.Scanner;

public class Integers {

	private static Scanner userin;
	public static int sum = 0;
	public static int product = 1;
	public static int count = 0;
	public static int largenum;
	public static int smallnum;
	public static int average = 0;
	public static int variance = 0;
	public static int j;
	public static int k;
	public static int arr[];
	static double temp = 0;
	

	public static void integers() {
		userin = new Scanner(System.in);
		System.out.println("Enter the number between 1 and 100");
		int firstnum = userin.nextInt();
		int arr[] = new int[firstnum];
		if (firstnum < 100 && firstnum > 0) {
			for (k = 0; k < firstnum; k++) {
				System.out.println("Enter the number = ");
				arr[k] = userin.nextInt();

			}
		}
		// Computing Sum and Product
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			product = product * arr[i];
		}
		// Computing average
		average = sum / arr.length;
		// Computing Variance
		for (int j = 0; j < arr.length; j++) {
			temp = temp + (arr[j] - average) * (arr[j] - average);
			System.out.println(temp);
		}
		double variance = temp / arr.length;

		// Computing Largest Number
		for (int p = 0; p < arr.length; p++) {
			if (arr[p] > largenum) {
				smallnum = arr[0];
				largenum = arr[p];
			}

			// Computing Smallest Number
			for (int k = 1; k < arr.length; k++) {
				if (arr[k] < smallnum) {

					smallnum = arr[k];

				}

			}
		}

		System.out.println("Smallest number is = " + smallnum);
		System.out.println("Largest number is = " + largenum);
		System.out.println("Total Sum is = " + sum);
		System.out.println("Total Product is = " + product);
		System.out.println("Total Average is = " + average);
		System.out.println("The variance is = " + variance);

	}

	public static void main(String[] args) {
		integers();

	}

}
