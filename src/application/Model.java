package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
// to be edited - Start
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
// End


public class Model {
	/*
	private static TreeMap<Integer> nH = new Treemap<Integer>() {{add(540);}};
	private static ArrayList<Integer> nD = new ArrayList<Integer>() {{add(2400);}};
	private static ArrayList<Integer> nC = new ArrayList<Integer>() {{add(340);}};
	*/
	
	private static HashMap<Integer, Integer> nH = new HashMap<Integer, Integer>(){{put(2017,1050);}};
	private static HashMap<Integer, Integer> nD = new HashMap<Integer, Integer>(){{put(2017,3400);}};
	private static HashMap<Integer, Integer> nC = new HashMap<Integer, Integer>(){{put(2017,230);}};
	private static HashMap<Integer, Integer> av_nH_nC = new HashMap<Integer, Integer>(){{put(2017,640);}};
	
	private static HashMap<String, Double> nH_Copy = new HashMap<String, Double>(){{put("2017",1050.0);}};
	private static HashMap<String, Double> nD_Copy = new HashMap<String, Double>(){{put("2017",3400.0);}};
	private static HashMap<String, Double> nC_Copy = new HashMap<String, Double>(){{put("2017",230.0);}};
	
	ArrayList<Double> growthRateL = new ArrayList<Double>();
	private ArrayList<Double> influence = new ArrayList<Double>();
	private double growthRate;
	private double carryingCapacity;
	private double av_K, av_R;

	public Model(double growthRate, double carryingCapacity) {
		super();
		this.growthRate = growthRate;
		this.carryingCapacity = carryingCapacity;
	}

	public Model(){

	}

	public static HashMap<String, Double> getnH_Copy() {
		return nH_Copy;
	}
	public static void setnH_Copy(HashMap<String, Double> nH_Copy) {
		Model.nH_Copy = nH_Copy;
	}
	public static HashMap<String, Double> getnD_Copy() {
		return nD_Copy;
	}
	public static void setnD_Copy(HashMap<String, Double> nD_Copy) {
		Model.nD_Copy = nD_Copy;
	}
	public static HashMap<String, Double> getnC_Copy() {
		return nC_Copy;
	}
	public static void setnC_Copy(HashMap<String, Double> nC_Copy) {
		Model.nC_Copy = nC_Copy;
	}
	public Model(ArrayList<Double> growthRateL) {
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

	// Teacher's method 
	public void competitionB(double year) {
		int CarryingCapacityHorses = 1150;
		int CarryingCapacityCattle = 680;
		int CarryingCapacityDeer = 3400;
		
		if (year >= (double)2017) {
			int difference =  (int) (year - 2017);
			int Nt_h, Nt_d, Nt_c,av_Nt_h_c;
			double result_h,result_d,result_c,av_Result;
			
			av_K = 915;
			
			growthRateL.add(-0.12);    // horses
			growthRateL.add(-0.088888);    // cattle
			growthRateL.add(-0.185);       // deer
			
			influence.add(0.2);
			influence.add(5.2);
			influence.add((0.4 + 0.08)/2);
			influence.add((2.5+13)/2);
			
			av_R = (this.growthRateL.get(0) + this.growthRateL.get(1)) / 2;

			for (int i = 0 ; i < difference ; i ++) {
				Nt_h = this.nH.get(2017 + i);
				Nt_d = this.nD.get(2017 + i);
				Nt_c = this.nC.get(2017 + i);
				av_Nt_h_c = this.av_nH_nC.get(2017 + i);
				
				result_h = Nt_h * ( 1 +  this.growthRateL.get(0)*(1-(Nt_h + influence.get(0) * Nt_c)/CarryingCapacityHorses));
				nH.put(2018+i,(int) result_h);
				nH_Copy.put(Integer.toString(2018+i),(double) (int) result_h);
				
				result_c = Nt_c * ( 1 +  this.growthRateL.get(1)*(1-(Nt_c + influence.get(1) * Nt_h)/CarryingCapacityCattle));
				nC.put(2018+i,(int) result_c);
				nC_Copy.put(Integer.toString(2018+i),(double) (int) result_c);

				av_Result = av_Nt_h_c * (1 + av_R * (1-(av_Nt_h_c + influence.get(3) * Nt_d)/av_K));
				av_nH_nC.put(2018+i,(int)av_Result/2);
				
				result_d = Nt_d * ( 1 +  this.growthRateL.get(2)*(1-(Nt_d + influence.get(2) * av_Nt_h_c)/CarryingCapacityDeer));
				nD.put(2018+i,(int) result_d);
				nD_Copy.put(Integer.toString(2018+i),(double) (int) result_d);
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
