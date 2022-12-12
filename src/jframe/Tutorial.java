package jframe;

import java.awt.*;
import javax.swing.*;

public class Tutorial extends JFrame
{
	JPanel jp = new JPanel();
	JLabel a, b, c, d;
	JButton e, f, g, h;
	
 	public Tutorial()
	{
		setTitle("Testing");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		
		jp.setLayout(new GridLayout(2, 4));
		jp.setBackground(Color.getHSBColor(216, 69, 62));
		
		a = new JLabel("Sample 1");
		jp.add(a);
		
		b = new JLabel("Sample 2");
		jp.add(b);
		
		c = new JLabel("Sample 3");
		jp.add(c);
		
		d = new JLabel("Sample 4");
		jp.add(d);
		
		e = new JButton("Button 1");
		jp.add(e);
		
		f = new JButton("Button 2");
		jp.add(f);
		
		g = new JButton("Button 3");
		jp.add(g);
		
		h = new JButton("Button 4");
		jp.add(h);
		
		add(jp);
	}
 	
	
	public static void main(String[] args) 
	{
		Tutorial t = new Tutorial();
	}
}
