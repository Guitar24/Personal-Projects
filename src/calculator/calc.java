package calculator;

public class calc 
{
	public static String DRG = "d";

	public static double add(double[] nums)
	{
		double sum = nums[0];
		
		for(int i = 1; i < nums.length; i++)
		{
			sum += nums[i];
		}
		
		return sum;
	}

	public static double subtract(double[] nums)
	{
		double diff = nums[0];
		
		for(int i = 1; i < nums.length; i++)
		{
			diff -= nums[i];
		}
		
		return diff;
	}

	public static double multiply(double[] nums)
	{
		double product = nums[0];
		
		for(int i = 1; i < nums.length; i++)
		{
			product *= nums[i];
		}
		
		return product;
	}
	
	public static double divide(double[] nums)
	{
		double quoteint = nums[0];
		
		for(int i = 1; i < nums.length; i++)
		{
			quoteint /= nums[i];
		}
		
		return quoteint;
	}

	public static double exponent(double num, double exponent)
	{
		return Math.pow(num, exponent);
	}
	
	public static double root(double num, double root)
	{
		return Math.pow(num, 1/root);
	}

	public static double sin(double angle)
	{
		if(DRG.equals("d"))
			return Math.sin(Math.toRadians(angle));
		else
			return Math.sin(angle);
		
	}

	public static double cos(double angle)
	{
		if(DRG.equals("d"))
			return Math.cos(Math.toRadians(angle));
		else
			return Math.cos(angle);
		
	}

	public static double tan(double angle)
	{
		if(DRG.equals("d"))
			return Math.tan(Math.toRadians(angle));
		else
			return Math.tan(angle);
		
	}

	public static double csc(double angle)
	{
		if(DRG.equals("d"))
			return 1/Math.sin(Math.toRadians(angle));
		else
			return 1/Math.sin(angle);
		
	}

	public static double sec(double angle)
	{
		if(DRG.equals("d"))
			return 1/Math.cos(Math.toRadians(angle));
		else
			return 1/Math.cos(angle);
		
	}

	public static double cot(double angle)
	{
		if(DRG.equals("d"))
			return 1/Math.tan(Math.toRadians(angle));
		else
			return 1/Math.tan(angle);
		
	}

}
