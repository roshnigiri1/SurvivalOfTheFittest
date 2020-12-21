package application;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal{
	private int lifeSpan;
	private int diet;
	private double mortalityRate=0.32;
	private int numberOfBabies; 
	private double captureEfficiency;
	private double beta;
	private double rateOfIncrease=0.0005;

	public int getLifeSpan()
	{
		int lifeSpan = ThreadLocalRandom.current().nextInt(15, 19);
		return lifeSpan;
	}
	
	public int getDiet() 
	{
		int diet=ThreadLocalRandom.current().nextInt(5, 8);
		return diet;

	}

	public double getMortalityRate() 
	{
		return mortalityRate;
	}
	
	public int getNumberOfBabies()
	{
		int babies=ThreadLocalRandom.current().nextInt(4,7);
		return babies;
	}
	public double getRateOfIncrease()
	{
		return rateOfIncrease;
	}

	

	
	
	
 
}
