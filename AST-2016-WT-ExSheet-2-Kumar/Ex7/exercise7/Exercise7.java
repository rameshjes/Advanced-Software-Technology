package exercise7;
/*
 * 
 * Author : Ramesh Kumar
 * 
 */
public class Exercise7 {
	public static double product = 1.0;
	public static double result = 0.0;
    public static double value = 0.0;
	public void funct(double k, double n) {

		for (int j = 1; j <= n; j++) {
			if ( j == 1){
				value = 0.5;
				product =  (product * ((value ) / (1 - value)));	
			}
			
			
			if(j !=1 && j < k){
				value = 0.9;
				product =  (product * ((value ) / (1 - value)));
			}
			else if(k <= j){
				value = 0.1;
				product = (product * ((value ) / (1 - value)));
			}
	
		}
		double brac = 1 + product;
		double powervalue = Math.pow(brac, -1);
		result = 1 - powervalue;
		System.out.println(result);
		
	}

	public static void main(String[] args) {
		Exercise7 obj = new Exercise7();
		System.out.println("function value for (10,20) is :"); 
		obj.funct(10, 20);
		
		System.out.println("function value for (100,120) is : ");
		obj.funct(100, 120);
		System.out.println("function value for (1000,1200) is " );
		obj.funct(1000, 1200);
		System.out.println("function value for (10000,10200) is " );
		obj.funct(10000, 10200);
	}
}
/*Part 3
   for (10,20) When value of i is less than k , function value increases but when value of i is 
   equal to or greater than k, function value gradually decreases. 
   for (100,120), (1000,1200) and (10000, 10200), whenever value of k is increased.
   overall function value remains same i.e : 1.
   
  Part 4:
  This program is designed that even you need to change the value of n, it will
  work still, means, you don't need to reprogram it, just assign
  desired value to n. 
  
   Part 5:
   This program follows efficient way as value of n can be changed anytime.


*/