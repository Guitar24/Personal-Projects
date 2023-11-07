package array;

import java.util.*;

public class ArrayClassTesting {

	public static void main(String[] args) 
	{
		String[] array = new String[5];
		String[] array2 = {null, null, null};
		
		System.out.println(Array.checkIfIdentical(array, array2));
	}
}