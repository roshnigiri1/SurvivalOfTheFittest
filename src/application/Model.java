package application;

import java.util.ArrayList;
import java.util.HashMap;
// to be edited - Start
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
// End


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
	/*
	private static TreeMap<Integer> nH = new Treemap<Integer>() {{add(540);}};
	private static ArrayList<Integer> nD = new ArrayList<Integer>() {{add(2400);}};
	private static ArrayList<Integer> nC = new ArrayList<Integer>() {{add(340);}};
	*/
	
	private static HashMap<Integer, Integer> nH = new HashMap<Integer, Integer>(){{put(2020,540);}};
	private static HashMap<Integer, Integer> nD = new HashMap<Integer, Integer>(){{put(2020,2400);}};
	private static HashMap<Integer, Integer> nC = new HashMap<Integer, Integer>(){{put(2020,340);}};
	
	private ArrayList<Double> growthRateL = new ArrayList<Double>();
	private ArrayList<Double> influence = new ArrayList<Double>();
	private double growthRate;
	private double carryingCapacity;

	public Model(double growthRate, double carryingCapacity) {
		super();
		this.growthRate = growthRate;
		this.carryingCapacity = carryingCapacity;
	}
	public Model(ArrayList<Double> growthRateL,ArrayList<Double> influence) {
		super();
		this.growthRateL = growthRateL;
		this.influence = influence;
	}

	// Source : book (chap 2)
	public HashMap<Integer, Integer> logisticPopulationGrowth(double year, HashMap<Integer, Integer> animal) {
		if (true) {
			int difference =  (int) (year - 2020);
			int Nt;
			double result;
			for (int i = 0 ; i < difference ; i ++) {
				Nt = animal.get(2020 + i);
				result = Nt + (Nt*growthRate*(1 - (Nt/this.carryingCapacity)));
				if (result <= 0) {
					return animal;
				}
				animal.put(2021 + i, (int) result);
			}
			return animal;
		}
		return new HashMap<Integer, Integer>();
	}
	// Source : book (chap 2)
	public HashMap<Integer, Integer> logisticPopulationGrowthCon(double year, HashMap<Integer, Integer> animal) {
		if (true) {
			int difference =  (int) (year - 2020);	
			double result;
			double Kr = this.carryingCapacity;
			for (int i = 0 ; i < difference ; i ++) {
				result = Kr/(1+((Kr-animal.get(2020))/animal.get(2020))*Math.exp(-growthRate*(i+1)));
				if (result <= 0) {
					return animal;
				}
				animal.put(2021 + i, (int) result);
			}
			return animal;
		}
		return new HashMap<Integer, Integer>();
	}
	// Source : https://sites.math.washington.edu/~morrow/336_16/2016papers/lalith.pdf (Page 8)
	public void competitionA(double year) {
		if (year >= 2020) {
			int difference =  (int) (year - 2020);
			int Nt_h, Nt_d, Nt_c;
			double result_h,result_d,result_c;
			for (int i = 0 ; i < difference ; i ++) {
				Nt_h = this.nH.get(2020 + i);
				Nt_d = this.nD.get(2020 + i);
				Nt_c = this.nC.get(2020 + i);
				result_h = this.growthRateL.get(0) + Nt_h + influence.get(0) * Nt_d + influence.get(1) * Nt_c;
				nH.put(2021+i,(int) result_h);
				result_d = this.growthRateL.get(1) + Nt_d + influence.get(2) * Nt_h + influence.get(3) * Nt_c;
				nD.put(2021+i,(int) result_d);
				result_c = this.growthRateL.get(2) + Nt_c + influence.get(4) * Nt_h + influence.get(5) * Nt_d;
				nC.put(2021+i,(int) result_c);
			}
		}
		return ;
	}
	
	public void competitionB(double year) {
		if (year >= 2020) {
			int difference =  (int) (year - 2020);
			int Nt_h, Nt_d, Nt_c;
			double result_h,result_d,result_c;
			for (int i = 0 ; i < difference ; i ++) {
				Nt_h = this.nH.get(2020 + i);
				Nt_d = this.nD.get(2020 + i);
				Nt_c = this.nC.get(2020 + i);
				result_h = this.growthRateL.get(0) + Nt_h + influence.get(0) * Nt_d + influence.get(1) * Nt_c;
				nH.put(2021+i,(int) result_h);
				result_d = this.growthRateL.get(1) + Nt_d + influence.get(2) * Nt_h + influence.get(3) * Nt_c;
				nD.put(2021+i,(int) result_d);
				result_c = this.growthRateL.get(2) + Nt_c + influence.get(4) * Nt_h + influence.get(5) * Nt_d;
				nC.put(2021+i,(int) result_c);
			}
		}
		return ;
	}
	public static HashMap<Integer, Integer> getnH() {
		return nH;
	}
	public static void setnH(HashMap<Integer, Integer> nH) {
		Model.nH = nH;
	}
	public static HashMap<Integer, Integer> getnD() {
		return nD;
	}
	public static void setnD(HashMap<Integer, Integer> nD) {
		Model.nD = nD;
	}
	public static HashMap<Integer, Integer> getnC() {
		return nC;
	}
	public static void setnC(HashMap<Integer, Integer> nC) {
		Model.nC = nC;
	}
	public ArrayList<Double> getGrowthRateL() {
		return growthRateL;
	}
	public void setGrowthRateL(ArrayList<Double> growthRateL) {
		this.growthRateL = growthRateL;
	}
	public ArrayList<Double> getInfluence() {
		return influence;
	}
	public void setInfluence(ArrayList<Double> influence) {
		this.influence = influence;
	}
	public double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}
	public double getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	
}
