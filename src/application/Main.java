package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
		
		System.out.print("Prediction for whick year : ");
		Scanner Y = new Scanner(System.in);
		int year = Y.nextInt();
		
		animal.logisticPopulationGrowth(year);
		
		System.out.println(animal.getnH());

	}
}
