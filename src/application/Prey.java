package application;

public abstract class Prey extends Animal{
	private double population;
	private double rateOfIncrease;
	private int carryingCapacity;
	private double captureEfficiency;
	
	public double getRateOfIncrease()
	{
		return rateOfIncrease;
	}
	
	public int getCarryingCapacity() 
	{
		return carryingCapacity;
	}

	public double getPopulation() {
		return population;
	}

	public double getCaptureEfficiency() {
		return captureEfficiency;
	}
}
