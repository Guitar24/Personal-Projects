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
	
	public static int[] player2TrumpNum = {0, 0, 0, 0};
	public static int[] player3TrumpNum = {0, 0, 0, 0};
	public static int[] player4TrumpNum = {0, 0, 0, 0};
	
	public static int play;
	public static int dealer = 4;
	
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
	
	
	public static Scanner Input = new Scanner(System.in);
	
	//Colours
	
	public static final String ESC = "\033[";
	
	public static final String RESET = "\033[0m";  // Text Reset
	
	public static final String BOXING = "\033[0;51m";   // BLACK
	
	public static final String BLACK = "\033[0;30m";   // BLACK
	
	public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
	
	public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
	public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
	
	public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		//Turns on caps lock
		Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
		
		//Prints out welcome message
		System.out.println("Welcome to Euchre!");
		
		//Runs the menu method
		int menuInput = menu();
		
		//tests for input from menu
		if(menuInput == 1)
		{
			startGame();
		}
		else if(menuInput == 2)
		{
			
		}
		else if(menuInput == 3)
		{
			//Prints out goodbye message
			System.out.println("Come again soon!");
			//Turns off caps lock
			Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
			//closes program
			System.exit(0);
		}
	}
	
	private static int menu() 
	{
		while(true)
		{
			System.out.println("\n"
					+ "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n"
					+ "█ S - Start Game  █\n"
					+ "█ H - How to play █\n"
					+ "█ Q - Quit game   █\n"
					+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.print("Input one of the options above: ");
			String menuInput = Input.next();
			
			if(menuInput.equalsIgnoreCase("s"))
			{
				return 1;
			}
			else if(menuInput.equalsIgnoreCase("h"))
			{
				return 2;
			}
			else if(menuInput.equalsIgnoreCase("q"))
			{
				return 3;
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
		
		printTable();
		
		System.out.print("\nPlayer 2 cards: " + player2Cards);
		System.out.println("Player 2 suit: " + player2Suit  + Arrays.toString(player2TrumpNum));
		
		System.out.print("Player 3 cards: " + player3Cards);
		System.out.println("Player 3 suit: " + player3Suit + Arrays.toString(player3TrumpNum));
		
		System.out.print("Player 4 cards: " + player4Cards);
		System.out.println("Player 4 suit: " + player4Suit + Arrays.toString(player4TrumpNum));
		
		System.out.println("Tell Dealer to PICK IT UP, or PASS");
		
		System.out.println(proposedTrump);
		
		while(true)
		{
			System.out.print("\"PICK\" or \"PASS\": ");
			
			play = 1;
			
			String trumpChoice = Input.next();
			
			if(trumpChoice.equalsIgnoreCase("pass"))
			{
				play = 2;
				if(dealer == 4)
				{
					if(player2Suit == proposedTrump && p2Max >= 4)
					{
						pickUpCard(2);
					}
					else 
					{
						System.out.println("Player 2 Passes");
						if(player3Suit == proposedTrump && p3Max >= 3)
						{
							pickUpCard(3);
						}
						else 
						{
							System.out.println("Player 3 Passes");
							if(player4Suit == proposedTrump && p4Max >= 3)
							{
								pickUpCard(4);
							}
							else 
							{
								
							}
						}
					}
				}
				
				break;
			}
			else if(trumpChoice.equalsIgnoreCase("pick"))
			{
				pickUpCard(1); 
				break;
			}
			else
			{
				System.out.println("Invalid input");
			}
		}
		
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
				System.out.println(player4Cards);
				
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
	
	public static void printPlayerCards(int playerNum)
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
	
	public static void printTable()
	{
		if(dealer == 4)
		{
			System.out.println("\n                Player 3\n"
							 + "\n"
							 + "\n"
							 + "\n"
							 + " Player 4         " + topCard + "         Player 2\n"
							 + "  " + GREEN_BOLD_BRIGHT + "DEALER\n" + RESET
							 + "\n"
							 + "\n"
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
}