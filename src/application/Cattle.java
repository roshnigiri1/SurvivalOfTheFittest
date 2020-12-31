package application;

public class Cattle extends Prey
{
	private double population=230;
	private double rateOfIncrease=0.378;
	private int carryingCapacity=680;
	private double captureEfficiency=0.017;
	private double compCoefficient=0.5;
	
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public double getRateOfIncrease() {
		return rateOfIncrease;
	}
	public int getCarryingCapacity() {
		return carryingCapacity;
	}
	public double getCaptureEfficiency() {
		return captureEfficiency;
	}
	public double getCompCoefficient() {
		return compCoefficient;
	}
}
