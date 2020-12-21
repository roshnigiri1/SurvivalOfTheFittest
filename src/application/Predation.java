package application;

import java.util.HashMap;
import java.util.Map;

public class Predation 
{
	private double deerPopulation=3400;
	double cattlePopulation = 230;
	double horsePopulation = 1050;
	double deerIntRate = -0.185;
	double cattleIntRate = 0.378;
	double horseIntRate = 0.128;
	int K1 = 680;
	int K2= 1350;
	int KD = 3650;
	double capEffD = 0.005;
	double capEffC = 0.017;
	double capEffH = 0.006;
	double compCoffH = 1.5;
	double compCoffC = 0.5;
	
	public Map<Integer,Integer> deerPopulationGrowth(double P,int year)
	{
		Map<Integer, Integer> yearAndNumber= new HashMap<Integer, Integer>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{			
			double change= (deerIntRate*deerPopulation*(1-(deerPopulation/KD)))-(capEffD*deerPopulation*P);
			double vpg= deerPopulation+change;
			continues-=1;
			cyear+=1;
			P=predatorPopulationGrowth(P,deerPopulation,0.005,0.47);
			deerPopulation=vpg;
			yearAndNumber.put(cyear, (int) vpg);
		}
		return yearAndNumber ;
	}	
	
	public Map<Integer,Integer> cattlePopulationGrowth(double P,int year)
	{
		Map<Integer, Integer> yearAndNumber= new HashMap<Integer, Integer>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{	
			double change1 = cattleIntRate*cattlePopulation;
			double change2 =((K1-cattlePopulation-(compCoffH*horsePopulation))/K1);
			double change3= change1*change2;
			double change4 = capEffC*cattlePopulation*P;
			double change = change3-change4;
			double cattlepg = cattlePopulation+change;
			continues-=1;
			cyear+=1;
			horsePopulation=horsePop(horsePopulation, cattlePopulation, P); 
			P=predatorPopulationGrowth(P,cattlePopulation,0.005,0.47);
			cattlePopulation = cattlepg;
			yearAndNumber.put(cyear, (int) cattlepg);
		}
		return yearAndNumber ;
	
	}
	
	public Map<Integer,Integer> horsePopulationGrowth(double P,int year)
	{
		Map<Integer, Integer> yearAndNumber= new HashMap<Integer, Integer>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{	
			double change1 = horseIntRate*horsePopulation;
			double change2 =((K2-horsePopulation-(compCoffC*cattlePopulation))/K2);
			double change3= change1*change2;
			double change4 = capEffH*horsePopulation*P;
			double change = change3-change4;
			double horsepg = horsePopulation+change;
			continues-=1;
			cyear+=1;
			cattlePopulation=cattlePop(horsePopulation, cattlePopulation, P); 
			P=predatorPopulationGrowth(P,horsePopulation,0.005,0.47);
			horsePopulation = horsepg;
			yearAndNumber.put(cyear, (int) horsepg);
		}
		return yearAndNumber ;
	
	}
	
	public double predatorPopulationGrowth(double P,double V, double beta, double q)
	{
		double change =(beta*V*P)-(q*P);
		double ppg = P+change;
		return ppg;
	}
	
	public double cattlePop(double hPopulation, double cPopulation, double P)
	{
		double change1 = cattleIntRate*cattlePopulation;
		double change2 =((K1-cattlePopulation-(compCoffH*horsePopulation))/K1);
		double change3= change1*change2;
		double change4 = capEffC*cattlePopulation*P;
		double change = change3-change4;
		double cattlepg = cattlePopulation+change;
		
		return cattlepg;
	}
	
	public double horsePop(double hPopulation, double cPopulation, double P)
	{
		double change1 = horseIntRate*horsePopulation;
		double change2 =((K2-horsePopulation-(compCoffC*cattlePopulation))/K2);
		double change3= change1*change2;
		double change4 = capEffH*cattlePopulation*P;
		double change = change3-change4;
		double horsePg = horsePopulation+change;
		
		return horsePg;
	}
	
}
