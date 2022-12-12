package piglatinTranslator;

import animations.Colours;
import java.util.*;

public class EnglishToPiglatin 
{

	public static void main(String[] args) 
	{
		char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'}; //Array of vowels

		ArrayList<Character> lettersOfWord = new ArrayList<Character>();

		Scanner Input = new Scanner(System.in);

		System.out.print("Input a word: " + Colours.GREEN_BOLD_BRIGHT);
		String word = Input.next(); //Collects word from user

		if(word.equalsIgnoreCase("curly"))
		{
			System.out.println("\n" + Colours.GREEN_BOLD_BRIGHT + word + Colours.RESET + " in pig latin is: " + Colours.CYAN_BOLD_BRIGHT + "curlycue" + Colours.RESET);
		}

		else
		{
			for(int i = 0; i < word.length(); i++)
			{
				lettersOfWord.add(word.charAt(i));
			}
			
			
			for(int i = 0; i < lettersOfWord.size(); i ++)
			{

				if(lettersOfWord.get(0) == vowels[0] || lettersOfWord.get(0) == vowels[1] || lettersOfWord.get(0) == vowels[2] || lettersOfWord.get(0) == vowels[3] || lettersOfWord.get(0) == vowels[4])
				{
					break;
				}

				else 
				{
					char tempChar = lettersOfWord.get(0);
					lettersOfWord.remove(0);
					lettersOfWord.add(tempChar);
				}
			}

			lettersOfWord.add('a');
			lettersOfWord.add('y');

			char[] newWord = new char[lettersOfWord.size()];

			for(int i = 0; i < lettersOfWord.size(); i++)
			{
				newWord[i] = lettersOfWord.get(i);
			}

			String pigLatinWord = new String(newWord);


			System.out.println("\n" + Colours.GREEN_BOLD_BRIGHT + word + Colours.RESET + " in pig latin is: " + Colours.CYAN_BOLD_BRIGHT + pigLatinWord + Colours.RESET);
		}
	}

}
