package testing;
import java.util.*;

public class Testing_1 {

	public static void main(String[] args)
	{
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{4, 3, 2, 1, 4}
				};
		
		String[][] array5 = {{"dd", "c", "ds", "gfg"},
							{"d", "sd", "j", "df"}};
		
		String[][] array7 = {{"sdf", "gfh", "djhgf", "dfs"},
				{"ghfs", "fdh", "yuy", "xc"}};
		
		int[][] array2 = {
				{6, 7, 8, 9, 7},
				{4, 3, 2, 1, 4}
				};
		
		double[][] array6 = {
				{6.34, 7.54, 8.23, 9.49, 7.57},
				{4.18, 3.54, 2.34, 1.89, 4.61}
				};
		
		//String[][] array3 = appendArrays(array1, array2, "r");
		
		//printWithDelimiter(array3, ", ");
		
		//printWithDelimiter(array3, ", ");
		
		System.out.println("");
		
		//int[][] array4 = appendArrays(array1, array2, "c");
		
		//printWithDelimiter(array4, ", ");
		
		//System.out.println(Arrays.toString(array1[0]));
		//System.out.println(array1[1][0]);
	}
	
	/**printWithDelimiter Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void printWithDelimiter(int[][] array, String delimiter) 
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
	
	/**printWithDelimiter Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void printWithDelimiter(double[][] array, String delimiter) 
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
	
	/**printWithDelimiter Prints 2d array with user specified delimiter
	 * @param array The 2d array being printed
	 * @param delimiter The comma or any other character the user defines
	 * @author Daniel Polach
	 */
	public static void printWithDelimiter(String[][] array, String delimiter) 
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
	
	/**appendArray Appends two 2d arrays side by side or stacked. Does not work with ragged arrays
	 * @param array1 The first array
	 * @param array2 The second array
	 * @param rowOrColumn User defined value for appending the rows or columns
	 * @return appendedArray The new array with both arrays appended
	 * @author Daniel Polach
	 */
	public static int[][] appendArrays(int[][] array1, int[][] array2, String rowOrColumn)
	{
		//For appending to rows together
		if(rowOrColumn == "r")
		{
			int numOfColumns = array1[0].length + array2[0].length;
			int numOfRows = array1.length;
			
			int[][] appendedArray = new int[numOfRows][numOfColumns];
			
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
						appendedArray[row][column] = array2[row][column - (array1[0].length)];
					}
				}
			}
			
			
			return appendedArray;
		}
		//for appending columns together
		else if(rowOrColumn == "c")
		{
			int numOfColumns = array1[0].length;
			int numOfRows = array1.length + array2.length;
			
			int[][] appendedArray = new int[numOfRows][numOfColumns];
			
			for(int row = 0; row < numOfRows; row ++)
			{
				for(int column = 0; column < numOfColumns; column ++)
				{
					if(row < array1.length)
					{
						appendedArray[row][column] = array1[row][column];
					}
					else
					{
						appendedArray
								[row]
								[column] = array2
								[row - (array1.length)]
								[column];
					}
				}
			}
			
			
			return appendedArray;
		}
		else 
			return null;
	}

	/**appendArray Appends two 2d arrays side by side or stacked. Does not work with ragged arrays
	 * @param array1 The first array
	 * @param array2 The second array
	 * @param rowOrColumn User defined value for appending the rows or columns
	 * @return appendedArray The new array with both arrays appended
	 * @author Daniel Polach
	 */
	public static double[][] appendArrays(double[][] array1, double[][] array2, String rowOrColumn)
	{
		//For appending to rows together
		if(rowOrColumn == "r")
		{
			int numOfColumns = array1[0].length + array2[0].length;
			int numOfRows = array1.length;
			
			double[][] appendedArray = new double[numOfRows][numOfColumns];
			
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
						appendedArray[row][column] = array2[row][column - (array1[0].length)];
					}
				}
			}
			
			
			return appendedArray;
		}
		//for appending columns together
		else if(rowOrColumn == "c")
		{
			int numOfColumns = array1[0].length;
			int numOfRows = array1.length + array2.length;
			
			double[][] appendedArray = new double[numOfRows][numOfColumns];
			
			for(int row = 0; row < numOfRows; row ++)
			{
				for(int column = 0; column < numOfColumns; column ++)
				{
					if(row < array1.length)
					{
						appendedArray[row][column] = array1[row][column];
					}
					else
					{
						appendedArray
								[row]
								[column] = array2
								[row - (array1.length)]
								[column];
					}
				}
			}
			
			
			return appendedArray;
		}
		else 
			return null;
	}

	/**appendArray Appends two 2d arrays side by side or stacked. Does not work with ragged arrays
	 * @param array1 The first array
	 * @param array2 The second array
	 * @param rowOrColumn User defined value for appending the rows or columns
	 * @return appendedArray The new array with both arrays appended
	 * @author Daniel Polach
	 */
	public static String[][] appendArrays(String[][] array1, String[][] array2, String rowOrColumn)
	{
		//For appending to rows together
		if(rowOrColumn == "r")
		{
			int numOfColumns = array1[0].length + array2[0].length;
			int numOfRows = array1.length;
			
			String[][] appendedArray = new String[numOfRows][numOfColumns];
			
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
						appendedArray[row][column] = array2[row][column - (array1[0].length)];
					}
				}
			}
			
			
			return appendedArray;
		}
		//for appending columns together
		else if(rowOrColumn == "c")
		{
			int numOfColumns = array1[0].length;
			int numOfRows = array1.length + array2.length;
			
			String[][] appendedArray = new String[numOfRows][numOfColumns];
			
			for(int row = 0; row < numOfRows; row ++)
			{
				for(int column = 0; column < numOfColumns; column ++)
				{
					if(row < array1.length)
					{
						appendedArray[row][column] = array1[row][column];
					}
					else
					{
						appendedArray
								[row]
								[column] = array2
								[row - (array1.length)]
								[column];
					}
				}
			}
			
			
			return appendedArray;
		}
		else 
			return null;
	}

}