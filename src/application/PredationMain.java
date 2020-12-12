package application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PredationMain {
	public static void main(String[] args)
	{	
		boolean repeat=true; 
		int choice = 0;
		while(repeat)
		{
			System.out.println("1. Predator population size\n2. Prey popultaion size");
			System.out.print("Choose one(1/2): ");
			Scanner x = new Scanner(System.in);
			try
			{
				choice = x.nextInt();
				if(choice>0 && choice<=2)
				{
					repeat=false;
				}
				
			}
			catch (InputMismatchException e)
			{
				System.out.println("Only numbers: 1/2");
			}
			catch(Exception e)
			{
				System.out.println("Something is wrong");
				
			}
		}

		double P;
		double r;
		double alpha;
		double q;
		double beta;
		int t;
		
		Predation predation= new Predation();
		System.out.println(predation.predatorPopulationGrowth(100, 4555, 0.0003, 0.6, 1500));

		double horsePopulation=59;//get the value from the file 
		
		List<Animal> animals=new ArrayList<Animal>();
		Deer deer= new Deer(200);
		Horse horse= new Horse(horsePopulation);
		Cattle cattle= new Cattle(100);
		GreyWolf greyWolf= new GreyWolf(100);
		animals.add(deer);
		animals.add(horse);
		animals.add(cattle);
		animals.add(greyWolf);
		

		switch (choice)
		{
			case 1:
				System.out.println("Predator popultion: ");
				Scanner scan1= new Scanner(System.in);
				P = scan1.nextDouble();
				
				System.out.println("Per capita death rate of the predators: ");
				Scanner scan2= new Scanner(System.in);
				q = scan2.nextFloat();
				
				System.out.println("Conversion efficiency of predator: ");
				Scanner scan3= new Scanner(System.in);
				beta = scan3.nextFloat();
				
				System.out.println("Give year: ");
				Scanner scant= new Scanner(System.in);
				t = scant.nextInt();
				
				System.out.println(predation.predatorPopulationGrowth(P, q, beta,t));
				break;
				
			case 2:
				System.out.println("Intrinsic rate of increase: ");
				Scanner scan4= new Scanner(System.in);
				r = scan4.nextFloat();
				
				System.out.println("Capture efficiency: ");
				Scanner scan5= new Scanner(System.in);
				alpha = scan5.nextFloat();
				
				System.out.println("Predator popultion: ");
				Scanner scan6= new Scanner(System.in);
				P = scan6.nextDouble();
				
				System.out.println("Give year: ");
				Scanner scant2= new Scanner(System.in);
				t = scant2.nextInt();
				
				System.out.println(predation.victimPopulationGrowth(r, alpha, P, t));
		
				break;
			
		}
		
	}

}
