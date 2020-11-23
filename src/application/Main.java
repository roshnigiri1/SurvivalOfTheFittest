package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("1. Horses\n2. Deer\n3. Cattle");
		System.out.print("Track : ");
		Scanner x = new Scanner(System.in);
		int choice = x.nextInt();
		
		System.out.print("Birth rate : ");
		Scanner BR = new Scanner(System.in);
		double birthRate = BR.nextDouble();
		
		System.out.print("Death rate : ");
		Scanner DR = new Scanner(System.in);
		double deathRate = DR.nextDouble();
		
		System.out.print("Carrying capacity : ");
		Scanner K = new Scanner(System.in);
		double carryingCapacity = K.nextDouble();
		
		Model animal = new Model(birthRate, deathRate, carryingCapacity);
		
		System.out.print("Prediction for year : ");
		Scanner Y = new Scanner(System.in);
		int year = Y.nextInt();
		
		
		if(choice == 1) {
			animal.logisticPopulationGrowth(year, animal.getnH());
		}
		
		if(choice == 2) {
			animal.logisticPopulationGrowth(year, animal.getnD());
		}
		
		if(choice == 3) {
			animal.logisticPopulationGrowth(year, animal.getnC());
		}
		

	}
}
