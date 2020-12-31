package application;

public abstract class Animal {
	 protected double population;
	 private double deathRate;
	 
	public double getPopulation() {
		return population;
	}
	public void setPopulation(int cPopulation) {
		this.population = cPopulation;
	}
	
	public double getDeathRate() {
		return deathRate;
	}

}
