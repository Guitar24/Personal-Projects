package tic_tac_toe;
import java.util.*;

public class Tic_Tac_Toe {
	
		//Open scanners
		public static Scanner P1Input = new Scanner(System.in);
		public static Scanner P2Input = new Scanner(System.in);
	
		public static boolean slotOne = false;
		public static boolean slotTwo = false;
		public static boolean slotThree = false;
		public static boolean slotFour = false;
		public static boolean slotFive = false;
		public static boolean slotSix = false;
		public static boolean slotSeven = false;
		public static boolean slotEight = false;
		public static boolean slotNine = false;
		
		public static ArrayList<Integer> numsUsed = new ArrayList<Integer>();
			
	public static void main(String[] args) throws InterruptedException 
	{
		//Define variables
		String menuInput;

		int headsOrTails;
		int coinFlip;
		int startingPlayer = 0;
		

		

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
						System.out.print("Input where you would like to start:");
						InputSlot(P1Input.nextInt());
						
						
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
			
			P1Input.close();
			P2Input.close();
		}



		//Prints out blank board
		/*System.out.println("       █       █\n"
						 + "       █       █\n"
						 + "       █       █\n"
						 + "▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n"
						 + "       █       █\n"
						 + "       █       █\n"
						 + "       █       █\n"
						 + "▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n"
						 + "       █       █\n"
						 + "       █       █\n"
						 + "       █       █");
		 */

		//Close scanner
		
	}
	
	public static void InputSlot(int slot)
	{
		if(slot == 1)
		{
			slotOne = true;
			
			numsUsed.add(1);
		}
		else if(slot == 2)
		{
			slotOne = true;
			
			numsUsed.add(2);
		}
		else if(slot == 3)
		{
			slotOne = true;
			
			numsUsed.add(3);
		}
		else if(slot == 4)
		{
			slotOne = true;
			
			numsUsed.add(4);
		}
		else if(slot == 5)
		{
			slotOne = true;
			
			numsUsed.add(5);
		}
		else if(slot == 6)
		{
			slotOne = true;
			
			numsUsed.add(6);
		}
		else if(slot == 7)
		{
			slotOne = true;
			
			numsUsed.add(7);
		}
		else if(slot == 8)
		{
			slotOne = true;
			
			numsUsed.add(8);
		}
		else if(slot == 9)
		{
			slotOne = true;
			
			numsUsed.add(9);
		}
	}
		
	

}
