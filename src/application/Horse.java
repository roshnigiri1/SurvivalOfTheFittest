package application;

public class Horse extends Prey
{
	private double population=1050;
	private double rateOfIncrease=0.128;
	private int carryingCapacity=1350;
	private double captureEfficiency=0.006;
	private double compCoefficient=1.5;
	
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
