package euchre;
import java.util.*;

public class Euchre_Singleplayer {
	
	public static String[] Cards = {"9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", 
								    "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦", 
								    "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", 
								    "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠"};
	
	public static String[] DealerCards = {"9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", 
										  "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦", 
										  "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", 
										  "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠"};
	
	public static ArrayList<String> player1Cards = new ArrayList<String>();
	public static ArrayList<String> player2Cards = new ArrayList<String>();
	public static ArrayList<String> player3Cards = new ArrayList<String>();
	public static ArrayList<String> player4Cards = new ArrayList<String>();
	public static ArrayList<String> kitty = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		dealCards();
		System.out.println("P1 = " + player1Cards);
		System.out.println("P2 = " + player2Cards);
		System.out.println("P3 = " + player3Cards);
		System.out.println("P4 = " + player4Cards);
		System.out.println("Kitty = " + kitty);
	}
	
	public static void dealCards()
	{
		int randCard;
		
		for(int i = 0; i < 5; i++)
		{
			while(true)
			{
				
				randCard = (int) (Math.random( )*23) + 0;
				
				//System.out.println(randCard);
				
				if(DealerCards[randCard] == null) {}
				
				else
				{
					player1Cards.add(DealerCards[randCard]);
					DealerCards[randCard] = null;
					break;
				}
			}
			
			while(true)
			{
				randCard = (int) (Math.random( )*23) + 0;
				
				if(DealerCards[randCard] == null) {}
				
				else
				{
					player2Cards.add(DealerCards[randCard]);
					DealerCards[randCard] = null;
					break;
				}
			}
			while(true)
			{
				randCard = (int) (Math.random( )*23) + 0;
				
				if(DealerCards[randCard] == null) {}
				
				else
				{
					player3Cards.add(DealerCards[randCard]);
					DealerCards[randCard] = null;
					break;
				}
			}
			while(true)
			{
				randCard = (int) (Math.random( )*23) + 0;
				
				if(DealerCards[randCard] == null) {}
				
				else
				{
					player4Cards.add(DealerCards[randCard]);
					DealerCards[randCard] = null;
					break;
				}
			}
			
			
		}
		
		for(int i = 0; i < Cards.length; i++)
		{
			while(true)
			{
				if(DealerCards[i] == null) {}
				else
				{
					kitty.add(DealerCards[i]);
					//DealerCards[i] = null;
					break;
				}
			}
		}
	}
	
	public static void resetDeck()
	{
		for(int i = 0; i < Cards.length; i++)
		{
			DealerCards[i] = Cards[i];
		}
	}

}
