//*************************************************************************************************
//
// 	Diamond.java		Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Creates four Squares and arranges them to form a Diamond shape
//
// *************************************************************************************************

package Assignment8;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Diamond extends Application {
	
	private static final int SIZE = 400;
	
	//Four square instances
	private static Square Q1 = new Square();
	private static Square Q2 = new Square();
	private static Square Q3 = new Square();
	private static Square Q4 = new Square();
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		Group group = new Group();
		
		//Transform the instances according to which corner they represent
		Q2.setRotate(90);
		Q2.setTranslateX(SIZE);
		Q3.setRotate(270);
		Q3.setTranslateY(SIZE);
		Q4.setRotate(180);
		Q4.setTranslateX(SIZE);
		Q4.setTranslateY(SIZE);
		
		//Add the instances to the group
		group.getChildren().add(Q1);
		group.getChildren().add(Q2);
		group.getChildren().add(Q3);
		group.getChildren().add(Q4);
		
		//Scene creation and initialization
		Scene scene = new Scene(group, SIZE * 2, SIZE * 2, Color.BLACK);
		primaryStage.setTitle("Diamond");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
