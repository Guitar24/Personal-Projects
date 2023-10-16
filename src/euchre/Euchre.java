package euchre;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

public class Euchre 
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


	public static ArrayList<Integer> player1CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	public static ArrayList<Integer> player2CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	public static ArrayList<Integer> player3CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	public static ArrayList<Integer> player4CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));

	public static ArrayList<String> kitty = new ArrayList<String>();
	public static ArrayList<String> tableList = new ArrayList<String>(Arrays.asList("    ", "    ", "    ","    "));

	public static int[] player2SuitScores = new int[4];
	public static int[] player3SuitScores = new int[4];
	public static int[] player4SuitScores = new int[4];
	public static int[] cardsOnTableScores = new int[4];

	public static String[] cardsOnTable = {"    ", "    ", "    ", "    "};

	public static int play;
	public static int dealer = 4;
	public static int trumpMaker;
	public static int team24Tricks;
	public static int team13Tricks;
	public static int pointsInGame = 10;
	public static int numOfGames = 0;

	public static int player1Partner = 3;
	public static int player2Partner = 4;
	public static int player3Partner = 1;
	public static int player4Partner = 2;

	public static int p2MaxScore;
	public static int p3MaxScore;
	public static int p4MaxScore;

	public static int team24Score = 0;
	public static int team13Score = 0;

	public static String player2Suit;
	public static String player3Suit;
	public static String player4Suit;

	public static String topCard;
	public static String proposedTrump;
	public static String Trump;

	public static String suitLead = "";

	public static boolean player1SoloStatus = false;
	public static boolean player2SoloStatus = false;
	public static boolean player3SoloStatus = false;
	public static boolean player4SoloStatus = false;

	public static boolean choosingTrump1 = true;
	public static boolean choosingTrump2 = false;

	public static boolean darkMode;

	public static boolean debugLog;

	public static File directory = new File(new SimpleDateFormat("MM.dd.HH.mm").format(new java.util.Date()));

	public static Scanner Input = new Scanner(System.in);


	public static final String ESC = "\033[";
	public static final String RESET = "\033[0m"; 		                              // RESET TEXT
	public static final String BLACK = "\033[0;30m";                                 // BLACK

	public static final String DARK_MODE = "\033[38;2;48;44;44m";                  // Eclipse Dark Mode
	public static final String LIGHT_MODE = "\033[38;2;255;255;255m";             // Eclipse Light Mode

	public static final String BLACK_BOLD = "\033[1;30m";                       // BLACK BOLD
	public static final String WHITE_BOLD = "\033[1;97m";                      // WHITE

	public static final String RED_BOLD_BRIGHT = "\033[1;91m";               // RED
	public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";            // BLACK BOLD BRIGHT
	public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";           // GREEN

	public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";  // WHITE BACKGROUND


	public static void main(String[] args) throws InterruptedException, IOException 
	{

		while(true)
		{
			System.out.println("\nSETUP            **WARNING THIS PROGRAM WILL ONLY WORK IF YOU ARE USING ECLIPSE v4.25 OR LATER**");
			System.out.println("\nAre you using dark mode or light mode in Eclipse?");
			System.out.print("Type \"D\" for dark of \"L\" for light: ");

			String userInput = Input.next();

			if(userInput.equalsIgnoreCase("d"))
			{
				darkMode = true;
				break;
			}
			else if(userInput.equalsIgnoreCase("l"))
			{
				darkMode = false;
				break;
			}
			else
			{
				Thread.sleep(750);
				System.out.println("\nError code: ID-10-T");
				Thread.sleep(750);
			}


		}

		player1Cards = new ArrayList<String>();
		player2Cards = new ArrayList<String>();
		player3Cards = new ArrayList<String>();
		player4Cards = new ArrayList<String>();

		player1Suits = new ArrayList<String>();
		player2Suits = new ArrayList<String>();
		player3Suits = new ArrayList<String>();
		player4Suits = new ArrayList<String>();

		System.out.println("             -------------------------------------------------------------------\n\n\n\n\n\n\n     Resize the console so that you these lines are on the top and bottom of the window\n\n\n\n\n\n\n\n");
		System.out.print("             -------------------------------------------------------------------");

		sleep(5000);

		System.out.println("\n\n\nWelcome to Euchre!");
		menu();
	}

	public static void menu() throws InterruptedException, IOException 
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
				directory.mkdir();
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
			else if(menuInput.equalsIgnoreCase("p")) // allows the user to select how many points in a game
			{
				while(true)
				{
					System.out.println("\nHow many points would you like to play to?\n");
					System.out.println("                 10 (Default)");
					System.out.println("                 7");
					System.out.println("                 5");
					System.out.print("\nType in one of the numbers above: ");

					String userInput = Input.next();
					if(userInput.equalsIgnoreCase("10") || userInput.equalsIgnoreCase("7") || userInput.equalsIgnoreCase("5"))
					{
						pointsInGame = Integer.parseInt(userInput);
						break;
					}
					else
					{
						System.out.println("\nError code: ID-10-T");
						sleep(500);
					}
				}

				while(true)
				{
					System.out.println("Debug?");
					System.out.print("\n\"Y\" or \"N\": ");
					String userInput = Input.next();

					if(userInput.equalsIgnoreCase("Y"))
					{
						debugLog = true;
						break;
					}
					else if(userInput.equalsIgnoreCase("N"))
					{
						debugLog = false;
						break;
					}
				}
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

	public static void startGame() throws InterruptedException, IOException
	{


		dealer = 4;
		numOfGames = 0;

		while(team13Score < pointsInGame && team24Score < pointsInGame)
		{
			resetDeck();
			resetTable();
			dealCards();

			player1SoloStatus = false;
			player2SoloStatus = false;
			player3SoloStatus = false;
			player4SoloStatus = false;


			team13Tricks = 0;
			team24Tricks = 0;

			//debug();

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

		if(team13Score >= pointsInGame)
		{
			System.out.println("\nYOU AND PLAYER 3 WON!!!!!");
			sleep(6000);
		}
		else if(team24Score >= pointsInGame)
		{
			System.out.println("\nPlayer 2 and Player 4 won.");
			sleep(6000);
		}


	}

	public static void dealCards() throws InterruptedException 
	{
		resetDeck();

		player1Cards.removeAll(player1Cards);
		player2Cards.removeAll(player2Cards);
		player3Cards.removeAll(player3Cards);
		player4Cards.removeAll(player4Cards);

		player1Suits.removeAll(player1Suits);
		player2Suits.removeAll(player2Suits);
		player3Suits.removeAll(player3Suits);
		player4Suits.removeAll(player4Suits);

		kitty.removeAll(kitty);

		player1CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		player2CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		player3CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		player4CardScores = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));

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
			if(player1Cards.get(i).contains("♥"))
			{
				player1Suits.add("♥");
			}
			else if(player1Cards.get(i).contains("♦"))
			{
				player1Suits.add("♦");
			}
			else if(player1Cards.get(i).contains("♣"))
			{
				player1Suits.add("♣");
			}
			else if(player1Cards.get(i).contains("♠"))
			{
				player1Suits.add("♠");
			}
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


		if(kitty.get(0).contains("♥") || kitty.get(0).contains("♦"))
		{
			topCard = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " +  kitty.get(0) + " " +  RESET + " ";
		}
		else
		{
			topCard = WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + kitty.get(0) + " " + RESET + " ";
		}

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

		cardScores(5);

		//debug();

		//System.out.println(player2CardScores);
		//System.out.println(player3CardScores);
		//System.out.println(player4CardScores);
	}

	public static void cardScores(int cardsInHand) throws InterruptedException 
	{

		cardsInHand = 5;
		//System.out.println("CardsInHand: " + cardsInHand);

		//Player 1 Card Score
		for(int i = 0; i < cardsInHand; i++)
		{

			if(choosingTrump1 == true)
			{

				if(player1Cards.get(i).contains("9"))
				{
					player1CardScores.set(i, 1);
				}
				else if(player1Cards.get(i).contains("10"))
				{
					player1CardScores.set(i, 2);
				}
				else if(player1Cards.get(i).contains("Q"))
				{
					player1CardScores.set(i, 4);
				}
				else if(player1Cards.get(i).contains("K"))
				{
					player1CardScores.set(i, 5);
				}
				else if(player1Cards.get(i).contains("A"))
				{
					player1CardScores.set(i, 6);
				}

				else if(player1Cards.get(i).contains("J"))
				{
					//test for right bower
					if(player1Cards.get(i).contains(proposedTrump))
					{
						player1CardScores.set(i, 8);
					}

					//test for left bower
					if(proposedTrump.contains("♠") && player1Cards.get(i).contains("♣"))
					{
						player1CardScores.set(i, 7);
						player1Suits.set(i, "♠");
					}
					else if(proposedTrump.contains("♣") && player1Cards.get(i).contains("♠"))
					{
						player1CardScores.set(i, 7);
						player1Suits.set(i, "♣");
					}
					else if(proposedTrump.contains("♦") && player1Cards.get(i).contains("♥"))
					{
						player1CardScores.set(i, 7);
						player1Suits.set(i, "♦");
					}
					else if(proposedTrump.contains("♥") && player1Cards.get(i).contains("♦"))
					{
						player1CardScores.set(i, 7);
						player1Suits.set(i, "♥");
					}
					else
					{
						player1CardScores.set(i, 3);
					}
				}
			}

			else if(choosingTrump2 == true)
			{

				if(player1Cards.get(i).contains("9"))
				{
					player1CardScores.set(i, 1);
				}
				else if(player1Cards.get(i).contains("10"))
				{
					player1CardScores.set(i, 2);
				}
				else if(player1Cards.get(i).contains("Q"))
				{
					player1CardScores.set(i, 4);
				}
				else if(player1Cards.get(i).contains("K"))
				{
					player1CardScores.set(i, 5);
				}
				else if(player1Cards.get(i).contains("A"))
				{
					player1CardScores.set(i, 6);
				}
				else if(player1Cards.get(i).contains("J"))
				{
					player1CardScores.set(i, 8);
				}
			}

			else if(choosingTrump1 == false && choosingTrump2 == false)
			{
				if(player1Cards.get(i).contains(Trump))
				{

					if(player1Cards.get(i).contains("9"))
					{
						player1CardScores.set(i, 9);
					}
					else if(player1Cards.get(i).contains("10"))
					{
						player1CardScores.set(i, 10);
					}
					else if(player1Cards.get(i).contains("Q"))
					{
						player1CardScores.set(i, 12);
					}
					else if(player1Cards.get(i).contains("K"))
					{
						player1CardScores.set(i, 13);
					}
					else if(player1Cards.get(i).contains("A"))
					{
						player1CardScores.set(i, 14);
					}
					else if(player1Cards.get(i).contains("J"))
					{
						player1CardScores.set(i, 16);
					}
				}
				else
				{
					if(player1Cards.get(i).contains("9"))
					{
						player1CardScores.set(i, 1);
					}
					else if(player1Cards.get(i).contains("10"))
					{
						player1CardScores.set(i, 2);
					}
					else if(player1Cards.get(i).contains("Q"))
					{
						player1CardScores.set(i, 4);
					}
					else if(player1Cards.get(i).contains("K"))
					{
						player1CardScores.set(i, 5);
					}
					else if(player1Cards.get(i).contains("A"))
					{
						player1CardScores.set(i, 6);
					}
					else if(player1Cards.get(i).contains("J"))
					{
						//test for left bower
						if(Trump.contains("♠") && player1Cards.get(i).contains("♣"))
						{
							player1CardScores.set(i, 15);
							player1Suits.set(i, "♠");
						}
						else if(Trump.contains("♣") && player1Cards.get(i).contains("♠"))
						{
							player1CardScores.set(i, 15);
							player1Suits.set(i, "♣");
						}
						else if(Trump.contains("♦") && player1Cards.get(i).contains("♥"))
						{
							player1CardScores.set(i, 15);
							player1Suits.set(i, "♦");
						}
						else if(Trump.contains("♥") && player1Cards.get(i).contains("♦"))
						{
							player1CardScores.set(i, 15);
							player1Suits.set(i, "♥");
						}
						else
						{
							player1CardScores.set(i, 3);
						}
					}
				}
			}
		}
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
						player2Suits.set(i, "♠");
					}
					else if(proposedTrump.contains("♣") && player2Cards.get(i).contains("♠"))
					{
						player2CardScores.set(i, 7);
						player2Suits.set(i, "♣");
					}
					else if(proposedTrump.contains("♦") && player2Cards.get(i).contains("♥"))
					{
						player2CardScores.set(i, 7);
						player2Suits.set(i, "♦");
					}
					else if(proposedTrump.contains("♥") && player2Cards.get(i).contains("♦"))
					{
						player2CardScores.set(i, 7);
						player2Suits.set(i, "♥");
					}
					else
					{
						player2CardScores.set(i, 3);
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
							player2Suits.set(i, "♠");
						}
						else if(Trump.contains("♣") && player2Cards.get(i).contains("♠"))
						{
							player2CardScores.set(i, 15);
							player2Suits.set(i, "♣");
						}
						else if(Trump.contains("♦") && player2Cards.get(i).contains("♥"))
						{
							player2CardScores.set(i, 15);
							player2Suits.set(i, "♦");
						}
						else if(Trump.contains("♥") && player2Cards.get(i).contains("♦"))
						{
							player2CardScores.set(i, 15);
							player2Suits.set(i, "♥");
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
						player3Suits.set(i, "♠");
					}
					else if(proposedTrump.contains("♣") && player3Cards.get(i).contains("♠"))
					{
						player3CardScores.set(i, 7);
						player3Suits.set(i, "♣");
					}
					else if(proposedTrump.contains("♦") && player3Cards.get(i).contains("♥"))
					{
						player3CardScores.set(i, 7);
						player3Suits.set(i, "♦");
					}
					else if(proposedTrump.contains("♥") && player3Cards.get(i).contains("♦"))
					{
						player3CardScores.set(i, 7);
						player3Suits.set(i, "♥");
					}
					else
					{
						player3CardScores.set(i, 3);
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
							player3Suits.set(i, "♠");
						}
						else if(Trump.contains("♣") && player3Cards.get(i).contains("♠"))
						{
							player3CardScores.set(i, 15);
							player3Suits.set(i, "♣");
						}
						else if(Trump.contains("♦") && player3Cards.get(i).contains("♥"))
						{
							player3CardScores.set(i, 15);
							player3Suits.set(i, "♦");
						}
						else if(Trump.contains("♥") && player3Cards.get(i).contains("♦"))
						{
							player3CardScores.set(i, 15);
							player3Suits.set(i, "♥");
						}
						else
						{
							player3CardScores.set(i, 3);
						}
					}
				}
			}
		}

		//Player 4 Card Score
		for(int i = 0; i < cardsInHand; i++)
		{

			if(choosingTrump1 == true)
			{

				if(player4Cards.get(i).contains("9"))
				{
					player4CardScores.set(i, 1);
				}
				else if(player4Cards.get(i).contains("10"))
				{
					player4CardScores.set(i, 2);
				}
				else if(player4Cards.get(i).contains("Q"))
				{
					player4CardScores.set(i, 4);
				}
				else if(player4Cards.get(i).contains("K"))
				{
					player4CardScores.set(i, 5);
				}
				else if(player4Cards.get(i).contains("A"))
				{
					player4CardScores.set(i, 6);
				}

				else if(player4Cards.get(i).contains("J"))
				{
					//test for right bower
					if(player4Cards.get(i).contains(proposedTrump))
					{
						player4CardScores.set(i, 8);
					}

					//test for left bower
					if(proposedTrump.contains("♠") && player4Cards.get(i).contains("♣"))
					{
						player4CardScores.set(i, 7);
						player4Suits.set(i, "♠");
					}
					else if(proposedTrump.contains("♣") && player4Cards.get(i).contains("♠"))
					{
						player4CardScores.set(i, 7);
						player4Suits.set(i, "♣");
					}
					else if(proposedTrump.contains("♦") && player4Cards.get(i).contains("♥"))
					{
						player4CardScores.set(i, 7);
						player4Suits.set(i, "♦");
					}
					else if(proposedTrump.contains("♥") && player4Cards.get(i).contains("♦"))
					{
						player4CardScores.set(i, 7);
						player4Suits.set(i, "♥");
					}
					else
					{
						player3CardScores.set(i, 3);
					}
				}
			}

			else if(choosingTrump2 == true)
			{

				if(player4Cards.get(i).contains("9"))
				{
					player4CardScores.set(i, 1);
				}
				else if(player4Cards.get(i).contains("10"))
				{
					player4CardScores.set(i, 2);
				}
				else if(player4Cards.get(i).contains("Q"))
				{
					player4CardScores.set(i, 4);
				}
				else if(player4Cards.get(i).contains("K"))
				{
					player4CardScores.set(i, 5);
				}
				else if(player4Cards.get(i).contains("A"))
				{
					player4CardScores.set(i, 6);
				}
				else if(player4Cards.get(i).contains("J"))
				{
					player4CardScores.set(i, 8);
				}
			}



			else if(choosingTrump1 == false && choosingTrump2 == false)
			{
				if(player4Cards.get(i).contains(Trump))
				{

					if(player4Cards.get(i).contains("9"))
					{
						player4CardScores.set(i, 9);
					}
					else if(player4Cards.get(i).contains("10"))
					{
						player4CardScores.set(i, 10);
					}
					else if(player4Cards.get(i).contains("Q"))
					{
						player4CardScores.set(i, 12);
					}
					else if(player4Cards.get(i).contains("K"))
					{
						player4CardScores.set(i, 13);
					}
					else if(player4Cards.get(i).contains("A"))
					{
						player4CardScores.set(i, 14);
					}
					else if(player4Cards.get(i).contains("J"))
					{
						player4CardScores.set(i, 16);
					}
				}
				else
				{
					if(player4Cards.get(i).contains("9"))
					{
						player4CardScores.set(i, 1);
					}
					else if(player4Cards.get(i).contains("10"))
					{
						player4CardScores.set(i, 2);
					}
					else if(player4Cards.get(i).contains("Q"))
					{
						player4CardScores.set(i, 4);
					}
					else if(player4Cards.get(i).contains("K"))
					{
						player4CardScores.set(i, 5);
					}
					else if(player4Cards.get(i).contains("A"))
					{
						player4CardScores.set(i, 6);
					}
					else if(player4Cards.get(i).contains("J"))
					{
						//test for left bower
						if(Trump.contains("♠") && player4Cards.get(i).contains("♣"))
						{
							player4CardScores.set(i, 15);
							player4Suits.set(i, "♠");
						}
						else if(Trump.contains("♣") && player4Cards.get(i).contains("♠"))
						{
							player4CardScores.set(i, 15);
							player4Suits.set(i, "♣");
						}
						else if(Trump.contains("♦") && player4Cards.get(i).contains("♥"))
						{
							player4CardScores.set(i, 15);
							player4Suits.set(i, "♦");
						}
						else if(Trump.contains("♥") && player4Cards.get(i).contains("♦"))
						{
							player4CardScores.set(i, 15);
							player4Suits.set(i, "♥");
						}
						else
						{
							player4CardScores.set(i, 3);
						}
					}
				}
			}
		}


		//Finding Player 3 best suits
		for(int i3 = 0; i3 < player3Suits.size(); i3++)
		{
			if(player3Suits.get(i3).equalsIgnoreCase("♥"))
			{
				player3SuitScores[0] = player3SuitScores[0] + player3CardScores.get(i3);
			}
			else if(player3Suits.get(i3).equalsIgnoreCase("♦"))
			{
				player3SuitScores[1] = player3SuitScores[1] + player3CardScores.get(i3);
			}
			else if(player3Suits.get(i3).equalsIgnoreCase("♣"))
			{
				player3SuitScores[2] = player3SuitScores[2] + player3CardScores.get(i3);
			}
			else if(player3Suits.get(i3).equalsIgnoreCase("♠"))
			{
				player3SuitScores[3] = player3SuitScores[3] + player3CardScores.get(i3);
			}
		}

		p3MaxScore = player3SuitScores[0];

		for(int i3 = 0; i3 < player3SuitScores.length; i3++)
		{
			if(player3SuitScores[i3] > p3MaxScore)
			{
				p3MaxScore = player3SuitScores[i3];
			}
		}

		int suitIndex3 = 0;

		int i3 = 0;
		while(i3 < player3SuitScores.length)
		{
			if(player3SuitScores[i3] == p3MaxScore)
			{
				suitIndex3 = i3;
				break;
			}

			i3++;
		}

		if(suitIndex3 == 0)
		{
			player3Suit = "♥";
		}
		else if(suitIndex3 == 1)
		{
			player3Suit = "♦";
		}
		else if(suitIndex3 == 2)
		{
			player3Suit = "♣";
		}
		else if(suitIndex3 == 3)
		{
			player3Suit = "♠";
		}



		//Finding Player 2 best suits
		for(int i2 = 0; i2 < player2Suits.size(); i2++)
		{
			if(player2Suits.get(i2).equalsIgnoreCase("♥"))
			{
				player2SuitScores[0] = player2SuitScores[0] + player2CardScores.get(i2);
			}
			else if(player2Suits.get(i2).equalsIgnoreCase("♦"))
			{
				player2SuitScores[1] = player2SuitScores[1] + player2CardScores.get(i2);
			}
			else if(player2Suits.get(i2).equalsIgnoreCase("♣"))
			{
				player2SuitScores[2] = player2SuitScores[2] + player2CardScores.get(i2);
			}
			else if(player2Suits.get(i2).equalsIgnoreCase("♠"))
			{
				player2SuitScores[3] = player2SuitScores[3] + player2CardScores.get(i2);
			}
		}

		p2MaxScore = player2SuitScores[0];

		for(int i2 = 0; i2 < player2SuitScores.length; i2++)
		{
			if(player2SuitScores[i2] > p2MaxScore)
			{
				p2MaxScore = player2SuitScores[i2];
			}
		}

		int suitIndex2 = 0;

		int i2 = 0;
		while(i2 < player2SuitScores.length)
		{
			if(player2SuitScores[i2] == p2MaxScore)
			{
				suitIndex2 = i2;
				break;
			}

			i2++;
		}

		if(suitIndex2 == 0)
		{
			player2Suit = "♥";
		}
		else if(suitIndex2 == 1)
		{
			player2Suit = "♦";
		}
		else if(suitIndex2 == 2)
		{
			player2Suit = "♣";
		}
		else if(suitIndex2 == 3)
		{
			player2Suit = "♠";
		}


		//Finding Player 4 best suits
		for(int i4 = 0; i4 < player4Suits.size(); i4++)
		{
			if(player4Suits.get(i4).equalsIgnoreCase("♥"))
			{
				player4SuitScores[0] = player4SuitScores[0] + player4CardScores.get(i4);
			}
			else if(player4Suits.get(i4).equalsIgnoreCase("♦"))
			{
				player4SuitScores[1] = player4SuitScores[1] + player4CardScores.get(i4);
			}
			else if(player4Suits.get(i4).equalsIgnoreCase("♣"))
			{
				player4SuitScores[2] = player4SuitScores[2] + player4CardScores.get(i4);
			}
			else if(player4Suits.get(i4).equalsIgnoreCase("♠"))
			{
				player4SuitScores[3] = player4SuitScores[3] + player4CardScores.get(i4);
			}
		}

		p4MaxScore = player4SuitScores[0];

		for(int i4 = 0; i4 < player4SuitScores.length; i4++)
		{
			if(player4SuitScores[i4] > p4MaxScore)
			{
				p4MaxScore = player4SuitScores[i4];
			}
		}

		int suitIndex4 = 0;

		int i4 = 0;
		while(i4 < player4SuitScores.length)
		{
			if(player4SuitScores[i4] == p4MaxScore)
			{
				suitIndex4 = i4;
				break;
			}

			i4++;
		}

		if(suitIndex4 == 0)
		{
			player4Suit = "♥";
		}
		else if(suitIndex4 == 1)
		{
			player4Suit = "♦";
		}
		else if(suitIndex4 == 2)
		{
			player4Suit = "♣";
		}
		else if(suitIndex4 == 3)
		{
			player4Suit = "♠";
		}
	}

	public static void pickUpCard(int player)  throws InterruptedException 
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
				int worstCard = 6;
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
				if(worstCard == 6)
				{
					for(int i = 0; i < player4Cards.size(); i++)
					{
						if(player4Cards.get(i).contains(Trump))
						{}
						else
						{
							if(player4Cards.get(i).contains("Q") || player4Cards.get(i).contains("K"))
							{
								worstCard = i;
							}
							else {}
						}
					}
					if(worstCard == 6)
					{
						worstCard = randInt(0, 4);
					}

					player4Cards.remove(worstCard);
					player4Cards.add(kitty.get(0));

				}
			}
		}
		else if(dealer == 1)
		{
			if(player == 3)
			{
				player3SoloStatus = true;
				Trump = proposedTrump;
				System.out.println("Player 3 is going alone!");
			}
			else
			{
				Trump = proposedTrump;
				int worstCard = 0;

				while(true)
				{
					System.out.print("Which card would you like to get rid of: ");
					String userInput = Input.next();

					if(userInput.contains("1") || userInput.contains("2") || userInput.contains("3") || userInput.contains("4") || userInput.contains("5"))
					{
						worstCard = Integer.parseInt(userInput);

						System.out.println("");
						player1Cards.remove(worstCard - 1);
						player1Suits.remove(worstCard - 1);
						player1Cards.add(kitty.get(0));
						player1Suits.add(proposedTrump);

						cardScores(5);

						//debug();

						break;
					}
					else
					{
						System.out.println("\nError code: ID-10-T");
						sleep(500);
					}
				}
			}
		}
		else if(dealer == 2)
		{
			if(player == 4)
			{
				player4SoloStatus = true;
				Trump = proposedTrump;
				System.out.println("Player 4 is going alone!");
			}
			else
			{
				Trump = proposedTrump;
				int worstCard = 6;
				for(int i = 0; i < player2Cards.size(); i++)
				{
					if(player2Cards.get(i).contains(Trump))
					{}
					else
					{
						if(player2Cards.get(i).contains("9") || player2Cards.get(i).contains("10"))
						{
							worstCard = i;
						}
						else {}
					}
				}
				if(worstCard == 6)
				{
					for(int i = 0; i < player2Cards.size(); i++)
					{
						if(player2Cards.get(i).contains(Trump))
						{}
						else
						{
							if(player2Cards.get(i).contains("Q") || player2Cards.get(i).contains("K"))
							{
								worstCard = i;
							}
							else {}
						}
					}
					if(worstCard == 6)
					{
						worstCard = randInt(0, 4);
					}

					player2Cards.remove(worstCard);
					player2Cards.add(kitty.get(0));
				}
			}
		}
		else if(dealer == 3)
		{
			if(player == 1)
			{
				player1SoloStatus = true;
				Trump = proposedTrump;
				System.out.println("Player 1 is going alone! (That's you!)");
			}
			else
			{
				Trump = proposedTrump;
				int worstCard = 6;
				for(int i = 0; i < player1Cards.size(); i++)
				{
					if(player3Cards.get(i).contains(Trump))
					{}
					else
					{
						if(player3Cards.get(i).contains("9") || player3Cards.get(i).contains("10"))
						{
							worstCard = i;
						}
						else {}
					}
				}
				if(worstCard == 6)
				{
					for(int i = 0; i < player3Cards.size(); i++)
					{
						if(player3Cards.get(i).contains(Trump))
						{}
						else
						{
							if(player3Cards.get(i).contains("Q") || player3Cards.get(i).contains("K"))
							{
								worstCard = i;
							}
							else {}
						}
					}
					if(worstCard == 6)
					{
						worstCard = randInt(0, 4);
					}

					player3Cards.remove(worstCard);
					player3Cards.add(kitty.get(0));

				}
			}
		}
	}

	public static void gameLoop() throws InterruptedException 
	{
		chooseTrumpLog();
		chooseTrump();

		//debug();

		Thread.sleep(1000);

		System.out.println("\nTrump is now: " + Trump + "\n");

		Thread.sleep(1000);

		//Start game
		if(dealer == 4)
		{
			if(player3SoloStatus == true)
			{
				play = 2;
				System.out.println("Player 2 starts");
			}
			else
			{
				play = 1;
				System.out.println("Player 1 starts (That's you!)");
			}
		}
		else if(dealer == 1)
		{
			if(player4SoloStatus == true)
			{
				play = 3;
				System.out.println("Player 3 starts");
			}
			else
			{
				play = 2;
				System.out.println("Player 2 starts");
			}
		}
		else if(dealer == 2)
		{
			if(player1SoloStatus == true)
			{
				play = 4;
				System.out.println("Player 4 starts");
			}
			else
			{
				play = 3;
				System.out.println("Player 3 starts");
			}
		}
		else if(dealer == 3)
		{
			if(player2SoloStatus == true)
			{
				play = 1;
				System.out.println("Player 1 starts (That's you!)");
			}
			else
			{
				play = 4;
				System.out.println("Player 4 starts");
			}
		}

		sleep(3000);

		printTable();

		choosingTrump1 = false;
		choosingTrump2 = false;

		int playWinner = 6;

		cardScores(5);

		gameLoopLog();

		for(int j = 1; j < 6; j++)
		{
			int[] played = {0, 0, 0, 0};

			resetTable();

			printTable();

			if(playWinner == 0)
			{
				play = 1;
			}
			else if(playWinner == 1)
			{
				play = 2;
			}
			else if(playWinner == 2)
			{
				play = 3;
			}
			else if(playWinner == 3)
			{
				play = 4;
			}

			boolean playing = true;

			while(playing)
			{
				ArrayList<String> tableTable = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
				for(int i = 0; i < 4; i++)
				{
					tableTable.set(i, cardsOnTable[i]);
				}

				if(!tableTable.contains("    "))
				{
					playing = false;
					break;
				}


				//System.out.println(i + 1);
				if(played[0] == 0)
				{
					if(play == 1)
					{
						if(player3SoloStatus == false)
						{
							if(suitLead == "")
							{
								while(true)
								{
									System.out.print("\nType in the position of the card you want to play: ");

									String userInput = Input.next();

									int cardNum;

									if(userInput.contains("1") || userInput.contains("2") || userInput.contains("3") || userInput.contains("4") || userInput.contains("5"))
									{
										cardNum = Integer.parseInt(userInput);

										if(cardNum >= 1 && cardNum <= player1Cards.size())
										{
											cardsOnTable[0] = player1Cards.get(cardNum - 1);
											//cardsOnTableScores[0] = player1CardScores.get();
											suitLead = player1Suits.get(cardNum - 1);
											player1Cards.remove(cardNum - 1);
											player1Suits.remove(cardNum - 1);
											//player1CardScores.remove(cardNum - 1);
											printTable();
											played[0] = 1;

											play = 2;

											break;
										}
									}
									else if(userInput.equalsIgnoreCase("debug"))
									{
										debug();
									}
								}
							}
							else
							{
								if(player1Suits.contains(suitLead))
								{
									while(true)
									{
										System.out.print("\nType in the position of the card you want to play: ");

										String userInput = Input.next();

										int cardNum;

										if(userInput.contains("1") || userInput.contains("2") || userInput.contains("3") || userInput.contains("4") || userInput.contains("5"))
										{
											cardNum = Integer.parseInt(userInput);
											if(player1Suits.get(cardNum-1).contains(suitLead))
											{
												if(cardNum >= 1 && cardNum <= player1Cards.size())
												{
													cardsOnTable[0] = player1Cards.get(cardNum - 1);
													//cardsOnTableScores[0] = player1CardScores.get();
													player1Cards.remove(cardNum - 1);
													player1Suits.remove(cardNum - 1);
													//player1CardScores.remove(cardNum - 1);
													printTable();
													played[0] = 1;

													play = 2;

													break;
												}
											}
											else
											{
												System.out.println("You cannot play this card because you must play a card with a suit that matches the card lead");
												sleep(500);
											}
										}
										else if(userInput.equalsIgnoreCase("debug"))
										{
											debug();
										}
									}
								}
								else if(!player1Suits.contains(suitLead))
								{
									while(true)
									{
										System.out.print("\nType in the position of the card you want to play: ");

										String userInput = Input.next();

										int cardNum;

										if(userInput.contains("1") || userInput.contains("2") || userInput.contains("3") || userInput.contains("4") || userInput.contains("5"))
										{
											cardNum = Integer.parseInt(userInput);

											if(cardNum >= 1 && cardNum <= player1Cards.size())
											{
												cardsOnTable[0] = player1Cards.get(cardNum - 1);
												//cardsOnTableScores[0] = player1CardScores.get();
												player1Cards.remove(cardNum - 1);
												player1Suits.remove(cardNum - 1);
												//player1CardScores.remove(cardNum - 1);
												printTable();
												played[0] = 1;

												play = 2;

												break;
											}
										}
										else if(userInput.equalsIgnoreCase("debug"))
										{
											debug();
										}
									}
								}
							}
						}
						else
						{
							cardsOnTable[0] = "Skip";
							play = 2;
						}
					}
				}
				if(played[1] == 0)
				{
					if(player4SoloStatus == false) 
					{
						if(play == 2)
						{
							if(suitLead == "")
							{
								int randCard;
								int count = 0;

								while(true)
								{
									randCard = randInt(0, (player2Cards.size() - 1));

									if(player2CardScores.get(randCard) > 3)
									{
										break;
									}
									else if(count > 5)
									{
										break;
									}
									else
									{
										count ++;
										continue;
									}
								}

								cardsOnTable[1] = player2Cards.get(randCard);

								suitLead = player2Suits.get(randCard);

								//System.out.println("\n\nPlayer 2 plays: " + cardsOnTable[1]);

								player2Cards.remove(randCard);
								player2Suits.remove(randCard);
								//player2CardScores.remove(randCard - 1);

								printTable();

								played[1] = 1;

								play = 3;
							}

							else if(player2Suits.contains(suitLead))
							{
								int cardIndex = player2Suits.indexOf(suitLead);

								cardsOnTable[1] = player2Cards.get(cardIndex);

								//System.out.println("\n\nPlayer 2 plays: " + cardsOnTable[1]);

								player2Cards.remove(cardIndex);
								player2Suits.remove(cardIndex);
								//player2CardScores.remove(cardIndex - 1);

								printTable();

								played[1] = 1;

								play = 3;
							}
							else if(!player2Suits.contains(suitLead))
							{
								if(player2Suits.contains(Trump))
								{
									int cardIndex = player2Suits.indexOf(Trump);

									cardsOnTable[1] = player2Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 2 plays: " + cardsOnTable[1]);

									player2Cards.remove(cardIndex);
									player2Suits.remove(cardIndex);
									//player2CardScores.remove(cardIndex - 1);

									printTable();

									played[1] = 1;

									play = 3;
								}
								else
								{
									int cardIndex = randInt(0, (player2Suits.size() - 1));

									cardsOnTable[1] = player2Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 2 plays: " + cardsOnTable[1]);

									player2Cards.remove(cardIndex);
									player2Suits.remove(cardIndex);
									//player2CardScores.remove(cardIndex - 1);

									printTable();

									played[1] = 1;

									play = 3;
								}
							}
						}

					}
					else
					{
						cardsOnTable[1] = "Skip";
						play = 3;
					}
				}
				if(played[2] == 0)
				{
					if(player1SoloStatus == false) 
					{
						if(play == 3)
						{
							if(suitLead == "")
							{
								int randCard;
								int count = 0;

								while(true)
								{
									randCard = randInt(0, (player3Cards.size() - 1));

									if(player3CardScores.get(randCard) > 3)
									{
										break;
									}
									else if(count > 5)
									{
										break;
									}
									else
									{
										count ++;
										continue;
									}
								}

								cardsOnTable[2] = player3Cards.get(randCard);

								suitLead = player3Suits.get(randCard);

								//System.out.println("\n\nPlayer 3 plays: " + cardsOnTable[2]);

								player3Cards.remove(randCard);
								player3Suits.remove(randCard);
								//player3CardScores.remove(randCard - 1);

								printTable();

								played[2] = 1;

								play = 4;
							}

							else if(player3Suits.contains(suitLead))
							{
								int cardIndex = player3Suits.indexOf(suitLead);

								cardsOnTable[2] = player3Cards.get(cardIndex);

								//System.out.println("\n\nPlayer 3 plays: " + cardsOnTable[2]);

								player3Cards.remove(cardIndex);
								player3Suits.remove(cardIndex);
								//player3CardScores.remove(cardIndex - 1);

								printTable();

								played[2] = 1;

								play = 4;
							}
							else if(!player3Suits.contains(suitLead))
							{
								if(player3Suits.contains(Trump))
								{
									int cardIndex = player3Suits.indexOf(Trump);

									cardsOnTable[2] = player3Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 2 plays: " + cardsOnTable[2]);

									player3Cards.remove(cardIndex);
									player3Suits.remove(cardIndex);
									//player3CardScores.remove(cardIndex - 1);

									printTable();

									played[2] = 1;

									play = 4;
								}
								else
								{
									int cardIndex = randInt(0, (player3Suits.size() - 1));

									cardsOnTable[2] = player3Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 3 plays: " + cardsOnTable[2]);

									player3Cards.remove(cardIndex);
									player3Suits.remove(cardIndex);
									//player3CardScores.remove(cardIndex - 1);

									printTable();

									played[2] = 1;

									play = 4;
								}
							}
						}

					}
					else
					{
						cardsOnTable[2] = "Skip";
						play = 4;
					}
				}

				if(played[3] == 0)
				{
					if(player2SoloStatus == false) 
					{
						if(play == 4)
						{
							if(suitLead == "")
							{
								int randCard;
								int count = 0;

								while(true)
								{
									randCard = randInt(0, (player4Cards.size() - 1));

									if(player4CardScores.get(randCard) > 3)
									{
										break;
									}
									else if(count > 5)
									{
										break;
									}
									else
									{
										count ++;
										continue;
									}
								}

								cardsOnTable[3] = player4Cards.get(randCard);

								suitLead = player4Suits.get(randCard);

								//System.out.println("\n\nPlayer 4 plays: " + cardsOnTable[3]);

								player4Cards.remove(randCard);
								player4Suits.remove(randCard);
								//player4CardScores.remove(randCard - 1);

								printTable();

								played[3] = 1;

								play = 1;
							}

							else if(player4Suits.contains(suitLead))
							{
								int cardIndex = player4Suits.indexOf(suitLead);

								cardsOnTable[3] = player4Cards.get(cardIndex);

								//System.out.println("\n\nPlayer 4 plays: " + cardsOnTable[3]);

								player4Cards.remove(cardIndex);
								player4Suits.remove(cardIndex);
								//player4CardScores.remove(cardIndex - 1);

								printTable();

								played[3] = 1;

								play = 1;
							}
							else if(!player4Suits.contains(suitLead))
							{
								if(player4Suits.contains(Trump))
								{
									int cardIndex = player4Suits.indexOf(Trump);

									cardsOnTable[3] = player4Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 4 plays: " + cardsOnTable[3]);

									player4Cards.remove(cardIndex);
									player4Suits.remove(cardIndex);
									//player4CardScores.remove(cardIndex - 1);

									printTable();

									played[3] = 1;

									play = 1;
								}
								else
								{
									int cardIndex = randInt(0, (player4Suits.size() - 1));

									cardsOnTable[3] = player4Cards.get(cardIndex);

									//System.out.println("\n\nPlayer 4 plays: " + cardsOnTable[3]);

									player4Cards.remove(cardIndex);
									player4Suits.remove(cardIndex);
									//player4CardScores.remove(cardIndex - 1);

									printTable();

									played[3] = 1;

									play = 1;
								}
							}
						}

					}
					else
					{
						cardsOnTable[3] = "Skip";
						play = 1;
					}
				}

				//System.out.println("\nsuitLead = " + suitLead+ "\n\n");

				//debug();
			}//End while loop



			if(cardsOnTable[0] != "    " && cardsOnTable[1] != "    " && cardsOnTable[2] != "    " && cardsOnTable[3] != "    " )
			{
				for(int i = 0; i < 4; i++)
				{
					//System.out.println("ScoreLoop");
					String tableCard = cardsOnTable[i];

					if(tableCard.contains(Trump))
					{
						//System.out.println("ScoreLoop - Trump");
						if(tableCard.contains("9"))
						{
							cardsOnTableScores[i] = 15;
						}
						else if(tableCard.contains("10"))
						{
							cardsOnTableScores[i] = 16;
						}
						else if(tableCard.contains("Q"))
						{
							cardsOnTableScores[i] = 18;
						}
						else if(tableCard.contains("K"))
						{
							cardsOnTableScores[i] = 19;
						}
						else if(tableCard.contains("A"))
						{
							cardsOnTableScores[i] = 20;
						}
						else if(tableCard.contains("J"))
						{
							//test for left bower
							if(Trump.contains("♠") && tableCard.contains("♣"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♣") && tableCard.contains("♠"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♦") && tableCard.contains("♥"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♥") && tableCard.contains("♦"))
							{
								cardsOnTableScores[i] = 21;
							}
							else
							{
								cardsOnTableScores[i] = 22;
							}
						}
					}

					else if(tableCard.contains(suitLead))
					{
						//System.out.println("ScoreLoop - suitLead");
						if(tableCard.contains("9"))
						{
							cardsOnTableScores[i] = 9;
						}
						else if(tableCard.contains("10"))
						{
							cardsOnTableScores[i] = 10;
						}
						else if(tableCard.contains("J"))
						{
							//test for left bower
							if(Trump.contains("♠") && tableCard.contains("♣"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♣") && tableCard.contains("♠"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♦") && tableCard.contains("♥"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♥") && tableCard.contains("♦"))
							{
								cardsOnTableScores[i] = 21;
							}
							else
							{
								cardsOnTableScores[i] = 11;
							}
						}
						else if(tableCard.contains("Q"))
						{
							cardsOnTableScores[i] = 12;
						}
						else if(tableCard.contains("K"))
						{
							cardsOnTableScores[i] = 13;
						}
						else if(tableCard.contains("A"))
						{
							cardsOnTableScores[i] = 14;
						}

					}
					else if(!tableCard.contains(suitLead))
					{
						//System.out.println("ScoreLoop- !suitLead");
						if(tableCard.contains("9"))
						{
							cardsOnTableScores[i] = 1;
						}
						else if(tableCard.contains("10"))
						{
							cardsOnTableScores[i] = 2;
						}
						else if(tableCard.contains("J"))
						{
							//test for left bower
							if(Trump.contains("♠") && tableCard.contains("♣"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♣") && tableCard.contains("♠"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♦") && tableCard.contains("♥"))
							{
								cardsOnTableScores[i] = 21;
							}
							else if(Trump.contains("♥") && tableCard.contains("♦"))
							{
								cardsOnTableScores[i] = 21;
							}
							else
							{
								cardsOnTableScores[i] = 3;
							}
						}
						else if(tableCard.contains("Q"))
						{
							cardsOnTableScores[i] = 4;
						}
						else if(tableCard.contains("K"))
						{
							cardsOnTableScores[i] = 5;
						}
						else if(tableCard.contains("A"))
						{
							cardsOnTableScores[i] = 6;
						}
					}
					else
					{

						cardsOnTableScores[i] = 0;
					}

				}


				int maxScore = cardsOnTableScores[0];

				for(int i = 0; i < 4; i++)
				{
					if(cardsOnTableScores[i] > maxScore)
					{
						maxScore = cardsOnTableScores[i];
					}
				}


				for(int i = 0; i < 4; i++)
				{
					if(cardsOnTableScores[i] == maxScore)
					{
						playWinner = i;
						break;
					}
				}

				if(playWinner == 0)
				{
					System.out.println("\nPlayer 1 wins this trick! (That's you!)");
					suitLead = "";
					team13Tricks ++;
					sleep(3000);
				}
				else if(playWinner == 2)
				{
					System.out.println("\nPlayer 3 wins this trick!");
					suitLead = "";
					team13Tricks ++;
					sleep(3000);
				}
				else if(playWinner == 1)
				{
					System.out.println("\nPlayer 2 wins this trick!");
					suitLead = "";
					team24Tricks ++;
					sleep(3000);
				}
				else if(playWinner == 3)
				{
					System.out.println("\nPlayer 4 wins this trick!");
					suitLead = "";
					team24Tricks ++;
					sleep(3000);
				}

				if(team24Tricks + team13Tricks == 5)
				{
					if(team13Tricks >= 3)
					{
						if(player3SoloStatus == true || player1SoloStatus == true)
						{
							if(team13Tricks == 5)
							{
								System.out.println("You and your partner won all the tricks this hand!");
								team13Score += 4;

								sleep(3000);
							}
							else
							{
								System.out.println("You and your partner won this hand!");
								team13Score += 1;
								sleep(3000);
							}
						}
						else
						{
							if(trumpMaker == 1 || trumpMaker == 3)
							{
								if(team13Tricks == 5)
								{
									System.out.println("You and your partner won all the tricks this hand!");
									team13Score += 2;
									sleep(3000);
								}
								else
								{
									System.out.println("You and your partner won this hand!");
									team13Score += 1;
									sleep(3000);
								}
							}
							else if(trumpMaker == 2 || trumpMaker == 4)
							{
								System.out.println("You and your partner euchred them!");
								team13Score += 2;
								sleep(3000);
							}
						}
					}
					else if(team24Tricks >= 3)
					{
						if(player2SoloStatus == true || player4SoloStatus == true)
						{
							if(team24Tricks == 5)
							{
								System.out.println("They won all the tricks in this hand");
								team24Score += 4;
								sleep(3000);
							}
							else
							{
								System.out.println("They won this hand");
								team24Score += 1;
								sleep(3000);
							}
						}
						else
						{
							if(trumpMaker == 2 || trumpMaker == 4)
							{
								if(team24Tricks == 5)
								{
									System.out.println("They won all the tricks in this hand");
									team24Score += 2;
									sleep(3000);
								}
								else
								{
									System.out.println("They won this hand");
									team24Score += 1;
									sleep(3000);
								}
							}
							else if(trumpMaker == 1 || trumpMaker == 3)
							{
								System.out.println("You and your partner got euchred!");
								team24Score += 2;
								sleep(3000);
							}
						}
					}

					numOfGames ++;
				}
			}
		}
	}

	public static void chooseTrump() throws InterruptedException  
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

		System.out.println("");

		int i;
		for(i = 0; i < 4;)
		{
			choosingTrump1 = true;

			if(play == 1)
			{
				while(true)
				{
					System.out.print("\n\n\"PASS\" or \"PICK\": ");
					String input = Input.next();

					if(input.equalsIgnoreCase("pass"))
					{
						System.out.println(" ");
						play = 2;
						sleep(2000);
						//System.out.println(i);
						i = i + 1;
						//System.out.println(i);
						break;
					}
					else if(input.equalsIgnoreCase("pick"))
					{
						if(dealer == 3)
						{
							System.out.println("You told your partner to pick it up so you will go alone");
							Trump = proposedTrump;
							pickUpCard(1);
							//System.out.println("Trump is now " + Trump);
							trumpMaker = 1;
							choosingTrump1 = false;
							i = 6;
						}
						else
						{
							Trump = proposedTrump;
							pickUpCard(1);
							//System.out.println("Trump is now " + Trump);
							trumpMaker = 1;
							choosingTrump1 = false;
							i = 6;
						}
						System.out.print("Would you like to play alone? \"Y\" or \"N\": ");
						String userInput = Input.next();

						if(userInput.equalsIgnoreCase("y"))
						{
							player1SoloStatus = true;
						}
						else
						{
							player1SoloStatus = false;
						}
						break;


					}
					else if(input.equalsIgnoreCase("debug"))
					{
						debug();
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
					if(player2Suit == proposedTrump && p2MaxScore >= randInt(14, 15))
					{
						sleep(2000);
						System.out.println("Player 2 tells dealer to pick it up and will go alone");
						Trump = proposedTrump;
						trumpMaker = 2;
						choosingTrump1 = false;
						player2SoloStatus = true;
						pickUpCard(2);
						break;
					}
					else 
					{
						System.out.println("Player 2 passes");
						sleep(2000);
						play = 3;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else if(dealer == 2)
				{
					if(player2Suit == proposedTrump && p2MaxScore >= randInt(7, 9))
					{
						if(player2Suit == proposedTrump && p2MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 2 is dealer so they will pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 2;
							choosingTrump1 = false;
							player2SoloStatus = true;
							pickUpCard(2);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 2 is the dealer and will pick it up");
							Trump = proposedTrump;
							trumpMaker = 2;
							choosingTrump1 = false;
							pickUpCard(2);
							break;
						}
					}
					else
					{
						System.out.println("Player 2 passes");
						sleep(2000);
						play = 3;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else
				{
					if(player2Suit == proposedTrump && p2MaxScore >= randInt(7, 9))
					{
						if(player2Suit == proposedTrump && p2MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 2 tells dealer to pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 2;
							choosingTrump1 = false;
							player2SoloStatus = true;
							pickUpCard(2);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 2 tells dealer to pick it up");
							Trump = proposedTrump;
							trumpMaker = 2;
							choosingTrump1 = false;
							pickUpCard(2);
							break;
						}
					}
					else 
					{
						System.out.println("Player 2 passes");
						sleep(2000);
						play = 3;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
			}//End player 2 trump choosing

			else if(play == 3)
			{
				if(player3Partner == dealer)
				{
					if(player3Suit == proposedTrump && p3MaxScore >= randInt(14, 15))
					{
						sleep(2000);
						System.out.println("Player 3 tells dealer to pick it up and will go alone");
						Trump = proposedTrump;
						trumpMaker = 3;
						choosingTrump1 = false;
						player3SoloStatus = true;
						pickUpCard(3);
						break;
					}
					else 
					{
						System.out.println("Player 3 passes");
						sleep(2000);
						play = 4;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else if(dealer == 3)
				{
					if(player3Suit == proposedTrump && p3MaxScore >= randInt(7, 9))
					{
						if(player3Suit == proposedTrump && p3MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 3 is dealer so they will pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 3;
							choosingTrump1 = false;
							player3SoloStatus = true;
							pickUpCard(3);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 3 is the dealer and will pick it up");
							Trump = proposedTrump;
							trumpMaker = 3;
							choosingTrump1 = false;
							pickUpCard(3);
							break;
						}
					}
					else
					{
						System.out.println("Player 3 passes");
						sleep(2000);
						play = 4;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else
				{
					if(player3Suit == proposedTrump && p3MaxScore >= randInt(7, 9))
					{
						if(player3Suit == proposedTrump && p3MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 3 tells dealer to pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 3;
							choosingTrump1 = false;
							player3SoloStatus = true;
							pickUpCard(3);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 3 tells dealer to pick it up");
							Trump = proposedTrump;
							trumpMaker = 3;
							choosingTrump1 = false;
							pickUpCard(3);
							break;
						}
					}
					else 
					{
						System.out.println("Player 3 passes");
						sleep(2000);
						play = 4;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
			}//End player 3 trump choosing

			else if(play == 4)
			{
				if(player4Partner == dealer)
				{
					if(player4Suit == proposedTrump && p4MaxScore >= randInt(14, 15))
					{
						sleep(2000);
						System.out.println("Player 4 tells dealer to pick it up and will go alone");
						Trump = proposedTrump;
						trumpMaker = 4;
						choosingTrump1 = false;
						player4SoloStatus = true;
						pickUpCard(4);
						break;
					}
					else 
					{
						sleep(2000);
						System.out.println("Player 4 passes");
						sleep(2000);
						play = 1;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else if(dealer == 4)
				{
					if(player4Suit == proposedTrump && p4MaxScore >= randInt(7, 9))
					{
						if(player4Suit == proposedTrump && p4MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 4 is dealer so they will pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 4;
							choosingTrump1 = false;
							player4SoloStatus = true;
							pickUpCard(4);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 4 is the dealer and will pick it up");
							Trump = proposedTrump;
							trumpMaker = 4;
							choosingTrump1 = false;
							pickUpCard(4);
							break;
						}
					}
					else
					{
						System.out.println("Player 4 passes");
						sleep(2000);
						play = 1;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
				else
				{
					if(player4Suit == proposedTrump && p4MaxScore >= randInt(7, 9))
					{
						if(player4Suit == proposedTrump && p4MaxScore >= randInt(14, 15))
						{
							sleep(2000);
							System.out.println("Player 4 tells dealer to pick it up and will go alone");
							Trump = proposedTrump;
							trumpMaker = 4;
							choosingTrump1 = false;
							player4SoloStatus = true;
							pickUpCard(4);
							break;
						}
						else 
						{
							sleep(2000);
							System.out.println("Player 4 tells dealer to pick it up");
							Trump = proposedTrump;
							trumpMaker = 4;
							choosingTrump1 = false;
							pickUpCard(4);
							break;
						}
					}
					else 
					{
						System.out.println("Player 4 passes");
						sleep(2000);
						play = 1;
						//System.out.println(i);
						i++;
						//System.out.println(i);
						//continue;
					}
				}
			}//End player 4 trump choosing
		}


		if(choosingTrump1 == true)
		{
			cardScores(5);
			choosingTrump1 = false;
			choosingTrump2 = true;

			int f;
			for(f = 0; f < 5; f++)
			{
				if(play == 1) 
				{
					while(true)
					{
						System.out.println("\nTo call a trump, type in one of the following: " + "1 - " + WHITE_BACKGROUND_BRIGHT +  BLACK_BOLD + " ♠ " + RESET + "   2 - " + WHITE_BACKGROUND_BRIGHT +  RED_BOLD_BRIGHT + " ♥ " + RESET + "   3 - " + WHITE_BACKGROUND_BRIGHT +  BLACK_BOLD + " ♣ " + RESET + "   4 - " + WHITE_BACKGROUND_BRIGHT +  RED_BOLD_BRIGHT + " ♦ " + RESET + "   Or type \"PASS\"");
						System.out.print("Your selection: ");

						String userInput = Input.next();

						if(userInput.equalsIgnoreCase("1"))
						{
							if(proposedTrump != "♠")
							{
								Trump = "♠";
								//System.out.println("Trump is now: " + Trump);
								trumpMaker = 1;
								choosingTrump2 = false;
								f = 6;
								break;
							}
							else
							{
								System.out.println("You cannot choose this suit because it has already been turned down");
								continue;
							}
						}
						else if(userInput.equalsIgnoreCase("2"))
						{
							if(proposedTrump != "♥")
							{
								Trump = "♥";
								//System.out.println("Trump is now: " + Trump);
								trumpMaker = 1;
								choosingTrump2 = false;
								f = 6;
								break;
							}
							else
							{
								System.out.println("You cannot choose this suit because it has already been turned down");
								continue;
							}
						}
						else if(userInput.equalsIgnoreCase("3"))
						{
							if(proposedTrump != "♣")
							{
								Trump = "♣";
								//System.out.println("Trump is now: " + Trump);
								trumpMaker = 1;
								choosingTrump2 = false;
								f = 6;
								break;
							}
							else
							{
								System.out.println("You cannot choose this suit because it has already been turned down");
								continue;
							}
						}
						else if(userInput.equalsIgnoreCase("4"))
						{
							if(proposedTrump != "♦")
							{
								Trump = "♦";
								//System.out.println("Trump is now: " + Trump);
								trumpMaker = 1;
								choosingTrump2 = false;
								f = 6;
								break;
							}
							else
							{
								System.out.println("You cannot choose this suit because it has already been turned down");
								continue;
							}
						}
						else if(userInput.equalsIgnoreCase("pass"));
						{
							play = 2;
							break;
						}
					}
				}

				else if(play == 2)
				{
					if(dealer == 2)
					{
						System.out.println("Player 2 is dealer and must choose a trump");
						sleep(2000);
						System.out.println("Player 2 sets trump to be:" + player2Suit);
						Trump = player2Suit;
						trumpMaker = 2;
						choosingTrump2 = false;
						break;
					}
					else
					{
						if(p2MaxScore > randInt(8, 9) && player2Suit != proposedTrump)
						{
							System.out.println("Player 2 sets trump to be: " + player2Suit);
							Trump = player2Suit;
							trumpMaker = 2;
							choosingTrump2 = false;
							break;
						}
						else
						{
							System.out.println("Player 2 Passes");
							play = 3;
						}
					}
				}

				else if(play == 3)
				{
					if(dealer == 3)
					{
						System.out.println("Player 3 is dealer and must choose a trump");
						sleep(2000);
						System.out.println("Player 3 sets trump to be:" + player3Suit);
						Trump = player3Suit;
						trumpMaker = 3;
						choosingTrump2 = false;
						break;
					}
					else
					{
						if(p3MaxScore > randInt(8, 9) && player3Suit != proposedTrump)
						{
							System.out.println("Player 3 sets trump to be: " + player3Suit);
							Trump = player3Suit;
							trumpMaker = 3;
							choosingTrump2 = false;
							break;
						}
						else
						{
							System.out.println("Player 3 Passes");
							play = 4;
						}
					}
				}

				else if(play == 4)
				{
					if(dealer == 4)
					{
						System.out.println("Player 4 is dealer and must choose a trump");
						sleep(2000);

						if(player4Suit == proposedTrump)
						{
							System.out.println("Player 4 sets trump to be:" + player4Suit);
							Trump = player4Suit;
							trumpMaker = 4;
							choosingTrump2 = false;
							break;
						}
						else
						{
							while(true)
							{
								int randChoice = randInt(1, 4);
								if(randChoice == 1)
								{
									Trump = "♥";
								}
								else if(randChoice == 2)
								{
									Trump = "♦";
								}
								else if(randChoice == 3)
								{
									Trump = "♣";
								}
								else if(randChoice == 4)
								{
									Trump = "♠";
								}

								if(Trump != proposedTrump)
								{
									break;
								}
							}

							System.out.println("Player 4 sets trump to be:" + Trump);
							trumpMaker = 4;
							choosingTrump2 = false;
							break;
						}
					}
					else
					{
						if(p4MaxScore > randInt(8, 9) && player4Suit != proposedTrump)
						{
							System.out.println("Player 4 sets trump to be: " + player4Suit);
							Trump = player4Suit;
							trumpMaker = 4;
							choosingTrump2 = false;
							break;
						}
						else
						{
							System.out.println("Player 4 Passes");
							play = 1;
						}
					}
				}
			}
		} 

		cardScores(5);
	}

	public static void printPlayerCards(int player) throws InterruptedException 
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

		if(!choosingTrump1 && !choosingTrump2)
		{
			if(darkMode == true)
			{
				System.out.print("\n      ");
				for(int i = 0; i < player1Cards.size(); i++)
				{
					System.out.print(DARK_MODE + player1Cards.get(i) + " " + RESET + (i + 1) + " ");
				}
			}
			else if(darkMode == false)
			{
				System.out.print("\n      ");
				for(int i = 0; i < player1Cards.size(); i++)
				{
					System.out.print(LIGHT_MODE + player1Cards.get(i) + " " + RESET + (i + 1) + " ");
				}
			}
		}
	}

	public static void printStartTable() throws InterruptedException 
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

		if(dealer == 2)
		{
			System.out.println("\n                Player 3\n"
					+ "\n"
					+ "\n                  " 
					+ "\n"
					+ " Player 2       " + kittyCard +  "        Player 4\n"
					+ "  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "          "
					+ "\n\n\n"
					+ "\n"
					+ "                  You");
		}
		else if(dealer == 1)
		{
			System.out.println("\n                Player 3\n"
					+ "\n                  "
					+ "\n"
					+ " Player 2       " + kittyCard +  "        Player 4\n"
					+ "  "
					+ "\n                "
					+ "\n"
					+ "\n" 
					+ "\n                  You\n                 " + GREEN_BOLD_BRIGHT + "DEALER" + RESET);
		}
		else if(dealer == 4)
		{
			System.out.println("\n                Player 3\n"
					+ "\n                   "
					+ "\n"
					+ " Player 2       " + kittyCard +  "        Player 4\n"
					+ "                             " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "\n                "
					+ "\n"
					+ "\n" 
					+ "\n                  You");
		}
		else if(dealer == 3)
		{
			System.out.println("\n                Player 3\n" + "             " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "\n                  "
					+ "\n"
					+ " Player 2       " + kittyCard +  "        Player 4\n"
					+ " "
					+ "\n                "
					+ "\n"
					+ "\n" 
					+ "\n                  You");
		}


		printPlayerCards(1);
	}

	public static void printTable() throws InterruptedException 
	{
		for(int i = 0; i < 4; i++)
		{
			tableList.set(i, cardsOnTable[i]);
		}


		String tableTrump = null;

		if(Trump == "♥" || Trump == "♦")
		{
			tableTrump = WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " + Trump + " " + RESET;
		}
		else if(Trump == "♣" || Trump == "♠")
		{
			tableTrump = WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + Trump + " " + RESET;
		}

		for(int i = 0; i < 4; i++)
		{
			if(tableList.get(i).contains("♥") || tableList.get(i).contains("♦"))
			{
				tableList.set(i, WHITE_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + " " + cardsOnTable[i] + " " + RESET);
			}
			else if(tableList.get(i).contains("♣") || tableList.get(i).contains("♠"))
			{
				tableList.set(i, WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + " " + cardsOnTable[i] + " " + RESET);
			}
			else
			{
				tableList.set(i, RESET + "    ");
			}
		}

		sleep(1500);

		if(dealer == 2)
		{
			System.out.println("\n\n\n                Player 3\n"
					+ "\n                  " + tableList.get(2) 
					+ "\n"
					+ " Player 2  " + tableList.get(1) + "        " + tableList.get(3) +  "     Player 4\n"
					+ "  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "\n                " + tableList.get(0)
					+ "                                   Trump: " + tableTrump + "          Player " + trumpMaker + " made trump" 
					+ "\n                                                       1 & 3: " + team13Tricks + " Tricks     " + team13Score + "/" + pointsInGame + " Points"
					+ "\n                                                       2 & 4: " + team24Tricks + " Tricks     " + team24Score + "/" + pointsInGame + " Points"
					+ "\n                  You");
		}
		else if(dealer == 1)
		{
			System.out.println("\n\n\n                Player 3\n"
					+ "\n                  " + tableList.get(2) 
					+ "\n"
					+ " Player 2  " + tableList.get(1) + "        " + tableList.get(3) +  "     Player 4\n"
					+ "  "
					+ "\n                " + tableList.get(0)
					+ "                                   Trump: " + tableTrump + "          Player " + trumpMaker + " made trump" 
					+ "\n                                                       1 & 3: " + team13Tricks + " Tricks     " + team13Score + "/" + pointsInGame + " Points"
					+ "\n                                                       2 & 4: " + team24Tricks + " Tricks     " + team24Score + "/" + pointsInGame + " Points"
					+ "\n                  You\n                  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET);
		}
		else if(dealer == 4)
		{
			System.out.println("\n\n\n                Player 3\n"
					+ "\n                  " + tableList.get(2) 
					+ "\n"
					+ " Player 2  " + tableList.get(1) + "        " + tableList.get(3) +  "     Player 4\n"
					+ "                                  " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "\n                " + tableList.get(0)
					+ "                                   Trump: " + tableTrump + "          Player " + trumpMaker + " made trump" 
					+ "\n                                                       1 & 3: " + team13Tricks + " Tricks     " + team13Score + "/" + pointsInGame + " Points"
					+ "\n                                                       2 & 4: " + team24Tricks + " Tricks     " + team24Score + "/" + pointsInGame + " Points"
					+ "\n                  You");
		}
		else if(dealer == 3)
		{
			System.out.println("\n\n\n                Player 3\n" + "                " + GREEN_BOLD_BRIGHT + "DEALER" + RESET
					+ "\n                  " + tableList.get(2) 
					+ "\n"
					+ " Player 2  " + tableList.get(1) + "        " + tableList.get(3) +  "     Player 4\n"
					+ " "
					+ "\n                " + tableList.get(0)
					+ "                                   Trump: " + tableTrump + "          Player " + trumpMaker + " made trump" 
					+ "\n                                                       1 & 3: " + team13Tricks + " Tricks     " + team13Score + "/" + pointsInGame + " Points"
					+ "\n                                                       2 & 4: " + team24Tricks + " Tricks     " + team24Score + "/" + pointsInGame + " Points"
					+ "\n                  You");
		}
		printPlayerCards(1);

		//System.out.println("Suit lead: " + suitLead);

	}

	public static void resetTable() throws InterruptedException
	{
		cardsOnTable[0] = "    ";
		cardsOnTable[1] = "    ";
		cardsOnTable[2] = "    ";
		cardsOnTable[3] = "    ";

		cardsOnTableScores[0] = 0;
		cardsOnTableScores[1] = 0;
		cardsOnTableScores[2] = 0;
		cardsOnTableScores[3] = 0;

		suitLead = "";
	}

	public static void resetDeck() throws InterruptedException 
	{
		cards = new ArrayList<String>(Arrays.asList(
				"9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", 
				"9♦", "10♦", "J♦", "Q♦", "K♦", "A♦", 
				"9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", 
				"9♠", "10♠", "J♠", "Q♠", "K♠", "A♠"));
	}

	public static int  randInt(int min, int max) throws InterruptedException
	{
		int randomNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);

		return randomNumber;
	}

	public static void sleep(int miliSeconds) throws InterruptedException
	{
		Thread.sleep(miliSeconds);
	}

	public static void debug() throws InterruptedException 
	{

		String timeStamp = new SimpleDateFormat("MM.dd.HH.mm").format(new java.util.Date());
		String filepath = directory +  "\\Euchre Log " + timeStamp + "Dealer - " + dealer + ".txt";

		try 
		{
			FileWriter debugFile = new FileWriter(filepath);
			debugFile.write("\nPlayer 1 cards: " + player1Cards
					+ "\nPlayer 1 suits: " + player1Suits
					+ "\nPlayer 1 card scores: " + player1CardScores
					+ "\n\nPlayer 2 cards: " + player2Cards
					+ "\nPlayer 2 suit: " + player2Suit
					+ "\nPlayer 2 suits: " + player2Suits
					+ "\nPlayer 2 card scores: " + player2CardScores
					+ "\n\nPlayer 3 cards: " + player3Cards
					+ "\nPlayer 3 suit: " + player3Suit
					+ "\nPlayer 3 suits: " + player3Suits
					+ "\nPlayer 3 card scores: " + player3CardScores
					+ "\n\nPlayer 4 cards: " + player4Cards
					+ "\nPlayer 4 suit: " + player4Suit
					+ "\nPlayer 4 suits: " + player4Suits
					+ "\nPlayer 4 card scores: " + player4CardScores
					+ "\n\nProposed Trump:" + proposedTrump
					+ "\nTrump: " + suitLead
					+ "\nDealer: " + dealer);


			debugFile.close();
		} 
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void chooseTrumpLog() throws InterruptedException
	{
		if(debugLog == true)
		{
			String timeStamp = new SimpleDateFormat("MM.dd.HH.mm.ss").format(new java.util.Date());
			String filepath = directory +  "\\" + timeStamp + " - choosingTrumpLog " + dealer + ".txt";

			try 
			{
				FileWriter debugFile = new FileWriter(filepath);
				debugFile.write("Player 1 cards: " + player1Cards
						+ "\nPlayer 1 suits: " + player1Suits
						+ "\nPlayer 1 card scores: " + player1CardScores
						+ "\n\nPlayer 2 cards: " + player2Cards
						+ "\nPlayer 2 suit: " + player2Suit
						+ "\nPlayer 2 suits: " + player2Suits
						+ "\nPlayer 2 card scores: " + player2CardScores
						+ "\n\nPlayer 3 cards: " + player3Cards
						+ "\nPlayer 3 suit: " + player3Suit
						+ "\nPlayer 3 suits: " + player3Suits
						+ "\nPlayer 3 card scores: " + player3CardScores
						+ "\n\nPlayer 4 cards: " + player4Cards
						+ "\nPlayer 4 suit: " + player4Suit
						+ "\nPlayer 4 suits: " + player4Suits
						+ "\nPlayer 4 card scores: " + player4CardScores
						+ "\n\nProposed Trump:" + proposedTrump
						+ "\nTrump: " + suitLead
						+ "\nDealer: " + dealer);


				debugFile.close();
			} 
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public static void gameLoopLog() throws InterruptedException
	{
		if(debugLog == true)
		{
			String timeStamp = new SimpleDateFormat("MM.dd.HH.mm.ss").format(new java.util.Date());
			String filepath = directory +  "\\" + timeStamp + " - gameLoopLog " + dealer + ".txt";

			try 
			{
				FileWriter debugFile = new FileWriter(filepath);
				debugFile.write("Player 1 cards: " + player1Cards
						+ "\nPlayer 1 suits: " + player1Suits
						+ "\nPlayer 1 card scores: " + player1CardScores
						+ "\n\nPlayer 2 cards: " + player2Cards
						+ "\nPlayer 2 suit: " + player2Suit
						+ "\nPlayer 2 suits: " + player2Suits
						+ "\nPlayer 2 card scores: " + player2CardScores
						+ "\n\nPlayer 3 cards: " + player3Cards
						+ "\nPlayer 3 suit: " + player3Suit
						+ "\nPlayer 3 suits: " + player3Suits
						+ "\nPlayer 3 card scores: " + player3CardScores
						+ "\n\nPlayer 4 cards: " + player4Cards
						+ "\nPlayer 4 suit: " + player4Suit
						+ "\nPlayer 4 suits: " + player4Suits
						+ "\nPlayer 4 card scores: " + player4CardScores
						+ "\n\nProposed Trump:" + proposedTrump
						+ "\nTrump: " + suitLead
						+ "\nDealer: " + dealer);


				debugFile.close();
			} 
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}
}
