//*************************************************************************************************
//
// 	Square.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Class which extends group, generates a group with 10,000 circles in random
//  position, and uses a different color depending on which diagonal half its in
//
//*************************************************************************************************

package Assignment8;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Square extends Group {

	private static final int SIZE = 400;			//Size of the group (px)
	private static final int CIRCLECOUNT = 10000;	//How many circles to make
	private static final Color LL = Color.GREEN;	//Color for Lower Left
	private static final Color UR = Color.RED;		//Color for Upper Right
	
	private static Random random = new Random();	//Instance of random object
	
	//Instance array of all circles
	private Circle[] circles = new Circle[CIRCLECOUNT];
	
	//Constructor
	public Square () {
	
		for (int i = 0; i < CIRCLECOUNT; i ++) {
			
			//Generate random x/y coordinates
			double x = random.nextDouble() * (SIZE - 1);
			double y = random.nextDouble() * (SIZE - 1);
			
			//Sets color depending on which half of the group it is in
			Color col = ((x + y)/2 < (SIZE/2)) ? LL : UR;
			
			//Create group and add to circle array
			circles [i] = new Circle(x, y, 1, col);
			
			//Add to group (very important, else instances exist but don't show)
			getChildren().add(circles[i]);
		
		}
	
	}

}
