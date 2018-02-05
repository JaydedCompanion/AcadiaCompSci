//*************************************************************************************************
//
// 	RotatedName.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Displays name with a random rotation on a randomly colored canvas.
//
//*************************************************************************************************

package Assignment3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.Random;

public class RotatedName extends Application {
	
	private static Random random = new Random();
	
	@Override
	public void start(Stage primaryStage) {
		
		//Generate background scene color
		Group group = new Group();
		Color bgCol = GenRandCol();
		//Create a text object, and rotate it
		Text name = new Text(218, 218,"Juan Callejas");
		name.setFont(new Font("Courier", 32));
		name.setRotate(random.nextDouble() * 360);
		//Add the text object to the group
		group.getChildren().add(name);
		//Start and display the scene
		Scene scene = new Scene(group, 500.0, 500.0, bgCol);
		primaryStage.setTitle("Juan Callejas");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//Generates a random color
	public Color GenRandCol () {
		return new Color(
				random.nextDouble(),
				random.nextDouble(),
				random.nextDouble(),
				1);
	}
	
	public static void main (String[] args) {
		
		launch (args);
		
	}
	
}
