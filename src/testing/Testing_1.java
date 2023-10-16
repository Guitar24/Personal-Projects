package testing;
import java.util.*;

public class Testing_1 {

	public static void main(String[] args)
	{
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{9, 8, 7, 6, 5}
				};
		
		int[][] array2 = {
				{6, 7, 8, 9},
				{4, 3, 2, 1}
				};
		
		int[][] array3 = appendArrays(array1, array2, "r");
		
		print(array3, ", ");
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
	
	/**appendArray Appends two 2d arrays side by side or stacked
	 * @param array1 The first array
	 * @param array2 The second array
	 * @param rowOrColumn User defined value for appending the rows or columns
	 * @return appendedArray The new array with both arrays appended
	 * @author Daniel Polach
	 */
	public static int[][] appendArrays(int[][] array1, int[][] array2, String rowOrColumn)
	{
		if(rowOrColumn == "r")
		{
			int numOfColumns = array1[0].length + array2[0].length;
			int numOfRows = array1.length;
			
			System.out.println(array1[0].length);
			System.out.println(array2[0].length);
			
			System.out.println(numOfColumns);
			System.out.println(numOfRows);
			
			int[][] appendedArray = new int[numOfColumns][numOfRows];
			
			for(int row = 0; row < numOfRows; row ++)
			{
				for(int column = 0; column < numOfColumns; column ++)
				{
					if(column < array1[0].length)
					{
						appendedArray[row][column] = array1[row][column];
					}
					else
					{
						appendedArray[row][column] = array2[row - (array1.length)][column];
					}
				}
			}
			
			
			return appendedArray;
		}
		return null;
	}
}