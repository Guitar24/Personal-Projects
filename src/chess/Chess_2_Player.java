package chess;

import java.util.Arrays;
import animations.Colours;

public class Chess_2_Player {

	public static String[][] piecesOnBoard = {{Colours.BLACK + Colours.WHITE_BACKGROUND +"♜", Colours.BLACK + "♞" + Colours.RESET, Colours.BLACK + "♝" + Colours.RESET, Colours.BLACK + "♛" + Colours.RESET, Colours.BLACK + "♚" + Colours.RESET, Colours.BLACK + "♝" + Colours.RESET, Colours.BLACK + "♞" + Colours.RESET, Colours.BLACK + "♜" + Colours.RESET},
											{"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"},
											{" ", " ", " ", " ", " ", " ", " ", "√"},
											{" ", " ", " ", " ", " ", " ", " ", " "},
											{" ", " ", " ", " ", " ", " ", " ", " "},
											{" ", " ", " ", " ", " ", " ", " ", " "},
											{"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"},
											{"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"}}; 
	
	public static void main(String[] args) 
	{
		System.out.println(Arrays.toString(piecesOnBoard[0]));
		System.out.println(Arrays.toString(piecesOnBoard[1]));
		System.out.println(Arrays.toString(piecesOnBoard[2]));
		System.out.println(Arrays.toString(piecesOnBoard[3]));
		System.out.println(Arrays.toString(piecesOnBoard[4]));
		System.out.println(Arrays.toString(piecesOnBoard[5]));
		System.out.println(Arrays.toString(piecesOnBoard[6]));
		System.out.println(Arrays.toString(piecesOnBoard[7]));
		
		printBoard();
	}
	
	public static void printBoard()
	{
		System.out.println(Colours.WHITE_BACKGROUND + " " + piecesOnBoard[0][0] + " " + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██");
		System.out.println(Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██" + Colours.WHITE + "██");
		System.out.println(Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██");
		System.out.println(Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██" + Colours.WHITE + "██");
		System.out.println(Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██");
		System.out.println(Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██" + Colours.WHITE + "██");
		System.out.println(Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██");
		System.out.println(Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██"  + Colours.WHITE + "██" + Colours.BLACK + "██" + Colours.WHITE + "██");
	}

}
