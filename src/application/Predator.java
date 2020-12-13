package application;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal{
	private int lifeSpan;
	private int diet;
	private int mortalityRate;
	private int numberOfBabies; 
	private double captureEfficiency;
	private double beta;

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
		double rate=ThreadLocalRandom.current().nextDouble(0.4,0.61);
		return rate;
	}
	
	public int getNumberOfBabies()
	{
		int babies=ThreadLocalRandom.current().nextInt(4,7);
		return babies;
	}

	

	
	
	
 
}
