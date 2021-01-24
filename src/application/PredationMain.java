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
			System.out.println("1. Cattle population size\n2. Deer popultaion size\n3. Horse Population");
			System.out.print("Choose one(1/2/3): ");
			Scanner x = new Scanner(System.in);
			try
			{
				choice = x.nextInt();
				if(choice>0 && choice<=3)
				{
					repeat=false;
				}
				
			}
			catch (InputMismatchException e)
			{
				System.out.println("Only numbers: 1/2/3");
			}
			catch(Exception e)
			{
				System.out.println("Something is wrong");
				
			}
		}

		double P;
		int t;
		Cattle cattle= new Cattle();
		Horse horse = new Horse();
		Deer deer = new Deer();
		
		Predation predation= new Predation();
		System.out.println("Predator popultion: ");
		Scanner scan1= new Scanner(System.in);
		P = scan1.nextDouble();
		
		System.out.println("Give year: ");
		Scanner scan2= new Scanner(System.in);
		t = scan2.nextInt();

		switch (choice)
		{
			case 1:
				System.out.println(predation.cattlePopulationGrowth(P, t));
				break;
				
			case 2:
				System.out.println(predation.deerPopulationGrowth(P,t));
				break;
				
			case 3:	
				System.out.println(predation.horsePopulationGrowth(P,t));	
				break;
			
		}
		
	}

}
