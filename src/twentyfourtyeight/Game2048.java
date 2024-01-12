package twentyfourtyeight;


import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game2048 extends Application 
{
	
	Tile[][] boardTiles = new Tile[4][4];
	
	ArrayList<Tile> tiles = new ArrayList<Tile>(); 

	@Override
	public void start(Stage stage) throws Exception 
	{
		startGame(stage);
	}

	public void startGame(Stage stage)
	{
		Image image = new Image("file:src\\twentyfourtyeight\\Art\\GameScreen.jpg");
		ImageView gameScreen = new ImageView();
		gameScreen.setImage(image);
		gameScreen.setX(0);
		gameScreen.setY(0);
		gameScreen.setFitWidth(400);
		gameScreen.setPreserveRatio(true);

		GridPane gameBoard = new GridPane();
		int rowGrid = 4;
		int columnGrid = 4;

		double boxSize = 66;
		for (int row = 0; row < rowGrid; row++) {
			for (int col = 0; col < columnGrid; col++) {
				Rectangle box = new Rectangle(boxSize, boxSize);
				gameBoard.setAlignment(Pos.CENTER_RIGHT);
				box.setFill(Color.TRANSPARENT);
				box.setStrokeWidth(5);
				box.setStroke(Color.TRANSPARENT);
				gameBoard.add(box, col, row);
			}
		}
		gameBoard.setBorder(null);
		gameBoard.setLayoutX(56);
		gameBoard.setLayoutY(230);
		
		Random randInt = new Random();
		int xPos = randInt.nextInt(3 - 0 + 0) + 0;
		int yPos = randInt.nextInt(3 - 0 + 0) + 0;
		
		Tile blankTile = new Tile(xPos, yPos);
		
		gameBoard.add(blankTile.getTile(), blankTile.xPos, blankTile.yPos);
		
		Group display = new Group(
				gameScreen,
				gameBoard
				);

		Scene startScene = new Scene(display, 400, 566);
		stage.setScene(startScene);
		stage.setTitle("2048");
		stage.show();
		
		
		
		startScene.setOnKeyPressed(event -> 
		{
			if(event.getCode() == KeyCode.LEFT) 
			{
				for(int column = 0; column < 4; column++)
				{
					for(int row = 0; row < 4; row++)
					{
						
					}
				}
			}
			else if(event.getCode() == KeyCode.RIGHT)
			{
				System.out.println("Right");
			}
			else if(event.getCode() == KeyCode.UP) 
			{
				System.out.println("Up");
			}
			else if(event.getCode() == KeyCode.DOWN)
			{
				System.out.println("Down");
			}
		});
		
	}

	public static void main(String[] args) 
	{
		launch(args);
	}

}
