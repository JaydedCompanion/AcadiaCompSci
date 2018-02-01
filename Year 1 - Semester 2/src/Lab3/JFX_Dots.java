//*************************************************************************************************
//
// 	JFX_Dots.java				Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	This program creates a JavaFX program that displays a scene with three colored circles
//
// *************************************************************************************************

package Lab3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


/**
 * Created by TheShadyColombian on 2018-02-01.
 */
public class JFX_Dots extends Application {
	//Define dimensions of the scene and the circles
	public static final double CircleRadius = 15;
	public static final double SceneW = 500;
	public static final double SceneH = 500;
	//Define dot colors for easy access
	public static final Color circCol1 = Color.GREEN;
	public static final Color circCol2 = Color.DEEPSKYBLUE;
	public static final Color circCol3 = Color.YELLOW;
	public static final Color circCol4 = Color.RED;
	
	
	@Override
	//Equivalent of void main() for JavaFX programs
	public void start(Stage primaryStage) throws Exception {
	
		//Instantiate new main group
		Group newGroup = new Group ();
		
		//Generate circles and add them to the group
		newGroup.getChildren().add(new Circle(CircleRadius, CircleRadius, CircleRadius, circCol1));
		newGroup.getChildren().add(new Circle(SceneW - CircleRadius, CircleRadius, CircleRadius, circCol2));
		newGroup.getChildren().add(new Circle(CircleRadius, SceneH - CircleRadius, CircleRadius, circCol3));
		newGroup.getChildren().add(new Circle(SceneW - CircleRadius, SceneH - CircleRadius, CircleRadius, circCol4));
		
		//Scene creation and initialization
		Scene scene = new Scene (newGroup, SceneW, SceneH, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main (String[] args) {
		
		launch(args);
		
	}
	
}
