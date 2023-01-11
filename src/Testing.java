import java.util.*;


public class Testing {

	public static void main(String[] args) 
	{
		for(int i = 0; i < 5;)
		{
			System.out.print(i + ": ");
			
			if(i == 3)
			{
				System.out.println("Three");
				i++;
				continue;
			}
			else
			{
				i ++;
			}
			
			if(i < 5)
			{
				System.out.println("go");
			}
		}
	}
}