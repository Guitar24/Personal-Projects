package twentyfourtyeight;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;
import java.math.*;

public class Tile 
{
	////////////////
	// ATTRIBUTES //
	////////////////
	
	private int number;
	private Color tileColor;
	private Color numColor;
	private StackPane tile;
	public int xPos;
	public int yPos;
	
	
	
	//////////////////
	// CONSTRUCTOR //
	//////////////////
	
	public Tile(int xPos, int yPos)
	{
		Random randInt = new Random();
		int chance = randInt.nextInt(10 - 1 + 1) + 1;
		
		if(chance == 7)
			this.number = 4;
		else
			this.number = 2;
		
		nextNumber(2);
		
		this.xPos = xPos;
		this.yPos = yPos;
		
		setColor();
		
		Text tileNum = new Text(Integer.toString(number));
		tileNum.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		tileNum.setFill(numColor);
		Rectangle tileRect = new Rectangle(66, 66);
		tileRect.setFill(tileColor);
		tileRect.setArcHeight(10);
		tileRect.setArcWidth(10);
		
		tile = new StackPane();
		
		tile.getChildren().add(tileRect);
		tile.getChildren().add(tileNum);
		
		setColor();
	}
	
	
	/////////////
	// SETTERS //
	/////////////
	
	public void nextNumber(int pow)
	{
		this.number *= pow;
	}
	
	public void setNumber(int newNum)
	{
		this.number = newNum;
	}
	
	private void setColor()
	{
		if(getNumber() == 2)
		{
			tileColor = Color.rgb(238,228,218);
			numColor = Color.rgb(119, 110, 101);
		}
		else if(getNumber() == 4)
		{
			tileColor = Color.rgb(237,224,200);
			numColor = Color.rgb(119, 110, 101);
		}
		else if(getNumber() == 8)
		{
			tileColor = Color.rgb(242,177,121);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 16)
		{
			tileColor = Color.rgb(245,149,99);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 32)
		{
			tileColor = Color.rgb(246,124,96);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 64)
		{
			tileColor = Color.rgb(246,94,59);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 128)
		{
			tileColor = Color.rgb(237,207,115);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 256)
		{
			tileColor = Color.rgb(237,204,98);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 512)
		{
			tileColor = Color.rgb(237,200,80);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 1024)
		{
			tileColor = Color.rgb(237,197,63);
			numColor = Color.rgb(249,246,242);
		}
		else if(getNumber() == 2048)
		{
			tileColor = Color.rgb(237,194,45);
			numColor = Color.rgb(249,246,242);
		}
	}
	
	
	/////////////
	// GETTERS //
	/////////////
	public StackPane getTile()
	{
		return this.tile;
	}
	
	public Color getColor()
	{
		return this.tileColor;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
}
