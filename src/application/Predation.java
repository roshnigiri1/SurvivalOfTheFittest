package application;

import java.util.LinkedHashMap;
import java.util.Map;

public class Predation 
{
	public Map<Double,Double> deerPopulationGrowth(double P,int year,Deer deer)
	{
		Map<Double, Double> preyAndPredator= new LinkedHashMap<Double, Double>();
		//Map<Integer, Integer> yearAndPredator= new HashMap<Integer, Integer>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{			
//getting the difference and adding to the initial population, considering resource limited environment in the presence of predator and calculating for every next year
			double change= (deer.getRateOfIncrease()*deer.getPopulation()*(1-(deer.getPopulation()/deer.getCarryingCapacity())))-(deer.getCaptureEfficiency()*deer.getPopulation()*P);
			double vpg= deer.getPopulation()+change;
			continues-=1;
			cyear+=1;
			P=predatorPopulationGrowth(P,deer.getPopulation()); //number of predator changing for every next year
			deer.setPopulation(vpg);
			preyAndPredator.put(P,vpg );
			
		}
		return preyAndPredator ;
	}	
	
	public Map<Double,Double> cattlePopulationGrowth(double P,int year, Cattle cattle, Horse horse)
	{
		Map<Double, Double> preyAndPredator= new LinkedHashMap<Double, Double>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{	
//getting the difference and adding to the initial population, considering competition between cattle and horse in the presence of predator	and calculating for every next year	
			double change1 = cattle.getRateOfIncrease()*cattle.getPopulation();
			double change2 =((cattle.getCarryingCapacity()-cattle.getPopulation()-(horse.getCompCoefficient()*horse.getPopulation()))/cattle.getCarryingCapacity());
			double change3= change1*change2;
			double change4 = cattle.getCaptureEfficiency()*cattle.getPopulation()*P;
			double change = change3-change4;
			double cattlepg = cattle.getPopulation()+change;
			continues-=1;
			cyear+=1; 
			horse.setPopulation(horsePop(cattle, horse, P));//changing the horsenumber for every next year
			P=predatorPopulationGrowth(P,cattle.getPopulation()); //changing the number of predator for every next year
			System.out.println(P);
			cattle.setPopulation(cattlepg);
			preyAndPredator.put(P, cattlepg);
		}
		return preyAndPredator ;
	
	}
	
	public Map<Double,Double> horsePopulationGrowth(double P,int year, Cattle cattle, Horse horse)
	{
		Map<Double, Double> preyAndPredator= new LinkedHashMap<Double, Double>();
		int cyear=2017;
		int continues=year-cyear;
		while(continues>0)
		{	
//getting the difference and adding to the initial population, considering competition between cattle and horse in the presence of predator	and calculating for every next year	
			double change1 = horse.getRateOfIncrease()*horse.getPopulation();
			double change2 =((horse.getCarryingCapacity()-horse.getPopulation()-(cattle.getCompCoefficient()*cattle.getPopulation()))/horse.getCarryingCapacity());
			double change3= change1*change2;
			double change4 = horse.getCaptureEfficiency()*horse.getPopulation()*P;
			double change = change3-change4;
			double horsepg = horse.getPopulation()+change;
			continues-=1;
			cyear+=1; 
			cattle.setPopulation(cattlePop(cattle, horse, P));//changing the cattlenumber for every next year
			P=predatorPopulationGrowth(P,horse.getPopulation());  //changing the number of predator for every next year
			horse.setPopulation(horsepg);
			preyAndPredator.put(P, horsepg);
		}
		return preyAndPredator ;
	
	}
	
	public double predatorPopulationGrowth(double P,double V)
	{
//getting the difference of predator number and adding to the inital number which will give the population size for the coming year
		Predator predator= new Predator();
		double change =(predator.getBeta()*V*P)-(predator.getDeathRate()*P);
		double ppg = P+change;
		return ppg;
	}
	
	public double cattlePop(Cattle cattle, Horse horse,double P)
	{
		double change1 = cattle.getRateOfIncrease()*cattle.getPopulation();
		double change2 =((cattle.getCarryingCapacity()-cattle.getPopulation()-(horse.getCompCoefficient()*horse.getPopulation()))/cattle.getCarryingCapacity());
		double change3= change1*change2;
		double change4 = cattle.getCaptureEfficiency()*cattle.getPopulation()*P;
		double change = change3-change4;
		double cattlepg = cattle.getPopulation()+change;
		
		return cattlepg;
	}
	
	public double horsePop(Cattle cattle, Horse horse,double P)
	{
		double change1 = horse.getRateOfIncrease()*horse.getPopulation();
		double change2 =((horse.getCarryingCapacity()-horse.getPopulation()-(cattle.getCompCoefficient()*cattle.getPopulation()))/horse.getCarryingCapacity());
		double change3= change1*change2;
		double change4 = horse.getCaptureEfficiency()*horse.getPopulation()*P;
		double change = change3-change4;
		double horsepg = horse.getPopulation()+change;
		
		return horsepg;
	}
	
}
