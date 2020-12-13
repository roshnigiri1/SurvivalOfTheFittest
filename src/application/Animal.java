package application;

public abstract class Animal {
	 protected double population;
	 protected int carryingCapacity;
	 private double deathRate;
	 private double birthRate;
	 
	public double getPopulation() {
		return population;
	}
	public void setPopulation(int cPopulation) {
		this.population = cPopulation;
	}
	public int getCarryingCapacity() {
		return carryingCapacity;
	}
	public double getDeathRate() {
		return deathRate;
	}
	public double getBirthRate() {
		return birthRate;
	}
	 

}
