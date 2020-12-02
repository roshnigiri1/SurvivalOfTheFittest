package application;

import java.util.ArrayList;


class MultiReturnValues { 
	ArrayList<Integer> horses;
	ArrayList<Integer> deer;
	ArrayList<Integer> cattle;
    MultiReturnValues(ArrayList<Integer> horses, ArrayList<Integer> deer, ArrayList<Integer> cattle) 
    { 
        this.horses = horses; 
        this.deer = deer;
        this.cattle = cattle; 
    }
	public MultiReturnValues() {
		return;
	} 
} 
public class Model {
	private static ArrayList<Integer> nH = new ArrayList<Integer>() {{add(540);}};
	private static ArrayList<Integer> nD = new ArrayList<Integer>() {{add(2400);}};
	private static ArrayList<Integer> nC = new ArrayList<Integer>() {{add(340);}};
	private double growthRate;
	private double carryingCapacity;


	public Model(double growthRate, double carryingCapacity) {
		super();
		this.growthRate = growthRate;
		this.carryingCapacity = carryingCapacity;
	}
	public Model() {

	}
	// Source : book (chap 2)
	public ArrayList<Integer> logisticPopulationGrowth(double year, ArrayList<Integer> animal) {
		if (true) {
			int difference =  (int) (year - 2020);
			int Nt;
			double result;
			for (int i = 0 ; i <= difference ; i ++) {
				Nt = animal.get(animal.size() - 1);
				result = Nt + Nt*growthRate*(1 - (Nt/this.carryingCapacity));
				animal.add((int) result);
			}
			
			return animal;
		}
		return new ArrayList<Integer>();
	}
	// Source : book (chap 2)
	public ArrayList<Integer> logisticPopulationGrowthCon(double year, ArrayList<Integer> animal) {
		if (true) {
			int difference =  (int) (year - 2020);	
			double result;
			double Kr = this.carryingCapacity;
			for (int i = 0 ; i <= difference ; i ++) {
				result = Kr/(1+((Kr-animal.get(0))/animal.get(0))*Math.exp(-growthRate*(i+1)));
				animal.add((int) result);
			}
			
			return animal;
		}
		return new ArrayList<Integer>();
	}
	// Source : https://sites.math.washington.edu/~morrow/336_16/2016papers/lalith.pdf (Page 8)
	public void competition(int year, ArrayList<Double> growthRate, ArrayList<Double> influence) {
		if (true) {
			int difference =  (int) (year - 2020);
			int Nt_h, Nt_d, Nt_c;
			double result_h,result_d,result_c;
			for (int i = 0 ; i < difference ; i ++) {
				Nt_h = this.nH.get(i);
				Nt_d = this.nD.get(i);
				Nt_c = this.nC.get(i);
				
				result_h = growthRate.get(0) + Nt_h + influence.get(0) * Nt_d + influence.get(1) * Nt_c;
				nH.add((int) result_h);
				
				result_d = growthRate.get(1) + Nt_d + influence.get(2) * Nt_h + influence.get(3) * Nt_c;
				nD.add((int) result_d);
				
				result_c = growthRate.get(2) + Nt_c + influence.get(4) * Nt_h + influence.get(5) * Nt_d;
				nC.add((int) result_c);
			
			}
			System.out.println(nH);
			System.out.println(nD);
			System.out.println(nC);
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
	public double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(double birthRate) {
		this.growthRate =growthRate;
	}
	public double getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}
}
