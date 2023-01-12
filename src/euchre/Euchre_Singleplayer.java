package euchre;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Euchre_Singleplayer 
{

	public static ArrayList<String> cards = new ArrayList<String>(Arrays.asList("9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦",  "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠"));

	public static ArrayList<String> player1Cards = new ArrayList<String>();
	public static ArrayList<String> player2Cards = new ArrayList<String>();
	public static ArrayList<String> player3Cards = new ArrayList<String>();
	public static ArrayList<String> player4Cards = new ArrayList<String>();


	public static ArrayList<String> player1Suits = new ArrayList<String>();
	public static ArrayList<String> player2Suits = new ArrayList<String>();
	public static ArrayList<String> player3Suits = new ArrayList<String>();
	public static ArrayList<String> player4Suits = new ArrayList<String>();

	public static ArrayList<String> kitty = new ArrayList<String>();

	public static ArrayList<Integer> player2CardScores  = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	public static ArrayList<Integer> player3CardScores  = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	public static ArrayList<Integer> player4CardScores  = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));

	public static int[] player2TrumpNum = {0, 0, 0, 0};
	public static int[] player3TrumpNum = {0, 0, 0, 0};
	public static int[] player4TrumpNum = {0, 0, 0, 0};

	public static String[] cardsOnTable = {"    ", "    ", "    ", "    "};

	public static int play;
	public static int dealer = 4;
	public static int numOfGames = 0;

	public static int player1Partner = 3;
	public static int player2Partner = 4;
	public static int player3Partner = 1;
	public static int player4Partner = 2;

	public static int p2Max;
	public static int p3Max;
	public static int p4Max;

	public static int p2Suit;
	public static int p3Suit;
	public static int p4Suit;

	public static String player2Suit;
	public static String player3Suit;
	public static String player4Suit;

	public static String topCard;
	public static String proposedTrump;
	public static String Trump;

	public static boolean player1SoloStatus;
	public static boolean player2SoloStatus;
	public static boolean player3SoloStatus;
	public static boolean player4SoloStatus;

	public static boolean choosingTrump1 = true;
	public static boolean choosingTrump2 = false;


	public static Scanner Input = new Scanner(System.in);

	//Colours
	public static final String ESC = "\033[";

	public static final String RESET = "\033[0m";  // RESET TEXT

	public static final String BOXING = "\033[0;51m";   // BLACK BOXING

	public static final String BLACK = "\033[0;30m";   // BLACK

	public static final String BLACK_BOLD = "\033[1;30m";  // BLACK BOLD
	public static final String WHITE_BOLD = "\033[1;97m";  // WHITE

	public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK BOLD BRIGHT
	public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN

	public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE BACKGROUND


	public static void main(String[] args) throws InterruptedException 
	{
		//Turns on caps lock
		//Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);

		//Welcomes the user and shows the menu
		System.out.println("Welcome to Euchre!");

		menu();
	}

	public static void menu() throws InterruptedException 
	{
		//Prints out the menu and asks the user for input
		while(true)
		{
			System.out.println("\n"
					+ "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\r\n"
					+ "█  S - Start Game   █\r\n"
					+ "█  R - Rules        █\r\n"
					+ "█  P - Preferences  █\r\n"
					+ "█  Q - Quit         █\r\n"
					+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.print("Input one of the options above: ");
			String menuInput = Input.next();


			if(menuInput.equalsIgnoreCase("s")) //If the user wishes to start the game
			{
				startGame();
			}
			else if(menuInput.equalsIgnoreCase("r")) //If the user needs to see the rules
			{
				System.out.println(RED_BOLD_BRIGHT + "\n**Object of the Game**\r\n" + RESET
						+ "The goal is to win at least three tricks. \r\n"
						+ "If the side that fixed the trump fails to get three tricks, it is said to be \"euchred.\"\r\n"
						+ "\r\n"
						+ RED_BOLD_BRIGHT +"**The Cards**\r\n" + RESET
						+ "The standard 52-card pack is stripped down to make a deck of 24 cards. A, K, Q, J, 10, 9 of each suit.\r\n"
						+ "\r\n"
						+ "\r\n"
						+ RED_BOLD_BRIGHT + "**Card Values/scoring**\r\n" + RESET
						+ "The following shows all scoring situations:\r\n"
						+ "\r\n"
						+ "Partnership making trump wins 3 or 4 tricks – 1 point\r\n"
						+ "Partnership making trump wins 5 tricks – 2 points\r\n"
						+ "Lone hand wins 3 or 4 tricks – 1 point\r\n"
						+ "Lone hand wins 5 tricks – 4 points\r\n"
						+ "Partnership or lone hand is euchred, opponents score 2 points\r\n"
						+ "\r\n"
						+ "The first player or partnership to score 5, 7 or 10 points, as agreed beforehand, wins the game. You can change this in the options in the menu.\r\n"
						+ "\r\n"
						+ "\r\n"
						+ RED_BOLD_BRIGHT + "**Making the Trump**\r\n" + RESET
						+ "Beginning with the player to the left of the dealer, each player passes or accepts the turn-up as trump. \r\n"
						+ "An opponent of the dealer accepts by saying \"I order it up.\" The partner of the dealer accepts by saying, \"I assist.\"  \r\n"
						+ "The dealer accepts by making their discard, called \"taking it up.\"\r\n"
						+ "\r\n"
						+ "If all four players pass in the first round, each player in turn, starting with the player to the dealer's left, has the option of passing again or of naming the trump suit. \r\n"
						+ "The rejected suit may not be named.\r\n"
						+ "\r\n"
						+ "If all four players pass in the second round, the cards are gathered and shuffled, and the next dealer deals. \r\n"
						+ "\r\n"
						+ "Once the trump is fixed, either by acceptance of the turn-up or by the naming of another suit, the turn-up is rejected, the bidding ends and play begins.\r\n"
						+ "\r\n"
						+ "\r\n"
						+ RED_BOLD_BRIGHT + "**Playing Alone**\r\n" + RESET
						+ "If the player who fixes the trump suit believes it will be to their side's advantage to play without the help of their partner's cards, the player exercises this option by declaring \"alone\" distinctly at the time of making the trump. \r\n"
						+ "This player's partner then turns their cards face down and does not participate in the play.\r\n"
						+ "\r\n"
						+ "\r\n"
						+ RED_BOLD_BRIGHT + "**The Play**\r\n" + RESET
						+ "The opening lead is made by the player to the dealer's left, or if this player's partner is playing alone, it is made by the player across from the dealer. \r\n"
						+ "If possible, each player must follow suit to a lead. If unable to follow suit, the player may trump or discard any card. \r\n"
						+ "A trick is won by the highest card of the suit led, or, if it contains trumps, by the highest trump. The winner of a trick leads next.");

				menu();
			}
			else if(menuInput.equalsIgnoreCase("o")) // allows the user to select how many points in a game
			{

			}
			else if(menuInput.equalsIgnoreCase("q")) // exits the program
			{
				//Prints out goodbye message
				System.out.println("Come again soon!");
				//Turns off caps lock
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
				//closes program
				System.exit(0);
			}
		}
	}

	public static void startGame() throws InterruptedException
	{
		dealCards();

		if(kitty.get(0).contains("♥") || kitty.get(0).contains("♦"))
		{
			topCard = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  kitty.get(0) + " " +  RESET + " ";
		}
		else
		{
			topCard = WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + kitty.get(0) + " " + RESET + " ";
		}

		if((numOfGames % 4) == 0) 
		{
			play = 1;
			dealer = 4;
		}

		else if((numOfGames % 4) == 1)
		{
			play = 2;
			dealer = 1;
		}

		else if((numOfGames % 4) == 2)
		{
			play = 3;
			dealer = 2;
		}

		else if((numOfGames % 4) == 3)
		{
			play = 4;
			dealer = 3;
		}

		gameLoop();


	}

	public static void dealCards()
	{
		int randCard;

		for(int i = 0; i < 5; i++)
		{
			randCard = (int) (Math.random( )*(cards.size()-1)) + 0;

			player1Cards.add(cards.get(randCard));
			cards.remove(randCard);

			randCard = (int) (Math.random( )*(cards.size()-1)) + 0;

			player2Cards.add(cards.get(randCard));
			cards.remove(randCard);

			randCard = (int) (Math.random( )*(cards.size()-1)) + 0;

			player3Cards.add(cards.get(randCard));
			cards.remove(randCard);

			randCard = (int) (Math.random( )*(cards.size()-1)) + 0;

			player4Cards.add(cards.get(randCard));
			cards.remove(randCard);
		}

		int size = cards.size();

		for(int i = 0; i < size; i++)
		{
			kitty.add(cards.get(i));
		}

		for(int i = 0; i < 5; i++)
		{
			if(player2Cards.get(i).contains("♥"))
			{
				player2Suits.add("♥");
			}
			else if(player2Cards.get(i).contains("♦"))
			{
				player2Suits.add("♦");
			}
			else if(player2Cards.get(i).contains("♣"))
			{
				player2Suits.add("♣");
			}
			else if(player2Cards.get(i).contains("♠"))
			{
				player2Suits.add("♠");
			}
		}
		for(int i = 0; i < 5; i++)
		{
			if(player3Cards.get(i).contains("♥"))
			{
				player3Suits.add("♥");
			}
			else if(player3Cards.get(i).contains("♦"))
			{
				player3Suits.add("♦");
			}
			else if(player3Cards.get(i).contains("♣"))
			{
				player3Suits.add("♣");
			}
			else if(player3Cards.get(i).contains("♠"))
			{
				player3Suits.add("♠");
			}
		}
		for(int i = 0; i < 5; i++)
		{
			if(player4Cards.get(i).contains("♥"))
			{
				player4Suits.add("♥");
			}
			else if(player4Cards.get(i).contains("♦"))
			{
				player4Suits.add("♦");
			}
			else if(player4Cards.get(i).contains("♣"))
			{
				player4Suits.add("♣");
			}
			else if(player4Cards.get(i).contains("♠"))
			{
				player4Suits.add("♠");
			}
		}

		for(int i = 0; i < 5; i++)
		{
			if(player2Suits.get(i) == "♥")
			{
				player2TrumpNum[0] ++;
			}
			else if(player2Suits.get(i) == "♦")
			{
				player2TrumpNum[1] ++;
			}
			else if(player2Suits.get(i) == "♣")
			{
				player2TrumpNum[2] ++;
			}
			else if(player2Suits.get(i) == "♠")
			{
				player2TrumpNum[3] ++;
			}
		}

		for(int i = 0; i < 5; i++)
		{
			if(player3Suits.get(i) == "♥")
			{
				player3TrumpNum[0] ++;
			}
			else if(player3Suits.get(i) == "♦")
			{
				player3TrumpNum[1] ++;
			}
			else if(player3Suits.get(i) == "♣")
			{
				player3TrumpNum[2] ++;
			}
			else if(player3Suits.get(i) == "♠")
			{
				player3TrumpNum[3] ++;
			}
		}

		for(int i = 0; i < 5; i++)
		{
			if(player4Suits.get(i) == "♥")
			{
				player4TrumpNum[0] ++;
			}
			else if(player4Suits.get(i) == "♦")
			{
				player4TrumpNum[1] ++;
			}
			else if(player4Suits.get(i) == "♣")
			{
				player4TrumpNum[2] ++;
			}
			else if(player4Suits.get(i) == "♠")
			{
				player4TrumpNum[3] ++;
			}
		}

		player2Suit = player2Suits.get(0);

		int maxCount = 0;
		for (int i = 0; i < player2Suits.size(); i++) {
			String value = player2Suits.get(i);
			int count = 1;
			for (int j = 0; j < player2Suits.size(); j++) {
				if (player2Suits.get(j) == value)
					count++;
				if (count > maxCount) {
					player2Suit = value;
					maxCount = count;
				}
			}
		}

		player3Suit = player3Suits.get(0);

		int maxCount2 = 0;
		for (int i = 0; i < player3Suits.size(); i++) {
			String value = player3Suits.get(i);
			int count = 1;
			for (int j = 0; j < player3Suits.size(); j++) {
				if (player3Suits.get(j) == value)
					count++;
				if (count > maxCount2) {
					player3Suit = value;
					maxCount2 = count;
				}
			}
		}

		player4Suit = player4Suits.get(0);

		int maxCount3 = 0;
		for (int i = 0; i < player4Suits.size(); i++) {
			String value = player4Suits.get(i);
			int count = 1;
			for (int j = 0; j < player4Suits.size(); j++) {
				if (player4Suits.get(j) == value)
					count++;
				if (count > maxCount3) {
					player4Suit = value;
					maxCount3 = count;
				}
			}
		}



		p2Max = player2TrumpNum[0];
		p2Suit = 0;
		for (int i = 0; i < player2TrumpNum.length; i++) 
		{
			if (p2Max < player2TrumpNum[i]) 
			{
				p2Max = player2TrumpNum[i];
				p2Suit = i;
			}
		}

		p3Max = player3TrumpNum[0];
		p3Suit = 0;
		for (int i = 0; i < player3TrumpNum.length; i++) 
		{
			if (p3Max < player3TrumpNum[i]) 
			{
				p3Max = player3TrumpNum[i];
				p3Suit = i;
			}
		}

		p4Max = player3TrumpNum[0];
		p4Suit = 0;
		for (int i = 0; i < player3TrumpNum.length; i++) 
		{
			if (p4Max < player3TrumpNum[i]) 
			{
				p4Max = player3TrumpNum[i];
				p4Suit = i;
			}
		}

		cardScores(5);
	}

	public static void cardScores(int cardsInHand)
	{
		//Player 2 Card Score
		for(int i = 0; i < cardsInHand; i++)
		{

			if(choosingTrump1 == true)
			{

				if(player2Cards.get(i).contains("9"))
				{
					player2CardScores.set(i, 1);
				}
				else if(player2Cards.get(i).contains("10"))
				{
					player2CardScores.set(i, 2);
				}
				else if(player2Cards.get(i).contains("Q"))
				{
					player2CardScores.set(i, 4);
				}
				else if(player2Cards.get(i).contains("K"))
				{
					player2CardScores.set(i, 5);
				}
				else if(player2Cards.get(i).contains("A"))
				{
					player2CardScores.set(i, 6);
				}

				else if(player2Cards.get(i).contains("J"))
				{
					//test for right bower
					if(player2Cards.get(i).contains(proposedTrump))
					{
						player2CardScores.set(i, 8);
					}

					//test for left bower
					if(proposedTrump.contains("♠") && player2Cards.get(i).contains("♣"))
					{
						player2CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♣") && player2Cards.get(i).contains("♠"))
					{
						player2CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♦") && player2Cards.get(i).contains("♥"))
					{
						player2CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♥") && player2Cards.get(i).contains("♦"))
					{
						player2CardScores.set(i, 7);
					}
				}
			}

			else if(choosingTrump2 == true)
			{

				if(player2Cards.get(i).contains("9"))
				{
					player2CardScores.set(i, 1);
				}
				else if(player2Cards.get(i).contains("10"))
				{
					player2CardScores.set(i, 2);
				}
				else if(player2Cards.get(i).contains("Q"))
				{
					player2CardScores.set(i, 4);
				}
				else if(player2Cards.get(i).contains("K"))
				{
					player2CardScores.set(i, 5);
				}
				else if(player2Cards.get(i).contains("A"))
				{
					player2CardScores.set(i, 6);
				}
				else if(player2Cards.get(i).contains("J"))
				{
					player2CardScores.set(i, 8);
				}
			}

			else if(choosingTrump1 == false && choosingTrump2 == false)
			{
				if(player2Cards.get(i).contains(Trump))
				{

					if(player2Cards.get(i).contains("9"))
					{
						player2CardScores.set(i, 9);
					}
					else if(player2Cards.get(i).contains("10"))
					{
						player2CardScores.set(i, 10);
					}
					else if(player2Cards.get(i).contains("Q"))
					{
						player2CardScores.set(i, 12);
					}
					else if(player2Cards.get(i).contains("K"))
					{
						player2CardScores.set(i, 13);
					}
					else if(player2Cards.get(i).contains("A"))
					{
						player2CardScores.set(i, 14);
					}
					else if(player2Cards.get(i).contains("J"))
					{
						player2CardScores.set(i, 16);
					}
				}
				else
				{
					if(player2Cards.get(i).contains("9"))
					{
						player2CardScores.set(i, 1);
					}
					else if(player2Cards.get(i).contains("10"))
					{
						player2CardScores.set(i, 2);
					}
					else if(player2Cards.get(i).contains("Q"))
					{
						player2CardScores.set(i, 4);
					}
					else if(player2Cards.get(i).contains("K"))
					{
						player2CardScores.set(i, 5);
					}
					else if(player2Cards.get(i).contains("A"))
					{
						player2CardScores.set(i, 6);
					}
					else if(player2Cards.get(i).contains("J"))
					{
						//test for left bower
						if(Trump.contains("♠") && player2Cards.get(i).contains("♣"))
						{
							player2CardScores.set(i, 15);
						}
						else if(Trump.contains("♣") && player2Cards.get(i).contains("♠"))
						{
							player2CardScores.set(i, 15);
						}
						else if(Trump.contains("♦") && player2Cards.get(i).contains("♥"))
						{
							player2CardScores.set(i, 15);
						}
						else if(Trump.contains("♥") && player2Cards.get(i).contains("♦"))
						{
							player2CardScores.set(i, 15);
						}
						else
						{
							player2CardScores.set(i, 3);
						}
					}
				}
			}
		}
		
		//Player 3 Card Score
		for(int i = 0; i < cardsInHand; i++)
		{

			if(choosingTrump1 == true)
			{

				if(player3Cards.get(i).contains("9"))
				{
					player3CardScores.set(i, 1);
				}
				else if(player3Cards.get(i).contains("10"))
				{
					player3CardScores.set(i, 2);
				}
				else if(player3Cards.get(i).contains("Q"))
				{
					player3CardScores.set(i, 4);
				}
				else if(player3Cards.get(i).contains("K"))
				{
					player3CardScores.set(i, 5);
				}
				else if(player3Cards.get(i).contains("A"))
				{
					player3CardScores.set(i, 6);
				}

				else if(player3Cards.get(i).contains("J"))
				{
					//test for right bower
					if(player3Cards.get(i).contains(proposedTrump))
					{
						player3CardScores.set(i, 8);
					}

					//test for left bower
					if(proposedTrump.contains("♠") && player3Cards.get(i).contains("♣"))
					{
						player3CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♣") && player3Cards.get(i).contains("♠"))
					{
						player3CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♦") && player3Cards.get(i).contains("♥"))
					{
						player3CardScores.set(i, 7);
					}
					else if(proposedTrump.contains("♥") && player3Cards.get(i).contains("♦"))
					{
						player3CardScores.set(i, 7);
					}
				}
			}

			else if(choosingTrump2 == true)
			{

				if(player3Cards.get(i).contains("9"))
				{
					player3CardScores.set(i, 1);
				}
				else if(player3Cards.get(i).contains("10"))
				{
					player3CardScores.set(i, 2);
				}
				else if(player3Cards.get(i).contains("Q"))
				{
					player3CardScores.set(i, 4);
				}
				else if(player3Cards.get(i).contains("K"))
				{
					player3CardScores.set(i, 5);
				}
				else if(player3Cards.get(i).contains("A"))
				{
					player3CardScores.set(i, 6);
				}
				else if(player3Cards.get(i).contains("J"))
				{
					player3CardScores.set(i, 8);
				}
			}

			else if(choosingTrump1 == false && choosingTrump2 == false)
			{
				if(player3Cards.get(i).contains(Trump))
				{

					if(player3Cards.get(i).contains("9"))
					{
						player3CardScores.set(i, 9);
					}
					else if(player3Cards.get(i).contains("10"))
					{
						player3CardScores.set(i, 10);
					}
					else if(player3Cards.get(i).contains("Q"))
					{
						player3CardScores.set(i, 12);
					}
					else if(player3Cards.get(i).contains("K"))
					{
						player3CardScores.set(i, 13);
					}
					else if(player3Cards.get(i).contains("A"))
					{
						player3CardScores.set(i, 14);
					}
					else if(player3Cards.get(i).contains("J"))
					{
						player3CardScores.set(i, 16);
					}
				}
				else
				{
					if(player3Cards.get(i).contains("9"))
					{
						player3CardScores.set(i, 1);
					}
					else if(player3Cards.get(i).contains("10"))
					{
						player3CardScores.set(i, 2);
					}
					else if(player3Cards.get(i).contains("Q"))
					{
						player3CardScores.set(i, 4);
					}
					else if(player3Cards.get(i).contains("K"))
					{
						player3CardScores.set(i, 5);
					}
					else if(player3Cards.get(i).contains("A"))
					{
						player3CardScores.set(i, 6);
					}
					else if(player3Cards.get(i).contains("J"))
					{
						//test for left bower
						if(Trump.contains("♠") && player3Cards.get(i).contains("♣"))
						{
							player3CardScores.set(i, 15);
						}
						else if(Trump.contains("♣") && player3Cards.get(i).contains("♠"))
						{
							player3CardScores.set(i, 15);
						}
						else if(Trump.contains("♦") && player3Cards.get(i).contains("♥"))
						{
							player3CardScores.set(i, 15);
						}
						else if(Trump.contains("♥") && player3Cards.get(i).contains("♦"))
						{
							player3CardScores.set(i, 15);
						}
						else
						{
							player3CardScores.set(i, 3);
						}
					}
				}
			}
		}
	}

	public static void pickUpCard(int player)
	{
		if(dealer == 4)
		{
			if(player == 2)
			{
				player2SoloStatus = true;
				Trump = proposedTrump;
				System.out.println("Player 2 is going alone!");
			}
			else
			{
				Trump = proposedTrump;
				player4Cards.add(kitty.get(0));
				int worstCard = 0;
				for(int i = 0; i < player4Cards.size(); i++)
				{
					if(player4Cards.get(i).contains(Trump))
					{}
					else
					{
						if(player4Cards.get(i).contains("9") || player4Cards.get(i).contains("10"))
						{
							worstCard = i;
						}
						else {}
					}
				}
				//System.out.println();
				player4Cards.remove(worstCard);
				//System.out.println(player4Cards);

			}
		}
		else if(dealer == 1)
		{

		}
		else if(dealer == 2)
		{

		}
		else if(dealer == 3)
		{

		}
	}

	public static void gameLoop() 
	{
		chooseTrump();

	}

	public static void chooseTrump() 
	{
		if(topCard.contains("♥"))
		{
			proposedTrump = "♥";
		}
		else if(topCard.contains("♦"))
		{
			proposedTrump = "♦";
		}
		if(topCard.contains("♣"))
		{
			proposedTrump = "♣";
		}
		else if(topCard.contains("♠"))
		{
			proposedTrump = "♠";
		}

		printStartTable();

		int i;
		for(i = 0; i < 5; i++)
		{
			choosingTrump1 = true;

			if(play == 1)
			{
				while(true)
				{
					System.out.print("\n\"PASS\" or \"PICK\"  : ");
					String input = Input.next();

					if(input.equalsIgnoreCase("pass"))
					{
						play = 2;
						i++;
						break;
					}
					else if(input.equalsIgnoreCase("pick"))
					{
						Trump = proposedTrump;
						System.out.println("Trump is now " + Trump);
						choosingTrump1 = false;
						i = 6;
						break;
					}

					else
					{
						System.out.println("Error code: ID-10-T");
						System.out.print("Try again. Type ");
					}
				}
			}

			else if(play == 2)
			{
				if(player2Partner == dealer)
				{
					if(player2Suit == proposedTrump && p2Max >= 4)
					{
						System.out.println("Player 2 tells dealer to pick it up and will go alone");
						choosingTrump1 = false;
						break;
					}
					else 
					{
						System.out.println("Player 2 passes");
						play = 3;
						i++;
						//continue;
					}
				}
				else
				{
					if(player2Suit == proposedTrump && p2Max >= 3)
					{
						if(player2Suit == proposedTrump && p2Max >= 4)
						{
							System.out.println("Player 2 tells dealer to pick it up and will go alone");
						}
						else 
						{
							System.out.println("Player 2 tells dealer to pick it up");
							choosingTrump1 = false;
							break;
						}
					}
					else 
					{
						System.out.println("Player 2 passes");
						play = 3;
						i++;
						//continue;
					}
				}
			}

			else if(play == 3)
			{
				if(player3Partner == dealer)
				{
					if(player3Suit == proposedTrump && p3Max >= 4)
					{
						System.out.println("Player 3 tells dealer to pick it up and will go alone");
						choosingTrump1 = false;
						break;
					}
					else 
					{
						System.out.println("Player 3 passes");
						play = 3;
						i++;
						//continue;
					}
				}
				else
				{
					if(player3Suit == proposedTrump && p3Max >= 3)
					{
						if(player3Suit == proposedTrump && p3Max >= 4)
						{
							System.out.println("Player 3 tells dealer to pick it up and will go alone");
						}
						else 
						{
							System.out.println("Player 3 tells dealer to pick it up");
							choosingTrump1 = false;
							break;
						}
					}
					else 
					{
						System.out.println("Player 3 passes");
						play = 4;
						i++;
						//continue;
					}
				}
			}

			else if(play == 4)
			{
				if(player4Partner == dealer)
				{
					if(player4Suit == proposedTrump && p4Max >= 4)
					{
						System.out.println("Player 17 tells dealer to pick it up and will go alone");
						choosingTrump1 = false;
						break;
					}
					else 
					{
						System.out.println("Player 4 passes");
						play = 1;
						i++;
						//continue;
					}
				}
				else
				{
					if(player4Suit == proposedTrump && p4Max >= 3)
					{
						if(player4Suit == proposedTrump && p4Max >= 4)
						{
							System.out.println("Player 4 tells dealer to pick it up and will go alone");
						}
						else 
						{
							System.out.println("Player 4 tells dealer to pick it up");
							choosingTrump1 = false;
							break;
						}
					}
					else 
					{
						System.out.println("Player 4 passes");
						play = 1;
						i++;
						//continue;
					}
				}
			}
		}


		if(choosingTrump1 == true)
		{
			choosingTrump1 = false;
			choosingTrump2 = true;

			int f;
			for(f = 0; f < 5; f++)
			{
				if(play == 1) 
				{
					while(true)
					{
						System.out.println("To call a trump, type in one of the following: " + "1 - " + WHITE_BACKGROUND_BRIGHT +  BLACK_BOLD_BRIGHT + "♠   " + RESET + "2 - " + WHITE_BACKGROUND_BRIGHT +  RED_BOLD_BRIGHT + "♥   " + RESET + "3 - " + WHITE_BACKGROUND_BRIGHT +  BLACK_BOLD_BRIGHT + "♣   " + RESET + "4 - " + WHITE_BACKGROUND_BRIGHT +  RED_BOLD_BRIGHT + "♦" + RESET + "   Or type \"PASS\"");
						System.out.print("Selection: ");

						String userInput = Input.next();

						if(userInput.equalsIgnoreCase("1"))
						{
							Trump = "♠";
							f = 6;
							break;
						}
						else if(userInput.equalsIgnoreCase("2"))
						{
							Trump = "♥";
							f = 6;
							break;
						}
						else if(userInput.equalsIgnoreCase("3"))
						{
							Trump = "♣";
							f = 6;
							break;
						}
						else if(userInput.equalsIgnoreCase("4"))
						{
							Trump = "♦";
							f = 6;
							break;
						}
						else if(userInput.equalsIgnoreCase("pass"));
						{
							play = 2;
							f++;
							break;
						}
					}
				}
			}
		}
	}

	public static void printPlayerCards(int player)
	{
		System.out.print("\n        "); 


		for(int i = 0; i < player1Cards.size(); i++)
		{
			if(player1Cards.get(i).contains("♥") || player1Cards.get(i).contains("♦"))
			{
				System.out.print(WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  player1Cards.get(i) + " " +  RESET + " ");
			}
			else
			{
				System.out.print(WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + player1Cards.get(i) + " " + RESET + " ");
			}
		}
	}

	public static void printStartTable()
	{
		String kittyCard;
		if(kitty.get(0).contains("♥") || kitty.get(0).contains("♦"))
		{
			kittyCard = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " + kitty.get(0) + " " + RESET;
		}
		else
		{
			kittyCard = WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + kitty.get(0) + " " + RESET;
		}

		if(dealer == 4)
		{
			System.out.println("\n                Player 3\n"
					+ "\n"
					+ "\n                  " + cardsOnTable[2] 
							+ "\n"
							+ " Player 4     " + cardsOnTable[3] + kittyCard + cardsOnTable[1] +  "      Player 2\n"
							+ "  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
							+ "          " + cardsOnTable[0]
									+ "\n\n\n"
									+ "\n"
									+ "                Player 1");
		}

		printPlayerCards(1);
	}

	public static void printTable()
	{
		//cardsOnTable[0] = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  player1Cards.get(0) + " " +  RESET + " ";
		//cardsOnTable[1] = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  player2Cards.get(0) + " " +  RESET + " ";
		//cardsOnTable[2] = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  player3Cards.get(0) + " " +  RESET + " ";
		//cardsOnTable[3] = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  player4Cards.get(0) + " " +  RESET + " ";

		if(dealer == 4)
		{
			System.out.println("\n                Player 3\n"
					+ "\n"
					+ "\n                  " + cardsOnTable[2] 
							+ "\n"
							+ " Player 4     " + cardsOnTable[3] + "   " + cardsOnTable[1] +  "      Player 2\n"
							+ "  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
							+ "          " + cardsOnTable[0]
									+ "\n\n\n"
									+ "\n"
									+ "                Player 1");
		}

		printPlayerCards(1);

	}

	public static void resetDeck()
	{
		cards = new ArrayList<String>(Arrays.asList("9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", 
				"9♦", "10♦", "J♦", "Q♦", "K♦", "A♦", 
				"9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", 
				"9♠", "10♠", "J♠", "Q♠", "K♠", "A♠"));
	}

	public static void debug()
	{

		System.out.print("\nPlayer 2 cards: " + player2Cards);
		System.out.println("Player 2 suit: " + player2Suit  + Arrays.toString(player2TrumpNum));

		System.out.print("Player 3 cards: " + player3Cards);
		System.out.println("Player 3 suit: " + player3Suit + Arrays.toString(player3TrumpNum));

		System.out.print("Player 4 cards: " + player4Cards);
		System.out.println("Player 4 suit: " + player4Suit + Arrays.toString(player4TrumpNum));

		System.out.println(proposedTrump);

	}
}
