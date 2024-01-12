package calculator;

import java.util.*;

public class Console_Calculator {

	static Scanner Input = new Scanner(System.in);


	public static void main(String[] args) 
	{
		menu();
	}

	public static void menu()
	{
		//Prints out the menu and asks the user for input
		while(true)
		{
			System.out.println("\n"
					+ "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\r\n"
					+ "█  E - Input Expression  █\r\n"
					+ "█  B - Basic Functions   █\r\n"
					+ "█  S - Settings          █\r\n"
					+ "█  Q - Quit              █\r\n"
					+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.print("Input one of the options above: ");
			String menuInput = Input.next();


			if(menuInput.equalsIgnoreCase("e")) //If the user wishes to start the game
			{
				equation();
			}
			else if(menuInput.equalsIgnoreCase("b")) //If the user needs to see the rules
			{
				basicFunctions();
			}
			else if(menuInput.equalsIgnoreCase("s")) // allows the user to select how many points in a game
			{
				while(true)
				{
					System.out.print("DRG: ");

					String newDRG = Input.next();

					if(newDRG.equalsIgnoreCase("d") || newDRG.equalsIgnoreCase("r"))
					{
						calc.DRG = newDRG.toUpperCase();

						if(newDRG.equalsIgnoreCase("d"))
						{
							System.out.println("Calculator in degree mode");
						}
						else if(newDRG.equalsIgnoreCase("r"))
						{
							System.out.println("Calculator in radian mode");
						}
						break;
					}
					else
						System.err.println("Invalid Input");
				}

			}
			else if(menuInput.equalsIgnoreCase("q")) // exits the program
			{
				System.exit(0);
			}
		}
	}

	public static void equation()
	{
		Stack<String> bedmas = new Stack<String>();
		
		Scanner newInput = new Scanner(System.in);
		System.out.print("Expression: ");
		String equation = newInput.nextLine();

//		String brackets = equation;
//		
//		brackets = brackets.substring(brackets.indexOf("(") + 1);
//		brackets = brackets.substring(0, brackets.indexOf(")"));
//
//		System.out.println(brackets);
		
		String exponent = equation;
		
		
		exponent = exponent.substring(exponent.indexOf("^") + 1);
		//exponent = exponent.substring(0, exponent.indexOf("^"));

		System.out.println(exponent);
	}
	
	private static void basicFunctions() 
	{
		while(true)
		{
			System.out.println("\n"
					+ "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\r\n"
					+ "█  +   exp   root █\r\n"
					+ "█  -   sin   csc  █\r\n"
					+ "█  x   cos   sec  █\r\n"
					+ "█  /   tan   cot  █\r\n"
					+ "█  E - Exit       █\r\n"
					+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
			System.out.print("Input one of the options above: ");
			String menuInput = Input.next();

			if(menuInput.equals("+"))
			{
				double[] terms = gatherTerms();


				double sum = calc.add(terms);

				System.out.println(sum);
			}
			else if(menuInput.equals("-"))
			{
				double[] terms = gatherTerms();


				double diff = calc.subtract(terms);

				System.out.println(diff);
			}
			else if(menuInput.equals("x"))
			{
				double[] terms = gatherTerms();


				double product = calc.multiply(terms);

				System.out.println(product);
			}
			else if(menuInput.equals("/"))
			{
				double[] terms = gatherTerms();


				double quotient = calc.divide(terms);

				System.out.println(quotient);
			}
			else if(menuInput.equalsIgnoreCase("exp"))
			{
				
				double base;
				double exp;
				
				while(true)
				{
					System.out.print("Base: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						base = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				
				while(true)
				{
					System.out.print("Exponent: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						exp = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				
				double ans = calc.exponent(base, exp);

				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("root"))
			{
				
				double base;
				double exp;
				
				while(true)
				{
					System.out.print("Base: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						base = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				
				while(true)
				{
					System.out.print("Root: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						exp = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				
				double ans = calc.root(base, exp);

				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("sin"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.sin(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("cos"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.cos(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("tan"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.tan(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("csc"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.csc(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("sec"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.sec(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("cot"))
			{
				double angle;
				
				while(true)
				{
					System.out.print("Angle: ");
					try
					{
						Scanner newInput = new Scanner(System.in);
						angle = newInput.nextDouble();
						break;
					}
					catch(Exception e)
					{
						System.err.println("\nInvalid Input");
					}
				}
				double ans = calc.cot(angle);
				
				System.out.println(ans);
			}
			else if(menuInput.equalsIgnoreCase("e"))
			{
				break;
			}
			else
			{
				System.err.println("Invalid Input");
			}
		}
	}

	public static double[] gatherTerms()
	{
		double[] terms;
		while(true)
		{
			System.out.print("\nNumber of terms: ");
			try
			{
				Scanner newInput = new Scanner(System.in);
				int len = newInput.nextInt();
				if(len > 1)
				{
					terms = new double[len];
					break;
				}
			}
			catch(Exception e)
			{
				System.err.println("\nInvalid Input");
			}
		}

		for(int i = 1; i <= terms.length; i++)
		{
			while(true)
			{
				System.out.print("Term " + i + ": ");
				try
				{
					Scanner newInput = new Scanner(System.in);
					terms[i-1] = newInput.nextDouble();
					break;
				}
				catch(Exception e)
				{
					System.err.println("\nInvalid Input");
				}
			}
		}

		return terms;
	}
}