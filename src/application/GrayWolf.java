package application;

import java.util.concurrent.ThreadLocalRandom;

public class GrayWolf{
	private int lifeSpan;
	private int diet;
	private int mortalityRate;
	private int numberOfBabies; 
	
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

	public int getMortalityRate() 
	{
		int rate=ThreadLocalRandom.current().nextInt(40,61);
		return rate;
	}
	
	public int getNumberOfBabies()
	{
		int babies=ThreadLocalRandom.current().nextInt(4,7);
		return babies;
	}

	

	
	
	
 
}
