package application;

public class Predation 
{
	private float r;
	private double V=3280;
	private float alpha;
	private double P;
	private float q;
	private float beta;
	
	public double victimPopulationGrowth(float r, float alpha, double P)
	{
		double vpr= (r*V)-(alpha*V*P);
		System.out.println("Victim population growth will be: "+vpr);
		return vpr;
	}
	
	public double predatorPopulationGrowth(double P,float q, float beta)
	{
		double ppr = (beta*V*P)-(q*P);
		System.out.println("Predator population growth will be: "+ppr);
		return ppr;
	}
	
	public double predatorPopulation(float r, float alpha)
	{
		double pp=r/alpha;
		System.out.println("Predator population that will maintain victim popultion at zero growth is: "+pp);
		return pp;
	}
	
	public double victimPopulation(float q, float beta)
	{
		double vp=q/beta;
		System.out.println("Victim population will be: "+vp);
		return vp;
	}
	
}
