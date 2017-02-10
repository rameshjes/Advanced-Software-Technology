package exer;

import java.util.Scanner;

public class Pie {

	private static Scanner user;
	static double circum = 0;
	static double f = 0;
	static double area = 0;
	static double previouscircum = 0;
	static double previousarea = 0;
	static double currentcircum = 0;
	static double currentarea = 0;
	static double percentcircum = 0;
	static double percentarea = 0;

	public static void circumference() {
		user = new Scanner(System.in);

		System.out.println("Enter the value of diameter");
		float diameter = user.nextInt();
		float r = diameter / 2;
		// Asks user to input precision of pi value
		System.out.println("Enter the precision of pi value");
		int pinumber = user.nextInt();

		String store1 = String.valueOf(Math.PI);
		String str = new String(store1);
		// If user enters precision more than than limit of pi it considers
		// maximum precision value
		if (pinumber > 15) {
			pinumber = 15;
		}

		for (int i = 0; i <= pinumber; i++) {
			if (i == 0) {
				previouscircum = 3.0 * diameter;      //Since in 1st iteration precision of pi will be 0.
				previousarea = 3.0 * (r * r);
			}
			if (i != 0) {

				f = Double.parseDouble(str.substring(0, i + 2));

				currentcircum = f * diameter;
				percentcircum = ((currentcircum - previouscircum) / previouscircum);
				currentarea = f * (r * r);
				percentarea = ((currentarea - previousarea) / previousarea);
				previouscircum = currentcircum;
				previousarea = currentarea;
				System.out.println("The value of Pi is " + f);

				System.out.println("The circumference of circle is " + currentcircum);
				System.out.println("The Area of circle is " + currentarea);
				System.out.println("The percentage increase in circumference is " + percentcircum);
				System.out.println("The percentage increase in area is " + percentarea);

			}
		}

	}

	public static void main(String[] args) {

		circumference();

	}
}
