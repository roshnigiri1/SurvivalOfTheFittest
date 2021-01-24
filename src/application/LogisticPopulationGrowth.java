package application;

import java.util.ArrayList;
import java.util.HashMap;

public class LogisticPopulationGrowth {
	
	ArrayList<Double> growthRateL = new ArrayList<Double>();
	private static HashMap<Integer, Integer> nH = new HashMap<Integer, Integer>(){{put(2017,1050);}};
	private static HashMap<Integer, Integer> nD = new HashMap<Integer, Integer>(){{put(2017,3400);}};
	private static HashMap<Integer, Integer> nC = new HashMap<Integer, Integer>(){{put(2017,230);}};
	
	private static HashMap<String, Double> nH_Copy = new HashMap<String, Double>(){{put("2017",1050.0);}};
	private static HashMap<String, Double> nD_Copy = new HashMap<String, Double>(){{put("2017",3400.0);}};

	public static HashMap<String, Double> getnH_Copy() {
		return nH_Copy;
	}

	public static void setnH_Copy(HashMap<String, Double> nH_Copy) {
		LogisticPopulationGrowth.nH_Copy = nH_Copy;
	}

	public static HashMap<String, Double> getnD_Copy() {
		return nD_Copy;
	}

	public static void setnD_Copy(HashMap<String, Double> nD_Copy) {
		LogisticPopulationGrowth.nD_Copy = nD_Copy;
	}

	public static HashMap<String, Double> getnC_Copy() {
		return nC_Copy;
	}

	public static void setnC_Copy(HashMap<String, Double> nC_Copy) {
		LogisticPopulationGrowth.nC_Copy = nC_Copy;
	}

	private static HashMap<String, Double> nC_Copy = new HashMap<String, Double>(){{put("2017",230.0);}};

	public void logisticPopulationGrowth(double year) {
		int CarryingCapacityHorses = 1150;
		int CarryingCapacityCattle = 680;
		int CarryingCapacityDeer = 3400;
		
		if (year >= (double)2017) {
			int difference =  (int) (year - 2017);
			int Nt_h, Nt_d, Nt_c,av_Nt_h_c;
			double result_h,result_d,result_c;
			
			
			growthRateL.add(-0.12);    // horses
			growthRateL.add(-0.088888);    // cattle
			growthRateL.add(-0.185);       // deer
			

			for (int i = 0 ; i < difference ; i ++) {
				Nt_h = this.nH.get(2017 + i);
				Nt_d = this.nD.get(2017 + i);
				Nt_c = this.nC.get(2017 + i);
				
				result_h = Nt_h + (Nt_h * this.growthRateL.get(0) * (1 - (Nt_h/CarryingCapacityHorses)));
				nH.put(2018+i,(int) result_h);
				nH_Copy.put(Integer.toString(2018+i),(double) (int) result_h);
				
				result_c = Nt_c + (Nt_c * this.growthRateL.get(1) * (1 - (Nt_c/CarryingCapacityCattle)));
				nC.put(2018+i,(int) result_c);
				nC_Copy.put(Integer.toString(2018+i),(double) (int) result_c);
				
				result_d = Nt_d + (Nt_d * this.growthRateL.get(2) * (1 - (Nt_d/CarryingCapacityDeer)));
				nD.put(2018+i,(int) result_d);
				nD_Copy.put(Integer.toString(2018+i),(double) (int) result_d);
			}
		}
		return ;
	}
	

}
