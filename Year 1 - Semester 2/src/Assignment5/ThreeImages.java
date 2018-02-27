//*************************************************************************************************
//
// 	ThreeImages.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************************************

package Assignment5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.*;

public class ThreeImages extends Application {

	private Image Q1 = new Image("Q1.jpg");
	private final int TILE_WIDTH = 400;
	private final int TILE_HEIGHT = 600;
	private final int TILE_GAP = 20;
	
	@Override
	//Equivalent of void main() for JavaFX programs
	public void start(Stage primaryStage) throws Exception {
		
		//Define viewports (crop zones)
		Rectangle2D viewport2 = new Rectangle2D(1290, 176, 1400, 2100);
		Rectangle2D viewport3 = new Rectangle2D(1960, 282, 346, 520);
		
		//Declare views and assign viewports
		ImageView V1 = new ImageView (Q1);
		V1.setFitWidth(TILE_WIDTH);
		V1.setFitHeight(TILE_HEIGHT);
		ImageView V2 = new ImageView (Q1);
		V2.setViewport(viewport2);
		V2.setFitWidth(TILE_WIDTH);
		V2.setFitHeight(TILE_HEIGHT);
		ImageView V3 = new ImageView (Q1);
		V3.setViewport(viewport3);
		V3.setFitWidth(TILE_WIDTH);
		V3.setFitHeight(TILE_HEIGHT);
		
		//Declare pane, set dimensions, add children
		FlowPane pane = new FlowPane();
		pane.setVgap(TILE_GAP);
		pane.setHgap(TILE_GAP);
		pane.setPadding(new Insets(TILE_GAP, TILE_GAP, TILE_GAP, TILE_GAP));
		pane.getChildren().add(V1);
		pane.getChildren().add(V2);
		pane.getChildren().add(V3);
		
		//Scene creation and initialization
		Scene scene = new Scene (
				pane,
				(TILE_WIDTH * 3) + (TILE_GAP * 4),
				TILE_HEIGHT + (TILE_GAP * 2),
				Color.BLACK
		);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Three Images");
		primaryStage.show();
		
	}
	
	public static void main (String[] args)	{
		
		launch(args);
		
	}
	
}
