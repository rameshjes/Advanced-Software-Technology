package exer;

import java.math.BigDecimal;

public class Calculations {
	static int fn = 0;
	static double fn1 = 0;
	static double fn2 = 0;
	
	static double fn3 = 0;
	static double fn4 = 0;
	static double fn5 = 0;

	public void functions() {

		for (int n = 0; n < 100; n++) {
			fn = 2 * n;

			fn1 = Math.pow(n, 0.5);

			fn2 = Math.pow(10, n);
			BigDecimal bd = BigDecimal.valueOf(fn2); // converting into BiGDecimal
			String out = bd.toString(); //converting into string

			fn3 = Math.pow(n, 3);
			// To aviod 1/0 case, I have equal function to 1 where this case occurs.
			if (n == 0) {
				fn4 = 1;
			} else {
				fn4 = Math.pow(2, 1 / n);
			}
			fn5 = Math.pow(Math.E, n);

			System.out.format("%d%20f%20s%25f%25f%60f", fn, fn1, out, fn3, fn4, fn5);
			System.out.println();

		}
	}

	public static void main(String[] args) {
		System.out.format("%s%20s%20s%25s%25s%55s", "fn", "fn1", "out", "fn3", "fn4", "fn5");
		System.out.println();
		Calculations call = new Calculations();
		call.functions();

	}
}
