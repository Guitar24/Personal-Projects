package computer_melter;

import java.io.*;
import java.math.*;
import java.util.*;

public class Computer_Melter {

	public static void main(String[] args) 
	{
		int n = 1;

		while(true)
		{

			ArrayList<BigInteger> list = new ArrayList<BigInteger>();

			for(int i = 1; i <= n; i++)
			{
				BigInteger number = fibonacciBigInteger(i);
				//System.out.println(i + ": " + number);
				list.add(number);
			}
			System.out.println(list);
			BigInteger product = BigInteger.ONE;
			
			for(int i = 0; i < list.size(); i++)
			{
				BigInteger temp = product.multiply(list.get(i));
				
				product = temp;
			}
			
			
			
			String filepath = "C:\\users\\jonathan\\desktop\\Computer Melter\\Product - " + n + ".txt";

			try 
			{
				FileWriter debugFile = new FileWriter(filepath);
				debugFile.write(product.toString());


				debugFile.close();
			} 
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			
			
			
			
			System.out.println(product);
			
			n += 1000;
		}
	}


	public static BigInteger fibonacciBigInteger(int n) 
	{
		if (n <= 1) {
			return BigInteger.valueOf(n);
		}

		BigInteger fib = BigInteger.ZERO;
		BigInteger prev = BigInteger.ONE;
		BigInteger temp;

		for (int i = 2; i <= n; i++) {
			temp = fib;
			fib = fib.add(prev);
			prev = temp;
		}
		return fib;
	}

}
