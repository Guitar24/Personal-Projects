public class Stack_Overflow {

	public static void main(String[] args) 
	{
		stackOverflow(1);
	}
	
	public static void stackOverflow(int i) {System.out.println(i); stackOverflow(i + 1); }
}
