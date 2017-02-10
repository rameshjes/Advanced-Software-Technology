package exercise6;
/*
 * 
 * Author : Ramesh Kumar
 * 
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exercise6 {
	public static int n1;
	public static double store[];
	public static double sum = 0;
	public static double product = 1;
	public static double average;
	ArrayList<Integer> num = new ArrayList<Integer>();

	// Take input value of n1
	public void inputn1Integer() {
		Scanner userinput = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the number n1 between 1 and 1 million");
			n1 = userinput.nextInt();
			if (n1 >= 1 && n1 <= 1000000) {
				break;
			}

		}

	}

	// Take value of n2 and n3.
	public void inputValuen2andn3() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the value of n2");
			int n2 = input.nextInt();
			System.out.println("Enter the value of n3 and it should be greater than n2");
			int n3 = input.nextInt();
			if (n2 < n3) {
				System.out.println("you entered value of n3 greater than n2");
				break;
			}
		}

	}

	// Getting n1 random values.
	public void randomnum() {
		Random rand = new Random();
		int x = 0;
		for (int i = 0; i < n1; i++) {
			x = rand.nextInt();
			// each random number is stored in array list.
			num.add(x);

		}
	}
	// Compute sum of random numbers
	public void sum(){
		for (int p = 0; p < n1; p ++){
			sum = sum + num.get(p);
		}
		System.out.println("sum  \t         : " + sum);
		
	}
	// compute product of random numbers.
	public void product(){
		for(int k = 0; k < n1; k ++) {
			product = product * num.get(k);
		}
		System.out.println("Product \t : " + product);

	}
      // Computing average.
	public void average() {
		average = sum / num.size();
		System.out.println("Average \t : " + average);
	}
	//compute minimum number from random numbers.
	public void minNum(){
	     double min = num.get(0);
	     for (int j = 1; j<n1; j++){
	    	 if(min<num.get(j)){
	    		 min = min;
	    	 }
	    	 else{
	    		 min = num.get(j);
	    	 }
	     }
	     System.out.println("Minimum number \t :" + min);
	     
	}
	//compute maximum number from random numbers.
	public void maxNum(){
		double max = 0;
		for(int m = 0; m<n1; m++){
			if(num.get(m) > max){
				max = num.get(m);
			}
		}
		System.out.println("Maximum number \t : " + max);
	}
	
	// Compute Variance.
	public void variance(){
		double temp = 0;
		for(int o = 0; o < n1; o++){
			temp = temp + ( ( num.get(o) - average) * (num.get(o) - average));
			
		}
		double variance = temp/num.size();
		System.out.println("Variance \t : " + variance);
	}

	public static void main(String[] args) {
		Exercise6 number = new Exercise6();
		number.inputn1Integer();
		number.inputValuen2andn3();
		number.randomnum();
		number.sum();
		number.product();
		number.average();
		number.minNum();
		number.maxNum();
		number.variance();

	}
}
