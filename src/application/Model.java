package application;

import java.util.ArrayList;

public class Model {
	private static ArrayList<Integer> nH = new ArrayList<Integer>() {{add(540);}};
	private static ArrayList<Integer> nD = new ArrayList<Integer>() {{add(2400);}};
	private static ArrayList<Integer> nC = new ArrayList<Integer>() {{add(340);}};
	private double birthRate;
	private double deathRate;
	private double carryingCapacity;


	public Model(double growthRate, double deathRate, double carryingCapacity) {
		super();
		this.birthRate = growthRate;
		this.deathRate = deathRate;
		this.carryingCapacity = carryingCapacity;
	}
	

	
	public void logisticPopulationGrowth(double year, ArrayList<Integer> animal) {
		if (year>=2020) {
			int difference =  (int) (year - 2020);
			int Nt;
			double result;
			double growthRate = this.birthRate - this.deathRate;
			for (int i = 0 ; i <= difference ; i ++) {
				Nt = animal.get(animal.size() - 1);
				result = Nt + Nt*growthRate*(1 - (Nt/this.carryingCapacity));
				animal.add((int) result);
			}
			
			System.out.println(animal);
		}
	}

	public static ArrayList<Integer> getnH() {
		return nH;
	}

	public static void setnH(ArrayList<Integer> nH) {
		Model.nH = nH;
	}

	public static ArrayList<Integer> getnD() {
		return nD;
	}

	public static void setnD(ArrayList<Integer> nD) {
		Model.nD = nD;
	}

	public static ArrayList<Integer> getnC() {
		return nC;
	}

	public static void setnC(ArrayList<Integer> nC) {
		Model.nC = nC;
	}

	public double getBirthRate() {
		return birthRate;
	}

	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
	}

	public double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
	}


	public double getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}


}
