package uno;

import java.util.*;
import animations.Colours;

public class UNO {

	static Scanner Input = new Scanner(System.in);

	static ArrayList<String> cards = new ArrayList<String>(Arrays.asList("OR", "1R", "1R", "2R", "2R", "3R", "3R", "4R", "4R", "5R", "5R", "6R", "6R", "7R", "7R", "8R", "8R", "9R", "9R","OG", "1G", "1G", "2G", "2G", "3G", "3G", "4G", "4G", "5G", "5G", "6G", "6G", "7G", "7G", "8G", "8G", "9G", "9G","OB", "1B", "1B", "2B", "2B", "3B", "3B", "4B", "4B", "5B", "5B", "6B", "6B", "7B", "7B", "8B", "8B", "9B", "9B","OY", "1Y", "1Y", "2Y", "2Y", "3Y", "3Y", "4Y", "4Y", "5Y", "5Y", "6Y", "6Y", "7Y", "7Y", "8Y", "8Y", "9Y", "9Y", "🛇R", "🛇R", "«»R", "«»R", "+2R", "+2R", "▄▀K", "▄▀K", "+4▄▀K","🛇G", "🛇G", "«»G", "«»G", "+2G", "+2G", "▄▀K", "▄▀K", "+4▄▀K","🛇B", "🛇B", "«»B", "«»B", "+2B", "+2B", "▄▀K", "▄▀K", "+4▄▀K","🛇Y", "🛇Y", "«»Y", "«»Y", "+2Y", "+2Y", "▄▀K", "▄▀K", "+4▄▀K"));

	static ArrayList<String> cardsPlayed = new ArrayList<String>();

	static String[][] playerCards;

	static int numOfPlayers = 4;
	static int numOfCards = 8;

	static int play;

	static String direction = "left";

	static String cardOnTop;

	static String currentColour;


	public static void main(String[] args) throws InterruptedException 
	{
		gameLoop();
	}

	public static void gameLoop() throws InterruptedException
	{

		for(int i = 0; i < cards.size(); i++)
		{
			if(!cards.get(i).contains("▄▀"))
			{
				cardsPlayed.add(0, cards.get(i));
				cards.remove(i);
				cardOnTop = cardsPlayed.get(0);
			}
		}

		cards.remove(0);
		
		playerCards = dealCards();
		getCurrentColour();
		printTable();
		
		play = 2;
		
		if(play == 1)
		{
			playCard();
		}
		else
		{
			playComputerCard(play);
		}
	}

	public static void playComputerCard(int player) throws InterruptedException
	{
		for(int k = 0; k < 2; k++)
		{
			String[] compCards = playerCards[player-1];
			String[] compSuit = new String[compCards.length];
			String[] compColour = new String[compCards.length];

			boolean[] playable = new boolean[compCards.length];


			for(int i = 0; i < compCards.length; i++)
			{
				String cardToPlay = compCards[i];
				String cardSuit = "";

				if(cardToPlay.contains("🛇"))
					cardSuit += "🛇";
				else if(cardToPlay.contains("«»"))
					cardSuit += "«»";
				else if(cardToPlay.contains("+2"))
					cardSuit += "+2";
				else if(cardToPlay.contains("+4▄▀"))
					cardSuit += "+4▄▀";
				else if(cardToPlay.contains("▄▀"))
					cardSuit += "▄▀";
				else if(cardToPlay.contains("O"))
					cardSuit += "0";
				else if(cardToPlay.contains("1"))
					cardSuit += "1";
				else if(cardToPlay.contains("2"))
					cardSuit += "2";
				else if(cardToPlay.contains("3"))
					cardSuit += "3";
				else if(cardToPlay.contains("4"))
					cardSuit += "4";
				else if(cardToPlay.contains("5"))
					cardSuit += "5";
				else if(cardToPlay.contains("6"))
					cardSuit += "6";
				else if(cardToPlay.contains("7"))
					cardSuit += "7";
				else if(cardToPlay.contains("8"))
					cardSuit += "8";
				else if(cardToPlay.contains("9"))
					cardSuit += "9";

				String cardColour = "";

				if(cardToPlay.contains("R"))
					cardColour += "R";
				else if(cardToPlay.contains("B"))
					cardColour += "B";
				else if(cardToPlay.contains("G"))
					cardColour += "G";
				else if(cardToPlay.contains("Y"))
					cardColour += "Y";
				else
					cardColour += "K";

				compSuit[i] = cardSuit;
				compColour[i] = cardColour;


			}


			for(int i = 0; i < compCards.length; i++)
			{
				if(compColour[i].equals(currentColour) || compColour[i].equals("K"))
				{
					playable[i] = true;
				}
				if(compSuit[i].equals(getTopCardNum()))
				{
					playable[i] = true;
				}
			}

			int numOfPlayable = 0;

			for(int i = 0; i < compCards.length; i++)
				if(playable[i])
					numOfPlayable ++;

			System.out.println("NumOfPlayable: " + numOfPlayable);
			
			if(numOfPlayable == 0)
			{
				addCard(player - 1, cards.get(0));
				cards.remove(0);
				System.out.println("n\nPlayer " + player + " cannot play");
			}

			else
			{
				
				String[] playableCards = new String[numOfPlayable];

				int index = 0;
				for(int i = 0; i < compCards.length; i++)
				{
					if(playable[i])
					{
						playableCards[index] = compCards[i];
						index ++;
					}
				}
				
				int changeColourIndex = -1;
				for(int i = 0; i < playableCards.length; i++)
				{
					if(playableCards[i].contains("▄▀"))
					{
						changeColourIndex = i;
					}
				}
				
				String cardToPlay;
				
				if(changeColourIndex == -1)
				{
					int randIndex = randInt(0, playableCards.length-1);
					cardToPlay = playableCards[randIndex];
				}
				else
				{
					int randIndex = 0; 
					int l = 0;
					while(l < 100)
					{
						randIndex = randInt(0, playableCards.length-1);
						
						if(randIndex != changeColourIndex) 
							l = 101;
						
						l++;
					}
					
					cardToPlay = playableCards[randIndex];
				}
				
				
				
				int indexOf = 0;
				
				for(int d = 0; d < compCards.length; d++)
				{
					if(compCards[d].equals(cardToPlay))
					{
						indexOf = d;
						break;
					}
				}
				
				cardsPlayed.add(0, cardToPlay);
				
				if(cardToPlay.contains("🛇"))
				{

					int playerSkipped = 0;
					if(direction == "left")
					{
						if(play == numOfPlayers - 1)
						{
							playerSkipped = numOfPlayers;
							play = 1;
						}
						else
						{
							playerSkipped = play + 1;
							play += 2;
						}
						
					}
					else if(direction == "right")
					{
						if(play == 2)
						{
							playerSkipped = 1;
							play = numOfPlayers;
						}
						else
						{
							play -= 2;
						}
						
					}
					System.out.println("Player " + player + " skips player " + playerSkipped);
				}
					
				else if(cardToPlay.contains("«»"))
				{
					if(direction == "left")
					{
						direction = "right";
						
						play --;
						
					}
					else if(direction == "right")
					{
						direction = "left";
						
						if(play == numOfPlayers)
							play = 1;
						else
							play ++;
						
					}
					System.out.println("Player " + player + " changes direction");
				}
				else if(cardToPlay.contains("+2"))
				{
					if(direction == "left")
					{
						
						if(play == numOfPlayers)
							play = 1;
						else
							play ++;
						
						addCard(play, cards.get(0));
						cards.remove(0);
						addCard(play, cards.get(0));
						cards.remove(0);
						
					}
					else if(direction == "right")
					{
						
						play --;
						
						addCard(play, cards.get(0));
						cards.remove(0);
						addCard(play, cards.get(0));
						cards.remove(0);
						
					}

					System.out.println("Player " + play + " picks up 2");
				}
				else if(cardToPlay.contains("+4▄▀"))
				{
					if(direction == "left")
					{
						
						if(play == numOfPlayers)
							play = 1;
						else
							play ++;
						
						addCard(play, cards.get(0));
						cards.remove(0);
						addCard(play, cards.get(0));
						cards.remove(0);
						
					} 
					else if(direction == "right")
					{
						
						play --;
						
						addCard(play, cards.get(0));
						cards.remove(0);
						addCard(play, cards.get(0));
						cards.remove(0);
						
					}
					
					String newColour = "K";
					
					int[] numOfColour = {0, 0, 0, 0};
					
					for(int i = 0; i < compCards.length; i++)
					{
						if(compCards[i].contains("R"))
						{
							numOfColour[0] ++;
						}
						else if(compCards[i].contains("G"))
						{
							numOfColour[1] ++;
						}
						else if(compCards[i].contains("B"))
						{
							numOfColour[0] ++;
						}
						else if(compCards[i].contains("Y"))
						{
							numOfColour[1] ++;
						}
					}
					
					int maxColourIndex = 0;
					
					for(int i = 0; i < 4; i++)
					{
						if(numOfColour[i] > numOfColour[maxColourIndex])
						{
							maxColourIndex = i;
						}
					}
					
					if(maxColourIndex == 0)
					{
						currentColour = "R";
						newColour = "RED";
					}
					else if(maxColourIndex == 1)
					{
						currentColour = "G";
						newColour = "GREEN";
					}
					else if(maxColourIndex == 3) 
					{
						currentColour = "B";
						newColour = "BLUE";
					}
					else if(maxColourIndex == 4) 
					{
						currentColour = "Y";
						newColour = "YELLOW";
					}
					
					
					
					
					System.out.println("Player " + player + " changes the colour to: " + newColour);
					System.out.println("Player " + play + " picks up 4");
					
				}
				else if(cardToPlay.contains("▄▀"))
				{
					String newColour = "K";
					
					int[] numOfColour = {0, 0, 0, 0};
					
					for(int i = 0; i < compCards.length; i++)
					{
						if(compCards[i].contains("R"))
						{
							numOfColour[0] ++;
						}
						else if(compCards[i].contains("G"))
						{
							numOfColour[1] ++;
						}
						else if(compCards[i].contains("B"))
						{
							numOfColour[0] ++;
						}
						else if(compCards[i].contains("Y"))
						{
							numOfColour[1] ++;
						}
					}
					
					int maxColourIndex = 0;
					
					for(int i = 0; i < 4; i++)
					{
						if(numOfColour[i] > numOfColour[maxColourIndex])
						{
							maxColourIndex = i;
						}
					}
					
					if(maxColourIndex == 0)
					{
						currentColour = "R";
						newColour = "RED";
					}
					else if(maxColourIndex == 1)
					{
						currentColour = "G";
						newColour = "GREEN";
					}
					else if(maxColourIndex == 3) 
					{
						currentColour = "B";
						newColour = "BLUE";
					}
					else if(maxColourIndex == 4) 
					{
						currentColour = "Y";
						newColour = "YELLOW";
					}
					
					
					
					
					System.out.println("Player " + player + " changes the colour to: " + newColour);
				}
				
				
				System.out.println("Current colour: " + currentColour);
				
				System.out.println(Arrays.toString(playableCards));

				System.out.println(Arrays.toString(compCards));
				System.out.println(Arrays.toString(compSuit));
				System.out.println(Arrays.toString(compColour));
				System.out.println(Arrays.toString(playable));
				
				System.out.println(cardToPlay);
				break;
			}


		}
	}

	public static void playCard()
	{

		for(int k = 0; k < 2; k++)
		{
			System.out.print("\n\nPlay card: ");
			String cardToPlay = Input.nextLine();

			if(cardToPlay.equalsIgnoreCase("pass"))
			{
				addCard(0, cards.get(0));
				cards.remove(0);
				printTable();

			}
			else
			{

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
				else if(cardToPlay.toLowerCase().contains(" 0"))
					desiredCard += "0";
				else if(cardToPlay.toLowerCase().contains(" 1"))
					desiredCard += "1";
				else if(cardToPlay.toLowerCase().contains(" 2"))
					desiredCard += "2";
				else if(cardToPlay.toLowerCase().contains(" 3"))
					desiredCard += "3";
				else if(cardToPlay.toLowerCase().contains(" 4"))
					desiredCard += "4";
				else if(cardToPlay.toLowerCase().contains(" 5"))
					desiredCard += "5";
				else if(cardToPlay.toLowerCase().contains(" 6"))
					desiredCard += "6";
				else if(cardToPlay.toLowerCase().contains(" 7"))
					desiredCard += "7";
				else if(cardToPlay.toLowerCase().contains(" 8"))
					desiredCard += "8";
				else if(cardToPlay.toLowerCase().contains(" 9"))
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
				int cardPos = 0;
				for(cardPos = 0; cardPos < playerCards[0].length; cardPos++)
				{
					if(playerCards[0][cardPos].equals(desiredCard))
					{
						inHand = true;
						break;
					}
				}

				if(!inHand)
				{
					System.out.println("You do not have that card in your hand");
				}
				else
				{
					String deisredCard = playerCards[0][cardPos];

					String desiredCardColour = "";
					String topCardColour = "";

					String desiredCardNum = "";
					String topCardNum = getTopCardNum();

					if(deisredCard.contains("R"))
						desiredCardColour += "R";
					else if(deisredCard.contains("B"))
						desiredCardColour += "B";
					else if(deisredCard.contains("G"))
						desiredCardColour += "G";
					else if(deisredCard.contains("Y"))
						desiredCardColour += "Y";
					else
						desiredCardColour += "K";



					if(cardOnTop.contains("R"))
						topCardColour += "R";
					else if(cardOnTop.contains("B"))
						topCardColour += "B";
					else if(cardOnTop.contains("G"))
						topCardColour += "G";
					else if(cardOnTop.contains("Y"))
						topCardColour += "Y";
					else
						topCardColour += "K";


					if(deisredCard.toLowerCase().contains("🛇"))
						desiredCardNum += "🛇";
					else if(deisredCard.toLowerCase().contains("«»"))
						desiredCardNum += "«»";
					else if(deisredCard.toLowerCase().contains("+2"))
						desiredCardNum += "+2";
					else if(deisredCard.toLowerCase().contains("+4▄▀K"))
						desiredCardNum += "+4▄▀";
					else if(deisredCard.toLowerCase().contains("▄▀"))
						desiredCardNum += "▄▀";
					else if(deisredCard.toLowerCase().contains("0"))
						desiredCardNum += "0";
					else if(deisredCard.toLowerCase().contains("1"))
						desiredCardNum += "1";
					else if(deisredCard.toLowerCase().contains("2"))
						desiredCardNum += "2";
					else if(deisredCard.toLowerCase().contains("3"))
						desiredCardNum += "3";
					else if(deisredCard.toLowerCase().contains("4"))
						desiredCardNum += "4";
					else if(deisredCard.toLowerCase().contains("5"))
						desiredCardNum += "5";
					else if(deisredCard.toLowerCase().contains("6"))
						desiredCardNum += "6";
					else if(deisredCard.toLowerCase().contains("7"))
						desiredCardNum += "7";
					else if(deisredCard.toLowerCase().contains("8"))
						desiredCardNum += "8";
					else if(deisredCard.toLowerCase().contains("9"))
						desiredCardNum += "9";




					if(desiredCardColour.equals(topCardColour) || desiredCardNum.equals(topCardNum) || desiredCardColour.equals("K") || desiredCardColour.equals(currentColour))
					{
						cardsPlayed.add(0, playerCards[0][cardPos]);

						removeCard(0, cardPos);

						if(desiredCardColour.equals("K"))
						{
							System.out.print("New colour: ");

							@SuppressWarnings("resource")
							Scanner newColourInput = new Scanner(System.in);

							String newColour = newColourInput.next();

							if(newColour.equalsIgnoreCase("red"))
								currentColour = "R";
							else if(newColour.equalsIgnoreCase("blue"))
								currentColour = "B";
							else if(newColour.equalsIgnoreCase("green"))
								currentColour = "G";
							else if(newColour.equalsIgnoreCase("yellow"))
								currentColour = "Y";

							System.out.println("\nThe colour is now: " + newColour);

						}

						if(desiredCardNum.equals("+2"))
						{
							if(direction == "left")
							{
								System.out.println("Player 2 must draw 2 cards");
							}
							else if(direction == "right")
							{
								System.out.println("Player " + numOfPlayers + " must draw 2 cards");
							}
						}

						if(desiredCardNum.equals("+4"))
						{
							if(direction == "left")
							{
								System.out.println("Player 2 must draw 4 cards");
							}
							else if(direction == "right")
							{
								System.out.println("Player " + numOfPlayers + " must draw 4 cards");
							}
						}

						if(desiredCardNum.equals("«»"))
						{
							if(direction == "left")
							{
								direction = "right";
								System.out.println("Reverse direction");
							}
							else if(direction == "right")
							{
								direction = "left";
								System.out.println("Reverse direction");
							}
						}

						if(desiredCardNum.equals("🛇"))
						{
							if(numOfPlayers == 2)
							{
								System.out.println("Player 2 is skipped");
								playCard();
							}
							else if(direction == "left")
							{
								System.out.println("Player 2 is skipped");
								play = 3;
							}
							else if(direction == "right")
							{
								System.out.println("Player " + numOfPlayers + " is skipped");
								play = numOfPlayers - 1;
							}
						}
						else
						{
							currentColour = desiredCardColour;

							if(direction == "left")
							{
								play = 2;
							}
							else if(direction == "right")
							{
								play = numOfPlayers;
							}

						}

						printTable();
						break;
					}
					else
					{
						System.out.println("You cannot play this card");
					}
				}
			}




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

	public static void addCard(int player, String value)
	{

		String[] array = new String[playerCards[player-1].length + 1];

		for(int i = 0; i < playerCards[player-1].length; i++)
		{
			array[i] = playerCards[player-1][i];
		}
		array[playerCards[player-1].length] = value;

		playerCards[player-1] = array;
	}

	public static void removeCard(int player, int index)
	{
		String[] array = new String[(playerCards[player].length) - 1];

		for(int i = 0; i < index; i++)
		{
			array[i] = playerCards[player][i];
		}

		for(int i = index + 1; i < playerCards[player].length; i++)
		{
			array[i - 1] = playerCards[player][i];			
		}

		playerCards[player] = array;

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

	public static String getTopCardNum()
	{
		String topCardNum = "";
		if(cardOnTop.toLowerCase().contains("🛇"))
			topCardNum += "🛇";
		else if(cardOnTop.toLowerCase().contains("«»"))
			topCardNum += "«»";
		else if(cardOnTop.toLowerCase().contains("+2"))
			topCardNum += "+2";
		else if(cardOnTop.toLowerCase().contains("+4▄▀"))
			topCardNum += "+4▄▀";
		else if(cardOnTop.toLowerCase().contains("▄▀"))
			topCardNum += "▄▀";
		else if(cardOnTop.toLowerCase().contains("0"))
			topCardNum += "0";
		else if(cardOnTop.toLowerCase().contains("1"))
			topCardNum += "1";
		else if(cardOnTop.toLowerCase().contains("2"))
			topCardNum += "2";
		else if(cardOnTop.toLowerCase().contains("3"))
			topCardNum += "3";
		else if(cardOnTop.toLowerCase().contains("4"))
			topCardNum += "4";
		else if(cardOnTop.toLowerCase().contains("5"))
			topCardNum += "5";
		else if(cardOnTop.toLowerCase().contains("6"))
			topCardNum += "6";
		else if(cardOnTop.toLowerCase().contains("7"))
			topCardNum += "7";
		else if(cardOnTop.toLowerCase().contains("8"))
			topCardNum += "8";
		else if(cardOnTop.toLowerCase().contains("9"))
			topCardNum += "9";

		return topCardNum;
	}

	public static void getCurrentColour()
	{
		if(cardOnTop.contains("R"))
			currentColour = "R";
		else if(cardOnTop.contains("B"))
			currentColour = "B";
		else if(cardOnTop.contains("G"))
			currentColour = "G";
		else if(cardOnTop.contains("Y"))
			currentColour = "Y";
	}

	public static int randInt(int min, int max) throws InterruptedException
	{
		int randomNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);

		return randomNumber;
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