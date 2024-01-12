package testing;
import java.io.*;
import java.util.*;
import array.Array;
import javafx.scene.effect.Light.Point;

public class Testing_1 {

	
    public static void main(String args[]) throws InterruptedException
    {
    	//int[] array = {5, 2, 3, 8, 2, 6, 1};
    	
    	//System.out.println(Arrays.toString(array));
    	
    	//array = shell(array);
    	
    	//System.out.println(Arrays.toString(array));
    	
    }
	
    
 // global variables to track important elements that determine efficiency
 	public static int loops = 0;
 	public static int swaps = 0;
 	public static int comparisons = 0;
 	public static int recursions = 0;

 	/**
 	 * Resets the values of the counters for loops, swaps and comparisons.
 	 */
 	private static void resetCounters() 
 	{
 		loops = 0;
 		swaps = 0;
 		comparisons = 0;
 		recursions = 0;
 	}//end reset method


 	/**
 	 * Takes an array and swaps the elements at indices: pos1 and pos2
 	 * O(1): constant time as the swap takes 3 moves/assignments regardless of the size of the list 
 	 * @param array: the array with elements to be swapped
 	 * @param pos1: first index position of the item to be swapped
 	 * @param pos2: second index position of the item to be swapped
 	 */
 	public static void swap(int[] array, int pos1, int pos2) 
 	{
 		int temp = array[pos1];
 		array[pos1] = array[pos2];
 		array[pos2] = temp;
 	
 	}// end swap for integer arrays


 	/**
 	 * Takes a linked list and swaps the elements at position: pos1 and pos2
 	 * O(1): constant time as the swap takes the same number of moves/assignments regardless of the size of the list 
 	 * @param list: the array with elements to be swapped
 	 * @param pos1: first position of the item to be swapped
 	 * @param pos2: second position of the item to be swapped
 	 */
 	public static void swap(LinkedList<Integer> list, int pos1, int pos2) 
 	{
 		//makes copies of the values at the correct positions
 		Integer temp1 = list.get(pos1);
 		Integer temp2 = list.get(pos2);
 	
 		//depending on the order, remove largest then smallest, then add smallest then largest to preserve the correct indices
 		if(pos1<pos2)
 		{	
 			//positions are given in order
 			list.remove(pos2);
 			list.remove(pos1);
 			list.add(pos1, temp2);
 			list.add(pos2, temp1);
 		}
 		else
 		{
 			//positions are given out of order
 			list.remove(pos1);
 			list.remove(pos2);
 			list.add(pos2, temp1);
 			list.add(pos1, temp2);	
 		}
 	
 	} // end swap for Linked Lists
 	

	/**
	 * This method sorts an array using shell sort
	 * @param originalArray the unsorted array
	 * @return originalArray the sorted array
	 * @author Simer/Daniel
	 */
 	public static int[] shell(int[] originalArray) 
	{		
		resetCounters();
		
		int n = originalArray.length;
		
//----------------------Getting the Original ShellSize-----------------------//
		
		//declare the shellsize variables
		int a = 0;
		double shellSize = 0;
		boolean shellsizeFound = false;
		
		//Loop to find the shell size
		do 
		{
			
			loops++; //Looping through the do while
			
			comparisons += 2; //Making two different comparisons
			
			//Check if the original length is in between the current powers of 2
			if (Math.pow(2, a) <= n && n <= Math.pow(2, a + 1))
			{
				
				//if it is, set the shell size to be that divided by 2
				shellsizeFound = true;
				shellSize = (Math.pow(2, a));
			}
			//If not, increment a
			else
			{
				//if (showDebug) System.out.println("Increment a");
				a++;
			}
			
			comparisons++; //making the boolean comparison below
			
		}  while (shellsizeFound == false); //end find shell size loop
		
//-----------------------Sorting the Array----------------------------------//
		
		//if (showDebug) System.out.println("Found ShellSize");
		
		///Loop that decreases the shell size
		for (int b = (int) shellSize; b > 0; b /= 2)
		{
			
			comparisons++; //comparison made above, b > 0
			
			loops++;//loop through the above loop
			
			//loop that compares the elements
			for (int c = b; c < n; c++)
			{
				comparisons++;//comparison made above, c < n
				loops++;//loop through the loop
				comparisons++;//comparison made below
				//compare the elements
				if (originalArray[c] < originalArray[c - b])
				{
					//swap the elements
					swap(originalArray, c, c - b);
					swaps++;//swap made above
				}//end compare elements
				
			}//end loop compares elements
			comparisons++;//extra comparison
			
		}//end decrease shellsize
		comparisons++;//extra comparison
		
//------------------Insertion Sort After-----------------------------------//
		
		//Loop that checks the position being checked
		for (int i = 1; i < originalArray.length; i++)
		{
			
			comparisons++;//comparison made above
			
			loops++;//loop through above loop
			
			comparisons++;//loop made below
			
			//Loop that moves the incorrect back to its place
			for (int j = i; j > 0; j--)
			{
				
				//Check if a swap needs to happen, swap if so
				if (originalArray[j] > originalArray[i])
				{
					swap(originalArray, j, i);
					swaps++;//swap made above
				}//end swap
				
				
			}//end move back
			comparisons++;//extra comparison
			
		}//end loop check position
		comparisons++;//extra comparison
		
		return originalArray;
		
	}//ends shell method for arrays

	public static LinkedList <Integer> shell(LinkedList<Integer> originalList) 
	{
		resetCounters();
		
		int n = originalList.size();
		int a = 0;
		double shellSize = 0;
		boolean shellsizeFound = false;
		
		do 
		{
			
			loops++;
			comparisons += 2;
			
			if (Math.pow(2, a) <= n && n <= Math.pow(2, a + 1))
			{
				shellsizeFound = true;
				shellSize = (Math.pow(2, a));
			}
			else
			{
				a++;
			}
			
			comparisons++;
			
		}  while (shellsizeFound == false);
		for (int b = (int) shellSize; b > 0; b /= 2)
		{
			
			comparisons++;
			loops++;
			for (int c = b; c < n; c++)
			{
				comparisons++;
				loops++;
				comparisons++;
				if (originalList.get(c) < originalList.get(c - b))
				{
					swap(originalList, c, c - b);
					swaps++;
				}
				
			}
			comparisons++;
		}
		comparisons++;
		for (int i = 1; i < originalList.size(); i++)
		{
			
			comparisons++;
			loops++;
			comparisons++;
			
			for (int j = i; j > 0; j--)
			{
				
				if (originalList.get(j) > originalList.get(i))
				{
					swap(originalList, j, i);
				
				
			}
				
			comparisons++;
		}
			
		comparisons++;
		
		}
		
		return originalList;
	}
}