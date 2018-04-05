//*************************************************************************************************
//
// 	TextFieldRadius.java		Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	This program displays a circle whose radius can be set via a text field
//
// *************************************************************************************************

package Assignment5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by TheShadyColombian on 2018-02-25.
 */
public class TextFieldRadius extends Application {
	
	private TextField textField;
	private Circle circle;
	
	@Override
	//Equivalent of void main() for JavaFX programs
	public void start(Stage primaryStage) throws Exception {
		
		//Define pane
		StackPane pane = new StackPane();
		
		//Generate UI elements and add them to the group
		textField = new TextField("100");
		textField.setAlignment(Pos.CENTER);
		textField.setPrefWidth(16);
		textField.setMaxWidth(50);
		textField.setOnKeyReleased (new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				textFieldUpdate(textField);
			}
		});
		circle = new Circle (200, 200, 100, Color.TRANSPARENT);
		circle.setStroke(Color.BLUE);
		
		//Set up pane
		pane.getChildren().add(circle);
		pane.getChildren().add(textField);
		pane.setAlignment(Pos.CENTER);
		
		//Scene creation and initialization
		Scene scene = new Scene (pane, 400, 400, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main (String[] args)	{
	
		launch(args);
	
	}
	
	private void textFieldUpdate (TextField field) {
	
		try {
			circle.setRadius(Integer.parseInt(textField.getText()));
		} catch (Exception e) {}
	
	}
	
}
