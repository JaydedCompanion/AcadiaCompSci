//*************************************************************************************************
//
// 	TriangleArea.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Requests 2D coordinates for a triangle and calculates
// 	its area using Heron's formula
//
//*************************************************************************************************

package Assignment3;

import java.util.Scanner;

public class TriangleArea {
	
	public static Scanner scanner = new Scanner(System.in);
	public static final String inputError = "Invalid input (double expected)." +
			" Try again.";
	
	public static void main (String[] args) {
		
		//Request three coordinates from the user
		System.out.println("Enter the first coordinate values:");
		Vector2 a = RequestVector();
		
		System.out.println("Enter the second coordinate values:");
		Vector2 b = RequestVector();
		
		System.out.println("Enter the third coordinate values:");
		Vector2 c = RequestVector();
		
		/*
		 * Calculate side lengths from coordinates
		 * and calculate triangle area from lengths
		 */
		double lenA = CoordDistance(a, b);
		double lenB = CoordDistance(b, c);
		double lenC = CoordDistance(c, a);
		
		double area = HeronArea(lenA,lenB, lenC);
		
		//Print the output (triangle area)
		System.out.println("Area:\t" + area);
	
	}
	
	//Request x and y coordinates and return as a vector
	public static Vector2 RequestVector () {
		
		double x = 0;
		double y = 0;
		
		//Request values from user
		x = PersistentDoubleRequest ("x:\t");
		y = PersistentDoubleRequest ("y:\t");
		
		return new Vector2(x, y);
		
	}
	
	/*
	 * Looping method to keep prompting the user
	 * for a valid double input in case an invalid
	 * entry is provided
	 */
	private static double PersistentDoubleRequest (String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				String in = scanner.next();
				return Double.parseDouble(in);
			} catch (Exception e){
				System.out.println(inputError);
			}
		}
	}
	
	//Calculates the distance between two vectors
	private static double CoordDistance (Vector2 a, Vector2 b) {
	
		//Why can you not overload arithmetic operators in java??
		Vector2 dist = b.subtract(a);
		
		/*
		 * Use the pythagorean theorem to calculate
		 * the direct distance from (0, 0) and the
		 * vector 'dist' and return it
		 */
		return Math.sqrt(Math.pow(dist.x, 2) + Math.pow(dist.y, 2));
		
	}

	/*
	 * Calculates the area of a triangle using Heron's formula
	 * when given three side lengths of any triangle as doubles
	 */
	public static double HeronArea (double a, double b, double c) {
	
		//s represents half of the triangle's perimeter
		double s = (a + b + c)/2;
		
		double area = Math.sqrt(s*(s - a)*(s - b)*(s - c));
		
		return area;
	
	}
	
}

//Vector2 is a custom object for storing and altering 2D coordinates with ease
class Vector2 {

	public double x, y;
	
	public Vector2 () {
		x = 0;
		y = 0;
	}
	
	public Vector2 (double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	public Vector2 subtract (Vector2 val) {
		return new Vector2(x - val.x, y - val.y);
	}
	
	public Vector2 multiply (double val) {
		return new Vector2(x * val, y * val);
	}

}