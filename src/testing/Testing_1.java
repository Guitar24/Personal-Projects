package testing;
import java.util.*;

public class Testing_1 {
	
	public static ArrayList<String> Suits = new ArrayList<String>(Arrays.asList("♥", "♠", "♥", "♦", "♠"));
	
	public static ArrayList<Integer> CardScores = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1));
	
	public static int[] SuitScores = {0, 0, 0, 0};
	
	public static void main(String[] args) 
	{
		for(int i = 0; i < Suits.size(); i++)
		{
			if(Suits.get(i).equalsIgnoreCase("♥"))
			{
				SuitScores[0] = SuitScores[0] + CardScores.get(i);
			}
			else if(Suits.get(i).equalsIgnoreCase("♦"))
			{
				SuitScores[1] = SuitScores[1] + CardScores.get(i);
			}
			else if(Suits.get(i).equalsIgnoreCase("♣"))
			{
				SuitScores[2] = SuitScores[2] + CardScores.get(i);
			}
			else if(Suits.get(i).equalsIgnoreCase("♠"))
			{
				SuitScores[3] = SuitScores[3] + CardScores.get(i);
			}
		}
		
		int max = SuitScores[0];
		
		for(int i = 0; i < SuitScores.length; i++)
		{
			if(SuitScores[i] > max)
			{
				max = SuitScores[i];
			}
		}
		
		int suitIndex = 0;
		
		int i = 0;
		while(i < SuitScores.length)
		{
			if(SuitScores[i] == max)
			{
				suitIndex = i;
				break;
			}
			
			i++;
		}
		
		if(suitIndex == 0)
		{
			System.out.println("The best suit is: ♥");
		}
		else if(suitIndex == 1)
		{
			System.out.println("The best suit is: ♦");
		}
		else if(suitIndex == 2)
		{
			System.out.println("The best suit is: ♣");
		}
		else if(suitIndex == 3)
		{
			System.out.println("The best suit is: ♠");
		}
	}
}