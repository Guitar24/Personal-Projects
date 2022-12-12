package euchre;

<<<<<<< HEAD
import javax.swing.*;
=======
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
>>>>>>> branch 'master' of https://github.com/Guitar24/Personal-Projects.git

public class Euchre_2D {

	public static void main(String[] args) throws IOException 
	{
		JFrame window = new JFrame();
<<<<<<< HEAD
		JButton button = new JButton("See if this works");  
=======
		
		BufferedImage image = ImageIO.read(new File(" Aceofspades.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		window.add(label);
>>>>>>> branch 'master' of https://github.com/Guitar24/Personal-Projects.git
		
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
