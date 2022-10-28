package tic_tac_toe;
import java.util.*;

public class Tic_Tac_Toe {
	
		//Open scanners
		public static Scanner P1Input = new Scanner(System.in);
		public static Scanner P2Input = new Scanner(System.in);
		
		//Define Variables
		public static String menuInput;
		
		public static String P1Symbol;
		public static String P2Symbol; 

		public static int headsOrTails;
		public static int coinFlip;
		public static int startingPlayer = 0;
		public static int slotInput;
		public static int randSlot;
		public static int numOfSlotsUsed;
		
		public static boolean slotOne = false;
		public static boolean slotTwo = false;
		public static boolean slotThree = false;
		public static boolean slotFour = false;
		public static boolean slotFive = false;
		public static boolean slotSix = false;
		public static boolean slotSeven = false;
		public static boolean slotEight = false;
		public static boolean slotNine = false;
		
		public static String[] slotsUsed = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
			
	public static void main(String[] args) throws InterruptedException 
	{
		//Define variables
		
		
		

		

		//Introduce game
		System.out.println("Welcome to Tic-Tac-Toe!\nInput one of the following");

		//Start main game loop
		while(true)
		{
			//Print out menu
			System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n"
							 + "█  S - Single Player  █\n"
							 + "█  T - Two Players    █\n"
							 + "█  R - Rules of Game  █\n"
							 + "█  Q - Quit Game      █\n"
							 + "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			menuInput = P1Input.next();

			//If user selects single player
			if(menuInput.equalsIgnoreCase("s"))
			{
				while(true)
				{
					while(true)
					{
						System.out.print("HEADS or TAILS?\nType \"1\" for HEADS or \"2\" for TAILS: ");
						headsOrTails = P1Input.nextInt();

						if(headsOrTails == 1 || headsOrTails == 2)
						{
							break;
						}
						else
						{
							Thread.sleep(50);
							System.err.println("Invalid input");
							Thread.sleep(50);
						}
					}

					coinFlip = (int) (Math.random() * 2 + 1);

					System.out.print("Flipping coin");
					Thread.sleep(500);
					System.out.print(" .");
					Thread.sleep(500);
					System.out.print(" .");
					Thread.sleep(500);
					System.out.print(" .");
					Thread.sleep(500);
					System.out.print(" .\n\n");
					Thread.sleep(500);

					if(coinFlip == 1)
					{
						if(coinFlip == headsOrTails)
						{
							System.out.println("You guessed: HEADS\nThe coin landed on: HEADS\nYou start as x");
							startingPlayer = 1;
						}
						if(coinFlip != headsOrTails)
						{
							System.out.println("You guessed: TAILS\nThe coin landed on: HEADS\nComputer starts as x");
							startingPlayer = 3;
						}
					}
					else if(coinFlip == 2)
					{
						if(coinFlip == headsOrTails)
						{
							System.out.println("You guessed: TAILS\nThe coin landed on: TAILS\nYou start as x");
							startingPlayer = 1;
						}
						if(coinFlip != headsOrTails)
						{
							System.out.println("You guessed: HEADS\nThe coin landed on: TAILS\nComputer starts as x");
							startingPlayer = 3;
						}
					}

					//Start playing game
					while(true) {
						if(startingPlayer == 1) 
						{
							System.out.println("       █       █\n"
											 + "   1   █   2   █   3\n"
											 + "       █       █\n"
											 + "▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n"
											 + "       █       █\r\n"
											 + "   4   █   5   █   6\n"
											 + "       █       █\n"
											 + "▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n"
											 + "       █       █\n"
											 + "   7   █   8   █   9\n"
											 + "       █       █\n");
							System.out.print("Input where you would like to start: ");
							slotInput = P1Input.nextInt();
							
							if(slotInput >= 1 && slotInput <= 9)
							{
								InputSlot(slotInput);
								break;
							}
							else
							{
								System.err.println("Invalid input");
							}
						}
					}
					
					numOfSlotsUsed = 0;
					
					while(numOfSlotsUsed < 10)
					{
						while(true)
						{
							randSlot = (int) (Math.random() * 9 + 1);
							if(slotsUsed[randSlot] != " ")
							{
								break;
							}
						}
						PrintBoard();
						numOfSlotsUsed ++;
					}
					
					


					




					break;

				}
			}
			else if(menuInput.equalsIgnoreCase("t"))
			{
				System.exit(0);
			}
			else if(menuInput.equalsIgnoreCase("r"))
			{
				System.exit(0);
			}
			else if(menuInput.equalsIgnoreCase("q"))
			{
				System.out.println("Come again soon!");
				System.exit(0);
			}
			else
			{
				System.err.println("Invalid Input");
				Thread.sleep(50); 
			}
			
			
		}


		
	}
	
	public static void InputSlot(int slot)
	{
		if(startingPlayer == 1)
		{
			P1Symbol = "x";
			P2Symbol = "O";
		}
		else if(startingPlayer == 3)
		{
			P1Symbol = "O";
			P2Symbol = "x";
		}
		
		if(slot == 1)
		{
			slotOne = true;
			
			slotsUsed[0] = P1Symbol;
		}
		else if(slot == 2)
		{
			slotOne = true;
			
			slotsUsed[1] = P1Symbol;
		}
		else if(slot == 3)
		{
			slotOne = true;
			
			slotsUsed[2] = P1Symbol;
		}
		else if(slot == 4)
		{
			slotOne = true;
			
			slotsUsed[3] = P1Symbol;
		}
		else if(slot == 5)
		{
			slotOne = true;
			
			slotsUsed[4] = P1Symbol;
		}
		else if(slot == 6)
		{
			slotOne = true;
			
			slotsUsed[5] = P1Symbol;
		}
		else if(slot == 7)
		{
			slotOne = true;
			
			slotsUsed[6] = P1Symbol;
		}
		else if(slot == 8)
		{
			slotOne = true;
			
			slotsUsed[7] = P1Symbol;
		}
		else if(slot == 9)
		{
			slotOne = true;
			
			slotsUsed[8] = P1Symbol;
		}
	}
	
	public static void PrintBoard()
	{
		System.out.println("       █       █");
		System.out.println("   " + slotsUsed[0] + "   █   " + slotsUsed[1] + "   █   " + slotsUsed[2]);
		System.out.println("       █       █\n▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n       █       █");
		System.out.println("   " + slotsUsed[3] + "   █   " + slotsUsed[4] + "   █   " + slotsUsed[5]);
		System.out.println("       █       █\n▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n       █       █");
		System.out.println("   " + slotsUsed[6] + "   █   " + slotsUsed[7] + "   █   " + slotsUsed[8]);
		System.out.println("       █       █");
	}
		
	

}
