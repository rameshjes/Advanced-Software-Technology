package exercise8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.time.Instant;

/*
 * 
 * Author : Ramesh Kumar
 * 
 */
public class MaxFinderTrails {
	RandomIntegerSetGenerator num = new RandomIntegerSetGenerator();
	public static long in;
	public static int number;
	public static int maxnumber = 0;
	
	public static int[] mem;
	public static String filename;
	public static int[] array;
	
	// It takes long integer input between 0 and 1 million from user and generate random numbers.
	public int[] setupArray() {

		long a = num.getsize();
		
		int[] b;
		b = num.generateSet(a);
		return b;

	}

	public int findMaxInArray(int[] integerArray) {
		number = integerArray[0];
		for (int i = 0; i < integerArray.length; i++) {
			    
			if (integerArray[i] > number) {
				number = integerArray[i];
			} else {
				number = number;
			}
		}

		return number;
	}

	// Part 3
	public void testArraySetup() {
		
		
		int power = 1;
		long arraysize = 0;
		while(true){
			Runtime.getRuntime().totalMemory();
			final long startTime = System.currentTimeMillis();
			if(power < 7){
				power = power + 2;
				arraysize = (long) Math.pow(10, power);
			}
			else{
				System.out.println("for more than " + (long) Math.pow(10, power)+ " The power has become larger so cannot store more than that power");
				break;
			}
			int[] randomarray = num.generateSet(arraysize);
			
			int maximum_number_inrandomarray = findMaxInArray(randomarray);
			System.out.println("The maximum number " + maximum_number_inrandomarray);
			final long endtime = ((System.currentTimeMillis() - startTime));
			System.out.println("Time consume to find maximum number in  " + (long) Math.pow(10, power) + " is "+ endtime);
			long total_memory = ((Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory()) / 1024);
			System.out.println(" The memory consumed by " + (long) Math.pow(10, power) + " is " + total_memory);
		} 
		
			
		}
		
	

	// Part 4
	public int findArraySizeForTimeLimit(int timeLimit) {
		int size_of_array = 15;
		int lastvalue = 0;
		while(true){
			int[] array_integer = num.generateSet(size_of_array);
			final long startTime = System.currentTimeMillis();
			findMaxInArray(array_integer);
			final long endtime = ((System.currentTimeMillis() - startTime));
			if(endtime < timeLimit){
				lastvalue = size_of_array;
				size_of_array = size_of_array + 1000;
						
			}
			else{
				break;
			}
		}
		return lastvalue;
	}
			
			
	// part 5
	public int[] setupFile() {
		Scanner userinput = new Scanner(System.in);

		long a = num.getsize();

		int[] arr = num.generateSet(a);
		Random rand = new Random();

		for (int k = 0; k < arr.length; k++) {
			arr[k] = rand.nextInt();
		}
		// Takes name of file and store random numbers in file.
		System.out.println("Enter the file name");
		filename = userinput.next();
		try {
			File objfile = new File(filename);
			System.out.println("File has been created.");
			int r = 0;
			FileWriter write = new FileWriter(objfile);
			write.write("");
			for (int j = 0; j < arr.length; j++) {
				r = r + arr[j];
				write.append(r + "\n");
			}

			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;

	}
	// Part 6
	// Find maximum of random numbers stored in file.
	public int findMaxInFile(String filename) {
		
		try {
			File f = new File(filename);
			Scanner s = new Scanner(f);
			int ctr = 0;
			while (s.hasNextInt()) {
				ctr++;
				s.nextInt();
			}
			array = new int[ctr];
			Scanner s1 = new Scanner(f);
			for (int k = 0; k < array.length; k++) {
				array[k] = s1.nextInt();
			}
			//System.out.println(Arrays.toString(array));

		} catch (Exception e) {
			e.printStackTrace();
		}
		//findMaxInArray(array);
		int max = findMaxInArray(array);
		return max;

	}
	
	//Part 8 
	// Store random numbers in file of 10 power 3, 10 power 5, 10 power 7, 10 power 9 and determine runtimes and memory usage
	public void testFileSetup(){
		int power = 1;
		long arraysize = 0;
		while(true){
			Runtime.getRuntime().totalMemory();
			final long startTime = System.currentTimeMillis();
			if(power < 7){
				power = power + 2;
				arraysize = (long) Math.pow(10, power);
			}
			else{
				System.out.println("for more than " + (long) Math.pow(10, power)+ " The power has become larger so cannot store more than that power");
				break;
			}
			int[] randomarray = num.generateSet(arraysize);
			// array of random is generated now storing it in file :
			// Takes name of file and store random numbers in file.
			Scanner userinput = new Scanner(System.in);
			System.out.println("Enter the file name");
			filename = userinput.next();
			try {
				File objfile = new File(filename);
				System.out.println("File has been created.");
				int r = 0;
				FileWriter write = new FileWriter(objfile);
				write.write("");
				for (int j = 0; j < 3; j++) {
					r = r + randomarray[j];
					write.append(r + "\n");
				}

				write.flush();
				write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Now array has been loaded in file, find maximum number in file:
			int maximum_number_infile = findMaxInFile(filename);
			System.out.println("The maximum number in file " + maximum_number_infile);
			
			final long endtime = ((System.currentTimeMillis() - startTime));
			System.out.println("Time consume to find maximum number in  " + (long) Math.pow(10, power) + " is "+ endtime);
			long total_memory = ((Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory()) / 1024);
			System.out.println(" The memory consumed by file " + (long) Math.pow(10, power) + " is " + total_memory);
		} 
		
	}

	public static void main(String[] args) {

		MaxFinderTrails name = new MaxFinderTrails();
		System.out.println("Task 1 >> int[] setupArray() : ");
		int[] array = name.setupArray();
		System.out.println("random array is" + Arrays.toString(array));
		System.out.println("");
		
		System.out.println("Task 2 >> findMaxInArray(int[] integerArray) :");
		int max = name.findMaxInArray(array);
		System.out.println("Maximum number in random array is " + max);
		System.out.println("");
		
		System.out.println("Task 3 >> Test Array Setup : " );
		name.testArraySetup();
		System.out.println("");
		
		System.out.println("Task 4 >> Find Array size : " );
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the time limit");
		int timeLimit = in.nextInt();
		name.findArraySizeForTimeLimit(timeLimit);
		System.out.println("");
		
		System.out.println("");
		System.out.println("Task 5 >> int[] setupFile() : ");
		name.setupFile();
		System.out.println("");
		
		System.out.println("Task 6 >> findMaxInFile(String filename) ");
		System.out.println("The maximum number is " +name.findMaxInFile(filename));
		System.out.println("");
		
		System.out.println("Task 7 >> testFileSetup() : ");
		name.testFileSetup();
		System.out.println("");
		
		
	}
}

// Part 9
/*  From my point of view, there may b many ways to optimize the performance,
 * but its performance is also good.
 * 
 * 
 * */
