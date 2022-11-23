package euchre;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Euchre_2D {

	public static void main(String[] args) throws IOException 
	{
		JFrame window = new JFrame();
		
		BufferedImage image = ImageIO.read(new File(" Aceofspades.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		window.add(label);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Euchre???");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
