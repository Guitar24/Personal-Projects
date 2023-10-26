package uno;

import java.util.*;
import animations.Colours;

public class UNO {
	
	public static ArrayList<String> cards = new ArrayList<String>(Arrays.asList("OR", "1R", "1R", "2R", "2R", "3R", "3R", "4R", "4R", "5R", "5R", "6R", "6R", "7R", "7R", "8R", "8R", "9R", "9R",
																				"OG", "1G", "1G", "2G", "2G", "3G", "3G", "4G", "4G", "5G", "5G", "6G", "6G", "7G", "7G", "8G", "8G", "9G", "9G",
																				"OB", "1B", "1B", "2B", "2B", "3B", "3B", "4B", "4B", "5B", "5B", "6B", "6B", "7B", "7B", "8B", "8B", "9B", "9B",
																				"0Y", "1Y", "1Y", "2Y", "2Y", "3Y", "3Y", "4Y", "4Y", "5Y", "5Y", "6Y", "6Y", "7Y", "7Y", "8Y", "8Y", "9Y", "9Y",
																				
			
																				"🛇R", "🛇R", "«»R", "«»R", "+2R", "+2R", "▄▀", "▄▀", "+4▄▀",
																				"🛇G", "🛇G", "«»G", "«»G", "+2G", "+2G", "▄▀", "▄▀", "+4▄▀",
																				"🛇B", "🛇B", "«»B", "«»B", "+2B", "+2B", "▄▀", "▄▀", "+4▄▀",
																				"🛇Y", "🛇Y", "«»Y", "«»Y", "+2Y", "+2Y", "▄▀", "▄▀", "+4▄▀"));

	public static void main(String[] args) 
	{
		//int cardIndex = callCard("skip", "red");
		
		printCard("change colour", "blue");
		
		//System.out.println(cards.get(94));
		
		
	}
	
	public static void printCard(String character, String colours)
	{
		int index = callCard(character, colours);
		
		String card = cards.get(index);
		String colour = "";
		
		if(card.contains("R"))
			colour = Colours.WHITE + Colours.RED_BACKGROUND;//_BRIGHT;
		else if(card.contains("G"))
			colour = Colours.GREEN_BACKGROUND_BRIGHT;
		else if(card.contains("B"))
			colour = Colours.WHITE + Colours.BLUE_BACKGROUND_BRIGHT;
		else if(card.contains("Y"))
			colour = Colours.BLACK_BOLD + Colours.UNO_YELLOW_BACKGROUND;
		
		if(card.contains("R") || card.contains("G") || card.contains("B") || card.contains("Y"))
		{
			StringBuilder sb = new StringBuilder(card);
	        sb.deleteCharAt(card.length() - 1);
	        
	        card = sb.toString();
	        
	        System.out.println(colour + card + Colours.RESET);
		}
		
		else if(card.contains("▄▀"))
		{
			System.out.println(Colours.GREEN_BACKGROUND_BRIGHT + Colours.BLUE_BOLD_BRIGHT + "▄" + Colours.UNO_YELLOW_BACKGROUND + Colours.RED_BOLD_BRIGHT + "▀" + Colours.RESET);
		}
		
		
		
		
	}
	
	public static int callCard(String character, String colour)
	{
		String cardToFind = "";
		
		if(character.equalsIgnoreCase("0"))
			cardToFind += "0"; 
		
		else if(character.equalsIgnoreCase("1"))
			cardToFind += "1"; 
		
		else if(character.equalsIgnoreCase("2"))
			cardToFind += "2"; 
		
		else if(character.equalsIgnoreCase("3"))
			cardToFind += "3"; 
		
		else if(character.equalsIgnoreCase("4"))
			cardToFind += "4";
		
		else if(character.equalsIgnoreCase("5"))
			cardToFind += "5"; 
		
		else if(character.equalsIgnoreCase("6"))
			cardToFind += "6"; 
		
		else if(character.equalsIgnoreCase("7"))
			cardToFind += "7"; 
		
		else if(character.equalsIgnoreCase("8"))
			cardToFind += "8"; 
		
		else if(character.equalsIgnoreCase("9"))
			cardToFind += "9"; 
		
		else if(character.equalsIgnoreCase("skip"))
			cardToFind += "🛇";
		
		else if(character.equalsIgnoreCase("reverse"))
			cardToFind += "«»";
		
		else if(character.equalsIgnoreCase("+2"))
			cardToFind += "+2";
		
		else if(character.equalsIgnoreCase("+4"))
			cardToFind += "+4▄▀";
		
		else if(character.equalsIgnoreCase("change colour"))
			cardToFind += "▄▀";
		
		if(colour.equalsIgnoreCase("red"))
			cardToFind += "R";
		
		else if(colour.equalsIgnoreCase("green"))
			cardToFind += "G";
		
		else if(colour.equalsIgnoreCase("blue"))
			cardToFind += "B";
		
		else if(colour.equalsIgnoreCase("yellow"))
			cardToFind += "Y";
		
		
		 for (int i = 0; i < cards.size(); i++)
		 {
	         if(cards.get(i).equals(cardToFind))
	         {
	        	 return i;
	         }
	     }
		 
		 return 0;
	}

}