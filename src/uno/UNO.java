package uno;

import java.util.*;
import animations.Colours;

public class UNO {
	
	static Scanner Input = new Scanner(System.in);

	static ArrayList<String> cards = new ArrayList<String>(Arrays.asList("OR", "1R", "1R", "2R", "2R", "3R", "3R", "4R", "4R", "5R", "5R", "6R", "6R", "7R", "7R", "8R", "8R", "9R", "9R","OG", "1G", "1G", "2G", "2G", "3G", "3G", "4G", "4G", "5G", "5G", "6G", "6G", "7G", "7G", "8G", "8G", "9G", "9G","OB", "1B", "1B", "2B", "2B", "3B", "3B", "4B", "4B", "5B", "5B", "6B", "6B", "7B", "7B", "8B", "8B", "9B", "9B","0Y", "1Y", "1Y", "2Y", "2Y", "3Y", "3Y", "4Y", "4Y", "5Y", "5Y", "6Y", "6Y", "7Y", "7Y", "8Y", "8Y", "9Y", "9Y", "🛇R", "🛇R", "«»R", "«»R", "+2R", "+2R", "▄▀K", "▄▀K", "+4▄▀K","🛇G", "🛇G", "«»G", "«»G", "+2G", "+2G", "▄▀K", "▄▀K", "+4▄▀K","🛇B", "🛇B", "«»B", "«»B", "+2B", "+2B", "▄▀K", "▄▀K", "+4▄▀K","🛇Y", "🛇Y", "«»Y", "«»Y", "+2Y", "+2Y", "▄▀K", "▄▀K", "+4▄▀K"));

	static ArrayList<String> cardsPlayed = new ArrayList<String>();
	
	static String[][] playerCards;

	static int numOfPlayers;
	static int numOfCards;
	
	static int play;
	
	static String cardOnTop;


	public static void main(String[] args) 
	{
		numOfPlayers = 4;
		numOfCards = 8;


		playerCards = dealCards();
		

		cardsPlayed.add(cards.get(0));

		
		printGiantUnoCard();
		gameLoop();
		//debug();



	}

	public static void gameLoop()
	{
		playerCards = dealCards();
		printTable();
		playCard();
	}
	
	public static void playCard()
	{
		System.out.print("\n\nPlay card: ");
		String cardToPlay = Input.nextLine();
		
		String desiredCard = "";

		if(cardToPlay.toLowerCase().contains("skip"))
			desiredCard += "🛇";
		else if(cardToPlay.toLowerCase().contains("reverse"))
			desiredCard += "«»";
		else if(cardToPlay.toLowerCase().contains("+2"))
			desiredCard += "+2";
		else if(cardToPlay.toLowerCase().contains("+4"))
			desiredCard += "+4▄▀K";
		else if(cardToPlay.toLowerCase().contains("change colour"))
			desiredCard += "▄▀K";
		else if(cardToPlay.toLowerCase().contains("0"))
			desiredCard += "0";
		else if(cardToPlay.toLowerCase().contains("1"))
			desiredCard += "1";
		else if(cardToPlay.toLowerCase().contains("2"))
			desiredCard += "2";
		else if(cardToPlay.toLowerCase().contains("3"))
			desiredCard += "3";
		else if(cardToPlay.toLowerCase().contains("4"))
			desiredCard += "4";
		else if(cardToPlay.toLowerCase().contains("5"))
			desiredCard += "5";
		else if(cardToPlay.toLowerCase().contains("6"))
			desiredCard += "6";
		else if(cardToPlay.toLowerCase().contains("7"))
			desiredCard += "7";
		else if(cardToPlay.toLowerCase().contains("8"))
			desiredCard += "8";
		else if(cardToPlay.toLowerCase().contains("9"))
			desiredCard += "9";
		
		if(cardToPlay.toLowerCase().contains("red"))
			desiredCard += "R";
		if(cardToPlay.toLowerCase().contains("blue"))
			desiredCard += "B";
		if(cardToPlay.toLowerCase().contains("green"))
			desiredCard += "G";
		if(cardToPlay.toLowerCase().contains("yellow"))
			desiredCard += "Y";
		
		
		//System.out.println(desiredCard);
		
		boolean inHand = false;
		for(int i = 0; i < playerCards[0].length; i++)
		{
			if(playerCards[0][i].equals(desiredCard))
			{
				inHand = true;
				break;
			}
		}
		System.out.println(inHand);
		
		if(inHand)
		{
			
		}
		
	}
	
	public static void printGiantUnoCard()
	{
		System.out.print(Colours.WHITE +   "█████████████████████████████████");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█████████████████████████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "████████████████" + Colours.RED_BOLD + "█████████" + Colours.BLACK   + "████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "████████████" + Colours.RED_BOLD + "████████████████" + Colours.BLACK   + "█" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█████████" + Colours.RED_BOLD + "████████████████████" + Colours.BLACK   + "" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "███████" + Colours.RED_BOLD + "██████████████████████" + Colours.BLACK   + "" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█████" + Colours.RED_BOLD + "████████████████████████" + Colours.BLACK   + "" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "████" + Colours.RED_BOLD + "█████████████████████████" + Colours.BLACK   + "" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" +  Colours.BANANA_YELLOW + "███" + Colours.RED_BOLD + "████" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "███" + Colours.BANANA_YELLOW + "████" + Colours.RED_BOLD + "███" + Colours.BLACK   + "" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" +  Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "█" + Colours.BANANA_YELLOW + "█" + Colours.RED_BOLD + "███" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "█" + Colours.BLACK   + "█" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█" + Colours.RED_BOLD + "█" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" +  Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "█" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "" + Colours.BLACK   + "██" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██"  + Colours.RED_BOLD + "██" +  Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "███" + Colours.BANANA_YELLOW + "█" + Colours.RED_BOLD + "█" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "██" + Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "" + Colours.BLACK   + "██" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "███" + Colours.BANANA_YELLOW + "████"  + Colours.RED_BOLD + "███" +  Colours.BANANA_YELLOW + "██" + Colours.RED_BOLD + "████" + Colours.BANANA_YELLOW + "███" + Colours.RED_BOLD + "███" + Colours.BANANA_YELLOW + "████" + Colours.BLACK   + "███" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "███████████████████████" + Colours.BLACK   + "██████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "██████████████████████" + Colours.BLACK   + "███████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "████████████████████" + Colours.BLACK   + "█████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "██████████████████" + Colours.BLACK   + "███████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "" + Colours.RED_BOLD + "█████████████████" + Colours.BLACK   + "████████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█" + Colours.RED_BOLD + "██████████████" + Colours.BLACK   + "██████████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "███" + Colours.RED_BOLD + "█████████" + Colours.BLACK   + "█████████████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n██" + Colours.BLACK + "█████████████████████████████" + Colours.WHITE + "██");
		System.out.print(Colours.WHITE + "\n█████████████████████████████████");
	}
	
	public static void printCard(String card)
	{
		String colour = "";

		if(card.contains("R"))
			colour = Colours.WHITE + Colours.RED_BACKGROUND;//_BRIGHT;
		else if(card.contains("G"))
			colour = Colours.BLACK + Colours.GREEN_BACKGROUND;
		else if(card.contains("B"))
			colour = Colours.WHITE + Colours.BLUE_BACKGROUND_BRIGHT;
		else if(card.contains("Y"))
			colour = Colours.BLACK_BOLD + Colours.UNO_YELLOW_BACKGROUND;

		if(card.contains("R") || card.contains("G") || card.contains("B") || card.contains("Y"))
		{
			StringBuilder sb = new StringBuilder(card);
			sb.deleteCharAt(card.length() - 1);

			card = sb.toString();

			System.out.print(colour + card + Colours.RESET);
		}

		else if(card.contains("+4▄▀"))
		{
			System.out.print( Colours.WHITE + Colours.BLACK_BACKGROUND +"+4" + Colours.GREEN_BACKGROUND_BRIGHT + Colours.BLUE_BOLD_BRIGHT + "▄" + Colours.UNO_YELLOW_BACKGROUND + Colours.RED_BOLD_BRIGHT + "▀" + Colours.RESET);
		}
		else if(card.contains("▄▀"))
		{
			System.out.print(Colours.GREEN_BACKGROUND + Colours.BLUE_BOLD_BRIGHT + "▄" + Colours.UNO_YELLOW_BACKGROUND + Colours.RED_BOLD_BRIGHT + "▀" + Colours.RESET);
		}
	}

	public static int callCard(String character, String colour)
	{
		String cardToFind = "";

		if(character.equalsIgnoreCase("0"))
			cardToFind += "0"; 

		else if(character.equalsIgnoreCase("1"))
			cardToFind += "1"; 

		else if(character.equalsIgnoreCase("+2"))
			cardToFind += "+2";

		else if(character.equalsIgnoreCase("+4"))
			cardToFind += "+4▄▀";

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
			if(cards.get(i).contains(cardToFind))
			{
				return i;
			}
		}

		return 0;
	}

	public static void shuffleCards()
	{
		for(int j = 0; j < 5; j++)
		{
			for(int i = 0; i < cards.size(); i++)
			{
				int randIndex1;
				int randIndex2;
				while(true)
				{
					Random rand = new Random();
					randIndex1 = rand.nextInt((cards.size()-1) + 1);
					randIndex2 = rand.nextInt((cards.size()-1) + 1);
					if(randIndex1 != randIndex2)
						break;
				}

				
				Collections.swap(cards, randIndex1, randIndex2);
				
			}
		}

		//System.out.println(cards);
	}

	public static String[] addCard(String[] originalArray, String value)
	{

		String[] newArray = new String[originalArray.length + 1];

		int position = originalArray.length;

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position; i < originalArray.length; i++)
		{
			newArray[i + 1] = originalArray[i];
		}
		newArray[position] = value;

		return newArray;
	}

	public static String[][] dealCards()
	{
		shuffleCards();

		String[][] playerCards = new String[numOfPlayers][numOfCards];


		for(int i = 0; i < numOfPlayers; i++)
		{
			for(int j = 0; j < numOfCards; j++)
			{
				playerCards[i][j] = cards.get(0);
				cards.remove(0);
			}
		}



		return playerCards;
	}

	public static void printTable()
	{
		cardOnTop = cardsPlayed.get(0);
		
		if(numOfPlayers == 3)
		{
			System.out.print("\n\nPlayer 2                         Player 3\n\n");
			System.out.print("                   ");
			printCard(cardOnTop);
			System.out.println("\n\n\n                Player 1");
			System.out.print("\n           ");
		}
		if(numOfPlayers == 4)
		{
			System.out.print("\n\n               Player 3\n\n\n\n");
			System.out.print("Player 2          ");
			printCard(cardOnTop);
			System.out.print("          Player 4");
			System.out.print("\n\n\n\n               Player 1");
			System.out.print("\n        ");
		}
		printPlayerCards(0);
	}

	public static void printPlayerCards(int player)
	{		
		for(int i = 0; i < playerCards[0].length; i++)
		{
			printCard(playerCards[0][i]);
			System.out.print(" ");
		}
	}

	public static void debug()
	{
		System.out.println("\n");
		for(int i = 0; i < numOfPlayers; i++)
		{
			System.out.println("Player " + (i+1) + ": " + Arrays.toString(playerCards[i]));
		}
	}
}