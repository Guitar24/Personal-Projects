package testing;

import array.Array;

public class Physics {

	public static void main(String[] args) 
	{
		
		//Right is positive
		//Up is positive
		
		double gravity = -9.81;
		
		double x, y, t = 0;
		
		double[] HDists = new double[91];
		
		for (int angle = 0; angle <= 90; angle++)
		{
			double Vi = 20.0;
			double Viy = Vi * Math.sin(angle * (Math.PI/180));
			double Vix = Vi * Math.cos(angle * (Math.PI/180));
	
			t = (Viy / (0.5 * -gravity));
			
			double dx = Vix * t;
			
			HDists[angle] = dx;
		}
		
		
		for(int i = 0; i < 91; i++)
		{
			
			System.out.println("Angle: " + i + "°\tDistance: " + Math.round(HDists[i]*100)/100 + "m");
		}
		

		int angle2 = Array.findMax(HDists);
		
		System.out.println("\nOptimal Angle: " + angle2 + "°");
		
		
		
	}

}
