package testing;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.util.Duration; 

public class Javafx_Test extends Application { 
	@Override 
	public void start(Stage stage) {      

		Rectangle rect = new Rectangle (100, 40, 100, 100);
		rect.setArcHeight(50);
		rect.setArcWidth(50);
		rect.setFill(Color.VIOLET);

		TranslateTransition tt = new TranslateTransition(Duration.millis(1000), rect);
		tt.setByX(200f);
		//tt.setCycleCount(4f);
		tt.setAutoReverse(true);

		tt.play();

		//Creating a Group object   
		Group root = new Group(rect); 

		//Creating a scene object 
		Scene scene = new Scene(root, 600, 300);   

		//Setting title to the Stage 
		stage.setTitle("Rotate transition example "); 

		//Adding scene to the stage 
		stage.setScene(scene); 

		//Displaying the contents of the stage 
		stage.show(); 
	}      
	public static void main(String args[]){ 
		launch(args); 
	} 
} 