/**Name: 
 * Course: 
 * Teacher: Mrs. McCaffery
 * Date: 
 * Description: 
 */
package array;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;

/**
 * 
 */
public class Array 
{

	/////////////////////////////////////
	//                                 //
	//         INTEGER CLASSES         //
	//                                 //
	/////////////////////////////////////

	/**Creates a new empty integer array
	 *@param size An integer that determines the size of the empty array
	 *@return newArray empty integer array
	 *@author D. Polach
	 */
	public static int[] createEmptyIntArray(int size)
	{
		return new int[size];
	}

	/**Creates a new integer array populated with random values
	 * @param size An integer that determines the size of the new array
	 * @param min The minimum value in the random array
	 * @param max The maximum value in the random array
	 * @return newArray The new array with random values
	 * @author D. Polach
	 */
	public static int[] createRandomIntArray(int size, int min, int max)
	{
		int[] newArray = new int[size];//Creates new empty array

		for(int i = 0; i < size; i++)//Loops through array
		{
			Random rand = new Random();
			newArray[i] = rand.nextInt((max - min) + 1) + min;//Generates random number for each slot in array

		}//end loop

		return newArray;//returns new random array
	}

	/**Creates a new integer array with user defined values
	 * @param size An integer that determines the size of the new array
	 * @return array The desired array
	 * @author D. Polach
	 */
	public static int[] createUserDefinedIntArray(int size)
	{
		Scanner Input = new Scanner(System.in);

		int[] array = new int[size];

		for(int i = 0; i < size; i++)
		{
			System.out.print("Type in number for array slot " + (i + 1) + ": ");
			int arraySlot = Input.nextInt();
			array[i] = arraySlot;
		}
		return array;

	}

	/**Prints out each value of an array
	 * @param array The array that the user wants printed
	 * @author D. Polach
	 */
	public static void print(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
	}

	/**Prints each element in an array to a file on a single line, separated by commas.
	 * @param myOutput a PrintWriter indicating where to print the information
	 * @param array the array of values to print
	 * @author Mrs McCaffery
	 */
	public static void printArrayToFile(PrintWriter myOutput, int [] array)

	{
		//prints first line
		myOutput.print(array[0]);

		// prints the rest of the elements separated by commas and spaces
		for (int i = 1; i<=array.length-1; i++)
		{
			myOutput.print(", "+ array[i]);
		} 

		myOutput.println(); //brings cursor to a new line

	}// ends printArrayToFile method

	/**Finds the maximum integer value of array
	 * @param array The array that the user wants to find the maximum value of
	 * @return maxPos The position of the maximum value in the array
	 * @author D. Polach
	 */
	public static int findMax(int[] array)
	{
		int maxPos = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] > array[maxPos])
			{
				maxPos = i;
			}
		}

		return maxPos;

	}

	/**Finds the minimum integer value of array
	 * @param array The array that the user wants the minimum value of
	 * @return minPos The position of the minimum value in the array
	 * @author D. Polach
	 */
	public static int findMin(int[] array)
	{
		int minPos = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] < array[minPos])
			{
				minPos = i;
			}
		}

		return minPos;

	}

	/**Swaps 2 elements in an integer array
	 * @param array The original array that the user wants to swap elements in 
	 * @param pos1 The position of the first element
	 * @param pos2 The position of the second element
	 * @author D. Polach
	 */
	public static void swapElements(int[] array, int pos1, int pos2)
	{
		int[] array2 = new int[array.length];

		for(int i = 0; i < array.length; i++)
		{
			array2[i] = array[i];
		}

		int element1 = array[pos1];
		int element2 = array[pos2];

		array[pos1] = element2;
		array[pos2] = element1;

	}

	/**Finds an element in the array and returns its position in the array
	 * @param value What value the user wants to find in the array
	 * @param array The array that the value is in
	 * @return position The position of the value in the array
	 * @author D. Polach
	 */
	public static int findElement(int value, int[] array)
	{
		int position = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				position = i;
				break;
			}
			else if(i == (array.length-1))
			{
				position = -1;
			}
		}

		return position;
	}

	/**Counts the number of times a certain value appears in an array
	 * @param value The value being counted
	 * @param array The array being counted
	 * @return numOfElements The Number of times the element appears in the array
	 * @author D. Polach
	 */
	public static int countElements(int value, int[] array)
	{
		int numOfElements = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				numOfElements ++;
			}
		}

		return numOfElements;
	}

	/**Copies all the values of an array to a new array
	 * @param originalArray The array being copied
	 * @return arrayCopy The copied array
	 * @author D. Polach
	 */
	public static int[] copyArray(int[] originalArray)
	{
		int[] arrayCopy = new int[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			arrayCopy[i] = originalArray[i];
		}

		return arrayCopy;
	}

	/**Checks if all the values in one array match the values of another array
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays contain the same values
	 * @author D. Polach
	 */
	public static boolean checkIfCopy(int[] array1, int[] array2)
	{
		int score = 0;

		if(array1 == array2) 
		{
			return false;
		}

		if(array1.length != array2.length)
		{
			return false;
		}

		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] == array2[i])
			{
				score ++;
			}
		}

		if(score == array1.length) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Checks if two arrays are identical
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays are identical
	 * @author D. Polach
	 */
	public static boolean checkIfIdentical(int[] array1, int[] array2)
	{
		if(array1 == array2) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Replaces an element in array with a new element
	 * @param array The array with the value being replaced
	 * @param value The new element
	 * @param position The position of the old element
	 * @author D. Polach
	 */
	public static void replaceElement(int[] array, int value, int position)
	{
		array[position] = value;
	}

	/**Replaces all the same elements in array with a new value
	 * @param array The array being searched
	 * @param originalValue The value being replaced
	 * @param newValue The new value replacing the old
	 * @author D. Polach
	 */
	public static void replaceElements(int[] array, int originalValue, int newValue)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == originalValue)
			{
				array[i] = newValue;
			}
		}
	}

	/**Inserts a new element in an array and changes the size of the array to incorporate the new value
	 * @param originalArray The original array without the new value
	 * @param value The value being inserted in the array
	 * @param position The position of the new value
	 * @return newArray The new array with the new value
	 * @author D. Polach
	 */
	public static int[] insertElement(int[] originalArray, int value, int position)
	{
		int[] newArray = new int[originalArray.length + 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position; i < originalArray.length; i++)
		{
			newArray[i + 1] = originalArray[i];
		}
		newArray[position] = value;

		return newArray;
	}

	/**Deletes an element in an array and changes the size of the array 
	 * @param originalArray The original array with the unwanted value
	 * @param position The position of the unwanted value
	 * @return newArray The new array without the unwanted value
	 * @author D. Polach
	 */
	public static int[] deleteElement(int[] originalArray, int position)
	{
		int[] newArray = new int[originalArray.length - 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position + 1; i < originalArray.length; i++)
		{
			newArray[i - 1] = originalArray[i];			
		}

		return newArray;
	}

	/**Sorts the integers in an array from high to low
	 * @param originalArray The array being sorted
	 * @return newArray The sorted array
	 * @author D. Polach
	 */
	public static int[] sortHighToLow(int[] originalArray)
	{
		int[] newArray = new int[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			newArray[i] = originalArray[i];
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] > newArray[f])
				{
					int element1 = newArray[i];
					int element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}

		return newArray;
	}

	/**Sorts the integers in an array from low to high
	 * @param originalArray The array being sorted
	 * @return newArray The sorted array
	 * @author D. Polach
	 */
	public static int[] sortLowToHigh(int[] originalArray)
	{
		int[] newArray = new int[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			newArray[i] = originalArray[i];
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] < newArray[f])
				{
					int element1 = newArray[i];
					int element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}

		return newArray;
	}






	/////////////////////////////////////
	//                                 //
	//         STRING  CLASSES         //
	//                                 //
	/////////////////////////////////////


	/**Creates a new empty string array
	 *@param size An string that determines the size of the empty array
	 *@return newArray empty string array
	 *@author D. Polach
	 */
	public static String[] createEmptyStringArray(int size)
	{
		return new String[size];
	}

	/**Creates a new string array with user defined values
	 * @param size An integer that determines the size of the new array
	 * @return array The desired array
	 * @author D. Polach
	 */
	public static String[] createUserDefinedStringArray(int size)
	{
		Scanner Input = new Scanner(System.in);

		String[] array = new String[size];

		for(int i = 0; i < size; i++)
		{
			System.out.print("Type in string for array slot " + (i + 1) + ": ");
			String arraySlot = Input.next();
			array[i] = arraySlot;
		}
		return array;

	}

	/**Prints out each value of an array
	 * @param array The array that the user wants printed
	 * @author D. Polach
	 */
	public static void print(String[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
	}

	/**Finds the highest string value in array
	 * @param array The array being searched
	 * @return 0 Returns the first value
	 * @author D. Polach
	 */
	public static int findMax(String[] array)
	{
		String[] newArray = new String[array.length];

		for(int i = 0; i < array.length; i++)
		{
			newArray[i] = array[i];
		}

		Arrays.sort(newArray);
		
		String value = newArray[0];
		int position = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[0] == value)
			{
				position = i;
			}
		}

		return position;
	}

	/**Finds the lowest string value in array
	 * @param array The array being searched
	 * @return 0 Returns the first value
	 * @author D. Polach
	 */
	public static int findMin(String[] array)
	{

		String[] newArray = new String[array.length];

		for(int i = 0; i < array.length; i++)
		{
			newArray[i] = array[i];
		}

		Arrays.sort(newArray, Comparator.reverseOrder());
		
		String value = newArray[0];
		int position = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[0] == value)
			{
				position = i;
			}
		}

		return position;
	}

	/**Swaps 2 elements in a string array
	 * @param array The original array that the user wants to swap elements in 
	 * @param pos1 The position of the first element
	 * @param pos2 The position of the second element
	 * @author D. Polach
	 */
	public static void swapElements(String[] array, int pos1, int pos2)
	{
		String[] array2 = new String[array.length];

		for(int i = 0; i < array.length; i++)
		{
			array2[i] = array[i];
		}

		String element1 = array[pos1];
		String element2 = array[pos2];

		array[pos1] = element2;
		array[pos2] = element1;

	}

	/**Finds an element in the array and returns its position in the array
	 * @param value What value the user wants to find in the array
	 * @param array The array that the value is in
	 * @return position The position of the value in the array
	 * @author D. Polach
	 */
	public static int findElement(String value, String[] array)
	{
		int position = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i].equals(value))
			{
				position = i;
				break;
			}
			else if(i == (array.length-1))
			{
				position = -1;
			}
		}

		return position;
	}

	/**Counts the number of times a certain element appears in an array
	 * @param value The element being counted
	 * @param array The array being counted
	 * @return numOfElements The Number of times the element appears in the array
	 * @author D. Polach
	 */
	public static int countElements(String value, String[] array)
	{
		int numOfElements = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i].equals(value))
			{
				numOfElements ++;
			}
		}

		return numOfElements;
	}

	/**Copies all the elements of an array to a new array
	 * @param originalArray The array being copied
	 * @return arrayCopy The copied array
	 * @author D. Polach
	 */
	public static String[] copyArray(String[] originalArray)
	{
		String[] arrayCopy = new String[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			arrayCopy[i] = originalArray[i];
		}

		return arrayCopy;
	}

	/**Checks if all the values in one array match the values of another array
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays contain the same values
	 * @author D. Polach
	 */
	public static boolean checkIfCopy(String[] array1, String[] array2)
	{
		int score = 0;

		if(array1 == array2) 
		{
			return false;
		}

		if(array1.length != array2.length)
		{
			return false;
		}

		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i].equals(array2[i]))
			{
				score ++;
			}
		}

		if(score == array1.length) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Checks if two arrays are identical
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays are identical
	 * @author D. Polach
	 */
	public static boolean checkIfIdentical(String[] array1, String[] array2)
	{
		if(array1 == array2) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Replaces an element in array with a new element
	 * @param array The array with the value being replaced
	 * @param value The new element
	 * @param position The position of the old element
	 * @author D. Polach
	 */
	public static void replaceElement(String[] array, String value, int position)
	{
		array[position] = value;
	}

	/**Replaces all the same elements in array with a new value
	 * @param array The array being searched
	 * @param originalValue The value being replaced
	 * @param newValue The new value replacing the old
	 * @author D. Polach
	 */
	public static void replaceElements(String[] array, String originalValue, String newValue)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i].equals(originalValue))
			{
				array[i] = newValue;
			}
		}
	}

	/**Inserts a new element in an array and changes the size of the array to incorporate the new value
	 * @param originalArray The original array without the new value
	 * @param value The value being inserted in the array
	 * @param position The position of the new value
	 * @return newArray The new array with the new value
	 * @author D. Polach
	 */
	public static String[] insertElement(String[] originalArray, String value, int position)
	{
		String[] newArray = new String[originalArray.length + 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position; i < originalArray.length; i++)
		{
			newArray[i + 1] = originalArray[i];
		}
		newArray[position] = value;

		return newArray;
	}

	/**Deletes an element in an array and changes the size of the array 
	 * @param originalArray The original array with the unwanted value
	 * @param position The position of the unwanted value
	 * @return newArray The new array without the unwanted value
	 * @author D. Polach
	 */
	public static String[] deleteElement(String[] originalArray, int position)
	{
		String[] newArray = new String[originalArray.length - 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position + 1; i < originalArray.length; i++)
		{
			newArray[i - 1] = originalArray[i];			
		}

		return newArray;
	}

	/**Sorts the values in an array in reverse alphabetical order
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static String[] sortHighToLow(String[] originalArray)
	{
		String[] sortedArray = new String[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			sortedArray[i] = originalArray[i];
		}

		Arrays.sort(sortedArray);

		return sortedArray;
	}

	/**Sorts the values in an array in alphabetical order
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static String[] sortLowToHigh(String[] originalArray)
	{
		String[] sortedArray = new String[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			sortedArray[i] = originalArray[i];
		}

		Arrays.sort(sortedArray, Comparator.reverseOrder());

		return sortedArray;
	}






	/////////////////////////////////////
	//                                 //
	//         DOUBLE CLASSES          //
	//                                 //
	/////////////////////////////////////


	/**Creates a new empty double array
	 *@param size An string that determines the size of the empty array
	 *@return newArray empty double array
	 *@author D. Polach
	 */
	public static double[] createEmptyDoubleArray(int size)
	{
		return new double[size];
	}

	/**Creates a new double array populated with random values
	 * @param size An double that determines the size of the new array
	 * @param min The minimum value in the random array
	 * @param max The maximum value in the random array
	 * @return newArray The new array with random values
	 * @author D. Polach
	 */
	public static double[] createRandomDoubleArray(int size, double min, double max)
	{
		double[] newArray = new double[size];//Creates new empty array

		for(int i = 0; i < size; i++)//Loops through array
		{
			Random rand = new Random();
			newArray[i] = rand.nextDouble((max - min) + 1) + min;//Generates random number for each slot in array

		}//end loop

		return newArray;//returns new random array
	}

	/**Creates a new double array with user defined values
	 * @param size An integer that determines the size of the new array
	 * @return array The desired array
	 * @author D. Polach
	 */
	public static double[] createUserDefinedDoubleArray(int size)
	{
		Scanner Input = new Scanner(System.in);

		double[] array = new double[size];

		for(int i = 0; i < size; i++)
		{
			System.out.print("Type in string for array slot " + (i + 1) + ": ");
			double arraySlot = Input.nextDouble();
			array[i] = arraySlot;
		}
		return array;

	}

	/**Prints out each value of an array
	 * @param array The array that the user wants printed
	 * @author D. Polach
	 */
	public static void print(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
	}

	/**Finds the highest double value in array
	 * @param array The array being searched
	 * @return 0 Returns the first value
	 * @author D. Polach
	 */
	public static int findMax(double[] array)
	{	int maxPos = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] > array[maxPos])
			{
				maxPos = i;
			}
		}

		return maxPos;
	}

	/**Finds the lowest double value in array
	 * @param array The array being searched
	 * @return maxPos Returns the position of the max value
	 * @author D. Polach
	 */
	public static int findMin(double[] array)
	{
		int maxPos = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] < array[maxPos])
			{
				maxPos = i;
			}
		}

		return maxPos;
	}

	/**Swaps 2 elements in a double array
	 * @param array The original array that the user wants to swap elements in 
	 * @param pos1 The position of the first element
	 * @param pos2 The position of the second element
	 * @author D. Polach
	 */
	public static void swapElements(double[] array, int pos1, int pos2)
	{
		double[] array2 = new double[array.length];

		for(int i = 0; i < array.length; i++)
		{
			array2[i] = array[i];
		}

		double element1 = array[pos1];
		double element2 = array[pos2];

		array[pos1] = element2;
		array[pos2] = element1;

	}

	/**Finds an element in the array and returns its position in the array
	 * @param value What value the user wants to find in the array
	 * @param array The array that the value is in
	 * @return position The position of the value in the array
	 * @author D. Polach
	 */
	public static int findElement(double value, double[] array)
	{
		int position = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				position = i;
				break;
			}
			else if(i == (array.length-1))
			{
				position = -1;
			}
		}

		return position;
	}

	/**Counts the number of times a certain element appears in an array
	 * @param value The element being counted
	 * @param array The array being counted
	 * @return numOfElements The Number of times the element appears in the array
	 * @author D. Polach
	 */
	public static int countElements(double value, double[] array)
	{
		int numOfElements = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				numOfElements ++;
			}
		}

		return numOfElements;
	}

	/**Copies all the elements of an array to a new array
	 * @param originalArray The array being copied
	 * @return arrayCopy The copied array
	 * @author D. Polach
	 */
	public static double[] copyArray(double[] originalArray)
	{
		double[] arrayCopy = new double[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			arrayCopy[i] = originalArray[i];
		}

		return arrayCopy;
	}

	/**Checks if all the values in one array match the values of another array
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays contain the same values
	 * @author D. Polach
	 */
	public static boolean checkIfCopy(double[] array1, double[] array2)
	{
		int score = 0;

		if(array1 == array2) 
		{
			return false;
		}

		if(array1.length != array2.length)
		{
			return false;
		}

		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] == array2[i])
			{
				score ++;
			}
		}

		if(score == array1.length) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Checks if two arrays are identical
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays are identical
	 * @author D. Polach
	 */
	public static boolean checkIfIdentical(double[] array1, double[] array2)
	{
		if(array1 == array2) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Replaces an element in array with a new element
	 * @param array The array with the value being replaced
	 * @param value The new element
	 * @param position The position of the old element
	 * @author D. Polach
	 */
	public static void replaceElement(double[] array, double value, int position)
	{
		array[position] = value;
	}

	/**Replaces all the same elements in array with a new value
	 * @param array The array being searched
	 * @param originalValue The value being replaced
	 * @param newValue The new value replacing the old
	 * @author D. Polach
	 */
	public static void replaceElements(double[] array, double originalValue, double newValue)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == originalValue)
			{
				array[i] = newValue;
			}
		}
	}

	/**Inserts a new element in an array and changes the size of the array to incorporate the new value
	 * @param originalArray The original array without the new value
	 * @param value The value being inserted in the array
	 * @param position The position of the new value
	 * @return newArray The new array with the new value
	 * @author D. Polach
	 */
	public static double[] insertElement(double[] originalArray, double value, int position)
	{
		double[] newArray = new double[originalArray.length + 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position; i < originalArray.length; i++)
		{
			newArray[i + 1] = originalArray[i];
		}
		newArray[position] = value;

		return newArray;
	}

	/**Deletes an element in an array and changes the size of the array 
	 * @param originalArray The original array with the unwanted value
	 * @param position The position of the unwanted value
	 * @return newArray The new array without the unwanted value
	 * @author D. Polach
	 */
	public static double[] deleteElement(double[] originalArray, int position)
	{
		double[] newArray = new double[originalArray.length - 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position + 1; i < originalArray.length; i++)
		{
			newArray[i - 1] = originalArray[i];			
		}

		return newArray;
	}

	/**Sorts the values in an array from high to low
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static double[] sortHighToLow(double[] originalArray)
	{
		double[] newArray = new double[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			newArray[i] = originalArray[i];
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] > newArray[f])
				{
					double element1 = newArray[i];
					double element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}

		return newArray;
	}

	/**Sorts the values in an array from low to high
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static double[] sortLowToHigh(double[] originalArray)
	{
		double[] newArray = new double[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			newArray[i] = originalArray[i];
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] < newArray[f])
				{
					double element1 = newArray[i];
					double element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}

		return newArray;
	}



		
		
	/////////////////////////////////////
	//                                 //
	//         BOOLEAN CLASSES         //
	//                                 //
	/////////////////////////////////////


	/**Creates a new empty double array
	 *@param size An string that determines the size of the empty array
	 *@return newArray empty double array
	 *@author D. Polach
	 */
	public static boolean[] createEmptyBooleanArray(int size)
	{
		return new boolean[size];
	}

	/**Creates a new boolean array populated with random values
	 * @param size An integer that determines the size of the new array
	 * @param min The minimum value in the random array
	 * @param max The maximum value in the random array
	 * @return newArray The new array with random values
	 * @author D. Polach
	 */
	public static boolean[] createRandomBooleanArray(int size)
	{
		boolean[] newArray = new boolean[size];//Creates new empty array

		for(int i = 0; i < size; i++)//Loops through array
		{
			Random rand = new Random();
			int bool = rand.nextInt((2 - 1) + 1) + 1;//Generates random number for each slot in array

			if(bool == 2)
				newArray[i] = true;
			else
				newArray[i] = false;
			
		}//end loop

		return newArray;//returns new random array
	}

	/**Creates a new boolean array with user defined values
	 * @param size An integer that determines the size of the new array
	 * @return array The desired array
	 * @author D. Polach
	 */
	public static boolean[] createUserDefinedBooleanArray(int size)
	{
		Scanner Input = new Scanner(System.in);

		boolean[] array = new boolean[size];

		for(int i = 0; i < size; i++)
		{
			while(true)
			{
				System.out.print("Type in \"true\" or \"false\" for array slot " + (i + 1) + ": ");
				String arraySlot = Input.next();
				if(arraySlot == "true")
				{
					array[i] = true;
					break;
				}
				else if(arraySlot == "false")
				{
					array[i] = false;
					break;
				}
			}
		}
		return array;

	}

	/**Prints out each value of an array
	 * @param array The array that the user wants printed
	 * @author D. Polach
	 */
	public static void print(boolean[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
	}

	/**Swaps 2 elements in a boolean array
	 * @param array The original array that the user wants to swap elements in 
	 * @param pos1 The position of the first element
	 * @param pos2 The position of the second element
	 * @author D. Polach
	 */
	public static void swapElements(boolean[] array, int pos1, int pos2)
	{
		boolean[] array2 = new boolean[array.length];

		for(int i = 0; i < array.length; i++)
		{
			array2[i] = array[i];
		}

		boolean element1 = array[pos1];
		boolean element2 = array[pos2];

		array[pos1] = element2;
		array[pos2] = element1;

	}

	/**Counts the number of times a certain element appears in an array
	 * @param value The element being counted
	 * @param array The array being counted
	 * @return numOfElements The Number of times the element appears in the array
	 * @author D. Polach
	 */
	public static int countElements(boolean value, boolean[] array)
	{
		int numOfElements = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				numOfElements ++;
			}
		}

		return numOfElements;
	}

	/**Copies all the elements of an array to a new array
	 * @param originalArray The array being copied
	 * @return arrayCopy The copied array
	 * @author D. Polach
	 */
	public static boolean[] copyArray(boolean[] originalArray)
	{
		boolean[] arrayCopy = new boolean[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			arrayCopy[i] = originalArray[i];
		}

		return arrayCopy;
	}

	/**Checks if all the values in one array match the values of another array
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays contain the same values
	 * @author D. Polach
	 */
	public static boolean checkIfCopy(boolean[] array1, boolean[] array2)
	{
		int score = 0;

		if(array1 == array2) 
		{
			return false;
		}

		if(array1.length != array2.length)
		{
			return false;
		}

		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] == array2[i])
			{
				score ++;
			}
		}

		if(score == array1.length) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Checks if two arrays are identical
	 * @param array1 The first array being compared
	 * @param array2 The second array being compared
	 * @return trueOrFalse If the arrays are identical
	 * @author D. Polach
	 */
	public static boolean checkIfIdentical(boolean[] array1, boolean[] array2)
	{
		if(array1 == array2) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**Replaces an element in array with a new element
	 * @param array The array with the value being replaced
	 * @param value The new element
	 * @param position The position of the old element
	 * @author D. Polach
	 */
	public static void replaceElement(boolean[] array, boolean value, int position)
	{
		array[position] = value;
	}

	/**Replaces all the same elements in array with a new value
	 * @param array The array being searched
	 * @param originalValue The value being replaced
	 * @param newValue The new value replacing the old
	 * @author D. Polach
	 */
	public static void replaceElements(boolean[] array, boolean originalValue, boolean newValue)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == originalValue)
			{
				array[i] = newValue;
			}
		}
	}

	/**Inserts a new element in an array and changes the size of the array to incorporate the new value
	 * @param originalArray The original array without the new value
	 * @param value The value being inserted in the array
	 * @param position The position of the new value
	 * @return newArray The new array with the new value
	 * @author D. Polach
	 */
	public static boolean[] insertElement(boolean[] originalArray, boolean value, int position)
	{
		boolean[] newArray = new boolean[originalArray.length + 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position; i < originalArray.length; i++)
		{
			newArray[i + 1] = originalArray[i];
		}
		newArray[position] = value;

		return newArray;
	}

	/**Deletes an element in an array and changes the size of the array 
	 * @param originalArray The original array with the unwanted value
	 * @param position The position of the unwanted value
	 * @return newArray The new array without the unwanted value
	 * @author D. Polach
	 */
	public static boolean[] deleteElement(boolean[] originalArray, int position)
	{
		boolean[] newArray = new boolean[originalArray.length - 1];

		for(int i = 0; i < position; i++)
		{
			newArray[i] = originalArray[i];
		}

		for(int i = position + 1; i < originalArray.length; i++)
		{
			newArray[i - 1] = originalArray[i];			
		}

		return newArray;
	}

	/**Sorts the values in an array from high to low
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static boolean[] sortHighToLow(boolean[] originalArray)
	{
		int[] newArray = new int[originalArray.length];
		boolean[] newBooleanArray = new boolean[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			if(originalArray[i] == true)
			{
				newArray[i] = 1;
			}
			else if(originalArray[i] == false)
			{
				newArray[i] = 0;
			}
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] > newArray[f])
				{
					int element1 = newArray[i];
					int element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}
		
		for(int i = 0; i < originalArray.length; i++)
		{
			if(newArray[i] == 1)
			{
				newBooleanArray[i] = true;
			}
			else if(newArray[i] == 0)
			{
				newBooleanArray[i] = false;
			}
		}

		return newBooleanArray;
	}

	/**Sorts the values in an array from low to high
	 * @param originalArray The array being sorted
	 * @return sortedArray The sorted array
	 * @author D. Polach
	 */
	public static boolean[] sortLowToHigh(boolean[] originalArray)
	{
		int[] newArray = new int[originalArray.length];
		boolean[] newBooleanArray = new boolean[originalArray.length];

		for(int i = 0; i < originalArray.length; i++)
		{
			if(originalArray[i] == true)
			{
				newArray[i] = 1;
			}
			else if(originalArray[i] == false)
			{
				newArray[i] = 0;
			}
		}
		for(int i = 0; i < originalArray.length; i++)
		{
			for(int f = 0; f < originalArray.length; f++)
			{
				if(newArray[i] < newArray[f])
				{
					int element1 = newArray[i];
					int element2 = newArray[f];

					newArray[i] = element2;
					newArray[f] = element1;
				}
			}
		}
		
		for(int i = 0; i < originalArray.length; i++)
		{
			if(newArray[i] == 1)
			{
				newBooleanArray[i] = true;
			}
			else if(newArray[i] == 0)
			{
				newBooleanArray[i] = false;
			}
		}

		return newBooleanArray;
	}







} // end class Array
