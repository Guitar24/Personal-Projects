package testing;
import java.util.*;

public class Testing_1 {

	public static void main(String[] args)
	{
		int[][] array = {
				{9, 0, 3, 2, 1, 3, 4},
				{9, 4, 3, 2, 1, 6, 4},
				{9, 5, 5, 2, 1, 3, 4},
				{4, 0, 4, 2, 1, 4, 4},
				};
		
		print(array, ", ");
	}

	
	/**print Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void print(int[][] array, String delimiter) 
	{
		//Loops through rows of elements
		for(int row = 0; row < array.length; row ++)
		{
			//Print the first element of row
			System.out.print(array[row][0]);
			
			//Print rest of row with comma
			for(int column = 1; column < array[row].length; column++)
			{
				System.out.print (delimiter + array[row][column]);
			}//end for loop
			
			System.out.println("");
			
		}//end for loop
	}//end print(int[][] array, String delimiter)
	
	/**print Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void print(double[][] array, String delimiter) 
	{
		//Loops through rows of elements
		for(int row = 0; row < array.length; row ++)
		{
			//Print the first element of row
			System.out.print(array[row][0]);
			
			//Print rest of row with comma
			for(int column = 1; column < array[row].length; column++)
			{
				System.out.print (delimiter + array[row][column]);
			}//end for loop
			
			System.out.println("");
			
		}//end for loop
	}//end print(double[][] array, String delimiter)
	
	/**print Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void print(String[][] array, String delimiter) 
	{
		//Loops through rows of elements
		for(int row = 0; row < array.length; row ++)
		{
			//Print the first element of row
			System.out.print(array[row][0]);
			
			//Print rest of row with comma
			for(int column = 1; column < array[row].length; column++)
			{
				System.out.print(delimiter + array[row][column]);
			}//end for loop
			
			System.out.println("");
			
		}//end for loop
	}//end print(String[][] array, String delimiter)
	
	public static int[][] appendArrays(int[][] array1, int[][] array2, String rowOrColumn)
	{
		if(rowOrColumn == "r")
		{
			int rowLength = array1.length + array2.length;
			
			int[][] appendedArray = new int[rowLength][array1[0].length];
			
			for(int row = 0; row < rowLength; row ++)
			{
				for(int column = 0; column < )
			}
			
			
			return null;
		}
		return null;
	}
}