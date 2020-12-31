package application;

public class Deer extends Prey
{
	private double population=3400;
	private double rateOfIncrease=-0.185;
	private int carryingCapacity=3650;
	private double captureEfficiency=0.005;
	
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

}
