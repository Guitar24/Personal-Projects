
package array;

import java.io.*;
import java.util.*;

public class IntegerArraysTestScript
{
	public static void main( String[] args ) throws IOException
	{
		Scanner myInput = new Scanner (System.in);
		Random rand = new Random();
		int size;
		int min;
		int max;

		//Collects the student name so the file can be written with their name	
		System.out.println("Please enter your first name and last name initial (no spaces)");
		String name = myInput.nextLine();
		String filename = "Array_Class_Test_"+name+".txt";

		//creates the ability to write to a file and prints the file name to the screen and at the top of the file
		FileWriter myWriter = new FileWriter(filename);
		PrintWriter myOutput = new PrintWriter(myWriter);		
		System.out.println(filename + "\n");
		myOutput.println(filename + "\n");

		//creates the arrays/variables that will be used for testing
		size = rand.nextInt(10)+2;
		int [] numbersArray = {2,-8,7,5,-3,11,14,5,-12};
		int [] numbersArray2;
		int [] numbersArray3;
		int [] emptyArray= new int [size];
		int [] emptyArray1;
		int [] arrayCopy;

		boolean test1;
		boolean test2;
		boolean test3;
		boolean test4;

		int grade = 0;

		//Testing: createUserDefinedIntArray
		System.out.println("Please enter 4 numbers");
		numbersArray3 = Array.createUserDefinedIntArray(4);
		//############################
		printSpacer(myOutput, "Green");
		printToScreenAndFile(myOutput, "createRandomIntArray", "Are these your numbers? \n\t", Integer.toString(numbersArray3[0]), Integer.toString(numbersArray3[1]), Integer.toString(numbersArray3[2]), Integer.toString(numbersArray3[3]));


		//Testing: print
		printToScreenAndFile(myOutput, "print", "Did your numbers print again with commas on one line? ");
		System.out.print("\t ");
		myOutput.print("\t ");
		Array.print(numbersArray3);
		Array.printArrayToFile(myOutput, numbersArray3);


		//Testing: createEmptyIntArray
		emptyArray1 = Array.createEmptyIntArray(size);
		test1 = containsSameElementsInOrder(emptyArray, emptyArray1);
		test2 = isEqual(emptyArray, emptyArray1);
		test3 = isEqual(emptyArray1, numbersArray);
		printToScreenAndFile(myOutput, "createEmptyIntArray", (test1==true ? "pass": "fail"), (test2==false ?  "pass" : "fail" ), (test3==false ? "pass": "fail"));
		if(test1==true) grade++; if(test2==false) grade++; if(test3==false) grade++;;

		
		//Testing: createRandomIntArray
		min = 2;
		max = 100;
		size = rand.nextInt(max - min + 1) + min;
		numbersArray2 = Array.createRandomIntArray(size, min, max);
		numbersArray3 = Array.createRandomIntArray(size, min, max);
		test1 = (size==numbersArray2.length);
		test2 = containsValuesBetween(numbersArray2, min, max);
		test3 = containsSameElementsInOrder(numbersArray2, numbersArray3);
		printToScreenAndFile(myOutput, "createRandomIntArray", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==false ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==false) grade++;

		
		//Testing: findMax
		test1 = isEqual(Array.findMax(numbersArray), 6);
		test2 = isEqual(Array.findMax(emptyArray), 0);
		emptyArray1[emptyArray1.length-1] = 1;
		test3 = isEqual(Array.findMax(emptyArray1), emptyArray1.length-1);
		printToScreenAndFile(myOutput, "findMax", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 

		
		//Testing: findMin
		test1 = isEqual(Array.findMin(numbersArray), 8);
		test2 = isEqual(Array.findMin(emptyArray), 0);
		emptyArray1[1] = -99;
		test3 = isEqual(Array.findMin(emptyArray1), 1);
		printToScreenAndFile(myOutput, "findMin", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 

		
		//Testing: swapElements
		Array.swapElements(numbersArray, 0, numbersArray.length-1);
		int [] testArray = {-12,-8,7,5,-3,11,14,5,2};
		test1 = containsSameElementsInOrder(numbersArray, testArray);
		Array.swapElements(numbersArray, 4, 7);
		int [] testArray2 = {-12,-8,7,5,5,11,14,-3,2};
		test2 = containsSameElementsInOrder(numbersArray, testArray2);
		Array.swapElements(numbersArray, 2, 2);
		test3 = containsSameElementsInOrder(numbersArray, testArray2);
		printToScreenAndFile(myOutput, "swapElements", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 
		
		
		//############################
		printSpacer(myOutput, "Blue");
		
		
		//Testing: findElement
		test1 = isEqual(Array.findElement(-12, numbersArray), 0);
		test2 = isEqual(Array.findElement(2, numbersArray), 8);
		test3 = isEqual(Array.findElement(5, numbersArray), 3);
		test4 = isEqual(Array.findElement(3, numbersArray), -1);
		printToScreenAndFile(myOutput, "findElement", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; if(test4==true) grade++;

		
		//Testing: countElements
		test1 = isEqual(Array.countElements(-12, numbersArray), 1);
		test2 = isEqual(Array.countElements(2, numbersArray), 1);
		test3 = isEqual(Array.countElements(5, numbersArray), 2);
		test4 = isEqual(Array.countElements(3, numbersArray), 0);
		printToScreenAndFile(myOutput, "countElements", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; if(test4==true) grade++;

		
		//Testing: copyArray
		arrayCopy = Array.copyArray(numbersArray);
		test1 = isEqual(arrayCopy, numbersArray);
		test2 = containsSameElementsInOrder(arrayCopy, numbersArray);
		arrayCopy[1] = 17;
		test3 = isEqual(arrayCopy, numbersArray);
		test4 = isEqual(arrayCopy, arrayCopy);
		printToScreenAndFile(myOutput, "copyArray", (test1==false ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==false ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==false) grade++; if(test2==true) grade++; if(test3==false) grade++; if(test4==true) grade++;

		
		//Testing: checkIfCopy
		arrayCopy = Array.copyArray(numbersArray);
		test1 = Array.checkIfCopy(arrayCopy, numbersArray);
		test2 = Array.checkIfCopy(numbersArray2, numbersArray2);
		printToScreenAndFile(myOutput, "checkIfCopy", (test1==true ? "pass": "fail"), (test2==false ?  "pass" : "fail" ));
		if(test1==true) grade++; if(test2==false) grade++;

		
		//Testing: checkIfIdentical
		test1 = Array.checkIfIdentical(numbersArray, numbersArray2);
		test2 = Array.checkIfIdentical(numbersArray2, numbersArray2);
		printToScreenAndFile(myOutput, "checkIfIdentical", (test1==false ? "pass": "fail"), (test2==true ?  "pass" : "fail" ));
		if(test1==false) grade++; if(test2==true) grade++; 

		
		//Testing: replaceElement
		Array.replaceElement(arrayCopy, 2, 4);
		test1 = isEqual(arrayCopy[4], 2);
		Array.replaceElement(arrayCopy, 2, 0);
		test2 = isEqual(arrayCopy[0], 2);
		Array.replaceElement(arrayCopy, 3, 8);
		test3 = isEqual(arrayCopy[8], 3);
		Array.replaceElement(arrayCopy, 2, 8);
		test4 = isEqual(arrayCopy[8], 2);
		printToScreenAndFile(myOutput, "replaceElement", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; if(test4==true) grade++;

		
		//############################
		printSpacer(myOutput, "Peach");
		
		
		//Testing: replaceElements
		Array.replaceElements(arrayCopy, 2, 99);
		test1 = isEqual(arrayCopy[4], 99);
		test2 = isEqual(arrayCopy[0], 99);
		test3 = isEqual(arrayCopy[8], 99);
		printToScreenAndFile(myOutput, "replaceElements", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ?  "pass" : "fail" ));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 
		
		
		//Testing: insertElement
		testArray = Array.insertElement(numbersArray, 33, 4 );
		test1 = isEqual(testArray[4], 33) && isEqual(numbersArray[4], 5);
		testArray = Array.insertElement(numbersArray, 34, 0);
		test2 = isEqual(testArray[0], 34) && isEqual(numbersArray[0], -12);
		testArray = Array.insertElement(numbersArray, 35, 9);
		test3 = isEqual(testArray[9], 35) && isEqual(numbersArray[8], 2);
		printToScreenAndFile(myOutput, "insertElement", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ?  "pass" : "fail" ));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 
		
		
		//Testing: deleteElement
		testArray = Array.deleteElement(numbersArray, 4 );
		test1 = isEqual(testArray[4], 11) && isEqual(testArray.length, 8);
		testArray = Array.deleteElement(numbersArray, 0);
		test2 = isEqual(testArray[0], -8) && isEqual(testArray.length, 8);
		testArray = Array.deleteElement(numbersArray, 8);
		test3 = isEqual(testArray[7], -3) && isEqual(testArray.length, 8);
		printToScreenAndFile(myOutput, "deleteElement", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ?  "pass" : "fail" ));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; 

		
		//############################
		printSpacer(myOutput, "Pink");
		
		
		//Testing: sortHighToLow
		int [] testArray3 = {2,-8,7,5,-3,11,14,5,-12}; //random
		int [] testArray4 = {-12, -8, -3, 2, 5, 5, 7, 11, 14}; //already sorted
		int [] testArray5 = {-8, -3, 2, 5, 5, 7, 11, -12, 14}; //almost sorted
		int [] testArray6 = {14, 11, 7, 5, 5, 2, -3, -8, -12}; //reverse sorted
		
		int [] sortedHtoL = {14, 11, 7, 5, 5, 2, -3, -8, -12};
		int [] arraySorted = Array.sortHighToLow(testArray3);
		test1 = containsSameElementsInOrder(sortedHtoL, arraySorted) && !isEqual(sortedHtoL, arraySorted);
		arraySorted = Array.sortHighToLow(testArray4);
		test2 = containsSameElementsInOrder(sortedHtoL, arraySorted) && !isEqual(sortedHtoL, arraySorted);
		arraySorted = Array.sortHighToLow(testArray5);
		test3 = containsSameElementsInOrder(sortedHtoL, arraySorted) && !isEqual(sortedHtoL, arraySorted);
		arraySorted = Array.sortHighToLow(testArray6);
		test4 = containsSameElementsInOrder(sortedHtoL, arraySorted) && !isEqual(sortedHtoL, arraySorted);
		printToScreenAndFile(myOutput, "sortHighToLow", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; if(test4==true) grade++;

		
		//Testing: sortLowToHigh	
		int [] sortedLtoH = {-12, -8, -3, 2, 5, 5, 7, 11, 14};
		arraySorted = Array.sortLowToHigh(testArray3);
		test1 = containsSameElementsInOrder(sortedLtoH, arraySorted) && !isEqual(sortedLtoH, arraySorted);
		arraySorted = Array.sortLowToHigh(testArray4);
		test2 = containsSameElementsInOrder(sortedLtoH, arraySorted) && !isEqual(sortedLtoH, arraySorted);
		arraySorted = Array.sortLowToHigh(testArray5);
		test3 = containsSameElementsInOrder(sortedLtoH, arraySorted) && !isEqual(sortedLtoH, arraySorted);
		arraySorted = Array.sortLowToHigh(testArray6);
		test4 = containsSameElementsInOrder(sortedLtoH, arraySorted) && !isEqual(sortedLtoH, arraySorted);
		printToScreenAndFile(myOutput, "sortLowToHigh", (test1==true ? "pass": "fail"), (test2==true ?  "pass" : "fail" ), (test3==true ? "pass": "fail"), (test4==true ? "pass": "fail"));
		if(test1==true) grade++; if(test2==true) grade++; if(test3==true) grade++; if(test4==true) grade++;
		
		
		//prints score except for print
		printToScreenAndFile(myOutput, "Tests passed (not including \"print\": ", Integer.toString(grade), "/52");
		
		
		myOutput.close();

	}// end main


	/**Checks if all of the values in the array are between the range of min - max
	 * @param array the array to be checked
	 * @param min the smallest value the numbers can be
	 * @param max the largest value the numbers can be
	 * @return true if all the values are in the range and false otherwise
	 */
	public static boolean containsValuesBetween( int[] array, int min, int max ) 
	{
		boolean result= false;

		// check each element to see if they are all values within the range
		for (int i = 0; i<array.length; i++)
		{
			try
			{
				assert (array[i]>=min && array[i]<=max);
				result = true;
			}
			catch (AssertionError a)
			{
				result = false;
				break;
			}
			catch (Exception e)
			{
				result = false;
				break;
			}
		}//ends for loop to check each element
		return result;
	}//end containsValuesBetween


	/**prints each string sent both to the screen and to the file using the PrintWriter
	 * @param myOutput the print writer used to write information to a file
	 * @param testName string indicating what the test is being written
	 * @param tests string varargs of the test results
	 */
	public static void printToScreenAndFile( PrintWriter myOutput, String testName, String ... tests )
	{
		//prints to the screen
		System.out.print("\n" + testName + "\n\t ");
		for(String test : tests)
		{
			System.out.print(test + " ");
		}
		System.out.println();

		//prints to the file
		myOutput.print("\n" + testName + "\n\t ");
		for(String test : tests)
		{
			myOutput.print(test + " ");
		}
		myOutput.println();

	}//end printToScreenAndFile


	/**for esthetics when printing on the screen and in a file
	 * @param myOutput the print writer used to write information to a file
	 * @param titlestring indicating what the test is being written
	 */
	public static void printSpacer(PrintWriter myOutput, String ... title)
	{
		System.out.println("\n#### " + title[0] + " #########################################################################");
		myOutput.println("\n#### " + title[0] + " #########################################################################");
	}// end printSpacer

	/** Verifies if the two numbers sent are the same value
	 * @param testingValue integer value being tested
	 * @param correctValue integer value that is correct
	 * @return true when values are equal and false when they are not
	 */
	public static boolean isEqual(int testingValue, int correctValue)
	{
		boolean result= false;
		try
		{
			assert testingValue==correctValue;
			result = true;
		}
		catch (AssertionError a)
		{
			result = false ;
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}//end isEqual for integers

	/** Verifies if the two Strings sent are the same value
	 * @param testingValue String value being tested
	 * @param correctValue String value that is correct
	 * @return true when values are equal and false when they are not
	 */
	public static boolean isEqual(String testingValue, String correctValue)
	{
		boolean result= false;
		try
		{
			assert testingValue.equals(correctValue);
			result = true;
		}
		catch (AssertionError a)
		{
			result = false ;
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}//end isEqual for Strings

	/** Verifies if the two numbers sent are the same value
	 * @param testingValue double value being tested
	 * @param correctValue double value that is correct
	 * @return true when values are equal and false when they are not
	 */
	public static boolean isEqual(double testingValue, double correctValue)
	{
		boolean result= false;
		try
		{
			assert testingValue==correctValue;
			result = true;
		}
		catch (AssertionError a)
		{
			result = false ;
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}//end isEqual for doubles

	/** Verifies if the two arrays are the same (located in the same spot in memory)
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean isEqual(int [] testingArray, int [] correctArray)
	{
		// if addresses to the arrays are the same 
		if(testingArray == correctArray)
			return true;
		else
			return false;

	}//end isEqual for integer arrays

	/** Verifies if the two arrays are the same (located in the same spot in memory)
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean isEqual(double [] testingArray, double [] correctArray)
	{
		// if addresses to the arrays are the same 
		if(testingArray == correctArray)
			return true;
		else
			return false;

	}//end isEqual for double arrays

	/** Verifies if the two arrays are the same (located in the same spot in memory)
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean isEqual(String [] testingArray, String [] correctArray)
	{
		// if addresses to the arrays are the same 
		if(testingArray == correctArray)
			return true;
		else
			return false;

	}//end isEqual for String arrays

	/** Verifies if the two arrays sent contain the same values
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean containsSameElementsInOrder(int [] testingArray, int [] correctArray)
	{
		boolean result= false;

		// if not the same size then they don't contain the same elements otherwise
		// check each element to see if they are all the same
		if(testingArray.length != correctArray.length)
			return false;
		else
		{
			for (int i = 0; i<testingArray.length; i++)
			{
				try
				{
					assert testingArray[i]==correctArray[i];
					result = true;
				}
				catch (AssertionError a)
				{
					result = false;
					break;
				}
				catch (Exception e)
				{
					result = false;
					break;
				}
			}//ends for loop to check each element
		}
		return result;

	}//end containsSameElementsInOrder for integer arrays

	/** Verifies if the two arrays sent contain the same values
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean containsSameElementsInOrder(double [] testingArray, double [] correctArray)
	{
		boolean result= false;

		// if not the same size then they don't contain the same elements otherwise
		// check each element to see if they are all the same
		if(testingArray.length != correctArray.length)
			return false;
		else
		{
			for (int i = 0; i<testingArray.length; i++)
			{
				try
				{
					assert testingArray[i]==correctArray[i];
					result = true;
				}
				catch (AssertionError a)
				{
					result = false;
					break;
				}
				catch (Exception e)
				{
					result = false;
					break;
				}
			}//ends for loop to check each element
		}
		return result;

	}//end containsSameElementsInOrder for double arrays

	/** Verifies if the two arrays sent contain the same values
	 * @param testingArray array with values being tested
	 * @param correctArray array with values that are correct
	 * @return true when all values are equal and false when they are not
	 */
	public static boolean containsSameElementsInOrder(String [] testingArray, String [] correctArray)
	{
		boolean result= false;

		// if not the same size then they don't contain the same elements otherwise
		// check each element to see if they are all the same
		if(testingArray.length != correctArray.length)
			return false;
		else
		{
			for (int i = 0; i<testingArray.length; i++)
			{
				try
				{
					assert testingArray[i].equals(correctArray[i]);
					result = true;
				}
				catch (AssertionError a)
				{
					result = false;
					break;
				}
				catch (Exception e)
				{
					result = false;
					break;
				}
			}//ends for loop to check each element
		}
		return result;

	}//end containsSameElementsInOrder for String arrays

}//end Testing class