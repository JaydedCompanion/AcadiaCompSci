//*************************************************************************************************
//
// 	JuanCallejas.java		Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Draws an animated red riding hood, walking through the forest
//  Also includes Cloak, Path, Person, and Tree classes
//
//	Last lab = best lab
//
// *************************************************************************************************

package Lab11;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Random;

public class JuanCallejas extends Application {
	
	private static final int Width = 1280;
	private static final int Height = 720;
	private static final int ZigZag = 50;
	private static final String title =
			"\uD83D\uDC3A Red Riding Hood \uD83D\uDC3A";
	private static final String titleWarn =
			"[STARTING TIME MAY BE REQUIRED]";
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		Group group = new Group();
		
		//Create an instance of a person to be Red Riding Hood
		Person redRidingHood = new Person (120, 0, 30, Color.RED);
		Rectangle ground = new Rectangle(0, Height*0.3, Width, Height);
		ground.setFill(Color.SADDLEBROWN.interpolate(Color.BLACK, 0.7));
		
		//Generate all parts of the scene
		group.getChildren().addAll(
				//Ground rectangle
				ground,
				//Background group of trees
				GenerateTreeGroup(Width, Height*0.2, Height*0.23, 200),
				//Path group (bunch of rocks)
				new Path(0, Height/2, Width, ZigZag).getGroup(),
				//Red Riding Hood (person instance)
				redRidingHood.getGroup(),
				//Foreground trees, varying instance count so there's
				//less trees obstructing the view to RRH, but are still
				//dense closer to the foreground
				GenerateTreeGroup(Width, 200, 350, 50),
				GenerateTreeGroup(Width, 400, 450, 400)
		);
		
		//Scene creation and initialization
		Scene scene = new Scene(group, Width, Height, Color.DEEPSKYBLUE.brighter());
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//OOO FANCY ANIMATIONS!
		Task task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				double x = 0;
				double x2 = 0;
				double increment = 0;
				while (true) {
					final double fx = x;
					final double fx2 = x2;
					Platform.runLater(() -> redRidingHood.setPos(
							//Move RRH along the screen
							(int)fx - 50,
							//Make RRH zig-zag by using sine
							320 + (int)(Math.sin(fx*0.08)*5)
					));
					
					//Make RRH move in bursts
					increment = lerp(increment, 0, 0.1);
					x += increment;
					x2 ++;
					if (x > Width + 100)
						x = 0;
					if (increment < 0.01)
						increment = 2;
					
					//Decrease parameter for faster anim
					Thread.sleep(10);
				}
			}
		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		
	}
	
	//Linear interpolation between a and b by fac
	public static double lerp (double a, double b, double fac) {
		return a + ((b-a) * fac);
	}
	
	//Generates a group or randomly positioned trees with varying segment counts
	Group GenerateTreeGroup (double width, double height,
							 double y, int instances) {
		
		System.out.println(titleWarn);
	
		Group group = new Group();
		Random random = new Random();
		
		for (int i = 0; i < instances; i++) {
			
			double tx = width * random.nextDouble();
			double ty = (height/instances) * i + y;
			int segments = 3 + (int) (random.nextDouble() * 4);
			
			group.getChildren().addAll(
					new Tree (tx, ty, segments).getGroup()
			);
		
		}
		
		return group;
	
	}
	
}

//Cloak class, used to create and easily modify the cloak polygon
class Cloak {
	
	private Polygon cloak;
	private int x, y;
	//These values must be added to the origin point
	private double x1, x2, x3, x4, y1, y2, y3, y4;
	
	public Cloak (int x, int y, double size, Color col) {
		
		Color border = new Color(
				col.getRed() * 0.2,
				col.getGreen() * 0.2,
				col.getBlue() * 0.2,
				1
		);
		
		this.x = x;
		this.y = y;
		
		x1 = (size*0.75);
		y1 = (size);
		
		x2 = (size*0.25);
		y2 = (size);
		
		x3 = (size * -0.25);
		y3 = (size*2);
		
		x4 = (size * 0.75);
		y4 = (size*2);
		
		cloak = new Polygon();
		
		cloak.getPoints().addAll (
				//Hood top
				x + x1, y + y1,
				x + x2, y + y2,
				//Hood bottom
				x + x3, y + y3,
				x + x4, y + y4
		);
		cloak.setFill(col);
		cloak.setStroke(border);
		cloak.strokeLineJoinProperty().setValue(StrokeLineJoin.ROUND);
		cloak.strokeTypeProperty().setValue(StrokeType.CENTERED);
		cloak.setStrokeWidth(size * 0.1);
		
	}
	
	public void setPos (int x, int y) {
		
		cloak.getPoints().setAll (
				//Hood top
				x + x1, y + y1,
				x + x2, y + y2,
				//Hood bottom
				x + x3, y + y3,
				x + x4, y + y4
		);
	
	}
	
	public void setSize (double size) {
		
		x1 = (size*0.75);
		y1 = (size);
		
		x2 = (size*0.25);
		y2 = (size);
		
		x3 = (size * -0.25);
		y3 = (size*2);
		
		x4 = (size * 0.75);
		y4 = (size*2);
		
		cloak.getPoints().setAll (
				//Hood top
				x + x1, y + y1,
				x + x2, y + y2,
				//Hood bottom
				x + x3, y + y3,
				x + x4, y + y4
		);
	
	}
	
	public void setColor (Color col) {
		
		Color border = new Color(
				col.getRed() * 0.2,
				col.getGreen() * 0.2,
				col.getBlue() * 0.2,
				1
		);
		
		cloak.setFill(col);
		cloak.setStroke(border);
	
	}
	
	public Polygon getPolygon() {
		return cloak;
	}
	
}

//Generates a rectangular path and random rocks placed all along it
class Path {
	
	private Group group = new Group();
	
	private Rectangle path;
	private Polygon[] rocks = new Polygon[RockCount];
	
	private static Random random = new Random();
	
	private static final Color pathCol = Color.DARKGRAY.darker();
	private static final int RockCount = 500;

	public Path (int x, int y, int width, int height) {
		
		Rectangle clip = new Rectangle(x, y, width, height);
		path = new Rectangle(x, y, width, height);
		path.setFill(pathCol);
		//group.getChildren().add(path);
		
		//Generate rocks in path
		for (int i = 0; i < RockCount; i++) {
			
			int rockPoints = 6 + (int) (new Random().nextDouble() * 4);
			Color rockCol = new Color(
					pathCol.getRed()*(random.nextDouble()*0.1 + 0.3),
					pathCol.getGreen()*(random.nextDouble()*0.1 + 0.3),
					pathCol.getBlue()*(random.nextDouble()*0.1 + 0.3),
					1
			);
			
			rocks[i] = new Polygon();
			
			double rx = x + (random.nextDouble() * width);
			double ry = y + (random.nextDouble() * height);
			
			
			//Generate individual points in rock
			for (int j = 0; j < rockPoints; j++) {
				
				double px = Math.sin(Math.PI * (double)j/rockPoints * 2) * 10;
				double py = Math.cos(Math.PI * (double)j/rockPoints * 2) * 10;
				
				px += (width*0.01) - (random.nextDouble() * height*0.25);
				py += (height*0.01) - (random.nextDouble() * height*0.1);
				
				px += rx;
				py += ry;
				
				rocks[i].getPoints().addAll(px, py);
			
			}
			
			rocks[i].setFill(rockCol);
			group.getChildren().add(rocks[i]);
			
		}
		
	}
	
	public Group getGroup() {
		return group;
	}
	
}

//Creates a person (RRH) using basic shapes and the cloak class
//Has a SetPos(x, y) method for animation purposes
class Person {
	
	private Group group;
	
	private Rectangle	Hood;
	private Rectangle	Face;
	private Cloak		Cloak;
	
	private double size, faceX, faceY;
	
	//GenPerson generator
	public Person (int x, int y, double size, Color CloakCol) {
		
		//Declare border color
		group = new Group();
		Color border = new Color(
				CloakCol.getRed() * 0.2,
				CloakCol.getGreen() * 0.2,
				CloakCol.getBlue() * 0.2,
				1
		);
		
		//Generate Hood
		double FaceHoodRatio = 0.85;
		Hood = new Rectangle(x, y, size, size);
		Hood.setFill(CloakCol);
		Hood.setStroke(border);
		Hood.strokeLineJoinProperty().setValue(StrokeLineJoin.ROUND);
		Hood.strokeTypeProperty().setValue(StrokeType.CENTERED);
		Hood.setStrokeWidth(size * 0.1);
		Hood.setArcHeight(size * (1 - FaceHoodRatio));
		Hood.setArcWidth(size * (1 - FaceHoodRatio));
		
		//Generate Face
		faceX = (size/2);
		faceY = (size * (1 - FaceHoodRatio));
		Face = new Rectangle(
				x + faceX,
				y + faceY,
				(size/2) - (size * (1-FaceHoodRatio)),
				(size) - (size * (1- FaceHoodRatio)*2)
		);
		
		//Generate cloak
		Cloak = new Cloak(x, y, size, CloakCol);
		
		group.getChildren().addAll(
				Cloak.getPolygon(),
				Hood,
				Face
		);
		
	}
	
	public void setPos (int x, int y) {
		
		Hood.setX(x);
		Hood.setY(y);
		
		Face.setX(x + faceX);
		Face.setY(y + faceY);
		
		Cloak.setPos(x, y);
		
	}
	
	public Group getGroup() {
		return group;
	}
	
}

//Creates a series of triangles and a rectangles, arranged to resemble a tree
class Tree {
	
	private Group group;
	
	private Polygon[] Segments = new Polygon[0];
	private Rectangle Trunk;
	
	//Tree generator
	public Tree (double x, double y, int segments) {
		
		group = new Group();
		Segments = new Polygon[segments];
		
		//These parameters will help define the size increments for each segment
		final double treeHeightBase = 30;
		final double treeHeightMulti = 20;
		final double treeWidthBase = 10;
		final double treeWidthMulti = 10;
		
		/*
		 * Declare a triangle. Loop 6 times, each time add a new
		 * triangle to the group with increasing width and lower
		 * down on the screen. Each triangle should also have a
		 * slightly darker shade of green.
		 */
		Polygon triangle = new Polygon();
		
		for (int i = 0; i < segments; i ++) {
			
			//Set the color of the leaves to green
			//subtract (i*5) from each value to darken
			triangle.setFill(Color.color(
					(68.0 - i*5 )/255,
					(135.0-(i*5))/255,
					(100.0-(i*5))/255,
					1));
			
			//Declare the coordinates for the current triangle
			double x1 = x;
			double y1 = y - (i*treeHeightMulti);
			
			double x2 = ((segments - i) * treeWidthMulti) + treeWidthBase + x;
			double x3 = ((segments - i) * -treeWidthMulti) - treeWidthBase + x;
			//The bottom of the triangle has the same y-position
			double y23 = y - (i * treeHeightMulti) + treeHeightBase;
			//Specify the triangle's points
			triangle.getPoints().addAll(
					x1, y1,
					x2, y23,
					x3, y23
			);
			
			//Add the triangle to the tree group and reset the triangle
			group.getChildren().add(triangle);
			
			Segments[i] = triangle;
			
			/*
			 * Instead of changing the existing points of the polygon
			 * we must create a new polygon instance, since we cannot
			 * add an object instance to a group more than once
			 */
			triangle = new Polygon();
			
		}
		Trunk = new Rectangle(
				x-15,
				y + treeHeightBase,
				30,
				20
		);
		
		Trunk.setFill(Color.color(64.0/255, 29.0/255, 28.0/255, 1));
		group.getChildren().add(Trunk);
		
	}
	
	public Group getGroup() {
		return group;
	}
	
}