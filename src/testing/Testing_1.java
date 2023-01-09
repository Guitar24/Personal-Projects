package testing;
import java.util.*;

public class Testing_1 {

	public static int loop = 0;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		for(int i = 0; i < 5; i++) 
		{
			System.out.println("i: " + i);
			
			while(loop < 5)
			{
				System.out.println("loop: " + loop);
				loop = loop + 1;
				if(loop == 3)
				{
					System.out.println("Loop de Loop");
					continue;
				}
				
			}
		}
	}

}
