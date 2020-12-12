package application;

import java.util.HashMap;
import java.util.Map;

public class Predation 
{
	private double r;
	private double V=4555;
	private double alpha;
	private double q;
	private double beta;
	
	public Map<Integer,Integer> victimPopulationGrowth(double r, double alpha, double P,int year)
	{
		Map<Integer, Integer> yearAndNumber= new HashMap<Integer, Integer>();
		int cyear=2017;
		int t=year-cyear;
		double time=1;
		while(t>0)
		{
//			System.out.println(time);
//			double po= (r*time)-(P*alpha*time);
//			Integer vpr= (int) (V*(Math.pow(2.718, po)));
//			t-=1;
//			time+=1;
//			cyear+=1;
//			yearAndNumber.put(cyear, vpr);
			
			
			Integer vpg= (int) (V+ (r*V*(1-(V/4700))-(alpha*V*P)));
			t-=1;
			cyear+=1;
			P=predatorPopulationGrowth(P,V,0.0005,0.5,750);
			System.out.println(P);
			V=vpg;
			yearAndNumber.put(cyear, vpg);
		}
		return yearAndNumber ;
	}	
	
	public double victimPopulationGrowth(double V, double P,double r, double alpha)
	{
		double vpg=(int) (V+ (r*V*(1-(V/4700))-(alpha*V*P)));
		return vpg;
	}
	
	public Map<Integer,Integer> predatorPopulationGrowth(double P,double q, double beta, int year)
	{
		Map<Integer, Integer> yearAndNumber= new HashMap<Integer, Integer>();
		int cyear=2016;
		int t=year-cyear;
		double time=1;
		while(t>0)
		{
		//	double po= (beta*V*time)-(q*time);
//			double ppr = P*(Math.pow(2.718,po ));
//			t-=1;
//			time+=1;
//			cyear+=1;
//			yearAndNumber.put(cyear, (int) ppr);
			
			Integer ppg= (int) (P+(q*P*(1-(P/(900*V)))));
			t-=1;
			V=victimPopulationGrowth(V, P, 0.5,0.95);
			P=ppg;
			cyear+=1;
			yearAndNumber.put(cyear, ppg);
		}
		return yearAndNumber;
	}	
	
	public double predatorPopulationGrowth(double P,double V,double beta,double q, int K)
	{		
//		double po= (beta*V)-q;
//		double ppg = P*(Math.pow(2.718,po ));
		double ppg= (P+(q*P*(1-(P/(K*V)))));
		
		return ppg;
	}
	
	public double getBeta()
	{
		
		 return 0;
	}
	
	public double getAlpha()
	{
		return 1;
	}
	
}
