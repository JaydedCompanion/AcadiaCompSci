//*************************************************************************************************
//
// 	Checkers.java		Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Creates checkerboard ui from a group of Rectangles
//
// *************************************************************************************************

package Lab8;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Checkerboard extends Application {
	
	//Constant to be used as tile size/spacing
	public static final int SIZE = 50;
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		Group group = new Group();
		
		//Nested 2D loop
		for (int y = 0; y < 8; y ++) {
			
			for (int x = 0; x < 8; x ++) {
				
				//Use black as fill color if x and y are both odd or even
				Color fill = Color.WHITE;
				if ((x % 2) == (y % 2))
					fill = Color.BLACK;
				
				//Instantiate rectangle, add to group
				Rectangle inst = new Rectangle(SIZE, SIZE, fill);
				
				inst.setX((x * SIZE) + SIZE);
				inst.setY((y * SIZE) + SIZE);
				
				group.getChildren().add(inst);
				
			}
			
		}
		
		//Scene creation and initialization
		Color bgFill = new Color(
				245/(double)255,
				245/(double)255,
				220/(double)255,
				1
		);
		Scene scene = new Scene(group, SIZE * 10, SIZE * 10, bgFill);
		primaryStage.setTitle("Checkerboard");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
