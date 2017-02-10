package exercise8;

/*
 * 
 * Author : Ramesh Kumar
 * 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomIntegerSetGenerator {
	public static long inputnum = 0;
	public static int[] k;
	public static String filename;
	

	public static long getsize() {
		long max = Long.MAX_VALUE;
		// long store = 0;
		Scanner userinput = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a positive long integer");
			inputnum = userinput.nextLong();
			if (inputnum > 0 && inputnum < max) {
				// System.out.println(" you entered number");

				break;
			} else {
				continue;
			}
		}
		return inputnum;

	}

	public int[] generateSet(long number) {
		Random num = new Random();
		int x;
		k = new int[(int) number];
		for (int i = 0; i < number; i++) {
			x = num.nextInt();
			
				k[i] = x;
			

		}

		return k;
		// System.out.println("array of random numbers is " + Arrays.toString(k));
		 
	}

	// It takes name of file as user input and stores random integers.
	public static void storeSetInFile(String filename) {
		Scanner userinput = new Scanner(System.in);
		System.out.println("Enter the file name");
		filename = userinput.next();
		try {
			File fac = new File(filename);
			System.out.println("The file has been created.");
			int r = 0;
			FileWriter write = new FileWriter(fac);
			write.write("");
			for (int j = 0; j < k.length; j++) {
				r = r + k[j];
				write.append(r + "\n");
			}

			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		RandomIntegerSetGenerator obj = new RandomIntegerSetGenerator();
		obj.getsize();

		obj.generateSet(inputnum);

		obj.storeSetInFile(filename);
	}
}
