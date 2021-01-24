package application;

import java.util.Scanner;

public class ExponentialGrowth {
	// exponential growth

	public static void main(String[] args) {
		System.out.println("enter initial value (N): ");

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		System.out.println("enter growth rate (r): ");
		double r  = scan.nextDouble();

		System.out.println("enter time (t): ");
		int t = scan.nextInt();
		
		System.out.println(calculateGrowth(N, r, t));

	}
	public static int calculateGrowth(int N, double r, int t) {
		if (t>=0) {
			//return (int) (N * Math.pow(1 + r, t));
			return (int) (N * Math.exp(r*t));
			
		}
		return 0;
	}

} 
