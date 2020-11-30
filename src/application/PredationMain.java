package application;
import java.util.Scanner;

public class PredationMain {
	public static void main(String[] args)
	{	
		System.out.println("1. Predator population growth\n2. Prey popultaion growth\n3. Equilibrium predator popultaion size\n4. Equilibrium victim popultiaon size");
		System.out.print("Choose one(1/2/3/4): ");
		Scanner x = new Scanner(System.in);
		int choice = x.nextInt();
		
		if (choice==1)
		{
			System.out.println("Predator popultion: ");
			Scanner scan1= new Scanner(System.in);
			double P = scan1.nextDouble();
			
			System.out.println("Per capita death rate of the predators: ");
			Scanner scan2= new Scanner(System.in);
			float q = scan2.nextFloat();
			
			System.out.println("Conversion efficiency of predator: ");
			Scanner scan3= new Scanner(System.in);
			float beta = scan3.nextFloat();
			
			Predation predation= new Predation();
			predation.predatorPopulationGrowth(P, q, beta);
		}
		
		if (choice==2)
		{
			System.out.println("Intrinsic rate of increase: ");
			Scanner scan1= new Scanner(System.in);
			float r = scan1.nextFloat();
			
			System.out.println("Capture efficiency: ");
			Scanner scan2= new Scanner(System.in);
			float alpha = scan2.nextFloat();
			
			System.out.println("Predator popultion: ");
			Scanner scan3= new Scanner(System.in);
			double P = scan3.nextDouble();
			
			Predation predation= new Predation();
			predation.victimPopulationGrowth(r, alpha, P);
		}
		
		if (choice==3)
		{
			System.out.println("Intrinsic rate of increase: ");
			Scanner scan1= new Scanner(System.in);
			float r = scan1.nextFloat();
			
			System.out.println("Capture efficiency: ");
			Scanner scan2= new Scanner(System.in);
			float alpha = scan2.nextFloat();
			
			Predation predation= new Predation();
			predation.predatorPopulation(r, alpha);
			
		}
		
		if (choice==4)
		{
			System.out.println("Per capita death rate of the predators: ");
			Scanner scan1= new Scanner(System.in);
			float q = scan1.nextFloat();
			
			System.out.println("Conversion efficiency of predator: ");
			Scanner scan2= new Scanner(System.in);
			float beta = scan2.nextFloat();
			
			Predation predation= new Predation();
			predation.victimPopulation(q, beta);
		}
		
		
	}

}
