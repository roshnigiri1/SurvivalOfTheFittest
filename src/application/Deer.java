package application;

public class Deer extends Prey {
	
	private double population=3500;
	private double rateOfIncrease=-0.185;
	
	public Deer()
	{
		this.carryingCapacity=3650;
	}
	public Deer(double population)
	{
		this.carryingCapacity=3650;
		this.population=population;
	}
	
	public double getPopulation()
	{
		return population;
	}
	
	public double getRateOfIncrease()
	{
		return rateOfIncrease;
	}
}
