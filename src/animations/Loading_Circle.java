package animations;

public class Loading_Circle {

	public static void main(String[] args) throws InterruptedException 
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println("\n\n\n\n\n◔");
			Thread.sleep(200);
			System.out.println("\n\n\n\n\n◑");
			Thread.sleep(200);
			System.out.println("\n\n\n\n\n◕");
			Thread.sleep(200);
			System.out.println("\n\n\n\n\n◉");
			Thread.sleep(200);
		}
	}

}
