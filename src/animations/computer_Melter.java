package animations;

public class computer_Melter {

	public static void main(String[] args) throws InterruptedException 
	{
		while(true)
		{
			double Randnum  = (double)(Math.random()*(1000000000-(-1000000000)+(-1000000000))) + (-1000000000);
			System.out.println(Randnum);
			double RandCheck  = (double)(Math.random()*(1000000000-(-1000000000)+(-1000000000))) + (-1000000000);
			if(RandCheck == Randnum) 
			{
				break;
			}
		//	Thread.sleep(100);
		}
		
	}

}
