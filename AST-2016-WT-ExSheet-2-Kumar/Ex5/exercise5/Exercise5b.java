package exercise5;
/*
 * 
 * Author : Ramesh Kumar
 * 
 */
import java.util.Scanner;

public class Exercise5b {
	Exercise5a prime = new Exercise5a(); 
	// Counting time between smallest to largest integers.
	public void countSmallestIntToLargestInt(int low, int high) {
		int small = low;
		int large = high;
		for (int i = small; i < large; i++) {
            System.out.println("loop is running");
		}

	}
	
	
	public void countTime(int low, int high) {
		final long startTime = System.currentTimeMillis();
		countSmallestIntToLargestInt(low, high);
		final long endtime = ((System.currentTimeMillis() - startTime));
		System.out.println("The total time loop takes in execution is :  " +endtime);
	}
	
	public static void main(String[] args) {
		Exercise5b value = new Exercise5b();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the minimum value and maximum value to compute the time");
		int number = in.nextInt();
		int number1 = in.nextInt();		
		value.countTime(number, number1);

	}
}
