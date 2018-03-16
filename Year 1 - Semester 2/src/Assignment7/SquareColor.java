//*************************************************************************************************
//
// 	SquareColor.java		Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Draws a UI with 5 radio buttons, each sets the colour of the square
//
// *************************************************************************************************

package Assignment7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;

public class SquareColor extends Application {
	
	//tGroup, square, and buttons are global so they can be accessed
	//by the handler method
	private static ToggleGroup tGroup = new ToggleGroup();
	private static Rectangle square = new Rectangle(100, 100);
	
	private static RadioButton buttonA = new RadioButton("Red");
	private static RadioButton buttonB = new RadioButton("Green");
	private static RadioButton buttonC = new RadioButton("Yellow");
	private static RadioButton buttonD = new RadioButton("Orange");
	private static RadioButton buttonE = new RadioButton("Blue");
	
	private static final Color col1 = Color.RED;
	private static final Color col2 = Color.GREEN;
	private static final Color col3 = Color.YELLOW;
	private static final Color col4 = Color.ORANGE;
	private static final Color col5 = Color.BLUE;
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		//Generate layout panes
		FlowPane layout = new FlowPane();
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(50);
		layout.setVgap(50);
		VBox buttonPanel = new VBox();
		buttonPanel.setAlignment(Pos.CENTER_LEFT);
		
		//Adds buttons to ToggleGroup
		tGroup.getToggles().add(buttonA);
		tGroup.getToggles().add(buttonB);
		tGroup.getToggles().add(buttonC);
		tGroup.getToggles().add(buttonD);
		tGroup.getToggles().add(buttonE);
		//Set action method for buttons
		buttonA.setOnAction(this::registerRadioChange);
		buttonB.setOnAction(this::registerRadioChange);
		buttonC.setOnAction(this::registerRadioChange);
		buttonD.setOnAction(this::registerRadioChange);
		buttonE.setOnAction(this::registerRadioChange);
		//Add buttons to VBox
		buttonPanel.getChildren().add(buttonA);
		buttonPanel.getChildren().add(buttonB);
		buttonPanel.getChildren().add(buttonC);
		buttonPanel.getChildren().add(buttonD);
		buttonPanel.getChildren().add(buttonE);
		
		//Add VBox to HBox
		layout.getChildren().add(buttonPanel);
		//Add Square to HBox
		layout.getChildren().add(square);
		layout.setStyle("-fx-background-color: cornsilk");
		buttonPanel.setStyle("-fx-background-color: cornsilk");
		
		//Scene creation and initialization
		Scene scene = new Scene(layout, 400, 400, Color.BLACK);
		primaryStage.setTitle("SquareColor");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//This method handles radio button changes
	private void registerRadioChange (ActionEvent actionEvent) {
		
		ToggleButton activeButton = (ToggleButton) tGroup.getSelectedToggle();
		
		if (activeButton == buttonA)
			square.setFill(col1);
		else if (activeButton == buttonB)
			square.setFill(col2);
		else if (activeButton == buttonC)
			square.setFill(col3);
		else if (activeButton == buttonD)
			square.setFill(col4);
		else
			square.setFill(col5);
		
	}
	
}
