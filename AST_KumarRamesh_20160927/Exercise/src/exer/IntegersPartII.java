package exer;

public class IntegersPartII {
	// First we are creating method to find prime numbers in Largest Integers
	public static void findPrimeLargestInt() {

		System.out.println("The Prime Numbers in Largest Integer are : ");
		int j = Integer.MAX_VALUE;

		int count = 0;
		// long startTime = System.currentTimeMillis();
		for (int i = 2; i < j; i++) {

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
	public static void findPrimeLargestLongint() {

		System.out.println("The Prime Numbers in Largest Long Integer are : ");

		long z = Integer.MAX_VALUE;
		int count1 = 0;

		for (int k = 2; k < z; k++) {

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

	// Counting time between smallest to largest integers.
	public static void countTimeSmallestIntToLargestInt() {
		final long startTime = System.nanoTime();
		int small = Integer.MIN_VALUE;
		int large = Integer.MAX_VALUE;
		for (int n = small; n < large; n++) {

		}
		final long duration = ((System.nanoTime() - startTime) / 1000);
		System.out.println("The total time for counting smallest to Largest is : " + duration);
	}

	// Counting time between smallest long to largest long integers.
	public static void countTimeSmallestLongIntToLargestLongInt() {
		final long startTime1 = System.nanoTime();
		long small = Integer.MIN_VALUE;
		long large = Integer.MAX_VALUE;
		for (long n = small; n < large; n++) {

		}
		final long duration1 = ((System.nanoTime() - startTime1) / 1000);
		System.out.println("The total time for counting smallest to Largest is : " + duration1);
	}

	// Here we are calling both methods inside main program.
	public static void main(String[] args) {
		findPrimeLargestInt();
		findPrimeLargestLongint();
		countTimeSmallestIntToLargestInt();
		countTimeSmallestLongIntToLargestLongInt();

	}
}
