package euchre;

import javax.swing.*;

public class Euchre_2D {

	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		JButton button = new JButton("See if this works");  
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(400, 400);
		//window.setResizable(false);
		window.setTitle("2D Euchre???");
		
		
		
		
		
		//GamePanel gamePanel = new GamePanel();
		//window.add(gamePanel);
		button.setBounds(50,100,95,30);  
	    window.add(button);  
		
	    
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
