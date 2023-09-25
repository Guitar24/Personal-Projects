package testing;
import java.util.*;

public class Testing_1 {

	public static void main(String[] args) 
	{
		Scanner Input = new Scanner(System.in);

		String newMessage = keyboardShiftEncode(Input);

		System.out.println(newMessage);


	}

	public static String keyboardShiftEncode(Scanner Input)
	{
		char[] row1 = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='};
		char[] row2 = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+'};

		char[] row3 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\'};
		char[] row4 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|'};

		char[] row5 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\''};
		char[] row6 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '\"'};

		char[] row7 = {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};
		char[] row8 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'};

		System.out.print("Enter string to encode: ");

		String messageString = Input.nextLine();

		char[] message = new char[messageString.length()];
		char[] messageEncoded = new char[messageString.length()];

		for(int i = 0; i < messageString.length(); i++)
		{
			message[i] = messageString.charAt(i);
		}

		for(int i = 0; i < message.length; i++)
		{
			messageEncoded[i] = message[i];
		}

		for(int i = 0; i < message.length; i++)
		{
			System.out.println("i = " + i);
			if(messageEncoded[i] != ' ')
			{	
				for(int a = 0; a < row1.length; a++)
				{
					//Searches the first array for character
					if(message[i] == row1[a])
					{

						if(a - 1 == row1.length)
						{
							messageEncoded[i] = row1[0];
							a = 15;
						}
						else
						{
							messageEncoded[i] = row1[a + 1];
							a = 15;
						}

						//Searches the second array for character
						for(int b = 0; b < row2.length; b++)
						{
							if(b - 1 == row1.length)
							{
								messageEncoded[i] = row2[0];
								a = 15;
							}
							else
							{
								messageEncoded[i] = row2[b + 1];
								a = 15;
							}
							//Searches the third array for character
							for(int c = 0; c < row3.length; c++)
							{
								if(c - 1 == row3.length)
								{
									messageEncoded[i] = row3[0];
									a = 15;
								}
								else
								{
									messageEncoded[i] = row3[c + 1];
									a = 15;
								}
								
								//Searches the fourth array for character
								for(int d = 0; d < row4.length; d++)
								{
									if(d - 1 == row4.length)
									{
										messageEncoded[i] = row4[0];
										a = 15;
									}
									else
									{
										messageEncoded[i] = row4[d + 1];
										a = 15;
									}
									
									//Searches the fifth array for character
									for(int e = 0; e < row5.length; e++)
									{
										if(e - 1 == row5.length)
										{
											messageEncoded[i] = row5[0];
											a = 15;
										}
										else
										{
											messageEncoded[i] = row1[e + 1];
											a = 15;
										}
										
										//Searches the sixth array for character
										for(int f = 0; f < row6.length; f++)
										{
											if(f - 1 == row6.length)
											{
												messageEncoded[i] = row6[0];
												a = 15;
											}
											else
											{
												messageEncoded[i] = row6[f + 1];
												a = 15;
											}
											
											//Searches the seventh array for character
											for(int g = 0; g < row7.length; g++)
											{
												if(g - 1 == row7.length)
												{
													messageEncoded[i] = row7[0];
													a = 15;
												}
												else
												{
													messageEncoded[i] = row7[g + 1];
													a = 15;
												}
												
												//Searches the eighth array for character
												for(int h = 0; h < row8.length; h++)
												{
													if(h - 1 == row8.length)
													{
														messageEncoded[i] = row8[0];
														a = 15;
													}
													else
													{
														messageEncoded[i] = row8[h + 1];
														a = 15;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		String encoded = new String(messageEncoded);

		return encoded;
	}//end keyboardShiftEncode

}