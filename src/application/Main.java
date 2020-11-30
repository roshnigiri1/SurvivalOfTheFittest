package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("1. Logistic Population Growth\n2. Competition model");
		Scanner modelType = new Scanner(System.in);
		int modelTypeChoice = modelType.nextInt();
		if(modelTypeChoice == 1) {
			System.out.println("1. Horses\n2. Deer\n3. Cattle");
			System.out.print("Track : ");
			Scanner x = new Scanner(System.in);
			byte choice = x.nextByte();
			
			System.out.print("Growth rate : ");
			Scanner GR = new Scanner(System.in);
			double growthRate = GR.nextDouble();
			
			System.out.print("Carrying capacity : ");
			Scanner K = new Scanner(System.in);
			double carryingCapacity = K.nextDouble();
			
			Model animal = new Model(growthRate, carryingCapacity);
			
			System.out.print("Prediction for year : ");
			Scanner Y = new Scanner(System.in);
			int year = Y.nextInt();
			
			// For the discrete model replace logisticPopulationGrowthCon() with logisticPopulationGrowth()
			if(choice == 1) {
				animal.logisticPopulationGrowthCon(year, animal.getnH());
			}
			
			else if(choice == 2) {
				animal.logisticPopulationGrowthCon(year, animal.getnD());
			}
			
			else if(choice == 3) {
				animal.logisticPopulationGrowthCon(year, animal.getnC());
			}
		}
		else {
			System.out.print("Prediction for year : ");
			Scanner Y = new Scanner(System.in);
			int year = Y.nextInt();
			ArrayList<Double> growthRate = new ArrayList<Double>();
			System.out.println("Growth rate > ");
			for(int i = 0 ; i<3 ; i ++) {
				System.out.println("Horses : ");
				Scanner GRH = new Scanner(System.in);
				double growthRateVal = GRH.nextDouble();
				growthRate.add(growthRateVal);
				
				System.out.println("Deer : ");
				Scanner GRD = new Scanner(System.in);
				growthRateVal = GRD.nextDouble();
				growthRate.add(growthRateVal);
				
				System.out.println("Cattle : ");
				Scanner GRC = new Scanner(System.in);
				growthRateVal = GRC.nextDouble();
				growthRate.add(growthRateVal);
			}
		}
		
	}
}
