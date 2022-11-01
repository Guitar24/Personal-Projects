package tic_tac_toe;
import java.util.*;

public class Tic_Tac_Toe_Main {

	//Open scanners
	public static Scanner P1Input = new Scanner(System.in);
	public static Scanner P2Input = new Scanner(System.in);

	//Define Variables
	public static String menuInput;

	public static String Reset = Colour.RESET;

	public static String P1Colour = Colour.CYAN_BOLD_BRIGHT;
	public static String P2Colour = Colour.GREEN_BOLD_BRIGHT;

	public static String Slot0Colour; 
	public static String Slot1Colour; 
	public static String Slot2Colour; 
	public static String Slot3Colour; 
	public static String Slot4Colour; 
	public static String Slot5Colour; 
	public static String Slot6Colour; 
	public static String Slot7Colour; 
	public static String Slot8Colour; 

	public static String P1Symbol;
	public static String P2Symbol; 

	public static int colourInput;
	public static int headsOrTails;
	public static int coinFlip;
	public static int startingPlayer = 0;
	public static int slotInput;
	public static int randSlot;
	public static int gameBoard;

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
		//Introduce game
		System.out.println("Welcome to " + Colour.CYAN_BOLD_BRIGHT + "Tic" + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + "Tac" + Reset + "-" + Colour.CYAN_BOLD_BRIGHT + "Toe!");


		Menu();


	}

	//Places X or O in board baised on user input
	public static void InputSlot(int slot, int player)
	{
		if(startingPlayer == 1)
		{
			P1Symbol = "X";
			P2Symbol = "O";
		}
		else if(startingPlayer == 2)
		{
			P1Symbol =  "O";
			P2Symbol = "X";
		}


		if(player == 1)
		{
			if(slot == 1) {
				slotOne = true;
				slotsUsed[0] = P1Symbol;
			}
			else if(slot == 2) {
				slotTwo = true;
				slotsUsed[1] = P1Symbol;
			}
			else if(slot == 3) {
				slotThree = true;
				slotsUsed[2] = P1Symbol;
			}
			else if(slot == 4) {
				slotFour = true;
				slotsUsed[3] = P1Symbol;
			}
			else if(slot == 5) {
				slotFive = true;
				slotsUsed[4] = P1Symbol;
			}
			else if(slot == 6) {
				slotSix = true;
				slotsUsed[5] = P1Symbol;
			}
			else if(slot == 7) {
				slotSeven = true;
				slotsUsed[6] = P1Symbol;
			}
			else if(slot == 8) {
				slotEight = true;
				slotsUsed[7] = P1Symbol;
			}
			else if(slot == 9) {
				slotNine = true;
				slotsUsed[8] = P1Symbol;
			}
		}

		if(player == 2)
		{
			if(slot == 0) {
				slotOne = true;
				slotsUsed[0] = P2Symbol;
			}
			else if(slot == 1) {
				slotTwo = true;
				slotsUsed[1] = P2Symbol;
			}
			else if(slot == 2) {
				slotThree = true;
				slotsUsed[2] = P2Symbol;
			}
			else if(slot == 3) {
				slotFour = true;
				slotsUsed[3] = P2Symbol;
			}
			else if(slot == 4) {
				slotFive = true;
				slotsUsed[4] = P2Symbol;
			}
			else if(slot == 5) {
				slotSix = true;
				slotsUsed[5] = P2Symbol;
			}
			else if(slot == 6) {
				slotSeven = true;
				slotsUsed[6] = P2Symbol;
			}
			else if(slot == 7) {
				slotEight = true;
				slotsUsed[7] = P2Symbol;
			}
			else if(slot == 8) {
				slotNine = true;
				slotsUsed[8] = P2Symbol;
			}
		}

	}

	public static void PrintBoard()
	{
		if(slotsUsed[0] == " ")
			Slot0Colour = "";
		if(slotsUsed[1] == " ")
			Slot1Colour = "";
		if(slotsUsed[2] == " ")
			Slot2Colour = "";
		if(slotsUsed[3] == " ")
			Slot3Colour = "";
		if(slotsUsed[4] == " ")
			Slot4Colour = "";
		if(slotsUsed[5] == " ")
			Slot5Colour = "";
		if(slotsUsed[6] == " ")
			Slot6Colour = "";
		if(slotsUsed[7] == " ")
			Slot7Colour = "";
		if(slotsUsed[8] == " ")
			Slot8Colour = "";



		if(slotsUsed[0] == P1Symbol)
			Slot0Colour = P1Colour;
		if(slotsUsed[1] == P1Symbol)
			Slot1Colour = P1Colour;
		if(slotsUsed[2] == P1Symbol)
			Slot2Colour = P1Colour;
		if(slotsUsed[3] == P1Symbol)
			Slot3Colour = P1Colour;
		if(slotsUsed[4] == P1Symbol)
			Slot4Colour = P1Colour;
		if(slotsUsed[5] == P1Symbol)
			Slot5Colour = P1Colour;
		if(slotsUsed[6] == P1Symbol)
			Slot6Colour = P1Colour;
		if(slotsUsed[7] == P1Symbol)
			Slot7Colour = P1Colour;
		if(slotsUsed[8] == P1Symbol)
			Slot8Colour = P1Colour;

		if(slotsUsed[0] == P2Symbol)
			Slot0Colour = P2Colour;
		if(slotsUsed[1] == P2Symbol)
			Slot1Colour = P2Colour;
		if(slotsUsed[2] == P2Symbol)
			Slot2Colour = P2Colour;
		if(slotsUsed[3] == P2Symbol)
			Slot3Colour = P2Colour;
		if(slotsUsed[4] == P2Symbol)
			Slot4Colour = P2Colour;
		if(slotsUsed[5] == P2Symbol)
			Slot5Colour = P2Colour;
		if(slotsUsed[6] == P2Symbol)
			Slot6Colour = P2Colour;
		if(slotsUsed[7] == P2Symbol)
			Slot7Colour = P2Colour;
		if(slotsUsed[8] == P2Symbol)
			Slot8Colour = P2Colour;


		System.out.println("       █       █");
		System.out.println("   " + Slot0Colour + slotsUsed[0] + Reset + "   █   " + Slot1Colour + slotsUsed[1] + Reset + "   █   " + Slot2Colour + slotsUsed[2] + Reset);
		System.out.println("       █       █\n▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n       █       █");
		System.out.println("   " + Slot3Colour + slotsUsed[3] + Reset + "   █   " + Slot4Colour + slotsUsed[4] + Reset + "   █   " + Slot5Colour + slotsUsed[5] + Reset);
		System.out.println("       █       █\n▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n       █       █");
		System.out.println("   " + Slot6Colour + slotsUsed[6] + Reset + "   █   " + Slot7Colour + slotsUsed[7] + Reset + "   █   " + Slot8Colour + slotsUsed[8] + Reset);
		System.out.println("       █       █");
	}

	public static void checkIfThreeInRow() throws InterruptedException
	{

		//If Player 1 wins
		if(slotsUsed[0] == P1Symbol && slotsUsed[1] == P1Symbol && slotsUsed[2] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[3] == P1Symbol && slotsUsed[4] == P1Symbol && slotsUsed[5] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[6] == P1Symbol && slotsUsed[7] == P1Symbol && slotsUsed[8] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[0] == P1Symbol && slotsUsed[3] == P1Symbol && slotsUsed[6] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[1] == P1Symbol && slotsUsed[4] == P1Symbol && slotsUsed[7] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[2] == P1Symbol && slotsUsed[5] == P1Symbol && slotsUsed[8] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[0] == P1Symbol && slotsUsed[4] == P1Symbol && slotsUsed[8] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[2] == P1Symbol && slotsUsed[4] == P1Symbol && slotsUsed[6] == P1Symbol)
		{
			System.out.println("Player 1 wins!\n");
			Thread.sleep(1250);
			Menu();
		}


		//If player two wins
		if(slotsUsed[0] == P2Symbol && slotsUsed[1] == P2Symbol && slotsUsed[2] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[3] == P2Symbol && slotsUsed[4] == P2Symbol && slotsUsed[5] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[6] == P2Symbol && slotsUsed[7] == P2Symbol && slotsUsed[8] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[0] == P2Symbol && slotsUsed[3] == P2Symbol && slotsUsed[6] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[1] == P2Symbol && slotsUsed[4] == P2Symbol && slotsUsed[7] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[2] == P2Symbol && slotsUsed[5] == P2Symbol && slotsUsed[8] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[0] == P2Symbol && slotsUsed[4] == P2Symbol && slotsUsed[8] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}
		else if(slotsUsed[2] == P2Symbol && slotsUsed[4] == P2Symbol && slotsUsed[6] == P2Symbol)
		{
			System.out.println("Player 2 wins!\n");
			Thread.sleep(1250);
			Menu();
		}

		if(slotOne == true && slotTwo == true && slotThree == true && slotFour == true && slotFive == true && slotSix == true && slotSeven == true && slotEight == true && slotNine == true)
		{
			System.out.println("It is a draw!");
			Menu();
		}
	}

	public static void CoinFlip() throws InterruptedException
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
				startingPlayer = 1;

				if(startingPlayer == 1)
				{
					P1Symbol = P1Colour + "X" + Colour.RESET;
					P2Symbol = P2Colour +  "O" + Colour.RESET;
				}
				else if(startingPlayer == 2)
				{
					P1Symbol = P1Colour + "O" + Colour.RESET;
					P2Symbol = P2Colour + "X" + Colour.RESET;
				}

				System.out.println("You guessed: " + Colour.CYAN_BOLD_BRIGHT + "HEADS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The coin flipped: " + Colour.CYAN_BOLD_BRIGHT + "HEADS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("You start as: " + P1Symbol);


			}
			if(coinFlip != headsOrTails)
			{
				startingPlayer = 2;

				if(startingPlayer == 1)
				{
					P1Symbol = Colour.GREEN_BOLD_BRIGHT + "X" + Colour.RESET;
					P2Symbol = Colour.BLUE_BOLD_BRIGHT +  "O" + Colour.RESET;
				}
				else if(startingPlayer == 2)
				{
					P1Symbol = Colour.GREEN_BOLD_BRIGHT + "O" + Colour.RESET;
					P2Symbol = Colour.BLUE_BOLD_BRIGHT + "X" + Colour.RESET;
				}

				System.out.println("You guessed: " + Colour.CYAN_BOLD_BRIGHT + "TAILS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The coin flipped: " + Colour.CYAN_BOLD_BRIGHT + "HEADS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The computer starts");
				Thread.sleep(1500);
				System.out.println("You play as: " + P1Symbol);
			}
		}
		else if(coinFlip == 2)
		{
			if(coinFlip == headsOrTails)
			{
				startingPlayer = 1;

				if(startingPlayer == 1)
				{
					P1Symbol = Colour.GREEN_BOLD_BRIGHT + "X" + Colour.RESET;
					P2Symbol = Colour.BLUE_BOLD_BRIGHT +  "O" + Colour.RESET;
				}
				else if(startingPlayer == 2)
				{
					P1Symbol = Colour.GREEN_BOLD_BRIGHT + "O" + Colour.RESET;
					P2Symbol = Colour.BLUE_BOLD_BRIGHT + "X" + Colour.RESET;
				}

				System.out.println("You guessed: " + Colour.CYAN_BOLD_BRIGHT + "TAILS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The coin flipped: " + Colour.CYAN_BOLD_BRIGHT + "TAILS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("You start as: " + P1Symbol);
			}
			if(coinFlip != headsOrTails)
			{
				startingPlayer = 2;

				if(startingPlayer == 1)
				{
					P1Symbol = P1Colour + "X" + Colour.RESET;
					P2Symbol = P1Colour +  "O" + Colour.RESET;
				}
				else if(startingPlayer == 2)
				{
					P1Symbol = P1Colour + "O" + Colour.RESET;
					P2Symbol = P1Colour + "X" + Colour.RESET;
				}

				System.out.println("You guessed: " + Colour.CYAN_BOLD_BRIGHT + "HEADS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The coin flipped: " + Colour.CYAN_BOLD_BRIGHT + "TAILS" + Colour.RESET);
				Thread.sleep(1500);
				System.out.println("The computer starts");
				Thread.sleep(1500);
				System.out.println("You play as: " + P1Symbol);
			}
		}
	}

	public static void SinglePlayer() throws InterruptedException
	{
		CoinFlip();

		//Start playing game
		gameBoard = 0;
		while(true) {
			if(startingPlayer == 1) 
			{
				System.out.println("       █       █\n"
						+ "   1   █   2   █   3\n"
						+ "       █       █\n"
						+ "▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n"
						+ "       █       █\n"
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
					InputSlot(slotInput, 1);
					PrintBoard();
					//System.err.println("break");
					break;
				}
				else
				{
					System.err.println("Invalid input");
				}
			}
			else
			{
				//System.err.println("break");
				break;
			}
		}


		while(gameBoard <= 9)
		{
			while(true)
			{
				randSlot = (int) (Math.random() * 8 + 0);
				//System.out.println(randSlot);
				if(slotsUsed[randSlot] != " ") 
				{

				}
				else 
				{
					InputSlot(randSlot, 2);
					//System.out.println(Arrays.toString(slotsUsed));
					System.out.print("Thinking "); Thread.sleep(500); System.out.print(". ");Thread.sleep(500); System.out.print(". ");Thread.sleep(500); System.out.print(". ");Thread.sleep(500); System.out.print(".\n\n");
					Thread.sleep(500);
					PrintBoard();
					checkIfThreeInRow();
					Thread.sleep(150);
					break;
				}
			}

			gameBoard ++;

			while(true)
			{
				Thread.sleep(1000);
				System.out.print("\nNext input: ");
				slotInput = P1Input.nextInt();
				if(slotsUsed[slotInput - 1] != " ")
				{
					System.out.println("That spot is already taken!");
				}
				else
				{
					InputSlot(slotInput, 1);
					PrintBoard();
					checkIfThreeInRow();
					Thread.sleep(2000);
					break;
				}
			}

			checkIfThreeInRow();

		}
	}

	public static void TwoPlayer() throws InterruptedException
	{
		//CoinFlip();

		startingPlayer = 1;

		//Start playing game
		gameBoard = 0;
		while(true) {
			if(startingPlayer == 1) 
			{
				System.out.println("       █       █\n"
						+ "       █       █\n"
						+ "       █       █\n"
						+ "▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n"
						+ "       █       █\n"
						+ "       █       █\n"
						+ "       █       █\n"
						+ "▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n"
						+ "       █       █\n"
						+ "       █       █\n"
						+ "       █       █\n");
				System.out.print("Player 1 Input: ");
				slotInput = P1Input.nextInt();

				if(slotInput >= 1 && slotInput <= 9)
				{
					InputSlot(slotInput, 1);
					PrintBoard();
					//System.err.println("break");
					break;
				}
				else
				{
					System.err.println("Invalid input");
				}
			}
			else
			{
				//System.err.println("break");
				break;
			}
		}


		while(gameBoard <= 9)
		{
			while(true)
			{
				Thread.sleep(1000);
				System.out.print("\nPlayer 2 Input: ");
				slotInput = P1Input.nextInt();
				if(slotsUsed[slotInput - 1] != " ")
				{
					System.out.println("That spot is already taken!");
				}
				else
				{
					InputSlot(slotInput - 1, 2);
					//System.out.println(Arrays.toString(slotsUsed));
					PrintBoard();
					checkIfThreeInRow();
					Thread.sleep(2000);
					break;
				}
			}

			gameBoard ++;

			while(true)
			{
				Thread.sleep(1000);
				System.out.print("\nPlayer 1 Input: ");
				slotInput = P1Input.nextInt();
				if(slotsUsed[slotInput - 1] != " ")
				{
					System.out.println("That spot is already taken!");
				}
				else
				{
					InputSlot(slotInput, 1);
					//System.out.println(Arrays.toString(slotsUsed));
					PrintBoard();
					checkIfThreeInRow();
					Thread.sleep(2000);
					break;
				}
			}

			checkIfThreeInRow();

		}
	}

	public static void Menu() throws InterruptedException
	{
		slotOne = false;
		slotTwo = false;
		slotThree = false;
		slotFour = false;
		slotFive = false;
		slotSix = false;
		slotSeven = false;
		slotEight = false;
		slotNine = false;
		
		slotsUsed[0] = " ";
		slotsUsed[1] = " ";
		slotsUsed[2] = " ";
		slotsUsed[3] = " ";
		slotsUsed[4] = " ";
		slotsUsed[5] = " ";
		slotsUsed[6] = " ";
		slotsUsed[7] = " ";
		slotsUsed[8] = " ";
		
		//Start main game loop
		while(true)
		{
			//Print out menu
			System.out.println(Colour.GOLD + "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n"
					+ "█ " + Colour.CYAN_BOLD_BRIGHT + " S " + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + " Single Player " + Colour.GOLD + " █\n"
					+ "█ " + Colour.CYAN_BOLD_BRIGHT + " T " + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + " Two Players   " + Colour.GOLD + " █\n"
					+ "█ " + Colour.CYAN_BOLD_BRIGHT + " O " + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + " Options       " + Colour.GOLD + " █\n"
					+ "█ " + Colour.CYAN_BOLD_BRIGHT + " R " + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + " Rules of Game " + Colour.GOLD + " █\n"
					+ "█ " + Colour.CYAN_BOLD_BRIGHT + " Q " + Reset + "-" + Colour.GREEN_BOLD_BRIGHT + " Quit Game     " + Colour.GOLD + " █\n"
					+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█" + Colour.RESET);
			System.out.print(Colour.RESET + "Input one of the options above: " + Colour.GREEN);
			menuInput = P1Input.next();
			System.out.print(Reset);

			//If user selects single player
			if(menuInput.equalsIgnoreCase("s"))
			{
				SinglePlayer();
			}
			//If User selects Multiplayer
			else if(menuInput.equalsIgnoreCase("t"))
			{
				TwoPlayer();
			}
			else if(menuInput.equalsIgnoreCase("o"))
			{
				System.out.println("\n     1     2     3     4     5     6     7     8     9\n    "
						+ Colour.RED_BOLD + "███   " 
						+ Colour.ORANGE + "███   " 
						+ Colour.YELLOW_BOLD_BRIGHT + "███   " 
						+ Colour.GREEN_BOLD_BRIGHT + "███   " 
						+ Colour.CYAN_BOLD_BRIGHT + "███   " 
						+ Colour.BLUE_BOLD_BRIGHT + "███   " 
						+ Colour.ROSY_PINK + "███   " 
						+ Colour.BROWN + "███   " 
						+ Colour.WHITE_BOLD_BRIGHT + "███\n" 
						+ Colour.RESET);

				System.out.print("Input player 1 colour: ");

				colourInput = P1Input.nextInt();
				if(colourInput == 1)
					P1Colour = Colour.RED_BOLD;
				else if (colourInput == 2)
					P1Colour = Colour.ORANGE;
				else if (colourInput == 3)
					P1Colour = Colour.YELLOW_BOLD_BRIGHT;
				else if (colourInput == 4)
					P1Colour = Colour.GREEN_BOLD_BRIGHT;
				else if (colourInput == 5)
					P1Colour = Colour.CYAN_BOLD_BRIGHT;
				else if (colourInput == 6)
					P1Colour = Colour.BLUE_BOLD_BRIGHT;
				else if (colourInput == 7)
					P1Colour = Colour.ROSY_PINK;
				else if (colourInput == 8)
					P1Colour = Colour.BROWN;
				else if (colourInput == 2)
					P1Colour = Colour.WHITE_BOLD_BRIGHT;

				System.out.print("Input player 2 colour: ");

				colourInput = P1Input.nextInt();
				if(colourInput == 1)
					P2Colour = Colour.RED_BOLD;
				else if (colourInput == 2)
					P2Colour = Colour.ORANGE;
				else if (colourInput == 3)
					P2Colour = Colour.YELLOW_BOLD_BRIGHT;
				else if (colourInput == 4)
					P2Colour = Colour.GREEN_BOLD_BRIGHT;
				else if (colourInput == 5)
					P2Colour = Colour.CYAN_BOLD_BRIGHT;
				else if (colourInput == 6)
					P2Colour = Colour.BLUE_BOLD_BRIGHT;
				else if (colourInput == 7)
					P2Colour = Colour.ROSY_PINK;
				else if (colourInput == 8)
					P2Colour = Colour.BROWN;
				else if (colourInput == 2)
					P2Colour = Colour.WHITE_BOLD_BRIGHT;
			}
			//If user selects Rules of the game
			else if(menuInput.equalsIgnoreCase("r"))
			{
				System.out.println("The goal of "
						+ Colour.CYAN_BOLD_BRIGHT + "Tic" 
						+ Reset + "-" 
						+ Colour.GREEN_BOLD_BRIGHT + "Tac" 
						+ Reset + "-" 
						+ Colour.CYAN_BOLD_BRIGHT + "Toe!" 
						+ Colour.RESET 	+ " is to get three of your symbols in a row.\n"
						+ "To input your symbol, type in a number from 1-9 which corresponds to the box you want to place your symbol in.");
				
				Thread.sleep(5000);
				System.out.println("       █       █\n"
								 + "   1   █   2   █   3\n"
								 + "       █       █\n"
								 + "▀▀▀▀▀▀▀█▀▀▀▀▀▀▀█▀▀▀▀▀▀▀\n"
								 + "       █       █\n"
								 + "   4   █   5   █   6\n"
								 + "       █       █\n"
								 + "▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄\n"
								 + "       █       █\n"
								 + "   7   █   8   █   9\n"
								 + "       █       █\n");
				Thread.sleep(5000);
			}
			//If user selects Quit Game
			else if(menuInput.equalsIgnoreCase("q"))
			{
				System.out.println("Come again soon!");
				System.exit(0);
			}
			//If user inputs anything else
			else
			{
				System.err.println("Invalid Input");
				Thread.sleep(50); 
			}
		}
	}
}
