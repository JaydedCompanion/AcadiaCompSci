//*************************************************************************************************
//
// 	Drawing.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Draws a blue oval, a red square, and a green circle on the screen
//
//*************************************************************************************************

package Lab4;

import Assignment2.SquareCalculations;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.*;

import javafx.stage.Stage;

public class Drawing extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		/*
		 * After inspecting the provided image in Photoshop:
		 * -Canvas: 974x1000
		 * -Blue oval is 240 x 320
		 * -Red square is 120 x 120
		 * -Green circle is 80 x 80 (diameter 80, radius 40)
		 * -Center pos of all is x480y490
		 *
		 */
		
		//Initialize group and shapes
		Group shapes = new Group();
		Ellipse ellipse = new Ellipse(480,490,240/2,320/2);
		ellipse.setFill(Color.BLUE);
		Rectangle rectangle = new Rectangle(120, 120, Color.RED);
		rectangle.setX(480-60.0);rectangle.setY(490-60.0);
		Circle circle = new Circle(480, 490, 40, Color.GREEN);
		//Add shapes to group
		shapes.getChildren().add(ellipse);
		shapes.getChildren().add(rectangle);
		shapes.getChildren().add(circle);
		
		//Initialize and show scene
		Scene scene = new Scene(shapes, 974, 1000, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Drawing");
		primaryStage.show();
	
	}
	
	public static void main (String[] args) {
		
		launch();
		
	}
	
}
