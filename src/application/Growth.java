package domain.src.application;

import java.util.Scanner;

public class Growth {

	public static void main(String[] args) {
		// formula dt/dn= N*r
	
				System.out.println("enter initial value (N): ");

				Scanner scan = new Scanner(System.in);
				int N = scan.nextInt();
				
				System.out.println("enter growth rate (r): ");
				double r  = scan.nextDouble();

				
				System.out.println(calculateGrowth(N, r));

			}
			public static int calculateGrowth(int N, double r) {
				return (int) (N * r);
			}
}
