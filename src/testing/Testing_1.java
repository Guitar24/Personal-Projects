package testing;
import java.util.*;

public class Testing_1 {

	public static void main(String[] args)
	{
		Scanner Input = new Scanner(System.in);

		String newMessage = keyboardShift(Input, 2);

		System.out.println(newMessage);


	}

	public static String keyboardShift(Scanner Input, int encodeOrDecode)
	{
		//All characters on keyboard

		char[] row1 = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='};
		char[] row2 = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+'};

		char[] row3 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\'};
		char[] row4 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|'};

		char[] row5 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\''};
		char[] row6 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '\"'};

		char[] row7 = {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};
		char[] row8 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'};

		char[][] allKeyboard = {row1, row2, row3, row4, row5, row6, row7, row8};

		if(encodeOrDecode == 1)
		{
			System.out.print("Enter string to encode: ");
		}
		else if(encodeOrDecode == 2)
		{
			System.out.print("Enter string to decode: ");
		}

		String messageString = Input.nextLine();//message to encode or decode

		int shift = 1;
		
		try
		{
			System.out.print("Enter shift number: ");
			shift = Input.nextInt();//message to encode
		}
		catch(Exception e)
		{
			System.out.println("Input was not an integer");
		}
		
		if(encodeOrDecode == 2)
		{
			shift = shift * -1;
		}
		
		
		//New arrays same length as message
		char[] message = new char[messageString.length()];
		char[] messageEncoded = new char[messageString.length()];

		//Copies message into arrays
		for(int i = 0; i < messageString.length(); i++)
		{
			message[i] = messageString.charAt(i);
			messageEncoded[i] = message[i];
		}

		//Loops through message
		for(int i = 0; i < message.length;)
		{
			if(messageEncoded[i] != ' ')//only searches keyboard if character is not a space
			{	
				for(int j = 0; j < 8; j++)//Loop through arrays in 2D array
				{
					for(int k = 0; k < allKeyboard[j].length; k++)//loops through characters in array in 2D array
					{
						if(messageEncoded[i] == allKeyboard[j][k])//Finds character
						{
							if((k + shift) >= allKeyboard[j].length)
							{
								messageEncoded[i] = allKeyboard[j][(k + shift) - allKeyboard[j].length];
								i++;
								j = 9;
								break;
							}
							else if((k + shift) < 0)
							{
								int offset = shift - (shift / allKeyboard[j].length);
								System.out.println(offset);
								messageEncoded[i] = allKeyboard[j][(k + shift) + (allKeyboard[j].length)];
								i++;
								j = 9;
								break;
							}
							else
							{
								messageEncoded[i] = allKeyboard[j][k + shift];
								i++;
								j = 9;
								break;
							}
						}
					}//end character loop
				}//end row loop
			}
			i++;
		}//end message loop

		String encoded = new String(messageEncoded);

		return encoded;
	}//end keyboardShiftEncode

}