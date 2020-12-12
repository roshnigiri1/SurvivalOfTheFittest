package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("1. Logistic Population Growth\n2. Competition model\nModel > ");
		Scanner modelType = new Scanner(System.in);
		int modelTypeChoice = modelType.nextInt();
		if(modelTypeChoice == 1) {
			System.out.println("1. Horses\n2. Deer\n3. Cattle");
			System.out.print("Track > ");
			Scanner x = new Scanner(System.in);
			byte choice = x.nextByte();
			
			System.out.print("Growth rate : ");
			Scanner GR = new Scanner(System.in);
			double growthRate = GR.nextDouble();
			
			System.out.print("Carrying capacity : ");
			Scanner K = new Scanner(System.in);
			double carryingCapacity = K.nextDouble();
			
			System.out.print("Prediction for year : ");
			Scanner Y = new Scanner(System.in);
			int year = Y.nextInt();
			
			Model animal = new Model(growthRate, carryingCapacity);
			// For the discrete model replace logisticPopulationGrowthCon() with logisticPopulationGrowth()
			
			if(choice == 1) {
				System.out.print(animal.logisticPopulationGrowth(year, animal.getnH()));
			}
			else if(choice == 2) {
				System.out.print(animal.logisticPopulationGrowth(year, animal.getnD()));
			}
			else if(choice == 3) {
				System.out.print(animal.logisticPopulationGrowth(year, animal.getnC()));
			}
		}
		else if (modelTypeChoice == 2) {
			System.out.print("Prediction for year : ");
			Scanner Y = new Scanner(System.in);
			int year = Y.nextInt();
			ArrayList<Double> growthRate = new ArrayList<Double>();
			System.out.println("Growth rate : ");
			
			System.out.print("Horses > ");
			Scanner GR = new Scanner(System.in);
			growthRate.add(GR.nextDouble());

			System.out.print("Deer > ");
			growthRate.add(GR.nextDouble());

			System.out.print("Cattle > ");
			growthRate.add(GR.nextDouble());
			
			System.out.println("Influence : ");
			
			ArrayList<Double> influence = new ArrayList<Double>();
			for (int i = 0 ; i< 6 ; i++) {
				System.out.print("> ");
				Scanner inf = new Scanner(System.in);
				influence.add(inf.nextDouble());
			}
			Model animals = new Model(growthRate,influence);
			animals.competition(year);
			System.out.println(animals.getnH());
			System.out.println(animals.getnD());
			System.out.println(animals.getnC());
		}
	}
}
