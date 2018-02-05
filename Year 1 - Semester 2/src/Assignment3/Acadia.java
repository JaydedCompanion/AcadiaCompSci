//*************************************************************************************************
//
// 	Acadia.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Draws a masterpiece on a 500x500 canvas.
//
//*************************************************************************************************

package Assignment3;


import com.sun.deploy.uitoolkit.impl.fx.FXWindow;
import com.sun.org.apache.xml.internal.utils.XML11Char;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.Random;

public class Acadia extends Application {
	
	private static Random random = new Random();
	
	@Override
	public void start(Stage primaryStage) {
		
		//Generate building, tree, empty world
		Group building = GenBuilding(150, 225, 8, 3);
		Group tree = GenTree(320, 205, 5);
		Group world = new Group();
		
		//Define colors for ground/sky
		Color skyCol = Color.color(124.0/255, 174.0/255, 1, 1);
		Color groundCol = Color.color(0.95, 0.95, 0.95, 1);
		
		//Create snowy ground
		Rectangle snowyGround = new Rectangle(0, 300, 500, 200);
		snowyGround.setFill(groundCol);
		
		//Add components to world group
		world.getChildren().add(snowyGround);
		world.getChildren().add(building);
		world.getChildren().add(tree);
		
		//Start and display the scene
		Scene scene = new Scene(world, 500.0, 500.0, skyCol);
		primaryStage.setTitle("Chipman House");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//Tree generator
	public static Group GenTree (double x, double y, int treeSegments) {
	
		Group tree = new Group();
		
		//These parameters will help define the size increments for each segment
		final double treeHeightBase = 30;
		final double treeHeightMulti = 20;
		final double treeWidthBase = 20;
		final double treeWidthMulti = 10;
		
		/*
		 * Declare a triangle. Loop 6 times, each time add a new
		 * triangle to the group with increasing width and lower
		 * down on the screen. Each triangle should also have a
		 * slightly darker shade of green.
		 */
		Polygon triangle = new Polygon();
		for (int i = 0; i < treeSegments; i ++) {
			
			//Set the color of the leaves to green
			//subtract (i*5) from each value to darken
			triangle.setFill(Color.color(
					(68.0 - i*5 )/255,
					(135.0-(i*5))/255,
					(100.0-(i*5))/255,
					1));
			
			//Declare the coordinates for the current triangle
			double x1 = x;
			double y1 = (i*treeHeightMulti) + y;
			
			double x2 = (i * treeWidthMulti) + treeWidthBase + x;
			double x3 = (i * -treeWidthMulti) - treeWidthBase + x;
			//The bottom of the triangle has the same y-position
			double y23 = (i * treeHeightMulti) + y + treeHeightBase;
			//Specify the triangle's points
			triangle.getPoints().addAll(
					x1, y1,
					x2, y23,
					x3, y23
			);
			
			//Add the triangle to the tree group and reset the triangle
			tree.getChildren().add(triangle);
			
			triangle = new Polygon();
		
		}
		
		/*
		 * Declare a trunk and add it to the group
		 * Since it is drawn on top of the other
		 * shapes, it must be placed at the exact
		 * place the tree ends to avoid strange overlap.
		 */
		Rectangle trunk = new Rectangle(
				x-15,
				y+((treeSegments-1)*treeHeightMulti) + treeHeightBase,
				30,
				20
		);
		trunk.setFill(Color.color(64.0/255, 29.0/255, 28.0/255, 1));
		tree.getChildren().add(trunk);
		
		return tree;
	
	}
	
	//Building generator
	//Note that the width/height is indicated by window count, not pixel count
	public static Group GenBuilding (double x, double y, int wWin, int hWin) {
	
		Group building = new Group();
		
		final double windowWidth = 10;
		final double windowHeight = 15;
		final double windowXgap = 5;
		final double windowYgap = 10;
		
		final double absWidth = (windowWidth*wWin) + (windowXgap*(wWin + 2));
		final double absHeight = (windowHeight*hWin) + (windowYgap*(hWin + 2));
		
		Rectangle wall = new Rectangle(x, y, absWidth, absHeight);
		Rectangle sideWall = new Rectangle(x + absWidth, y, 20, absHeight);
		wall.setFill(Color.color(181.0/255, 135.0/255, 103.0/255, 1));
		sideWall.setFill(Color.color(161.0/255, 115.0/255, 083.0/255, 1));
		building.getChildren().add(wall);
		building.getChildren().add(sideWall);
		
		Rectangle door = new Rectangle(
				x + (absWidth/2) - 15,
				y + absHeight - 15,
				30,
				15
		);
		door.setFill(Color.color(0.85, 0.84, 0.85, 1));
		building.getChildren().add(door);
		
		for (int i = 0; i < hWin; i++) {
		
			for (int j = 0; j < wWin; j++) {
			
				double xPos = x + (windowXgap*(j+1)) + (windowWidth*j);
				double yPos = y + (windowYgap*(i+1)) + (windowHeight*i);
				
				Rectangle window = new Rectangle(
						xPos,
						yPos,
						windowWidth,
						windowHeight
				);
				
				window.setFill(Color.color(188.0/255, 248.0/255, 1, 1));
				
				building.getChildren().add(window);
			
			}
		
		}
		
		return building;
		
	}
	
	public static void main (String[] args) {
		
		launch (args);
		
	}
	
}
