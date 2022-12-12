package euchre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ref {


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

	public static String[] cardsOnTable = {"    ", "    ", "    ", "    "};
	
	public static int play;
	public static int dealer = 4;
	
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

		/*
		System.out.print("\nPlayer 2 cards: " + player2Cards);
		System.out.println("Player 2 suit: " + player2Suit  + Arrays.toString(player2TrumpNum));
		
		System.out.print("Player 3 cards: " + player3Cards);
		System.out.println("Player 3 suit: " + player3Suit + Arrays.toString(player3TrumpNum));
		
		System.out.print("Player 4 cards: " + player4Cards);
		System.out.println("Player 4 suit: " + player4Suit + Arrays.toString(player4TrumpNum));
		
		;
		
		System.out.println(proposedTrump);
		*/
		
		
		while(true)
		{
			System.out.println("\n\nThe top card is: " + topCard);
			System.out.println("\nTell Dealer to PICK IT UP, or PASS");
			System.out.print("\n\"PICK\" or \"PASS\": ");
			
			play = 1;
			
			String trumpChoice = Input.next();
			
			if(trumpChoice.equalsIgnoreCase("pass"))
			{
				play = 2;
				if(dealer == 4)
				{
					if(player2Suit == proposedTrump && p2Max >= 4)
					{
						Thread.sleep(250);
						System.out.println("Player 2 tells dealer to PICK IT UP");
						//pickUpCard(2);
					}
					else 
					{
						Thread.sleep(250);
						System.out.println("Player 2 Passes");
						if(player3Suit == proposedTrump && p3Max >= 2)
						{
							Thread.sleep(250);
							System.out.println("Player 3 tells dealer to PICK IT UP");
							//pickUpCard(3);
						}
						else 
						{
							Thread.sleep(250);
							System.out.println("Player 3 Passes");
							if(player4Suit == proposedTrump && p4Max >= 2)
							{
								Thread.sleep(250);
								System.out.println("Player 4 PICKS IT UP");
								//pickUpCard(4);
							}
							else 
							{
							
								System.out.println("Player 4 passes");
								
								
								
							}
						}
					}
				}
				
				break;
				
				
				
				
				
				
				
				
				
			}
			else if(trumpChoice.equalsIgnoreCase("pick"))
			{
				//pickUpCard(1); 
				break;
			}
			else
			{
				System.out.println("Invalid input");
			}
		}
	}
}

